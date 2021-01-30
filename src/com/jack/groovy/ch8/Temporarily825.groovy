package com.jack.groovy.ch8


import groovy.test.GroovyTestCase

/**
 * @author liangchen* @date 2020/11/11
 */
class Temporarily825 extends GroovyTestCase {
    static connections = []

    static setInChannel(ChannelComponent self, value) {
        connections << [target: self, source: value]

    }

    static getOutChannel(ChannelComponent self) {
        self
    }
    void testChannelComponent(){
        def producer =new Producer()
        def adaptor = new Adaptor()
        def printer = new Printer()
        // 使用这个class，调用setInChannel然后给connections赋值
        use Temporarily825, {
            adaptor.inChannel = producer.outChannel
            printer.inChannel = adaptor.outChannel
        }
        assert Temporarily825.connections == [
                [source: producer, target: adaptor],
                [source: adaptor, target: printer]
        ]
    }
}
interface ChannelComponent{}

class Producer implements ChannelComponent{
    List<Integer> outChannel
}

class Adaptor implements ChannelComponent{
    List<Integer> inChannel
    List<String> outChannel
}

class Printer implements ChannelComponent{
    List<String> inChannel
}

