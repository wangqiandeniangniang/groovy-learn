package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.AutoClone
import groovy.transform.AutoCloneStyle
import groovy.transform.TupleConstructor

/**
 * @AutoClone 克隆注解
 *
 * @author liangchen* @date 2020/11/13
 */
class AutoClone720  extends GroovyTestCase{

    void testAutoClone(){
        def name = "Heston Blumenthal"

        def recipes =["Snail porridge","Bacon & egg ice cream"]
        def born = Date.parse("yyyy-MM-dd", '1999-01-01')

        def c1 = new Chef1( name,  recipes,  born)
        def c2 = c1.clone()
        assert  c2.recipes == recipes
        assert c1.name == c2.name
    }

    void testAutoCopyConstructor() {
        def name = 'Jamie Oliver'

        def recipes = ['Lentil Soup', 'Crispy Duck']

        def born = Date.parse('yyyy-MM-dd', '1975-05-27')

        def c1 = new Chef2(name, born, recipes)

        def c2 = c1.clone()

        assert c2.name == name

        assert c2.born == born

        assert c2.recipes == recipes
    }
}

/**
 * 提供四种类型， CLONE：不提供深度拷贝，不适合final修饰属性
 * SIMPLE : 只会调用无参构造方法，不支持深度拷贝
 * COPY_CONSTRUCTOR 不支持深度拷贝，支持final修饰属性
 * SERIALIZATION ： 支持深度拷贝，不适合final修饰属性拷贝
 */
@AutoClone
class Chef1{

    String  name

    List<String> recipes

    Date born
}

@TupleConstructor
@AutoClone(style=AutoCloneStyle.COPY_CONSTRUCTOR)

class Person {

    final String name

    final Date born

}



@TupleConstructor(includeSuperProperties=true, callSuper=true)
@AutoClone(style=AutoCloneStyle.COPY_CONSTRUCTOR)

class Chef2 extends Person {

    final List<String> recipes

}