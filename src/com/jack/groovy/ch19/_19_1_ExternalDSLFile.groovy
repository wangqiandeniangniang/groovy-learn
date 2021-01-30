package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */
// 直接加载外部脚本，直接执行
def shell = new GroovyShell()
shell.evaluate './_19_1_RobotMove.groovy' as File


