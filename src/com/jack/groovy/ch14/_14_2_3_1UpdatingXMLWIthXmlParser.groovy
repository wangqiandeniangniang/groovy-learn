package com.jack.groovy.ch14

import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil

/** 采用 XmlParser更新
 * @author liangchen* @date 2020/12/4
 */

def plan = new XmlParser().parse(new File('data/plan.xml'))
// 第一个week，第三个task的属性为2
plan.week[0].task[2].@done = '2'
plan.week[0].task[2].value = 'time saver'

// 替换第2个week，第二个task
plan.week[1].task[1].replaceNode{
    task(done:'0', total:'4', title:'build web service')
}

// 在第二个task新增一个节点task
plan.week[1].task[1] + {
    task(done:'0', total:'1', title:'build web service client')
}
UpdateChecker.check(XmlUtil.serialize(plan))

// XmlSlurper修改数据本质和 xmlParser无关

def slurper = new XmlSlurper().parse(new File('data/plan.xml'))
// 第一个week，第三个task的属性为2
plan.week[0].task[2].@done = '2'
plan.week[0].task[2].value = 'time saver'

// 替换第2个week，第二个task
plan.week[1].task[1].replaceNode{
    task(done:'0', total:'4', title:'build web service')
}

// 在第二个task新增一个节点task
plan.week[1].task[1] + {
    task(done:'0', total:'1', title:'build web service client')
}
UpdateChecker.check(XmlUtil.serialize(plan))