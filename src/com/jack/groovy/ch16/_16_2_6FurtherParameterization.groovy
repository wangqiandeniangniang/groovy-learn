package com.jack.groovy.ch16

import org.codehaus.groovy.control.CompilerConfiguration


/**
 * @author liangchen* @date 2020/12/6
 */
// 通过配置CompilerConfiguration 类
// 继承 Script 抽象类，然后定义抽象方法
abstract class BaseScript extends  Script{
   def multiply(a, b) { a * b}
}

// 设置compiler配置， evaluate就可以实现这个抽象方法了
def conf = new CompilerConfiguration()
conf.setScriptBaseClass("com.jack.groovy.ch16.BaseScript")
def shell = new GroovyShell(conf)
def  value = shell.evaluate('''
    multiply(5,6)
''')
assert  value == 30