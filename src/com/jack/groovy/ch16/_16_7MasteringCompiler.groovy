package com.jack.groovy.ch16

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer

/**
 * @author liangchen* @date 2020/12/12
 */

def conf = new CompilerConfiguration()
conf.setScriptBaseClass("com.jack.groovy.ch16.BaseScript")
def shell = new GroovyShell(conf)
def value = shell.evaluate('''
multiply(5,6)
''')
assert  value == 30

// 导入自定义类

def config = new CompilerConfiguration()
def customizer = new ImportCustomizer()
customizer.addImports('java.util.concurrent.atomic.AtomicInteger',
'java.util.concurrent.atomic.AtomicLong')
config.addCompilationCustomizers(customizer)
def shells = new GroovyShell(config)
def values = shells.evaluate('''
    def myInt = new AtomicInteger(1)
    def myLong = new AtomicLong(2) 
''')