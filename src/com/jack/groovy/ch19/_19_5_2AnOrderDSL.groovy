package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */

def of = "silent word"

def buy(n){
    [shares:{of ->
        [:].withDefault {ticker ->
            println "buy $n shares of $ticker"
        }
    }]
}
buy 200 shares of GOOG