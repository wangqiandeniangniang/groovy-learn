package com.jack.groovy.ch10

/**
 * @author liangchen* @date 2020/11/19
 */

unresolvedVariable {
    var ->
        if (var.name == 'robot') {
            storeType(var, lookupClassNodeFor('Robot'))
            handled = true
        }
}

// 检查sql语法 10.47

//@Grab('com.github.jsqlparser:jsqlparser:0.9.2')

