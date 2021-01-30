package com.jack.groovy.ch7
/**
 * @author liangchen* @date 2020/11/9
 */
class CallConstructorDemo {
    String name, product

    CallConstructorDemo(name, product) {
        this.name = name
        this.product = product
    }

    // Java 的方式
    def first = new CallConstructorDemo('Canoo', "ULC")

    // as 语法
    def second = ['Canoo','ULC'] as CallConstructorDemo

    // 自己数组元素
    CallConstructorDemo third = ['Canoo', 'ULC']
}


class CallConstructorNameDemo{
    String name, product

    public static void main(String[] args) {
        // 可以指定成员变量名
        new CallConstructorNameDemo()
        new CallConstructorNameDemo(name: 'Canoo')
        new CallConstructorNameDemo(product:'ULC')
        new CallConstructorNameDemo(name: 'Canoo', product: 'ULC')

    }
}
