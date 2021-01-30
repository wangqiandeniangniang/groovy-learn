package com.jack.groovy.ch14

import groovy.xml.DOMBuilder
import groovy.xml.XmlParser
import groovy.xml.XmlSlurper
import groovy.xml.dom.DOMCategory

/**
 * @author liangchen* @date 2020/12/1
 */
//使用DOMCategory解析，变成链表结构的，利用注解获取对应的值，比如@capacity就是获取容量
def doc = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement
use(DOMCategory) {
    assert plan.name() == 'plan'
    assert plan.week[0].name() == 'week'
    assert plan.week[0].'@capacity' == '8'
    assert plan.week.task[0].name() == 'task'
    assert plan.week.task[0].text() == 'easy'
}


// groovy's xmlParser
plan = new XmlParser().parse(new File('data/plan.xml'))
assert  plan.name() == 'plan'
assert plan.week[0].name()== 'week'

def firstTask = plan.week[0].task[0]
assert firstTask.name() == 'task'
assert firstTask.text() == 'easy'
assert firstTask.@title=='read XML chapter'

//使用XmlSlurper() 解析
plan = new XmlSlurper().parse(new File('data/plan.xml'))
assert plan.week.task.size() == 5
//属性字段求和
assert plan.week.task.@done*.toInteger().sum() == 6
assert plan.week[1].task.every { it.@done == '0' }
// 广度遍历
assert plan.breadthFirst()*.name().join('->') ==
        'plan->week->week->task->task->task->task->task'
//深度遍历
assert plan.depthFirst()*.name().join('->') ==
        'plan->week->task->task->task->week->task->task'
// 深度遍历简写
assert plan.depthFirst()*.name() == plan.'**'*.name()
