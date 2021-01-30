package com.jack.groovy.ch17

import groovy.test.GroovyTestCase
import junit.framework.TestCase
import org.junit.Test

/**
 * @author liangchen* @date 2020/12/13
 */
class SimpleUnitTest extends GroovyTestCase {
    //直接继承GroovyTestCase ，且方法名需要以test开头
    void testSimple(){
        assertEquals("Groovy should add correctly", 2, 1+1)
    }
}

import static org.junit.Assert.assertEquals
// 或者不继承GroovyTestCase ，直接使用注解
class SimpleUnitAnnotationTest{

    @Test
    void shouldAdd() {
        assertEquals("Groovy should add correctly", 2, 1 + 1)

    }
}


//或者直接继承TestCase
class AnotherSimpleUnitTest extends TestCase{

    void testSimpleAgain(){
        assertEquals("should substract correctly too", 2, 3-1)
    }
}