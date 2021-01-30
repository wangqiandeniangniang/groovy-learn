package com.jack.groovy.ch14

import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlSlurper

/**
 * @author liangchen* @date 2020/12/4
 */
// 生成没有修改流的xml
def path = new XmlSlurper().parse(new File('data/plan.xml'))
def builder = new StreamingMarkupBuilder()
// 去掉空格形成一行
def copier = builder.bind {mkp.yield(path)}
def result = "$copier"

assert result.startsWith('<plan><week')
assert result.endsWith('</week></plan>')
//打印到控制台
System.out << copier


// 通过流将xml转换HTML, 流式解析
def taskStatus(task) {
    switch (task.@done.toInteger) {
        case 0: return 'scheduled'
        case 1..<task.@total.toInteger() : return 'in progress'
        default: return 'finished'
    }
}

def weekStatus(week) {
    if(week.task.every { taskStatus(it) == 'finished' }){
        return 'finished'
    }
    if(week.task.any{taskStatus(it) == 'in progress'}){
        return 'in progress'
    }
    return 'scheduled'
}

def plan = new XmlSlurper().parse(new File('data/plan.xml'))
Closure markup = {
    html{
        head{
            title('Current Groovy progress')
            link(rel:'stylesheet',
                type: 'text/css',
                href: 'style.css')
        }
        body{
            plan.week.eachWithIndex{ week, i ->
                h1("Week No. $i: ${owner.weekStatus(week)}")
                d1 {
                    week.task.each{task ->
                        def status = owner.taskStatus(task)
                        dt(class: status, task.@title)
                        dd("(${task.@done}/${task.@total}): $status")
                    }
                }

            }
        }
    }
}
def heater = new StreamingMarkupBuilder().bind(markup)
def outfile = new File('data/StreamedGroovyPlans.xml')
outfile.withWriter {it << heater}