package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.Immutable

/**
 * 一旦实例化属性就不能修改
 * @author liangchen* @date 2020/11/12
 */
class Immutable911  extends GroovyTestCase{

    void testImmutable(){
        def g1 = new Genius(firstName: 'Albert',lastName: 'Einstein')
        assert g1.toString() == 'com.jack.groovy.ch9.Genius(Albert, Einstein)'

        def g2 = new Genius('Leonardo', 'da Vinci')
        assert g2.firstName == 'Leonardo'
        assert g1 != g2
        shouldFail (ReadOnlyPropertyException) {
            g2.lastName = 'DiCaprio'
        }
    }
}

@Immutable
class Genius{
   String firstName, lastName
}
