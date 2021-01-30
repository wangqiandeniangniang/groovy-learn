package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */

// 定义when结构
def when(boolean condition, Closure block) {
    if(condition) block()
}

def a= 1
def b = 2
when(a < b, {println "a < b"})

// 定义until结构
def until(boolean  condition, Closure closure){
    while(!condition) closure();
}
def counter = 0
until(counter == 10) {
    counter++

}
assert  counter == 10