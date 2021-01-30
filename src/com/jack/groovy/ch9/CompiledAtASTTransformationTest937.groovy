package com.jack.groovy.ch9

import groovy.test.GroovyTestCase

/**
 * @author liangchen* @date 2020/11/13
 */
class CompiledAtASTTransformationTest937 extends GroovyTestCase {

    // 匹配格式，format:EEE MMM dd HH:mm:ss zzz yyy
    static DATE_FMT = /\w{3} \w{3} \d\d \d\d:\d\d:\d\d \S{3,9} \d{4}/


    @Override
    protected void setUp() throws Exception{
        super.setUp()
    }

    void testShouldApplytoThisTest(){
        assert compiledTime.toString =~ DATE_FMT
    }

    void testShouldApplyToScriptAndScriptClasses(){
        assertScript """
           import static com.jack.groovy.ch9.CompiledAtASTTransformationTest937.*
           
           assert compiledTime.toString() =~ DATE_FMT
           class MyClass{}
           
           assert MyClass.compiledTime.toString() =~ DATE_FMT 
"""
    }
}

