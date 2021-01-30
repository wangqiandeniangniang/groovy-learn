package com.jack.groovy.ch8

/**
 * metaClass 理解
 * @author liangchen* @date 2020/11/11
 */
class MetaClass87 {

    static void main(String[] args) {
        MetaClass mc= String.metaClass
        final Object[] NO_ARGS = []
        // 返回值数量
        assert  1 == mc.respondsTo("toString", NO_ARGS).size()
        // 属性
        assert 3 == mc.properties.size()
        // 方法个数
        assert 76 == mc.methods.size()
        // meta方法
        assert 215 == mc.metaMethods.size()
        // 调用toString方法
        assert "" == mc.invokeMethod("", "toString", NO_ARGS)
        //调用静态方法
        assert null == mc.invokeStaticMethod(String, "println", NO_ARGS)
        //调用构造方法
        assert "111111" == mc.invokeConstructor("111111")

    }
}
