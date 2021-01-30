package com.jack.groovy.ch12

/**
 * @author liangchen* @date 2020/11/22
 */
// 使用 dump 和inspect 方法

def newline = "\n"
assert newline.toString() == "\n"

// dump 对象信息
assert newline.dump()=="<java.lang.String@a value=\n hash=10>"

// 值
assert newline.inspect() == /'\n'/


class MyClass{
    def first = 1
    def getSecond(){
        first * 2
    }
    public third = 3
    def myMethod(){}
}

def obj = new MyClass()
//判断是否存在某个属性
assert  obj.hasProperty('first')
// 判断是否存在某个方法
assert obj.respondsTo('myMethod')

// 属性的key
def keys = ['first', 'second', 'class']
assert obj.properties.keySet() == new HashSet<>(keys)

// 属性map获取属性
assert  1 == obj.properties['first']
assert 1 == obj.properties.first

// 调用getAt('first')
assert 1 == obj.first
assert 1 == obj['first']

def one = 'first'
def two = 'second'
obj[one] = obj[two]
// 查找存在first=2字符串
assert obj.dump() =~'first=2'