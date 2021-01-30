package com.jack.groovy.ch5

/**
 * 简单闭包申明
 * @author liangchen* @date 2020/11/4
 */
class SimpleDeclarationDemo {

    static void main(String[] args) {

        // 自定义参数名 counter
        def  log = ""
        (1..10).each { counter -> log += counter}

        assert  log == '12345678910'

        // it就是默认参数名称
        log = ''
        (1..10).each { log += it }
        assert  log == '12345678910'

    }
}
