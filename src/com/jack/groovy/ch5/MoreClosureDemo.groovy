package com.jack.groovy.ch5

/**
 * 更多闭包特性 和 curry
 * @author liangchen* @date 2020/11/5
 */
class MoreClosureDemo {
    static void main(String[] args) {
        //判断closure 参数是1
        assert numParams {one ->} == 1
        //判断closure 参数数量是2
        assert numParams { one, two -> } == 2

        // 判断参数类型
        assert paramTypes { String s -> } == [String]
        assert paramTypes {Number n, Date d ->} == [Number, Date]

        // currying 填充未知数
        def mult = { x, y, z -> return x * y * z }
        // {x,y,z -> return 2 * y * z}
        def twoTimes = mult.curry(2)
        // {x,y,z -> return 2 * 3 * z}
        def threeTimes = twoTimes.curry(3)
        // {x,y,z -> return 2 * 3 * 60}
        assert threeTimes(10) == 60

        // 将参数归纳一下， 有点类似定义抽象问题
        def configurator = {
            format, filter, line -> filter(line) ? format(line) : null
        }
        def appender = {config, append ,line  ->
            def out = config(line)
            if(out) append(out)
        }
        def dateFormatter = { line -> "${new Date()} : $line" }

        def debugFilter = { line -> line.contains('debug') }
        def consoleAppender = {line -> println line}

        def myConf = configurator.curry(dateFormatter, debugFilter)
        def myLog = appender.curry(myConf, consoleAppender)
        myLog("here is some debug message")
        myLog("this will not be printed")


        // 合并组合closure
        // currying 填充未知数
         mult = { x, y -> return x * y  }
        // {x,y,z -> return 2 * y * z}
        twoTimes = mult.curry(2)
        def fourTimes = twoTimes >> twoTimes
        def  eightTimes = twoTimes << fourTimes

        assert  eightTimes(1) == twoTimes(fourTimes(1))

        // 内存化 提高访问速度
        def fib
        fib = { it < 2 ? 1 : fib(it - 1) + fib(it - 2) }
        fib = fib.memoize()
        assert fib(40) == 165_580_141

        // trampoline 蹦床 防止递归栈溢出
        def last
        last = { it.size() == 1 ? it.head() : last.trampoline(it.tail()) }
        last = last.trampoline()

        assert  last(0..10_000) == 10_000

    }


    def static numParams(Closure closure) {
        closure.getMaximumNumberOfParameters()
    }

    def static paramTypes(Closure closure) {
        closure.getParameterTypes()
    }


}
