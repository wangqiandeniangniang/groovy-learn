package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.Canonical

/**
 * 集合注解 @Canonical = @ToString, @EqualsAndHashCode, @TupleConstructor
 * @author liangchen* @date 2020/11/12
 */
class Canonical910 extends GroovyTestCase{
    void testCanonical(){
        def i1 = new Inventor('Thomas', 'Edison')
        def i2 = new Inventor('Thomas')
        assert i1 != i2
        assert i1.firstName == i2.firstName
        assert i1.toString()=='com.jack.groovy.ch9.Inventor(Thomas, Edison)'
    }
}
@Canonical
class Inventor{
    String firstName, lastName
}

