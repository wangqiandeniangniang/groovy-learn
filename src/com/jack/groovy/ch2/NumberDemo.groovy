package com.jack.groovy.ch2

/**
 * @author liangchen* @date 2020/10/22
 */
class NumberDemo {

    static void main(String[] args) {
        def  x = 1
        def  y = 2
        assert  x + y == 3
        assert  x.plus(y) == 3
        assert  y instanceof Integer
    }
}
