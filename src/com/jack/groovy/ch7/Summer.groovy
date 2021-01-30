package com.jack.groovy.ch7

/**
 * list map 入参
 * @author liangchen* @date 2020/11/9
 */
class Summer {

    static void main(String[] args) {
        def summer = new Summer();
        assert  2 == summer.sumWithDefualts(1,1)

        assert 3 == summer.sumWithDefualts(1, 1, 1)

        assert 2 == summer.sumWithList([1,1])
        assert 3 == summer.sumWithList([1,1,1])

        assert 2 == summer.sumWithOptionals(1,1)
        assert 3 == summer.sumWithOptionals(1,1,1)

        assert 2 == summer.sumNamed(a:1, b:1)
        assert 3 == summer.sumNamed(a: 1, b: 1, c: 1)
        assert 1 == summer.sumNamed(c:1)

    }

    def sumWithDefualts(a, b, c = 0) {
        return a + b + c

    }

    def sumWithList(List args) {
        return args.inject (0){sum, i -> sum +=i}
    }

    def sumWithOptionals(a, b, Object[] optionals) {
        return a + b + sumWithList(optionals.toList())
    }
/**
 * 入参为map
 * @param args
 * @return
 */

    def sumNamed(Map args) {
        // 不存在设置0
        ['a','b','c'].each {args.get(it, 0)}
        return args.a + args.b + args.c
    }
}
