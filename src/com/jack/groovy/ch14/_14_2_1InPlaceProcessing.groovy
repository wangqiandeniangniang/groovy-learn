package com.jack.groovy.ch14

import groovy.xml.MarkupBuilder

/**
 * @author liangchen* @date 2020/12/4
 */

// 在内存准备生成HTML 报告
// 数字字符串，转成 数字类型
void numberfy(Node node) {
    def atts = node.attributes()
    atts.keySet().grep(['capacity', 'total', 'done']).each {
        atts[it] = atts[it].toInteger()
    }
    node.each{
        if(it instanceof  Node) numberfy(it)
    }
}

// done 和 total属性，给这个node节点增加字段status（scheduled, in progress, finished)
void taskStatus(task) {
    def atts = task.attributes()
    switch (atts.done) {
        case 0: atts.status = 'scheduled'; break
        case 1..<atts.total: atts.status = 'in progress'; break
        default: atts.status = 'finished';
    }
}

// 设置week属性，增加status默认是scheduled，
void weekStatus(week) {
    week.task.each{
        taskStatus(it)
    }
    def atts = week.attributes()
    atts.status = 'scheduled'
    // 遍历每个节点task的状态是否全部为完成
    if(week.task.every { it.@status == 'finished' }){
        atts.status = 'finished'
    }
    // 遍历任意一个为task状态 it.@status=in progress
    if(week.task.any { it.@status == 'in progress' }){
        atts.status = 'in progress'
    }
}

void htmlReport(builder, plan) {
    builder.html{
        head{
            title('Current Groovy progress')
            link(rel:'stylesheet',
                type: 'text/css',
                href :'style.css')
        }
        body{
            // 节点本身和索引位置
            plan.week.eachWithIndex{ week, i ->
                h1("Week No. $i:${week.@status}")
                d1 {
                    week.task.each { task ->
                        dt(class: task.@status, task.@title)
                        dd("(${task.@done}/${task.@total}): ${task.@status}")
                    }
                }

            }
        }
    }
}

def node = new XmlParser().parse(new File('data/plan.xml'))
numberfy(node)
node.week.each{weekStatus(it)}
new File('data/GroovyPlans.html').withWriter {writer ->
    def builder = new MarkupBuilder(writer)
    htmlReport(builder, node)
}