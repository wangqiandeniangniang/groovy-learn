package com.jack.groovy.ch16

/**
 * @author liangchen* @date 2020/12/6
 */
@Grab(group='org.apache.httpcomponents', module='httpcore', version='4.2.1')
def shell = new GroovyShell()
def result = shell.evaluate("12 + 23")
assert  result == 35


// 显示创建GroovyShell 一些case
assert  "Hello" == Eval.me("'Hello'")
// 前面是值，后面是表达式
assert  1 == Eval.x(1, "x")
// 两个数据相加
assert 3 == Eval.xy(1, 2, "x+y")
// 三个数据相加
assert 6 == Eval.xyz(1, 2, 3, "x+y+z")
