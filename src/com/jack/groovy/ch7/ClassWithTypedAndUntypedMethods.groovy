package com.jack.groovy.ch7

/**
 * 声明方法 和入参类型
 * @author liangchen* @date 2020/11/8
 */
class ClassWithTypedAndUntypedMethods {

    static void main(args) {
        def some = new ClassWithTypedAndUntypedMethods()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()
        assert 'ho' == some.publicTypeMethod()
        def classWith = new ClassWithTypedAndUntypedMethodParams()
        // 入参类型
        assert 'untyped' == classWith.method(1)
        assert 'typed' == classWith.method('whatever')
        assert  'two args' == classWith.method(1,2)

    }


    /**
     * 没有返回值
     */
    void publicVoidMethod(){}

    /**
     * 没有返回类型方法
     * @return
     */
    def publicUntypedMethod(){
        return 'hi'
    }

    /**
     * 有返回值类型
     * @return
     */
    String publicTypeMethod(){
        return 'ho'
    }
    private static final void combinedMethod(){}
}

class ClassWithTypedAndUntypedMethodParams {
    static void main(args) {

    }

    /**
     * 不确定类型入参
     * @param arg
     * @return
     */
    static method(arg){
        return 'untyped'
    }

    /**
     * 有类型入参
     * @param arg
     * @return
     */
    static method(String arg) {
        return 'typed'
    }

    /**
     * 两个参数
     * @param arg1
     * @param arg2
     * @return
     */
    static method(arg1, Number arg2) {
        return 'two args'
    }
}
