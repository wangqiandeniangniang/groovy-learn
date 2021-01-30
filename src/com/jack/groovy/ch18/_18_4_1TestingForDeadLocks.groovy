package com.jack.groovy.ch18

import groovyx.gpars.dataflow.Dataflow
import groovyx.gpars.dataflow.Dataflows

/**
 * @author liangchen* @date 2020/12/18
 */
@Grab('org.codehaus.gpars:gpars:1.2.1')
//
def flow = new Dataflows()
Dataflow.task { flow.x = flow.y }
Dataflow.task{flow.y = flow.x}

