package com.jack.groovy.ch10

import groovy.transform.TypeChecked

/**
 * @author liangchen* @date 2020/11/18
 */

//@TypeChecked
def flowTyping() {
    // 一个变量名，会有不同类型值， 这个var的类型是动态
    def var = 'A String'
    var = var.toUpperCase()
    var = var.length()
    var = String.valueOf(var)
    var = 2*var

}

interface Flying{
    void fly()
}
class Bird implements  Flying{
    void fly(){
        println "I'm flying"
    }
}
class Canary extends Bird{
    void sing(){
        println "Tweet!"
    }
}


/**
 *引用也是
 */
@TypeChecked
void aviary(){
    def o = new Bird()
    o.fly()
    o = new Canary()

    o.fly()
    o.sing()
}
aviary()