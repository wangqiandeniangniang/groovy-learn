package com.jack.groovy.ch17

import static org.junit.Assert.assertSame
/**
 * @author liangchen* @date 2020/12/13
 */
def relay(request, farm) {
    //排序取第一条
    farm.machines.sort{
        it.load
    }[0].send(request)
}

class FakeMachine{
    def load
    def send(request){return this}
}
final LOW_LOAD = 5, HIGH_LOAD=10
def farm = [machines:[
        new FakeMachine(load: HIGH_LOAD),
        new FakeMachine(load: LOW_LOAD)
]]
assertSame(LOW_LOAD, relay(null,farm).load)