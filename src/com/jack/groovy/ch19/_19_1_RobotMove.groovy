package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */
enum  Direction{
    left, right, forward, backward
}

class Robot{
    void move(Direction direction) {
        println "robot moved $direction"
    }

    void move(Direction dir, Distance distance) {
        println "robot moved $dir by $distance"
    }

    void move(Map m, Direction direction) {
        println "robot moved $direction by $m.by at ${m.at ?: '1 km/h'}"
    }
    void execute(Closure actions) {

        this.with actions

    }
}
def robot = new Robot()
// 可以省略括号
robot.move Direction.left
robot.move Direction.right

// 使用groovyshell

def shell= new GroovyShell(this.class.classLoader)
shell.evaluate '''
import com.jack.groovy.ch19.Direction
import com.jack.groovy.ch19.Robot
def robt = new Robot()
robt.move Direction.left
'''