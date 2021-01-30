package com.jack.groovy.ch7

/**
 * 引用成员变量
 * @author liangchen* @date 2020/11/8
 */
class ReferenceFieldDemo {
    static void main(String[] args) {
        def counter = new Counter()
        counter.count = 1
        assert counter.count == 1

        def fieldName = 'sum'
        counter[fieldName] = 2
        assert counter.sum == 2

        // 没有值，就调用get方法
        def pretender = new PretendFieldCounter()
        assert pretender.isNoField == 'pretend value'

        assert pretender.count == 0
        //调用set方法 count ==1
        pretender.isNoFieldEither = 'just to increase counter'
        // 调用set方法  count==2
        pretender.aaa = 1
        assert pretender.count == 2
    }
}
class Counter{
    public count =0
    public sum = 0
}

class PretendFieldCounter {
    public count = 0

    Object get(String name) {
        return 'pretend value'
    }

    void set(String name, Object value) {
        count++

    }
}
