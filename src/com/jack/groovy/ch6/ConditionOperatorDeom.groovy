package com.jack.groovy.ch6

/**
 * 三元表达式
 * @author liangchen* @date 2020/11/6
 */
class ConditionOperatorDeom {

    static void main(String[] args) {

        // 值的类型可以不一致
        def result = (1==1) ? 'ok' : 'failed'

        assert result == 'ok'

        result = 'some string' ? 10 : ['x']
        assert result == 10

        // 简写
        def argument = 'given'

        def standard = 'defualt'
        result = argument ? argument : standard
        //简写
        def value = argument ?: standard

    }
}
