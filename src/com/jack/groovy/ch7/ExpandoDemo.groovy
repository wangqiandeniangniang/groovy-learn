package com.jack.groovy.ch7

/**
 * 动态扩展属性和方法 Expando
 * @author liangchen* @date 2020/11/10
 */
class ExpandoDemo {

    static void main(String[] args) {
        def boxer = new Expando()
        assert null == boxer.takeThis
        // 赋值 takeThis 不存在的值
        boxer.takeThis = 'jack'
        assert 'jack' == boxer.takeThis
        // 定义方法
        boxer.fightBack = {times -> delegate.takeThis * times}
        assert  'jackjack' == boxer.fightBack(2)
    }
}
