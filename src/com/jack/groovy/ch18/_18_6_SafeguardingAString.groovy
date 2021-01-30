package com.jack.groovy.ch18

import groovyx.gpars.agent.Agent


/**
 * @author liangchen* @date 2020/12/18
 */
// 只能代理能够修改原类的方法， 起到保护的作用
def guard = new Agent<String>()
guard{updateValue('GPars')}

guard { updateValue(it + ' is groovy!') }
assert "GPars is groovy!" == guard.val
