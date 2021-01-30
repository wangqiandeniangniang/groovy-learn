package com.jack.groovy.ch16

/**
 * @author liangchen* @date 2020/12/6
 */
// 利用 evalue 定义动态类
def shell = new GroovyShell()
def clazz = shell.evaluate('''
    class MyClass{
        def method(){"value"}
    }
    return MyClass
''')
assert clazz.name == "MyClass"
def instance = clazz.newInstance()
assert  instance.method() == "value"