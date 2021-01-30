package com.jack.groovy.ch3

import groovy.transform.Immutable

/**
 * @author liangchen* @date 2020/10/23
 */
class OverridingDemo {

    static void main(String[] args) {
        Money buck = new Money(1, "USD")
        assert  buck
        assert  buck == new Money(1,'USD')
        assert buck + buck == new Money(2, 'USD')
        assert buck + 1 == new Money(2, 'USD')

    }

}

@Immutable
class Money {
    int amount
    String currency

    Money plus (Money other){
        if(null == other) return this
        if (other.currency != currency) {
            throw  new IllegalArgumentException("cannot add $other.currency to $currency")
        }
        return new Money(amount + other.amount, currency)
    }
    Money plus (Integer more){
        return  new Money(amount + more, currency)
    }
}
