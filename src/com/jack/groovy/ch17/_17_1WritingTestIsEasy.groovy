package com.jack.groovy.ch17

/**
 * @author liangchen* @date 2020/12/13
 */

// 摄氏度转 华氏温度
class Converter{
    static celsius(fahrenheit) {
        (fahrenheit - 32) * 5 / 9

    }
}
// 验证一个方法是否正确
assert 20 == Converter.celsius(68)
assert 35 == Converter.celsius(95)
assert -17 == Converter.celsius(0).toInteger()
assert 0 == Converter.celsius(32)

