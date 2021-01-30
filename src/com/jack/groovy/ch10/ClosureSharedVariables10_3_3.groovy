package com.jack.groovy.ch10

import groovy.transform.TypeChecked

/**
 * @author liangchen* @date 2020/11/18
 */

// 表示外部变量可以在闭包中修改
def captureOfALocalVariable() {
    def msg = 'Hello'
    def cl = { msg = 'Hi!' }
    assert msg == 'Hello'
    cl()
    assert msg == 'Hi!'
}
captureOfALocalVariable()

// 10.38 toUpperCase, 类型不对
//@TypeChecked
void notAllowed(){
    def var = "String"
    def cl = {var  = new Date()}
    cl()
    var = var.toUpperCase()
}
//notAllowed() 报错

// 10.39， valid assignment of closure-shared

class A{
    void foo() {}
}
class B extends A{
    void bar(){}
}
void main(){
    def var = new A()
    def cl = {var = new B()}
    cl()
    var.foo()
}
main()