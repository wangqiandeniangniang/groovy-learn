package com.jack.groovy.ch5

/**
 * 闭包的作用域
 * @author liangchen* @date 2020/11/5
 */
class ClosureScopeDemo {

    static void main(String[] args) {
        def x = 0
        10.times {
            x++
        }
        assert  x == 10
    }
}
