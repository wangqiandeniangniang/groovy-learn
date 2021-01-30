package com.jack.groovy.ch8
/**
 * 在类和对象上添加方法和属性
 * @author liangchen* @date 2020/11/11
 */
class MyGroovy1 {

    static void main(String[] args) {
       def before = new MyGroovy1()
        //类添加方法
        MyGroovy1.metaClass.myProp = "MyGroovy prop"
        MyGroovy1.metaClass.test = { -> myProp}

        try{
            // 设置在创建对象之前
            before.test()
            assert false, "should throw MME"
        }catch(mme){}
        // 后面创建对象就可以了
        assert  new MyGroovy1().test() == 'MyGroovy prop'

        //
        def myGroovy =  new MyGroovy2()
        myGroovy.myCustomizeString()
    }
}
class MyGroovy2{

    /**
     * 对象添加方法
     */
    void myCustomizeString(){
        def myGroovy = new String()
        myGroovy.metaClass.myProp = "MyJava prop"
        myGroovy.metaClass.test = { -> myProp }
        try {
            new String().test()
            assert false, 'should throw MME'
        } catch (mme) {
            println "error"
        }
        assert myGroovy.test() == "MyJava prop"
    }
}
