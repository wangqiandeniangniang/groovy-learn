package com.jack.groovy.ch17

import groovy.test.GroovyLogTestCase
import java.util.logging.Level
import java.util.logging.Logger

/**
 * @author liangchen* @date 2020/12/13
 */
//主要记录测试的日志

class LoggingCounter{
    static final LOG = Logger.getLogger('LoggingCounter')

    def biggerThan(items, target) {
        def count = 0
        items.each {
            if (it > target) {
                count++
                LOG.finer("item was bigger - count this one")
            }else if (it == target) {
                LOG.finer "item was equal - don't count this one"
            } else {
                LOG.finer "item was smaller - don't count this one"
            }
        }
        return count
    }
}
class LoggingCounterTest extends GroovyLogTestCase {
    static final MIXED_NUMBERS = [99, 2, 1, 0, -1, -2, -99]
    private count
    void setUp(){
        //初始化创建对象
        count = new LoggingCounter()
    }

    void testCounterAndLog(){
        // 将日志转换成字符串，确定收集日志的级别和类，我们是不是利用这个类收集一下mybatis打印的sql语句日志？可以试一下
        // 非侵入式测试
        def log = stringLog(Level.FINER, 'LoggingCounter'){
            def bigger = count.biggerThan(MIXED_NUMBERS, -1)
            assertEquals( 4, bigger)
        }
        checkLogCount(1, "was equal", log)
        checkLogCount(4, "was bigger", log)
        checkLogCount(2, "was smaller", log)
        checkLogCount(4,/[^d][^o][^n][^'][^t] count this one/, log)
        checkLogCount(3, "don't count this one", log)
    }

    private checkLogCount(expectedCount, regex, log) {
        def matcher = (log =~ regex)
        assertTrue log, expectedCount == matcher.count
    }

}
