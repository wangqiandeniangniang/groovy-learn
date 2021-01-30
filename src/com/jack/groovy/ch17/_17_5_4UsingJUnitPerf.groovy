package com.jack.groovy.ch17

import com.clarkware.junitperf.ConstantTimer
import com.clarkware.junitperf.LoadTest
import com.clarkware.junitperf.TimedTest
import junit.framework.TestCase
import junit.framework.Test
import junit.textui.TestRunner;
/**
 * @author liangchen* @date 2020/12/13
 */
// 测试性能
@Grab('junitperf:junitperf:1.9.1')
@GrabResolver('https://repository.jboss.org/')

class JUnitPerf extends  TestCase{

    JUnitPerf(String testName) {
        super(testName)
    }

    void testConverter() {
        assert 0 == Converter.celsius(32)
        assert 100 == Converter.celsius(212)
    }

    static main(args) {
        TestRunner.run(suite())
    }

    static Test suite() {
        def testCase = new JUnitPerf('testConverter')
        def numUsers =20
        def stagger = new ConstantTimer(100)
        def loadTest = new LoadTest(testCase, numUsers, stagger)
        def timeLimit = 2100
        return new TimedTest(loadTest, timeLimit)
    }
}