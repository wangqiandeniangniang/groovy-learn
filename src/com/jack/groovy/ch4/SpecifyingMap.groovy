package com.jack.groovy.ch4

/**
 * 一般map使用
 * 指定map
 * @author liangchen* @date 2020/11/1
 */
class SpecifyingMap {
    static void main(String[] args) {
        // 默认创建是LinkedHashMap
        def myMap = [a: 1, b: 2, c: 3]
        assert myMap instanceof  LinkedHashMap;

        assert myMap.size() == 3

        assert myMap['a'] == 1

        //创建一个空Map
        def emptyMap = [:]
        assert emptyMap.size() == 0

        // 将map放入TreeMap
        def explicitMap = new TreeMap()
        explicitMap.putAll(myMap)
        assert explicitMap['a'] == 1

        //直接用*map集合 进行引用，组合成Map
        def composed = [x: 'y', *: myMap]
        assert composed == [x: 'y', a: 1, b: 2, c: 3]

        def x = 'a'
        // 表示默认加上'x'
        assert ['x': 1] == [x: 1]
        // 如果要是引用变量时候需要加上括号
        assert ['a': 1] == [(x): 1]



    }
}
