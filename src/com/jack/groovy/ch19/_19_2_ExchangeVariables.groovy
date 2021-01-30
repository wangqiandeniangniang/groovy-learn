package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */
// 使用binding 绑定变量，可以给脚本增加一些字段
def binding = new Binding(distance: 11400, time: 5 * 60)

def shell = new GroovyShell(binding)
shell.evaluate'''
speed = distance / time
'''

assert binding.distance == 11400
assert binding.time == 5 * 60
assert binding.speed == 38

// 将Robot 类注入到脚本中
binding = new Binding(robot: new Robot())
shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    import  com.jack.groovy.ch19.Direction
    robot.move Direction.left
'''
