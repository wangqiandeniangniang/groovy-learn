package com.jack.groovy.ch17

import groovy.test.AllTestSuite
import groovy.test.GroovyTestSuite

/**
 * @author liangchen* @date 2020/12/13
 */

/**
 * 将多个脚本集合在一起跑
 */
import junit.framework.*
import junit.runner.TestRunListener
import junit.textui.TestRunner

static  Test suite(){

    def suite = new TestSuite()
    def gts = new GroovyTestSuite()
    suite.addTestSuite(gts.compile("src/com/jack/groovy/ch17/_17_2Counter.groovy"))
    suite.addTestSuite(gts.compile("src/com/jack/groovy/ch17/_17_3TestingHashMap.groovy"))
    return suite
}
// 跑多个脚本
TestRunner.run(suite())
// 利用匹配表达式
def suiteAll = AllTestSuite.suite(".", "_17_2Counter*.groovy")
TestRunner.run(suiteAll)