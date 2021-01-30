package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.EqualsAndHashCode

/**
 * @EqualAndHashCode
 * @author liangchen* @date 2020/11/12
 */
class EqualsAndHashCode93 extends GroovyTestCase {

    void testGeneratesEqualAndHashCodeMethods(){

        def magneto = new Actor(firstName: "Ian", lastName: "McKellen")
        def gandalf = new Actor(firstName: "Ian", lastName: "McKellen")
        assert  magneto == gandalf
    }
}

@EqualsAndHashCode
class Actor{
    String firstName, lastName
}
