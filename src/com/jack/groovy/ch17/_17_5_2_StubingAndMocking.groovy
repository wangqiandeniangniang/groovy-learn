package com.jack.groovy.ch17

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import groovy.transform.Sortable

/**
 * @author liangchen* @date 2020/12/13
 */
//利用stubing， 其实就一个空壳方法
class Farm{
    def getMachines(){
        // 这里代码非常复杂
    }
}

def relay(request) {
    //这里调用getMachines方法时候自动会调用到，返回fakeOne, fakeTwo
    new Farm().getMachines().sort{it.load}[0].send(request)
}
def fakeOne = new Expando(load:10, send: { false })
def fakeTwo = new Expando(load:5, send: { true })
// 确定存根对象
def farmStub = new StubFor(Farm)
// 需要实现存根对象方法,返回两个fake对象
farmStub.demand.getMachines{[fakeOne, fakeTwo]}

farmStub.use {
    assert relay(null)
}

// 使用mocking

class SortableFarm extends Farm{
    void sort(){
        //排序machine
    }
}

def relayMocking(request) {
    def farm = new SortableFarm()
    farm.sort()
    farm.getMachines()[0].send(request)
}
def farmMock = new MockFor(SortableFarm)
farmMock.demand.sort(){}
farmMock.demand.getMachines { [new Expando(send: {})] }
farmMock.use{
    relayMocking(null)
}