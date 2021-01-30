package com.jack.groovy.ch17

import groovy.transform.TupleConstructor
import spock.lang.Specification

/**
 * @author liangchen* @date 2020/12/15
 */
// 使用spock框架
// 只能手动下载下来放到grape中了，哎，还要注意spock-core的版本， 原书的版本太老的了
@Grab('org.spockframework:spock-core:2.0-M4-groovy-3.0')
class GivenWhenThenSpec extends Specification {

    def "test adding a new item to a set"(){
        given:
        def items = [4, 6, 3, 2] as Set

        when:
        items << 1

        then:
        items.size() == 5
    }
}

interface  MovieTheater{
    void purchaseTicket(name, number)
    boolean hasSeatsAvailable(name, number)
}

@TupleConstructor
class Purchase{

    def name, number, completed = false

    def fill(theater) {
        if (theater.hasSeatsAvailable(name, number)) {
            theater.purchaseTicket(name, number)
            completed = true
        }
    }
}
// 需要引入spock框架
//想要测这段逻辑但是没有具体实现这个时候可以使用mock
class MovieSpec extends Specification {
    def "buy ticket for a movie theater"() {
        given:
        def purchase = new Purchase("Lord of the Rings", 2)
        // mock对象，mock方法
        MovieTheater theater = Mock()
        theater.hasSeatsAvailable("Lord of the Rings", 2) >> true
        when :
        // 执行测试方法
        purchase.fill(theater)
        then :
        // 判断结果
        purchase.completed
        // 断言方法接下来方法入参（1表示调用次数为1次）
        1 * theater.purchaseTicket("Lord of the Rings", 2)

    }
    // 用通配符
    def "cannot buy a ticket when the movie is sold out"(){
        given:
        def purchase = new Purchase("Lord of the rings", 2)
        MovieTheater theater = Mock()

        when:
        theater.hasSeatsAvailable(_,_) >> false
        purchase.fill(theater)
        then:
        !purchase.completed
        //表示方法被调用0次  _ 表示通配符（不管参数）
        0 * theater.purchaseTicket(_, _)

    }

    // 可以进行入参的校验动作，如下 偶数票数被销售掉了
    def "on couples night tickets are sold in pairs"(){
        given:
        def purchase = new Purchase("Lord of the Rings", 2)
        MovieTheater theater = Mock()
        //调用这个方法返回true
        theater.hasSeatsAvailable("Lord of the Rings", 2) >> true

        when:
        purchase.fill(theater)
        then:
        1*theater.purchaseTicket(_, { it % 2 == 0 })

    }


}

