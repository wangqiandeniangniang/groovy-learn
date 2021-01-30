package com.jack.groovy.ch11

/**
 * @author liangchen* @date 2020/11/20
 */

def builder = new NodeBuilder()
def ulcDate = Date.parse("yyyy-MM-dd", '2015-01-01')
def otherDate = Date.parse('yyyy-MM-dd', '2015-02-02')

// 构建一个nodeBuilder 节点， 然后使用grep查询node节点的数据
def invoices = builder.invoices {
    invoice(date: ulcDate) {
        item(count: 5) {
            product(name: 'ULC', dollar: 1499)
        }
        item(count: 1) {
            product(name: 'Visual Editor', dollar: 499)

        }

    }
    invoice(date: otherDate) {
        item(count: 4) {
            product(name: 'Visual Editor', dollar: 499)
        }
    }

}
// @符号在grep是引用
soldAt = invoices.grep{
    it.item.product.any{it.'@name' == 'ULC'}
}.'@date'
assert soldAt == [ulcDate]
