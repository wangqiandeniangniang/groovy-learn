package com.jack.groovy.ch10

import groovy.test.GroovyTestCase
import groovy.transform.TypeChecked

/**
 * 方法类型测试
 * @author liangchen* @date 2020/11/13
 */
class TypeTest extends GroovyTestCase {

    void testMethod(){
       assert "2:Hello" == this.greet("Hello")
       assert "1:World" == this.greet((Object)"World")
    }

    /**
     * 默认类型是bject
     * @param message
     * @return
     */
    def greet(message){
        return  "1:$message"
    }

    def greet(String message) {
        return  "2:$message"
    }

//    @TypeChecked
//    void testAssignmentsShouldThrowCompilationErrors(){
//        Set set = new Object()
//        byte b = 200L
//    }

}
