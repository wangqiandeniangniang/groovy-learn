package com.jack.groovy.ch14

import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamReader


/**
 * @author liangchen* @date 2020/12/3
 */
def input = 'file:data/plan.xml'.toURL()
def underway = []
def upcoming =[]

// 定义解析工具方法，
def eachStartElement(inputStream, Closure yield) {
   // 创建一个流解析XML读取器
    def token = XMLInputFactory.newInstance()
            .createXMLStreamReader(inputStream)
    try {
        while (token.hasNext()) {
            //如果是解析到一个标签时候， 调用 闭包 yield方法进行处理
            if(token.startElement) yield token
            token.next()
        }
    }finally {
        // token、inputStream不为空就关闭
        token?.close()
        inputStream?.close()
    }

}
class XMLStreamCategory{
    static Object get(XMLStreamReader self, String key) {
        return self.getAttributeValue(null, key)
    }
}

// 将token字符转换标签对象，也就使用XMLStreamCategory get方法
use(XMLStreamCategory){
    eachStartElement(input.openStream()) { element ->
        if (element.name.toString() != 'task') {
            return
        }
        switch (element.done) {
            case '0' :
                upcoming << element.title
                break
            case {it != element.total}:
                underway << element.title
        }
    }
}
assert  underway == ['use in current project']
assert upcoming == ['re-read DB chapter', 'use DB/XML combination']
