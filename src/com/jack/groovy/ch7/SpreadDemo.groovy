package com.jack.groovy.ch7

/**
 *    * 号操作
 * @author liangchen* @date 2020/11/10
 */
class SpreadDemo {

    def getList(){
        return [1,2,3]
    }

    def sum(a, b, c) {
        return a + b + c
    }

    static void main(String[] args) {
       def spread =  new SpreadDemo()
        // 直接调用getList 方法获取到值作为sum的参数
        assert 6 == spread.sum(*spread.list)

        // 直接使用*变量数组
        def range = (1..3)
        assert [0,1,2,3] == [0, *range]

        // 或者map 或者map *:map
        def map = [a:1, b:2]
        assert [a:1, b:2, c:3] == [c:3, *:map]
    }

}
