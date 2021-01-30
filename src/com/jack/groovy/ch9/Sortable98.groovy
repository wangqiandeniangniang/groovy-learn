package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.Sortable

/**
 * @Sortable 注解，有序
 * @author liangchen* @date 2020/11/12
 */
class Sortable98  extends GroovyTestCase{

    void testSortableGenerateComparableMethod() {
        def politicians = [
                new Politician(first: 'Margaret', initial: 'H', last: 'Thatcher'),
                new Politician(first: 'George', initial: 'W', last: 'Bush'),
                new Politician(first: 'Jack', initial: 'O', last: 'Bush')
        ]
        // 执行排序
        def sorted = politicians.toSorted()
        //执行排序之后调用initials
        assert  sorted*.initials() == ['JOB','GWB',"MHT"]
        def byInitial = Politician.comparatorByInitial()
        sorted = politicians.toSorted(byInitial)
        assert sorted*.initials() == ['MHT','JOB', 'GWB']
    }
}

/**
 * 排序，首先根据last排序，然后按照initial 排序
 */
@Sortable(includes = 'last,initial')
class Politician {
    String first
    Character initial
    String last
    String initials(){
        first[0] + initial + last[0]
    }
}
