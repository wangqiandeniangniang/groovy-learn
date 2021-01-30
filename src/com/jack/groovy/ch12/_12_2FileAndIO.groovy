package com.jack.groovy.ch12

/**
 * @author liangchen* @date 2020/11/22
 */
file = new File('_12_1_1InteractiveObject.groovy')

file.each {println it}
assert  file.any{ it=~ /方法/}

assert 2 == file.findAll { it =~ /方法/ }.size()

assert 38== file.grep{it}.size()
