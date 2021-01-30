package com.jack.groovy.ch16

import javax.script.ScriptEngineManager

/**
 * @author liangchen* @date 2020/12/12
 */
// 多态编程 ,定义一个斐波那契数列
def mgr = new ScriptEngineManager()
assert  mgr.getEngineByName("javascript").eval('''

function factorial(n){
    if(n == 0) {return 1;}
    return n * factorial(n-1);
}
factorial(4)
''') == 24.0