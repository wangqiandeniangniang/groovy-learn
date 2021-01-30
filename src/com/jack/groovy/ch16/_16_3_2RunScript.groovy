package com.jack.groovy.ch16

/**
 * @author liangchen* @date 2020/12/7
 */
def engine = new GroovyScriptEngine(".")
def value = engine.run("test/MyScript.groovy", new Binding())
println value