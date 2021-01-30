package com.jack.groovy.ch8

import groovy.test.GroovyTestCase

/**
 * ArrayList的mixin的方法
 * @author liangchen* @date 2020/11/11
 */

class Even822 extends GroovyTestCase{

    void testArrayListMixin() {
        //合并多个方法，这样读起来很简洁
        ArrayList.mixin EvenSieve, MinusSieve,PlusSieve
        //这里-， + 分别执行MinusSieve的minus 和PlusSieve.plus
        assert (0..10).toList().no2-3+7==[1,5]
    }
}
class EvenSieve {
    def getNo2(){
        removeAll { it % 2 == 0 }
        return this
    }

}
/**
 * 执行减法时候，说明groovy 内置minus方法
 */
class MinusSieve{
    def minus(int num) {
        removeAll { it % num == 0 }
        return this
    }
}

/**
 * 执行加法时候调用这个方法 说明groovy 内置plus方法
 */
class PlusSieve{
    def plus(int num) {
        removeAll { it % num == 0 }
        return this
    }
}
