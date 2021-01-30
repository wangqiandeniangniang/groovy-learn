package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.Memoized

/**
 * 缓存数据
 * @author liangchen* @date 2020/11/12
 */
class Memoized914 extends GroovyTestCase {

    void testMemoized(){
        new Calc().with {
            assert  sum(3,4) == 7
            assert sum(4,4) == 8
            //查询缓存
            assert  sum(3,4) == 7
            assert sum(4,4) == 8
            assert logs.join(" ") == "3+4 4+4"
        }
    }

}

class Calc {
    def logs = []

    @Memoized
    int sum(int a, int b) {
        logs << "$a+$b"
        a + b
    }
}