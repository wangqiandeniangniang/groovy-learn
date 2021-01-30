package com.jack.groovy.ch9


import groovy.test.GroovyTestCase
import groovy.transform.ConditionalInterrupt

/**
 * 这个例子有问题，是不是版本问题导致
 * @author liangchen* @date 2020/11/13
 */
class CondtionalInterrupt925 extends GroovyTestCase{

    void testConditionInterrupte(){
        def b = new BlastOff3()
        try {
            b.countdown()
        } catch (InterruptedException ignore) {
            b.logs << 'aborted'
        }
        assert  b.logs.join(' ') == ''
    }
}

@ConditionalInterrupt(value = {BlastOff3})
class BlastOff3 {
    def logs = []

    def count =10

    def countdown() {
        while (count != 0) {
            logs << count
            count --
        }
        logs << 'ignition'
    }
}