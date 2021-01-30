package com.jack.groovy.ch2

import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

/**
 * @author liangchen* @date 2020/10/22
 */
class Universe {

    @groovy.transform.TypeChecked(TypeCheckingMode.PASS)
    int answer() {
//        "forty two"
    }

     static void main(String[] args) {
        new Universe().answer();
    }
}
