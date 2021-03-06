package com.jack.groovy.ch14

import javax.xml.parsers.DocumentBuilderFactory
import static org.w3c.dom.Node.*;

/**
 * @author liangchen* @date 2020/12/1
 */
//java版解析dom文档

def fac = DocumentBuilderFactory.newInstance()
def builder = fac.newDocumentBuilder()
def doc = builder.parse(new FileInputStream("data/plan.xml"))
def plan = doc.documentElement

String info(node) {
    switch (node.nodeType) {
        case ELEMENT_NODE:
            return "element: $node.nodeName"
        case ATTRIBUTE_NODE:
            return "attribute: $node.nodeName=$node.nodeValue"
        case TEXT_NODE:
            return "text: $node.nodeValue"

    }
    return "some other type: $node.nodeType"
}

assert info(plan) == 'element: plan'
assert plan.childNodes.length == 5

//查找节点为nodeName为week
def firstWeek = plan.childNodes.find { it.nodeName == 'week' }
assert info(firstWeek) == 'element: week'

def firstTask = firstWeek.childNodes.item(1)
assert info(firstTask) == 'element: task'
def firstTaskText = firstTask.childNodes.item(0)
assert info(firstTaskText) == 'text: easy'

def firstTaskTitle = firstTask.attributes.getNamedItem('title')
assert info(firstTaskTitle) == 'attribute: title=read XML chapter'

def firstTaskTitleText = firstTaskTitle.childNodes.item(0)
assert info(firstTaskTitleText) == 'text: read XML chapter'

