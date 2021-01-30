package com.jack.groovy.ch5

/** 这有问题
 * @author liangchen* @date 2020/11/4
 */
class FullClosure {

    static void main(String[] args) {

        // 遍历元素 值*2
        Map map = ['a': 1, 'b': 2]
        map.each { key, value -> map[key] = value * 2 }
        assert map == ['a':2, 'b':4]

        // 先定义Closure
        Closure doubler = { key, value -> map[key] = value * 2 }
        map.each {doubler}
        assert map == ['a': 4, 'b': 8]

        doubler= FullClosure.&doubleMethod
        map.each {doubler}
        assert map == ['a': 8, 'b': 16]

    }
    static def doubleMethod (entry) {
        entry.value = entry.value * 2
    }
}
