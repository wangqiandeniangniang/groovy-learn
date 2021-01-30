package com.jack.groovy.ch14

import org.xml.sax.helpers.DefaultHandler
import org.xml.sax.*

import javax.xml.parsers.SAXParserFactory

/**
 * 继承 DefualtHandler接口
 * @author liangchen* @date 2020/12/3
 */
class PlanHandler extends DefaultHandler {
    def underway = []
    def upcoming = []
    /**
     *
     * @param namespace
     * @param localName
     * @param qName  标签名称
     * @param attrs 属性对象
     */
    void startElement(String namespace, String localName, String qName, Attributes attrs){

        print namespace + "==" + localName + "==" + qName +"==" +attrs
        if(qName != 'task') return
        def title = attrs.getValue('title')
        def total = attrs.getValue('total')
        switch ((attrs.getValue('done'))) {
            case '0' : upcoming << title; break
            case {it != total} : underway << title; break
        }
    }
}
// 创建一个自已handler
def handler = new PlanHandler()
// 创建一个工厂对象
def factory = SAXParserFactory.newInstance()
//文档读取器
def reader = factory.newSAXParser().XMLReader
// 文档处理器
reader.contentHandler = handler
new File('data/plan.xml').withInputStream { is ->
    reader.parse(new InputSource(is))
}
assert  handler.underway == ['use in current project']
assert handler.upcoming == ['re-read DB chapter','use DB/XML combination']