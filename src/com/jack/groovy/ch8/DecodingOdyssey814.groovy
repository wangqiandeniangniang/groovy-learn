package com.jack.groovy.ch8

/**
 * 奥赛德编码和解码, 自定义String 类的MetaClass  添加字符
 * @author liangchen* @date 2020/11/11
 */
class DecodingOdyssey814 {

    /**
     * 字符转成ASCII 码+shift， 然后转成字符
     * @param string 原字符串
     * @param distance 每个字符+shift 组成字符串
     * @return
     */
    def move(string, distance) {
        string.collect { (it as char) + distance as char}.join()
    }

    static void main(String[] args) {
       def decoding =  new DecodingOdyssey814()
        // 自定义String 类的metaClass
        String.metaClass{
            shift = -1
            // delegate 本对象 this ( "IBM")
            encode {-> decoding.move delegate, shift}
            decode {-> decoding.move delegate, -shift}
            getCode{-> encode()}
            getOrig{-> decode()}
        }
        assert "IBM".encode()=="HAL"
        assert "HAL".orig == "IBM"

        def ibm = "IBM"
        ibm.shift = 7
        assert  ibm.code == 'PIT'
    }

}
