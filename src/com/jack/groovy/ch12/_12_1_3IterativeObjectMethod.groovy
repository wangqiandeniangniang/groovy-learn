package com.jack.groovy.ch12

/**
 * @author liangchen* @date 2020/11/22
 */

//for (MyClass obj : collection) {
//
//}
//
//// 或者each
//collection.each{}

samples = 4

def domain(yield) {
    step = Math.PI * 2 / samples
    (0..samples).each { yield it * step }

}
domain {println it}
this.&domain.collect{Math.sin(it)}