package com.jack.groovy.ch15

import groovy.xml.Namespace

/**
 * @author liangchen* @date 2020/12/6
 *
 */
// 获取bbc的头三条消息
def base = 'http://news.bbc.co.uk/rss/newsonline_uk_edition/'

def url = base + 'front_page/rss091.xml'

println 'The top three news items today:'
//其实就是一个xml文件
def items = new XmlParser().parse(url).channel[0].item
for (item in items[0..2]) {
    // 标题
    println item.title.text()
    //详情地址url
    println item.link.text()
    // 描述
    println item.decription.text()
    println '---------------'
}
// RSS 结构
//        <rss ...>
//
//          <channel>
//
//              ...
//
//              <item>
//
//                  <title>...</title>
//
//                  <description>...</description>
//
//                   <link>...</link>
//
//                    ...

// 使用Atom feed解析
def urlAtom = 'http:/www.ibm.com/developerworks/views/java/rss' +
        'libraryview.jsp?feed_by=atom'
def atom = new Namespace('http://www.w3.org/2005/Atom')
def numEntries = 3
def entries = new XmlParser().parse(url)[atom.entry][0..<numEntries]
def len = "dd mmm yyyy ".size()
def summaries = entries.collect {
    it[atom.published].text()[0..<len] +
            (it[atom.summary].text().contains('Groovy') ? '*' : ' ')+
            it[atom.title].text()
}
println summaries.join("\n")

// Atom 格式结构
//        <feed xmlns="http://www.w3.org/2005/Atom">
//
//            ...
//
//            <entry>
//
//                  <title>Java.next: The Java.next languages</title>
//
//                      ...

