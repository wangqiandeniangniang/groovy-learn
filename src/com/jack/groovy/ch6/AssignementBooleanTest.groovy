package com.jack.groovy.ch6

/**
 *
 * 赋值符号出现在if条件中会怎么样
 * @author liangchen* @date 2020/11/6
 */
class AssignementBooleanTest {

    static void main(String[] args) {
        def x =1
        if (x == 2) {
            assert false
        }
        // true
        if (x = 2) {
            println x
        }

        assert x == 2

        x = 3
        def store = []
        while (x = x - 1) {
            // 把元素放入到store中
            store << x
        }
        assert store == [2, 1]
        while (x = 2) {
            println x
            break
        }
    }

}
