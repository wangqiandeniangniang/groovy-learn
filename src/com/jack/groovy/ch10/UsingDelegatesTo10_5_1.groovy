package com.jack.groovy.ch10

/**
 * @author liangchen* @date 2020/11/19
 */
// 10.45 使用@DelegateTo.Target， 自动识别类型，自动替换closure

class Address{
    String country
}

class WishList{
    List<String> items
}

def validate(@DelegatesTo.Target def o, @DelegatesTo Closure rule) {
    rule.delegate = o
    rule()
}

void validateAll() {
    def a = new Address(country: 'Australia')
    validate(a) {
        if (country[0] == 'X') {
            println "No countries start with that"
        }
    }
    def wl = new WishList(items: ['iphone', 'iphone'])
    validate(wl) {
        if (items != items.toUnique()) {
            println 'Item appeared twice'
        }
    }

}
validateAll()