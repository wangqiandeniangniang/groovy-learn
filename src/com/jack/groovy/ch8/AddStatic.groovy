package com.jack.groovy.ch8

/**
 * 添加静态方法 和父类添加的方法子类都可以共享
 * @author liangchen* @date 2020/11/11
 */
class AddStatic {

    static void main(String[] args) {
        // 添加静态方法
        Integer.metaClass.static.answer = {-> 42}
        assert Integer.answer() == 42

        //父类添加的方法，子类都是可以共享的
        MySuperGroovy.metaClass.added = {-> true}
        //子类共享
        assert new MySubGroovy().added()

        Map.metaClass.toTable = {
            // 变更展示的方式
            -> delegate.collect{[it.key, it.value]}
        }
        assert [a:1,b:2].toTable() == [["a",1],["b",2]]

    }

}
/**
 * 父类添加的方法，子类都是可以共享的
 */

class MySuperGroovy{}

class MySubGroovy extends  MySuperGroovy{}

