package com.jack.groovy.ch11


import groovy.xml.StreamingMarkupBuilder

/**
 * @author liangchen* @date 2020/11/20
 */
// 去掉空格子类，尽可能最小，缩成一行
def builder = new StreamingMarkupBuilder()

def writable = builder.bind{
    invoices {
        for (day in 1..3) {
            def invDate = Date.parse('yyyy-MM-dd', '2015-01-0$day')
            invoice(date: invDate) {
                item(count: day) {
                    product(name: 'ULC', dollar: 1499)

                }

            }
        }

    }
}
def result = writable.toString()
println result