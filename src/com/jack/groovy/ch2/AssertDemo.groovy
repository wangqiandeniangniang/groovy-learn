package com.jack.groovy.ch2

/**
 * 断言示例
 * @author liangchen* @date 2020/10/22
 */
class AssertDemo {
     static void main(String[] args) {
         assert (true)
         assert 1 == 1
         def  x = 1
         assert  x ==1
         def y = 1; assert y == 1

         def  a = 5
         def  b = 9
      //   assert b == a + a;

         //
         assert ('text' * 3 << 'hell').size() == 4 * 3 + 5

     }
}
