package com.jack.groovy.ch18

import groovyx.gpars.dataflow.Dataflow
import groovyx.gpars.dataflow.Dataflows

/**
 * @author liangchen* @date 2020/12/18
 */
@Grab('org.codehaus.gpars:gpars:1.2.1')

// 三个任务，一个任务是要算计一个值， 但是缺少 x， y值， 直到另外两个线程赋值 x,y
final flow = new Dataflows();
Dataflow.task {flow.result= flow.x + flow.y}
Dataflow.task { flow.x = 10 }
Dataflow.task { flow.y = 5 }
// 满足即可出结果，忽略下列的值
Dataflow.task {flow.x=100}
assert 15 == flow.result


