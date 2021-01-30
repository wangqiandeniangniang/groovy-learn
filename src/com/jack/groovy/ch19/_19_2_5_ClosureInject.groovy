package com.jack.groovy.ch19

import org.codehaus.groovy.control.CompilerConfiguration


/**
 * @author liangchen* @date 2020/12/19
 */
def robot = new Robot()
def binding = new Binding(
        robot: robot,
        // 引用robot的move方法
        move: robot.&move,
        *: Direction.values().collectEntries { [(it.name()): it] }
)
def shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    move left
'''

// 自定义BaseScript 和 自定义Binding方法， 在调用方法时候忽略字符大小写
abstract  class CaseRobotBaseScript extends RobotBaseScript{
    def invokeMethod(String name, args) {
        //调用root方法，同时方法变成小写
        getBinding().robot."${name.toLowerCase()}"(*args)
    }
}

class CustomBinding extends Binding{

    private Map variables
    CustomBinding(Map vars) {
       this.variables = [
               *:vars,
               *:Direction.values().collectEntries { [(it.name()): it] }
       ]
    }

    def getVariable(String name) {
        variables[name.toLowerCase()]
    }
}


// 使用上面自定义类
binding = new CustomBinding(robot: new Robot())
def config = new CompilerConfiguration()
config.scriptBaseClass = CaseRobotBaseScript.name
shell = new GroovyShell(this.class.classLoader, binding, config)
shell.evaluate '''
    mOVe lEFt
'''
