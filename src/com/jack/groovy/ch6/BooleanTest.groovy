package com.jack.groovy.ch6

/**
 * boolean 测试
 * @author liangchen* @date 2020/11/6
 */
class BooleanTest {

    static void main(String[] args) {
        assert true
        assert  !false

        // matcher匹配
        assert ('a' =~ /./)
        assert !('a' =~ /b/)

        //集合必须非空为true
        assert [1]
        assert ![]

        // 迭代器必须要下一个元素才会是true
        Iterator iterator = [1].iterator()
        assert iterator
        iterator.next()
        assert !iterator

        // Map必须需要有元素才是true
        assert ['a': 1]
        assert ![:]

        // 字符串必须非空
        assert 'a'
        assert !''

        // 0是false， 非0是true
        assert 1
        assert 1.1
        assert 1.2f
        assert 1.3g
        assert 2L
        assert 3G
        assert !0

        //对象等于null 是false，反之为true
        assert ! null
        assert  new Object()

        //需要重新asBoolean方法
        assert !new AlwaysFalse()


    }
    static class AlwaysFalse{

        boolean  asBoolean(){false}
    }
}
