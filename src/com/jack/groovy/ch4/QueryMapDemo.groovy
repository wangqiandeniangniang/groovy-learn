package com.jack.groovy.ch4

/**
 * map的查询遍历
 * @author liangchen* @date 2020/11/1
 */
class QueryMapDemo {

    static void main(String[] args) {

        def myMap = [a: 1, b: 2, c: 3]
        def other = [b: 2, c: 3, a: 1]
        assert myMap == other

        assert !myMap.isEmpty()
        assert myMap.size()
        assert myMap.containsKey("a")
        assert myMap.containsValue(1)
        assert myMap.entrySet() instanceof Collection

        assert myMap.any { entry -> entry.value > 2 }
        assert myMap.every { entry -> entry.key < 'd' }
        assert myMap.keySet() == ['a', 'b', 'c'] as Set
        assert myMap.values().toList() == [1, 2, 3]

        //========= 迭代,遍历元素
        def store = ''
        myMap.each { entry ->
            store += entry.key
            store += entry.value
        }
        assert store == 'a1b2c3'

        store = ''
        myMap.each { key, value ->
            store += key
            store += value
        }

        assert store == 'a1b2c3'

        store = ''
        for (key in myMap.keySet()) {
            store += key
        }
        assert store == 'abc'

        store = ''
        for (value in myMap.values()) {
            store += value
        }
        assert  store == '123'
    }
}
