package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.ToString

/**
 * 使用groovy 的@ToString注解
 * @author liangchen* @date 2020/11/12
 */
class ToString91_92 extends GroovyTestCase{

    void testToStringToGenerating(){
        def sherLock = new Detective(firtName: "Sherlock", lastName: "Holmes")
        assert sherLock.toString() == 'com.jack.groovy.ch9.Detective(Sherlock, Holmes)'
    }

    void testToStringParameters(){
        def nancy = new Sleuth(firstName: 'Nancy',lastName: 'Drew')
        assert nancy.toString() == 'com.jack.groovy.ch9.Sleuth(firstName:Nancy, lastName:Drew)'
        // 忽略null值
        nancy.lastName=null
        assert nancy.toString() == 'com.jack.groovy.ch9.Sleuth(firstName:Nancy)'
    }
}
@ToString
class Detective{
    String firtName, lastName
}

//包括字段名且忽略null的字段
@ToString(includeNames = true, ignoreNulls =true)
class Sleuth{
    String firstName, lastName
}
