package com.jack.groovy.ch17

import groovy.test.GroovyTestCase

/**
 * @author liangchen* @date 2020/12/13
 */
class _17_2CounterTest extends GroovyTestCase {
    static final Integer[] NEG_NUMBERS = [-2, -3, -4]
    static final Integer[] POS_NUMBERS = [4, 5, 6]
    static final Integer[] MIXED_NUMBERS = [4, -6, 0]

    private Counter counter

    // 初始化
    void setUp(){
        counter = new Counter()
    }


    void testCounterWorks() {
        // 大于7 的数字数量
        assertEquals(2, counter.biggerThan([5, 10, 15], 7))
    }

    void testCountHowManyFromSampleNumbers(){
        check(0, NEG_NUMBERS, -1)
        check(0, NEG_NUMBERS, -2)
        check(2, NEG_NUMBERS, -4)
        check(3, NEG_NUMBERS, -5)

        //
        check(0, POS_NUMBERS, 7)
        check(0, POS_NUMBERS, 6)
        check(2, POS_NUMBERS, 4)
        check(3, MIXED_NUMBERS, -7)
        check(2, MIXED_NUMBERS, -1)
    }

    //测试输入日期是否改变
    void testInputDataUnchanged(){
        def numbers = NEG_NUMBERS.clone()
        def origLength = numbers.size()
        counter.biggerThan(numbers, 0)
        assertLength(origLength, numbers)
        assertArrayEquals( NEG_NUMBERS, numbers)
    }

    void testCountHowManyFromSapleStrings() {
        check(2, ['Dog', 'Cat', 'Antelope'], 'Bird')
    }

    /**
     * 使用了 assertTrue 和 assertContains
     */
    void testInputDataAssumptions(){

        assertTrue( NEG_NUMBERS.every { it < 0 })
        assertTrue(POS_NUMBERS.every { it > 0 })
        assertContains 0, MIXED_NUMBERS
        int negCount =0
        int posCount =0
        MIXED_NUMBERS.each {
            if(it <0) negCount ++
            else  if (it> 0) posCount ++
        }
        assert negCount && posCount

    }


    // 自定义检查方法
    private check(expectedCount, items, threshold) {
        assertEquals(expectedCount, counter.biggerThan(items, threshold))

    }
}

class Counter{
    int biggerThan(items, threshold) {
        items.grep { it > threshold }.size()

    }
}