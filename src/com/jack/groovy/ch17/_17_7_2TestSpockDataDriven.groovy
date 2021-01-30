package com.jack.groovy.ch17

import groovy.transform.TupleConstructor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author liangchen* @date 2020/12/15
 */
// 使用spock框架
// 只能手动下载下来放到grape中了，哎，还要注意spock-core的版本， 原书的版本太老的了
@Grab('org.spockframework:spock-core:2.0-M4-groovy-3.0')
class SpockDataDriven extends Specification {

    def "test temperature scenario"() {
        //期望值
        expect:
        Converter.celsius(tempF) == tempC

        // 列出一些场景， || 分割输入参数和输出参数
        where:
        scenario  | tempF || tempC
        'Freezing' | 32 || 0
        'Garden party condition' | 68 || 20
        'Beach condition' | 95 || 315
        'Boiling' | 212 || 100
    }


    @Unroll
    def "test unroll temperature scenario"() {
        //期望值
        expect:
        Converter.celsius(tempF) == tempC

        // 列出一些场景， || 分割输入参数和输出参数
        where:
        scenario  | tempF || tempC
        'Freezing' | 32 || 0
        'Garden party condition' | 68 || 20
        'Beach condition' | 95 || 35
        'Boiling' | 212 || 100
    }


    /**
     * 进一步优雅
     * @return
     */
    @Unroll
    def  "Scenario #scenario: #tempFºF should convert to #tempCºC"() {
        //期望值
        expect:
        Converter.celsius(tempF) == tempC

        // 列出一些场景， || 分割输入参数和输出参数
        where:
        scenario  | tempF || tempC
        'Freezing' | 32 || 0
        'Garden party condition' | 68 || 20
        'Beach condition' | 95 || 315
        'Boiling' | 212 || 100
    }
}

