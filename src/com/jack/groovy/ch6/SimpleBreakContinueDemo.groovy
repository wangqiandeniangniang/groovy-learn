package com.jack.groovy.ch6

/**
 * break continue
 * @author liangchen* @date 2020/11/8
 */
class SimpleBreakContinueDemo {

    static void main(String[] args) {
        def a = 1
        while (true) {
            a++
            break
        }
        assert  a == 2
        for (i in 0..10) {
            if(i == 0) continue
            a++
            if(i > 0) break
        }
        assert a == 3
    }
}
