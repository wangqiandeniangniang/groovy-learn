package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.TimedInterrupt

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * @author liangchen* @date 2020/11/13
 */
class TimedInterrupt923 extends GroovyTestCase{


    void testBlastOff1(){
        def b = new BlastOff1()
        Thread.start {
            try {
                b.countdown(10)
            } catch (TimeoutException ignore) {
                b.logs << 'aborted'
            }
        }.join()
        assert b.logs.join(' ') == '10 9 8 7 6 aborted'
    }
}

/**
 * 超过480毫米自动打断方法，触发timeInterrupt
 */
@TimedInterrupt(value = 480L,unit = TimeUnit.MILLISECONDS)
class BlastOff1 {
    def logs = []

    def countdown(n) {
        sleep 100
        logs << n
        if (n == 0) {
            logs << 'ignition'
        }else countdown(n -1)
    }
}
