package com.jack.groovy.ch8

import groovy.test.GroovyTestCase

import java.awt.Dimension

/**
 * @author liangchen* @date 2020/11/11
 */
class FactoryReplace824  extends GroovyTestCase{
    void testDefiniteStaticFactoryForAllClass(){
        //为所有Class添加一个make方法
        Class.metaClass.make = { Object[] args ->
            delegate.metaClass.invokeConstructor(*args)

        }
        assert new HashMap<>() == HashMap.make()
        assert new Integer(42) == Integer.make(42)
        assert new Dimension(2,3) == Dimension.make(2,3)
    }
}
