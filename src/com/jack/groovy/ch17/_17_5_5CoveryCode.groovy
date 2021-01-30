package com.jack.groovy.ch17

import groovy.test.GroovyTestCase

/**
 * @author liangchen* @date 2020/12/14
 */
// 代码覆盖测试

class BiggestPairCalc{
    int sumBiggestPair(a, b, c) {
        def op1 = a
        def op2 = b
        if (c > a) {
            op1 = c
        }else if (c > b) {
            op2 = c
        }
        return op1 + op2
    }
}

class BiggestPairCalcTest extends  GroovyTestCase{
    void testSumBiggestPair(){
        def calc = new BiggestPairCalc()
        assertEquals(9, calc.sumBiggestPair(5, 4,1))
        assertEquals(15, calc.sumBiggestPair( 5, 9, 6))

      assertEquals(16, calc.sumBiggestPair(10, 2, 6))
//        assertEquals(11, calc.sumBiggestPair(5, 2, 6))

    }
}
