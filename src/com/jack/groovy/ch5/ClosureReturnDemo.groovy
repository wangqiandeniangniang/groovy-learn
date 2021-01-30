package com.jack.groovy.ch5

/**
 * closure 返回值
 * @author liangchen* @date 2020/11/6
 */
class ClosureReturnDemo {


     static void main(String[] args) {
         // 不需要return
         def doubled =  [1,2,3].collect{it * 2}
         assert doubled == [2,4,6]

         // return 关键字
         doubled =  [1,2,3].collect { return it * 2 }
         assert doubled == [2,4,6]

         // 偶数 * 2， 奇数直接返回
         def odd= [1,2,3].collect {
             if(it % 2 ==0) return it * 2
            return it
         }
         assert odd == [1,4,3]
     }
}
