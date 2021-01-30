package com.jack.groovy.ch5

/**
 * 闭包定义
 * @author liangchen* @date 2020/11/4
 */
class AssignmentClosure {


    static void main(String[] args) {
       AssignmentClosure assignmentClosure =  new AssignmentClosure()
        def t= 1111
        assignmentClosure.printers.call(t)
    }
    // 闭包定义方式一
    def printers = { line -> println line}

    // 方式二
    Closure getPrinter(){
        return { line -> println line}
    }
}
