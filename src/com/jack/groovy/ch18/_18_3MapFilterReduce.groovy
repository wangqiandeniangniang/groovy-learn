package com.jack.groovy.ch18

/**
 * @author liangchen* @date 2020/12/17
 */

@Grab('org.codehaus.gpars:gpars:1.2.1')
import static  groovyx.gpars.GParsPool.withPool

withPool {
    assert 55 == [0, 1, 2, 3, 4].parallel
            //每个元素加一，平方之和
            .map{it + 1}
            .map{it **2}
            .reduce{a,b -> a+b}

}

