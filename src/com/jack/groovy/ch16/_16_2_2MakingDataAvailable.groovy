package com.jack.groovy.ch16

/**
 * @author liangchen* @date 2020/12/6
 */
def binding = new Binding()
binding.mass = 22.3
binding.velocity = 10.6
def shell = new GroovyShell(binding)
// velocity ** 2  velocity的平方  22.3 * 10.6*10.6 / 2
def expression = "mass * velocity ** 2/2"
assert  shell.evaluate(expression) == 1252.814
binding.setVariable("mass", 25.4)
assert  shell.evaluate(expression) == 1426.972

// 绑定字段的值
def bindingFlow = new Binding(x: 6, y: 4)
def shellFlow = new GroovyShell(bindingFlow)
shellFlow.evaluate('''
    xSquare = x * x
    yCube = y * y * y
''')
assert  bindingFlow.getVariable("xSquare") == 36
assert bindingFlow.yCube == 64

// 可以在 表达式完成赋值
def bindingLocal = new Binding()
def shellLocal = new GroovyShell(bindingLocal)
shellLocal.evaluate('''
    def localVariable = 'local variable'
    bindingVariable = 'binding variable'
''')
assert  bindingLocal.getVariable("bindingVariable") == "binding variable"