package com.jack.groovy.ch8

import groovy.test.GroovyTestCase

/**
 * 比如计算不同规则，例如不同币种计算总资产
 * @author liangchen* @date 2020/11/11
 */
class MetricCalculation823 extends GroovyTestCase{

    void testMetricCalculations(){
        //先添加两个方法，10.mm会调用getMm方法
        Number.metaClass{
            getMm = { delegate }
            getCm = { delegate * 10.mm }
            getM = {delegate * 100.cm}
        }
        assert 1.m + 20.cm - 8.mm == 1.192.m
    }

}
