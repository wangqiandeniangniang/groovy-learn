package com.jack.groovy.ch20

/**
 * @author liangchen* @date 2020/12/22
 */
// 利用groovy 生成node.js原生代码
@Grab('org.grooscript:grooscript:1.2.2')

import org.grooscript.GrooScript

def conversionOptions = [:]
conversionOptions['initialText'] = "var gs = require('grooscript');"

GrooScript.convert 'source.groovy', '.', conversionOptions