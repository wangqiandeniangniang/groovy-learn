package com.jack.groovy.ch7

/**
 *  GPath 解析
 * @author liangchen* @date 2020/11/10
 */
class GPathInvoiceDemo {

    static class Invoice{
        List items
        Date date
    }

    static class LineItem{
        Product product
        int count
        int total(){
            return product.dollar * count
        }
    }

    static class Product {
        String name
        def dollar
    }

    static void main(String[] args) {
        def ulcDate = Date.parse('yyyy-MM-dd', '2015-01-01')
        def otherDate = Date.parse('yyy-MM-dd', '2015-02-02')
        def ulc = new Product(dollar: 1499, name: 'ULC')
        def ve = new Product(dollar: 499, name: 'Visual Editor')

        def invoices = [
                new Invoice(date: ulcDate, items: [
                        new LineItem(count: 5, product: ulc),
                        new LineItem(count: 1, product: ve)
                ]),
                new Invoice(date: otherDate, items: [
                        new LineItem(count: 4, product: ve)
                ])
        ]
        // lineItem 平铺，拆开
        def allItems = invoices.items.flatten()

        // 循环调用 total方法
        assert [5*1499, 499, 4*499] == allItems*.total()

        // 查询 数量大于 7000的
        assert ['ULC'] == allItems.grep{it.total() > 7000}.product.name

        // product == ulc , date日期变成字符串
        def searchDates = invoices.grep { it.items.any{it.product == ulc}}.date*.toString()
        assert [ulcDate.toString()] == searchDates
    }
}
