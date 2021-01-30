package com.jack.groovy.ch9

import groovy.transform.Field

/**
 * 不需要创建类似class文件结构只要是groovy就行
 */
@Field
List awe = [1,2,3]
def awesum(){
    awe.sum()
}
assert awesum() == 6