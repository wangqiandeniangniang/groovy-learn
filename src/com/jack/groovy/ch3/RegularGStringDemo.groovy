package com.jack.groovy.ch3

/**
 * @author liangchen* @date 2020/10/24
 */
class RegularGStringDemo {

    static void main(String[] args) {
        // 以/开头和结尾， /pattern/
        assert  "abc" == /abc/

        assert "\\d" == /\d/

        def  reference = 'hello'

        assert  reference == /$reference/
    }
}
