package com.jack.groovy.ch4

/**
 * @author liangchen* @date 2020/10/24
 */
class ListOperatorDemo {

    static void main(String[] args) {
       def myList = ['a', 'b', 'c', 'd', 'e','f']
        assert  myList [0..2] == ['a','b','c']
        assert  myList [0,2,4] == ['a', 'c', 'e']

        // myList
        myList[0..2] = ['x', 'y', 'z']
        assert  myList == ['x','y','z', 'd','e', 'f']

        // 删除3..5元素
        myList [3..5] = []

        assert  myList == ['x','y','z']

        // 替换1号位置元素
        myList[1..1] = [0,1,2]
        assert  myList == ['x', 0, 1,2,'z']

        // 添加元素
        def yourList = []

        yourList += 'a'
        assert  yourList == ['a']

        yourList +=['b','c']
        assert  yourList == ['a','b','c']

        yourList =[]
        yourList << 'a' << 'b'

        assert  yourList == ['a', 'b']
        // 减去一个元素
        assert  yourList - ['b'] == ['a']

        //乘以元素
        assert yourList * 2 == ['a','b','a','b']


        //控制结构
        def controlList = ['a', 'b','c']
        assert  controlList.isCase('a')
        assert 'b' in controlList
        def candidate = 'c'
        switch (candidate) {
         case controlList : assert true; break
         default: assert  false
        }
        // 取交集
        assert ['x', 'a','z'].grep(controlList) == ['a']
        controlList = []

        if(controlList) assert  false
        // 遍历list集合
         def  expr =''
      for (i in [1, '*', 5]) {
       expr +=i
      }
      assert expr == '1*5'

    }
}
