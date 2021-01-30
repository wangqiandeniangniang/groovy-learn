package com.jack.groovy.ch8

/**
 * 自定义String的methodMissing 方法， 新增方法
 * @author liangchen* @date 2020/11/11
 */
class MopHook817 {

    static void main(String[] args) {
       String.metaClass{
           // 加上前缀，在原字符上
           rightShiftUnsigned = {
               // 所有匹配字符前面都会加上前缀 \w 单词
               prefix -> delegate.replaceAll(~/\w+/) {prefix + it}
           }

           // 当方法不存在就会调用这个方法， name是方法名
           methodMissing = {String name, params ->
               delegate.replaceAll name, params[0]
           }
       }
        def people = "Dierk,Guillaume,Paul,Hamlet,Jon"
        //
        people = people.rightShiftUnsigned("prefix").Dierk('Mittie').Guillaume("Mr.G")
        println people
    }
}
