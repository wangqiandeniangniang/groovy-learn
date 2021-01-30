package com.jack.groovy.ch16

/**
 * @author liangchen* @date 2020/12/6
 */

// 计算贷款利率
def monthly = "amount * (rate/12) / (1-(1+rate/12)**-numberOfMonths)"
def shell = new GroovyShell()
def script = shell.parse(monthly)
script.binding.amount = 154000
script.rate = 3.75/100
script.numberOfMonths = 240

assert  script.run() == 913.0480050387338
// 不需要重新解析 monthly 表达式
script.binding = new Binding(amount: 185000, rate: 3.50 / 100, numberOfMonths: 300)
assert script.run() == 926.1536089487843
