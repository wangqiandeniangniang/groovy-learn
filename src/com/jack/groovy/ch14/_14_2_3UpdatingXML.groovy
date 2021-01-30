package com.jack.groovy.ch14

import groovy.xml.DOMBuilder
import groovy.xml.XmlUtil
import groovy.xml.dom.DOMCategory

/** 更新xml文件
 * @author liangchen* @date 2020/12/4
 */

// 更新检查
class UpdateChecker{
    static check(text) {
        def updated = new XmlParser().parseText(text)
        updated.week[0].with{w0 ->
            //第一周所有done的值之和是否等于7
           assert w0.task.@done*.toInteger().sum() == 7
            assert w0.find{ it.text() == 'time saver'}
        }
        updated.week[1].with{w1 ->
            assert  w1.children().size() ==2
            assert w1.find{it.@total == '1'}
            assert w1.find{it.@title == "build web service client"}
            assert !w1.find{it.@title == 'use DB/XML combination'}
        }
    }
}

// 变更dom数据
def doc = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement
use(DOMCategory) {
    plan.week[0].task[2]['@done'] = '2'
    plan.week[0].task[2].value = 'time saver'
    plan.week[1].task[1].replaceNode{
        task(done:'0', total:'1', title:'build web service client')
    }
}
UpdateChecker.check(XmlUtil.serialize(plan))