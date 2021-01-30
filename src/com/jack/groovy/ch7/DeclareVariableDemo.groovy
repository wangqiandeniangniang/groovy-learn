package com.jack.groovy.ch7

import groovy.test.GroovyAssert

/**
 * 声明变量
 * @author liangchen* @date 2020/11/8
 */
class DeclareVariableDemo {

    // 成员变量
    public fieldWithModifier
    String typedField
    def untypeField
    protected field1, field2, field3
    private assignedField = new Date()
    static classField
    public static final String CONSTA = 'a', CONSTB = 'b'

    static void main(String[] args) {
        // ClassCastException 类转换异常
        final String PI = '3.14'
        assert PI.class.name == 'java.lang.String'

        assert PI.size() == 4

        GroovyAssert.shouldFail(ClassCastException) {
            Float areaofCircleRadiusOne = PI
        }
    }

    def someMethods(){
        // 本地变量
        def localUntypedMethodVar = 1

        int localTypedMethodVar = 1

        def localVarWithoutAssigment , andAnotherOne

    }

    def localvar = 1,boundvar1 = 1
    def someMethod(){
        def localMethodVar = 1
        boundvar2 = 1
    }



}
