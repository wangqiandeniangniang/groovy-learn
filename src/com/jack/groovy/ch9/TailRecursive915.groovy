package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.TailRecursive

/**
 * @author liangchen* @date 2020/11/12
 */
class TailRecursive915 extends GroovyTestCase{

    void testTailRecursive(){
        assert ListUtil.reverse(['1','2','3']) == ['3','2','1']
    }

}

class ListUtil{
    static reverse(List list) {
        doReverse(list,[])
    }

    @TailRecursive
    private static doReverse(List todo, List done) {
        if(todo.isEmpty()) done
        else doReverse(todo.tail(), [todo.head()] + done)
    }
}
