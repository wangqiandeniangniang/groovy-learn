package com.jack.groovy.ch12


import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

/**
 * @author liangchen* @date 2020/11/24
 */
// Groovy 多线程

//创建线程的方式
// 方式1
t = new Thread(){
    // 具体运行内容
}
t.start()

// 方式2
Thread.start {
    //具体运行内容
}
Thread.start("线程名称"){

}
// 创建守护线程
Thread.startDaemon {
    //具体运行内容
}
Thread.startDaemon ("线程名称"){
    // 具体运行内容
}
// 线程延迟1秒后运行
current = System.currentTimeMillis()
println "当前时间：$current"
new Timer().runAfter(1000){
   delta = System.currentTimeMillis() - current
    println "耗时：$delta"
}

// 12.12 使用线程来解决生产者和消费者
//在Thread中定义个静态的getName方法
Thread.metaClass.'static'.getName = {Thread.currentThread().name}
BlockingQueue sharedQueue = [] as LinkedBlockingQueue

// 创建生产者线程
Thread.start('push'){
    // 遍历10次
    10.times {
        try {
            println("${Thread.name}\t: ${it}")
            // 数字加到sharedQueue当中
            sharedQueue << it
            sleep(100)
        } catch (InterruptedException ignore) {}
    }
}
// 创建消费者线程
Thread.start('pop') {
    for (i in 0..9) {
        sleep 200
        println("队列元素：$sharedQueue")
        println ("${Thread.name}\t : ${sharedQueue.take()}")
    }
}
