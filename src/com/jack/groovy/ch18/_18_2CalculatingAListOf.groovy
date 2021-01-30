package com.jack.groovy.ch18

/**
 * @author liangchen* @date 2020/12/17
 */

@Grab('org.codehaus.gpars:gpars:1.2.1')
import static  groovyx.gpars.GParsPool.withPool

def numbers = [1, 2, 3, 4, 5, 6]

def squares = [1, 4, 9,16, 25, 36]

// 括号里面线程数量10
withPool(10){
    assert squares == numbers.collectParallel {it * it}
}

