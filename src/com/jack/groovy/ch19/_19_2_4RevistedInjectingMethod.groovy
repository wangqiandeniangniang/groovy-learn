package com.jack.groovy.ch19

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer

import javax.script.ScriptEngine

/**
 * @author liangchen* @date 2020/12/19
 */
// 利用RobotBaseScript脚本
def binding = new Binding(robot: new Robot())
def importCustomizer = new ImportCustomizer()
importCustomizer.addStaticStars Direction.name
def config = new CompilerConfiguration()
config.addCompilationCustomizers importCustomizer
config.scriptBaseClass = RobotBaseScript.name

def shell = new GroovyShell(this.class.classLoader, binding, config)
shell.evaluate '''
   move left
'''


// 使用@Delegate 注解

abstract  class RobotBaseScriptDelegate extends Script{
    @Delegate
    @Lazy Robot robot = this.binding.robot
}