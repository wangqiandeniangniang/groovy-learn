package com.jack.groovy.ch5

/**
 *
 * groovy 累加器
 * @author liangchen* @date 2020/11/6
 */
class AccumulatorTest {

    static void main(String[] args) {
        def accumulator = foo(1)
       // 1+2 ==3
        assert  accumulator(2) == 3
        // 3+1 ==4
        assert accumulator(1) == 4
        // 4+1==5
        assert accumulator(1) == 5

    }

   static def foo(n) {
        return { n += it }

    }

}
