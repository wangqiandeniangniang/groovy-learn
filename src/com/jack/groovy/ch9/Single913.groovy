package com.jack.groovy.ch9

import groovy.test.GroovyTestCase

/**
 * @author liangchen* @date 2020/11/12
 */
class Single913 extends GroovyTestCase {

    void testSingletonInstance(){
        assert Zeus.instance
        def ex = shouldFail (RuntimeException){
            new Zeus()
        }
        assert ex.toString()== "Can't instantiate singleton com.jack.groovy.ch9.Zeus. Use com.jack.groovy.ch9.Zeus.instance"
    }
}

@Singleton
class Zeus{}
