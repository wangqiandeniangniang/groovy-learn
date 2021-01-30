package com.jack.groovy.ch8

/**
 * 利用@Category 添加marshal 和unMarshal
 * @author liangchen* @date 2020/11/11
 */
class AnotationCategory {

    static void main(String[] args) {
       use([IntegerMarshal, StringMarshal]) {
           assert 1.marshal() == '1'
           assert "1".unMarshal() ==1
       }
    }
}
@Category(Integer)
class IntegerMarshal{
    String marshal(){
        toString()
    }

}
@Category(String)

class StringMarshal{
    Integer unMarshal(){
        this.toInteger()
    }
}
