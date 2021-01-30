package com.jack.groovy.ch20

/**
 * @author liangchen* @date 2020/12/22
 */
class Hello {
    def methodMissing(String name, args) {
        println "Hello ${name}!"
    }
}

def hello = new Hello()
hello.Groovy()
hello.Javascript()
hello.grooscript()