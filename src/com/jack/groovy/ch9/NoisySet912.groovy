package com.jack.groovy.ch9

import groovy.test.GroovyTestCase

/**
 * @Delegate 代理、委托
 * @author liangchen* @date 2020/11/12
 */
class NoisySet912 extends GroovyTestCase {

    void testDelegate(){
        Set ns = new NoisySet();
        ns.add(1)
        ns.addAll([2,3])
        assert ns.size() == 3
    }
}

/**
 * 如果某个类具有委托类能力
 */
class NoisySet {

    @Delegate
    Set delegate = new HashSet()

//    @Delegate
//    Map mapDelegate = new HashMap()

    @Override
    boolean add(item) {
        println "adding $item"
        delegate.add(item)
    }

    boolean addAll(Collection items) {
        items.each {println "adding $it"}
        delegate.addAll(items)
    }

//   Object put(key,value) {
//       mapDelegate.put(key, value)
//    }

}
