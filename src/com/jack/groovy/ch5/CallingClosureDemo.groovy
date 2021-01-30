package com.jack.groovy.ch5

/**
 * 闭包定义规则，比如做一下，四则运算
 * @author liangchen* @date 2020/11/4
 */
class CallingClosureDemo {

    static void main(String[] args) {
        def adder = { x, y -> return x + y }

        assert  adder(4,3) == 7

        assert adder.call(2, 6) == 8
        def slow = benchmark(10000) { (int) it / 2 }
        def fast = benchmark(10000) { it.intdiv(2) }
        assert  fast * 2 < slow

        def plus = calculate(1, 2) { x, y -> x + y }
        assert plus == 3

        def multi = calculate(1, 2) { x, y -> x * y }
        assert multi == 2


    }

    def static benchmark(int repeat, Closure worker){
        def start = System.nanoTime()

        repeat.times {worker(it)}
        def stop = System.nanoTime()
        return stop - start
    }

    def static calculate(int num1, int num2, Closure worker) {
       worker(num1, num2)
    }
}
