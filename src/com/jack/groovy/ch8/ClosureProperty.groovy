package com.jack.groovy.ch8

/**
 * 重写Closure来动态方法
 * @author liangchen* @date 2020/11/10
 */
class ClosureProperty {

    Closure whatToDo = {name -> "accessed $name"}

    def propertyMissing(String name) {
        whatToDo(name)
    }

    static void main(String[] args) {
        def one = new ClosureProperty()
        assert one.hello == 'accessed hello'
        //重写闭包实现动态方法特性
        one.whatToDo = {name -> name.size()}
        assert one.hello == 5
    }
}
