package com.jack.groovy.ch10


import groovy.transform.TypeChecked

/**
 * @author liangchen* @date 2020/11/18
 */

interface Polite{
    void greet()
    void thank()
}

class Person implements Polite {

    @Override
    void greet() {
        String name
        println "Hello , I'm $name!"
    }

    @Override
    void thank() {
        println "Thanks!"
    }

}
class Owl implements Polite{

    @Override
    void greet() {
        hoot()
    }

    @Override
    void thank() {
        hoot()
    }
    void hoot(){
        println "Hoot"
    }
}
//@TypeChecked
void main(){
    def list = [new com.jack.groovy.ch10.Person(name:"Bill"), new com.jack.groovy.ch10.Owl()]
    Polite p1 = list[0]
    Polite o1 = list[1]
    Owl o2 = list[1] as Owl
    Person p2 = list[0] as Person

}
//@TypeChecked, Date 和 Hello 公用父类是Serializable, 就会去这类去找是否存在time属性
void leastUpperBoundOnConditional() {
    def o = new Date()
    if (Math.random()) {

        o = 'Hello'
    }
    o.time
}