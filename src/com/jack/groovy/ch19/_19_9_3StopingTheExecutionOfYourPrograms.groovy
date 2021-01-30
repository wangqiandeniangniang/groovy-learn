package com.jack.groovy.ch19

import groovy.test.GroovyAssert
import groovy.transform.TimedInterrupt
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer

import java.util.concurrent.TimeoutException

/**
 * @author liangchen* @date 2020/12/20
 */


// 超时控制
def config = new CompilerConfiguration()
config.addCompilationCustomizers(new ASTTransformationCustomizer(value: 2, TimedInterrupt))
def shell = new GroovyShell(config)
def te = GroovyAssert.shouldFail(TimeoutException) {
    shell.evaluate'''
    for (i in  1..100){
        sleep 1000
    }
   
'''
}