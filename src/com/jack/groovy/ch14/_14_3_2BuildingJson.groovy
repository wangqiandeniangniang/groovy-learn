package com.jack.groovy.ch14

import groovy.json.JsonBuilder

/**
 * @author liangchen* @date 2020/12/5
 */
def builder = new JsonBuilder()
builder.weeks{
    capacity '8'
    tasks(
            [{
                done '0'
                total '4'
                title 'build web service'
             },{
                done '0'
                total '1'
                title 'build web service client'
            }

            ]
    )
}

println builder.toString()

// 使用builder方法的控制语句
def invoiceBuilder = new JsonBuilder()
invoiceBuilder{
    invoices(1..3) { day ->
        invoice(date: "2015-01-0$day") {
            item(count: day){
                product(name:'ULC', dollar:1499)
            }
        }
    }
}
println invoiceBuilder.toString()


import static groovy.json.JsonOutput.*
//输出json对象, 数组
def json = toJson([date: '2015-01-01', time: '6 am'])
assert json =='{"date":"2015-01-01","time":"6 am"}'

class Athlete{String first, last}

//对象转json字符串
def mj = new Athlete(first: 'Michael', last: 'Jordan')
assert toJson(mj) == '{"first":"Michael","last":"Jordan"}'

def pt = new Athlete(first: 'Paul', last: 'Tergat')
def athletes = [basketball:mj, marathon:pt]
json = toJson(athletes)
System.out << prettyPrint(json)