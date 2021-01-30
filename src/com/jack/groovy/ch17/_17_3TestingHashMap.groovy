package com.jack.groovy.ch17

import groovy.test.GroovyTestCase

/**
 * @author liangchen* @date 2020/12/13
 */
//测试Hashmap

class HashMapTest extends GroovyTestCase {

    static final KEY = new Object()
    static final MAP = [key1: new Object(), key2: new Object()]

    // 抛出空指针异常
    void testHashtableRejectsNull(){
        shouldFail (NullPointerException){
            new Hashtable()[KEY] = null
        }
    }

    // 创建map传入的长度不对
    void testBadInitialSize(){
        def msg = shouldFail(IllegalArgumentException) {
            new HashMap(-1)
        }
        assertEquals "Illegal initial capacity: -1", msg

    }

    // 判断
    void testHashMapAcceptsNull(){
        def myMap = new HashMap()
        myMap.entrySet().each {
            myMap[it] = MAP[it]
            assertSame Map[it], myMap[it]
        }
        assert MAP.dump().contains("java.lang.Object")
        assert myMap.size() == MAP.size()
    }
}
