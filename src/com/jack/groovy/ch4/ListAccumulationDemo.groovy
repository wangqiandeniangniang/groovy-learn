package com.jack.groovy.ch4

/**
 * @author liangchen* @date 2020/10/27
 */
class ListAccumulationDemo {

    static void main(String[] args) {
        def list = [1, 2, 3]
        assert list.first() == 1
        assert list.head() == 1
        assert list.tail() == [2, 3]
        assert list.last() == 3
        // 计数
        assert list.count(2) == 1
        assert list.max() == 3

        assert list.min() == 1

        def  even = list.find {
            item -> item % 2 == 0

        }
        assert even == 2
        // 每个元素都满足如下条件
        assert list.every() { item -> item < 5 }
        // 任意一个元素满足条件
        assert list.any { item -> item < 2 }

        def store =''
        // 字符串拼接
        list.each { item -> store += item }
        assert  store == '123'

        // 逆序
        store = ''
        list.reverseEach {
            item -> store += item
        }
        assert  store == '321'

        // 遍历索引和值
        store = ''
        list.eachWithIndex { item, index ->
            store += "$index:$item "
        }
        assert store == '0:1 1:2 2:3 '

        // 拼接
        assert  list.join('-') == '1-2-3'

        // 进行连续计算，0 和 list第一个元素算出结果，继续+下一个元素
        def result =list.inject ( 0 ) { clinks, guests -> clinks + guests }
        assert  result == 0 + 1 + 2 + 3

        assert  list.sum() == 6

        def factorial = list.inject (1) {
            fac, item -> fac * item

        }
        assert  factorial == 1 * 1 * 2 * 3

    }
}
