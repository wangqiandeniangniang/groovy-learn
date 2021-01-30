package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.ThreadInterrupt

/**
 * 线程打断, 这里例子有问题
 * @author liangchen* @date 2020/11/13
 */
class ThreadInterrupt924 extends GroovyTestCase{

    void testThreadInterrupt(){
        def b = new BlastOff2()
        def t1 = Thread.start {
            try {
                println 1
                b.countdown(10)
                println 2
            } catch (InterruptedException ignore) {
                b.logs << 'aborted'
            }
        }
        sleep 300
        println 3
        t1.interrupt()
        t1.join()
        assert  b.logs.join(' ')=='10 9 8 7 6 5 4 3 2 1 0 ignition'
    }
}

@ThreadInterrupt()
class BlastOff2 {
    def logs = []

    def countdown(n) {
        sleep 100
        logs << n
        if (n == 0) {
            logs << 'ignition'
        }else countdown(n -1)
    }
}
