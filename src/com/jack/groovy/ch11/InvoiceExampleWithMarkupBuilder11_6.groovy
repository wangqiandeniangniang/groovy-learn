package com.jack.groovy.ch11


import groovy.xml.MarkupBuilder

/**
 * @author liangchen* @date 2020/11/20
 */
// 11.6

TimeZone.default = TimeZone.getTimeZone("CET")
def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
builder.invoices {
    for (day in 1..3) {
        def invDate = Date.parse('yyyy-MM-dd', '2015-01-0$day')
        invoice(date: invDate) {
            item(count: day) {
                product(name: 'ULC', dollar: 1499)

            }

        }

    }
}
println writer.toString()

// 用单引号也是可以了
def web = builder.'web-app' {
    builder.'display-name'('Groovy WebApp')
}
println writer.toString()