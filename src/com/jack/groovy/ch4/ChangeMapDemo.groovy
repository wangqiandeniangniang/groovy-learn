package com.jack.groovy.ch4

/**
 * @author liangchen* @date 2020/11/1
 */
class ChangeMapDemo {

    static void main(String[] args) {

        //清除原始
        def myMap = [a: 1, b: 2, c: 3]
        myMap.clear()
        assert myMap.isEmpty()

        //移除元素
        myMap = [a: 1, b: 2, c: 3]
        myMap.remove('a')
        assert myMap.size() == 2

        // 创建子map
        assert [a: 1] + [b: 2] == [a: 1, b: 2]
        myMap = [a: 1, b: 2, c: 3]
        def abMap = myMap.subMap(['a', 'b'])
        assert abMap.size() == 2

        // 查找所有满足要求元素
        abMap = myMap.findAll { entry -> entry.value < 3 }
        assert abMap.size() == 2
        assert abMap.a == 1

        //查询满足条件第一元素
        def found = myMap.find { entry -> entry.value < 2 }
        assert found.key == 'a'
        assert found.value == 1

        def doubled = myMap.collect { entry -> entry.value *= 2 }
        assert doubled instanceof List
        assert doubled.every { item -> item % 2 == 0 }

        def addTo = []
        myMap.collect (addTo) { entry -> entry.value *= 2 }
        assert  addTo instanceof  List
        assert  addTo.every { item -> item % 2 == 0 }








    }
}
