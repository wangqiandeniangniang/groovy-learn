package com.jack.groovy.ch7

/**
 * 一个groovy 有两个类
 * @author liangchen* @date 2020/11/9
 */
class MultipleClassDemo {
    static void main(String[] args) {
        def canoo = new Vendor()
        canoo.name = 'jack'
        canoo.product='apple'
        canoo.address.street = '天顶乡'
        canoo.address.zip = 1121
        canoo.address.town = '岳麓区'
        canoo.address.state = '长沙'
        // 查找匹配字符
        assert canoo.dump() =~ /apple/
        // 查找匹配字符
        assert canoo.address.dump() =~/1121/
        println canoo.address.dump()
    }
}
class Vendor {
    public String name
    public String product

    public Address address =new Address();
}
class Address{
    public String  street, town , state
    public int zip
}
