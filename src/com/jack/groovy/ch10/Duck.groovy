package com.jack.groovy.ch10

/**
 * @author liangchen* @date 2020/11/13
 */
class Duck101  {

    def methodMissing(String name, Object args) {
        println "$name!"
    }

}
def duck = new Duck101()
duck.quack()