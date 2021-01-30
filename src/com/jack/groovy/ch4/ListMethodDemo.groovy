package com.jack.groovy.ch4

/**
 * @author liangchen* @date 2020/10/27
 */
class ListMethodDemo {

    static void main(String[] args) {

        //平铺元素
        assert [1, [2,3]].flatten() == [1,2,3]
        //取交集
        assert [1,2,3].intersect([4,3,1]) == [3,1]

        assert [1,2,3].disjoint([4,5,6])

        def  list = [1,2,3]
        //移除第一个元素
        def popped = list.pop()

        assert popped == 1
        assert  list == [2,3]
        //反转
        assert [1,2].reverse() == [2,1]
        //排序
        assert [3,1,2].sort() == [1,2,3]
        def sortMultiArray = [[1,0],[0,1,2]]
        // 第一个元素排序
        sortMultiArray = sortMultiArray.sort{a,b -> a[0]<=> b[0]}
        assert sortMultiArray == [[0,1,2], [1,0]]
        // 数组大小排序
        sortMultiArray.sort{item -> item.size()}
        assert  sortMultiArray == [[1,0], [0,1,2]]

        // 移除第三个元素
        list = ['a', 'b','c']
        list.remove(2)
        assert list == ['a','b']
        list.remove('b')
        assert list == ['a']
        // 移除多个元素
        list =['a','b','b','c']
        list.removeAll(['b','c'])
        assert  list == ['a']

        // 乘以2
        def doubled  = [1,2,3].collect{
            item -> item*2
        }

        // 遍历查找元素
        assert doubled == [2,4,6]
        def  odd = [1,2,3].findAll {
            item -> item % 2 == 1

        }
        assert  odd == [1,3]


        //去重
        def x = [1,1,1]
        assert [1] == new HashSet(x).toList()
        assert [1] == x.unique()

        x = [1,null,1]
        assert  [1,1] == x.findAll { it != null }
        assert [1,1] == x.grep{it}

    }
}
