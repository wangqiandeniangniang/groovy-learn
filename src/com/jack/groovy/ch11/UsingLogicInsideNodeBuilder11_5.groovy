package com.jack.groovy.ch11


/**
 * @author liangchen* @date 2020/11/20
 */

TimeZone.default = TimeZone.getTimeZone("CET")

def builder = new NodeBuilder()
def invoices = builder.invoices {
    for (day in 1..3) {
        def invDate = Date.parse('yyyy-MM-dd', '2015-01-0$day')
        invoice(date: invDate) {
            item(count: day) {
                product(name: 'ULC', dollar: 1499)
            }
        }
    }
}
def writer = new StringWriter()
invoices.print(new PrintWriter(writer))
println writer.toString()
// 深度遍历节点
println invoices.depthFirst()*.name()
// 广度遍历节点
println invoices.breadthFirst()*.name()

