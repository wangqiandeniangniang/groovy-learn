package com.jack.groovy.ch6

/**
 * if语句
 * @author liangchen* @date 2020/11/6
 */
class ifDmeo {
    static void main(String[] args) {

        if (true)  assert true
        else assert false

        if (1) {
            assert true
        } else {
            assert false
        }

        if ('nonempty') {
            assert true
        }else if (['x']) {
            assert false
        } else {
            assert false
        }

        if (0) {
            assert false
        }else if ([]) {
            assert false
        } else {
            assert true
        }
    }
}
