package com.jack.groovy.ch8

/**
 * Expando 相当于一个盒子，你可以自定义你类和方法
 * @author liangchen* @date 2020/11/11
 */
class Expando89 {

    static void main(String[] args) {
        def boxer = new Expando()
        // 定义一个方法takThis 返回值good!
        boxer.takeThis = 'good!'
        //定义闭包 调用三次takeThis方法，字符串拼接
        boxer.fightBack = { times -> takeThis * times }
        assert boxer.fightBack(3) == 'good!good!good!'

        //
        def addLow= new AddLowMethodToString810()
        addLow.addLowMethod()

    }
}
/** 利用 ExpandoMetaClass
 * 新增low方法 toLowerCase
 */
class AddLowMethodToString810{

    void addLowMethod(){
        assert  String.metaClass =~ /MetaClassImpl/
        // 新增low 调用toLowerCase -> 前面没有值表示无参
        String.metaClass.low = {-> delegate.toLowerCase()}
        assert String.metaClass =~ /ExpandoMetaClass/
        assert "DiErK".low() == 'dierk'
    }
}
