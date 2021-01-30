package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.builder.Builder

/**
 * 建造模式创建对象, 链式调用
 * @author liangchen* @date 2020/11/12
 */
class Builder99  extends GroovyTestCase{

    void testNormalInstance(){
       def c = new Chemist(first: "jack", last: "mar", born: 1822)
    }
    void testUseBuilderInstance(){
        def builder = Chemist.builder()
        def c = builder.first('jack').last('mar').born(1867).build()
        assert c.first == 'jack'
    }
}

@Builder
class Chemist{
    String first, last
    int born
}
