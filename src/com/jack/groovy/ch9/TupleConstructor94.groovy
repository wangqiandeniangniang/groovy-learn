package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.TupleConstructor

/**
 * @TupleConstructor 生成各种参数的构造方法
 * @author liangchen* @date 2020/11/12
 */
class TupleConstructor94  extends GroovyTestCase{
    void testTupleConstructorToGenerateJava(){

        def al = new Athlete('Michael', 'Jordan')
        def a2 = new Athlete('Michael')
        assert al.firstName == a2.firstName
    }
}

@TupleConstructor
class Athlete{

    String firstName, lastName
}

