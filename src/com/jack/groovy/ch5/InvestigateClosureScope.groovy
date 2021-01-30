package com.jack.groovy.ch5
/**
 * Closure域
 * @author liangchen* @date 2020/11/6
 */
class InvestigateClosureScope {
    static void main(String[] args) {

        Mother julia = new Mother()
        def closure = julia.birth('param')
        // 获取closure上下文
        def context = closure.call()

        assert context[0] == julia
        assert context[1, 2] == ['prop', 'method']
        assert context[3, 4] == ['local', 'param']
        // 对象
        assert closure.thisObject == julia
        assert  closure.owner == julia

        // 代理
        assert closure.delegate == julia
        assert closure.resolveStrategy == Closure.OWNER_FIRST

        def map = [:]
        // map 进行代理
        map.with {
            a = 1
            b = 2
        }
        assert map == [a: 1, b: 2]

    }


}

class Mother {
    def prop = 'prop'
    def method(){
        'method'
    }
    Closure birth(param){
        def local = 'local'
        def closure = {
            [this, prop, method(), local, param]
        }
        return closure
    }
}
