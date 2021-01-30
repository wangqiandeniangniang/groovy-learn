package com.jack.groovy.ch2

/** Groovy 字符串处理, 用$符号开头
 * @author liangchen* @date 2020/10/22
 */
class StringDemo {
     static void main(String[] args) {
         def  nick = "jack"
         def book = 'Groovy in Action , 2nd ed.'

         assert "$nick is $book" =='jack is Groovy in Action , 2nd ed.'


         // Regular expression  （正则表达式） 以/开头，以/结尾
          assert  '12345' =~/\d+/
         assert 'xxxxx' == '12345'.replaceAll(/\d/,'x')
    }
}
