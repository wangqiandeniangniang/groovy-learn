package com.jack.groovy.ch17

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.Test

/**
 * @author liangchen* @date 2020/12/13
 */
// 参数化驱动测试，使用JUnit 4 , 这个是一个宝藏，

@RunWith(Parameterized)
class DataDrivenJUnitTest{
    private c, f, scenario

    // 列出一些参数入参创建对象，然后测试不同对象情况，可以不用写死这些情况
    @Parameterized.Parameters
    static scenarios(){
        [
                [0,32,'Freezing'],
                [20,68,'Garden party condition'],
                [35,95,'Beach conditions'],
                [100,212,'Boiling']
        ]*.toArray()
    }

    DataDrivenJUnitTest(c, f, scenario) {
        this.c = c
        this.f = f
        this.scenario = scenario
    }

    @Test
    void convert(){
        def actual = Converter.celsius(f)
        def msg = "$scenario:${f}F should convert into ${c}C"
        assert  c == actual, msg
    }

}

