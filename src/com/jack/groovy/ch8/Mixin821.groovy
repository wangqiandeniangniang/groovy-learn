package com.jack.groovy.ch8

import groovy.test.GroovyTestCase

/**
 * 合并方法
 * @author liangchen* @date 2020/11/11
 */
class Mixin821 {
}

//这个相当于继承了MessageFeature,具有它的方法
@Mixin(MessageFeature)
class FirstTest extends GroovyTestCase{
    void testWithMixinUsage(){
        message = "Called from Test"
        assertMessage "Called from Test"
    }
}

class MessageFeature{
    def message

    void assertMessage(String msg) {
        assertEquals msg, message
    }
}