package com.jack.groovy.ch16

/**
 * @author liangchen* @date 2020/12/7
 */

def gc1 = new GroovyClassLoader()
// 解析这个类
Class greetingClass = gc1.parseClass(new File("Hello.groovy"))
assert "Hello!" == greetingClass.newInstance().greeting()