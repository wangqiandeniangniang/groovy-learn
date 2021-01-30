package com.jack.groovy.ch10

import groovy.transform.TypeChecked

import java.util.function.Predicate

/**
 * @author liangchen* @date 2020/11/15
 */
// 10.18 Comparing methods and closure

def sum1(int x, int y) {x +y}
def sum2 = { int x, int y -> x + y }
assert sum1(3, 4) == 7
assert sum2(4,5) ==9

//============ 闭包类型不行匹配================
class Logger{
    /**
     * 接收字符串
     * @param messageProvider
     */
    static void print(Closure<String> messageProvider) {
        println "Received message: ${messageProvider}"
    }


}
@TypeChecked
testMessage(){
    def returnString = { 'Hello Groovy!' }
    def returnInt = { int x, int y -> x + y }
    Logger.print(returnString)
    // 这里编译错误
//    Logger.print(returnInt)
}

//=========10.20 动态校验用户信息
class User{
    String name
    String password
}

void validate(User u, Closure<Boolean> rule) {
    if (!rule.call(u)) {
        println "User $u.name $u.password rejected"
    }
}

void validateAll(user) {
    validate(user) { !it.name.isEmpty() }
    validate(user) {it.password.size() > 7}
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)

//10.23..., 使用predicte方法
interface Predicate<On> { boolean  apply(On e)}

void validate(User u, Predicate<User> rule) {
    if (!rule.apply(u)) {
        println "User $u.name $u.password rejected"
    }
}


def bobs = new User(name: 'Bob', password: 'secr3t')
validateAll(bobs)


