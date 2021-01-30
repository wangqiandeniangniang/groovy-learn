package com.jack.groovy.ch17

import groovy.test.GroovyTestCase

/**
 * @author liangchen* @date 2020/12/13
 */
// 写一个测试某类没有实现方法

public void testNotImplementYet() {
    if (GroovyTestCase.notYetImplemented(this)) {
        return
    }
    fail("will be implemented tomorrow")
}

testNotImplementYet()