package com.jack.groovy.ch2

/**
 * 就是一个数组，提供这种语法糖
 * @author liangchen* @date 2020/10/22
 */
class RangeDemo {


    static void main(String[] args) {
        def x = 1..10
        assert   x.contains(5)
        assert !x.contains(11)
        assert x.size() ==10
        assert x.from == 1
        assert x.to == 10
        assert x.reverse() == 10..1
    }
}
