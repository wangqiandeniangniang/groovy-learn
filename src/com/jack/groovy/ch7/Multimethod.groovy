package com.jack.groovy.ch7
/**
 * 方法重载
 * @author liangchen* @date 2020/11/10
 */
class Multimethod {

    def oracle(Object o) {
        return 'object'
    }

    def oracle(String o) {
        return 'string'
    }

    static void main(String[] args) {
       def multi =  new Multimethod()
        Object x =1
        Object y = 'foo'

        assert 'object' == multi.oracle(x)

        assert 'string' == multi.oracle(y)

    }

}

