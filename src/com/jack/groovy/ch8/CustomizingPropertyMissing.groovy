package com.jack.groovy.ch8

/**
 * 属性 不存在
 * @author liangchen* @date 2020/11/10
 */
class CustomizingPropertyMissing {

    def propertyMissing(String name) {
       "accessed $name"
    }

    static void main(String[] args) {
        def bounce = new CustomizingPropertyMissing()
        assert bounce.hello == 'accessed hello'
        def dslMissing = new DSLMissingProperty();
        assert dslMissing.IIOI + dslMissing.IOI == dslMissing.IOOIO
    }
}
class DSLMissingProperty{
    def propertyMissing(String name) {
        int result = 0
        name.each {
            // 移位运算
            result <<=1
            if(it == 'I') result++
        }
        return result
    }
}
