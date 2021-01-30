package com.jack.groovy.ch14

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

/**
 * @author liangchen* @date 2020/12/4
 */
// 14.14XPath 使用
def doc = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement
def xpath = XPathFactory.newInstance().newXPath()
def out = new StringBuilder()
use(DOMCategory){

    xpath.evaluate('//week', plan, XPathConstants.NODESET).eachWithIndex{  wk,  i ->
        out << "\nWeek No. $i\n"
        int total = xpath.evaluate('sum(task/@total)', wk,XPathConstants.NUMBER)
        int done = xpath.evaluate('sum(task/@done)', wk, XPathConstants.NUMBER)
        out << " planned $total of ${wk.'@capacity'}\n"
        out << " done   $done of $total"
    }
}
System.out << out