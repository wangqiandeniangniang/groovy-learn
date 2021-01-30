package com.jack.groovy.ch17

import net.java.quickcheck.generator.PrimitiveGenerators

/**
 * @author liangchen* @date 2020/12/13
 */

@Grab('net.java.quickcheck:quickcheck:0.6')
// 利用随机测试，确定某一个范围是正确的

def gen = PrimitiveGenerators.integers(-40, 240)
def liquidC = 0..100
def liquidF = 32..212
100.times {
    int f = gen.next()
    int c = Math.round(Converter.celsius(f))
    assert c <= f
    assert c in liquidC == f in liquidF
}
