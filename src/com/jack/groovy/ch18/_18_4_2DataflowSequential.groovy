package com.jack.groovy.ch18

import groovyx.gpars.dataflow.Dataflow
import groovyx.gpars.dataflow.DataflowQueue

/**
 * @author liangchen* @date 2020/12/18
 */

@Grab('org.codehaus.gpars:gpars:1.2.1')
def chances  = new DataflowQueue()
def amounts = new DataflowQueue()
def payouts = new DataflowQueue()

// 定义输入流和输出流，然后进行具体输入
Dataflow.operator(inputs : [chances, amounts], outputs:[payouts],
        {chance, amount -> payouts << chance * amount})
Dataflow.task {[0,1,0.2, 0.3].each {chances << it}}
Dataflow.task {[300, 200, 100].each {amounts << it}}

[30,40,30].each {assert  it == payouts.val}