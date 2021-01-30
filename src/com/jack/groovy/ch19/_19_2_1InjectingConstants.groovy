package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */
//通过binding注入常量（单个枚举对象注入）
def binding = new Binding(
        robot : new Robot(),
        left: Direction.left,
        right: Direction.right,
        forward:Direction.forward,
        backward: Direction.backward
)
def shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    robot.move left
'''

// 注入整个枚举类,通过*通配符， 利用collectEntries方法
binding = new Binding(
        robot: new Robot(),
        *: Direction.values().collectEntries { [(it.name()): it] }

)
shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    robot.move left
'''