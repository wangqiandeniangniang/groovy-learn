package com.jack.groovy.ch8

import groovy.test.GroovyTestCase

/**
 * 自导自演
 * @author liangchen* @date 2020/11/12
 */
class Intercept827 extends GroovyTestCase{

    void  testInterceptCacheInvokePattern(){
        ArrayList.metaClass.methodMissing= {String name, Object args ->
            assert name.startsWith("findBy")
            assert args.size() ==1
            // 定义一个方法
            Object.metaClass."$name" = {value ->
                delegate.find{ it[name.toLowerCase()-'findby'] == value}
            }
            // 直接调用刚刚定义的方法
            delegate."$name"(args[0])
        }

        def data = [
                [name:'moon', au:0.0025],
                [name:'sun',au:1],
                [name:'nepture', au: 30]
        ]
        assert data.findByName('moon')
        assert data.findByName('sun')
        assert data.findByAu(1)
        assert data.find{it['name']=='moon'}
    }


}
