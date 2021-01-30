package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */

//定义一个抽象robot基础脚本
abstract  class RobotBaseScript extends  Script{
    void move(Direction direction) {
        this.binding.robot.move  direction
    }
    void move(Direction direction, Distance distance) {
        this.binding.robot.move  direction, distance
    }
}

def binding = new Binding(
        robot: new Robot(),
        *: Direction.values().collectEntries { [(it.name()): it] }

)
//利用@BaseScript导入脚本，其实方法是可以共用
def shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    @BaseScript(com.jack.groovy.ch19.RobotBaseScript)  
    import groovy.transform.BaseScript  
    move left
'''