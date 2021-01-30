package com.jack.groovy.ch3

/**
 * @author liangchen* @date 2020/10/24
 */
class JavaToGroovy {

     static void main(String[] args) {
         // java
         System.out.print("Hello Groovy")

         // 简化groovy 采用单引号
         System.out.print('Hello Groovy')

        // 继续简化
         print ('Hello Groovy')

         //继续简化
         print 'Hello Groovy'


         String greeting = 'Hello Groovy'

         assert  greeting.startsWith('Hello')

         assert greeting.getAt(0) =='H'

         assert greeting[0] == 'H'

         assert  greeting.indexOf('Groovy') >=0
         assert greeting.contains('Groovy')

         assert greeting[6..11] == 'Groovy'
         // 居然支持减法
         assert 'Hi' + greeting - 'Hello' == 'Hi Groovy'

         // 计数 o字符的次数
         assert greeting.count('o') == 3

         // 左边补足3位（空格）
         assert  'x'.padLeft(3) == '  x'

         // 右边补足3 （_)
         assert 'x'.padRight(3,'_') == 'x__'

         //中间两侧补足3位
         assert 'x'.center(3) == ' x '

         // 多个x累加
         assert 'x' * 3 =='xxx'


         // StringBuffer 操作

         def greet = 'Hello'
         // 变成StringBuffer类型
         greet <<= ' Groovy'
         println greet
         assert  greet instanceof java.lang.StringBuffer

         // 执行拼接操作
         greet << '!'
         assert  greet.toString() == 'Hello Groovy!'
         greet[1..4] = 'i'
         assert  greet.toString() == 'Hi Groovy!'

     }
}
