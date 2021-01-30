package com.jack.groovy.ch4

/**
 * 获取map的值以及默认值
 * @author liangchen* @date 2020/11/1
 */
class AccessingMapDemo {
    static void main(String[] args) {

        def mayMap = [a: 1, b: 2, c: 3]
        // 获取存在key对应的值
        assert mayMap['a'] == 1
        assert mayMap.a ==1
        assert mayMap.get('a') == 1
        // 如果获取不到返回默认值1
        assert mayMap.get('f',1) == 1

        assert mayMap['d'] == null
        assert mayMap.d == null
        assert mayMap.get('d') == null

        // 获取不到值默认是1， 同时设置d = 1
        assert mayMap.get('d', 1) == 1
        assert mayMap.d == 1

        mayMap['d'] = 2
        assert mayMap.d == 2

        mayMap.d = 2
        assert mayMap.d == 2

        mayMap = ['a.b': 1]
        assert  mayMap.'a.b' ==1
    }
}
