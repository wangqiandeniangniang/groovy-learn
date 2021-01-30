package com.jack.groovy.ch19

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer

/**
 * @author liangchen* @date 2020/12/19
 */
def binding = new Binding(robot : new Robot())
// 把要导入包先放到这里面，后面脚本需要可以直接导包
def importCustomer = new ImportCustomizer()
importCustomer.addStaticStars 'com.jack.groovy.ch19.Direction'
def config = new CompilerConfiguration()
config.addCompilationCustomizers importCustomer
def shell = new GroovyShell(this.class.classLoader, binding, config)
shell.evaluate '''
    robot.move left
'''
