package com.jack.groovy.ch10

import groovy.transform.CompileStatic

/**
 * @author liangchen* @date 2020/11/18
 */
//
public class Greeter {               // Java!

    static void greet(Object o) {

        System.out.println("Hello, object "+o);

    }

    static void greet(String s) {

        System.out.println("Hello, string " + s);

    }

    public static void main(String...args) {

        Object o = "Bob";

        String s = "Bob";

        greet(o);

        greet(s);

    }

}
// 在java环境输出是
//Hello, object Bob
//Hello, string Bob

// groovy环境输出是
//Hello, string Bob

//Hello, string Bob
// 10.43,静态方法不能够被动态方法影响到
class MyFrammework{
    static int sizeOf(String s){
        s.size()
    }

    @CompileStatic
    static int staticSizeOf(String s) {
        s.size()
    }

}

String s = "a Happy new year!"
s.metaClass.size = { -> 5 }
assert s.size() == 5
// 返回动态方法
assert MyFrammework.sizeOf(s) == 5
// 静态方法，原始子串长度
assert MyFrammework.staticSizeOf(s) == 17