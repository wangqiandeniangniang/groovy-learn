package com.jack.groovy.ch18

import groovyx.gpars.dataflow.Dataflow
import groovyx.gpars.dataflow.Dataflows

/**
 * @author liangchen* @date 2020/12/18
 */
@Grab('org.codehaus.gpars:gpars:1.2.1')
def flow = new Dataflows()
Dataflow.task { flow.list = [0] }
Dataflow.task { flow.list[0] = 1 }
println flow.list