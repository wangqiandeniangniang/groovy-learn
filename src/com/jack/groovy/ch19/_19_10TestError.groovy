package com.jack.groovy.ch19

import groovy.transform.InheritConstructors

/**
 * @author liangchen* @date 2020/12/20
 */

class Query{
    static query(Closure closure){
        def q = closure.clone()
        q.resolveStrategy = Closure.DELEGATE_FIRST
        q.delegate = new Query()
        q()
    }

    def getProperty(String name){
        name
    }

    Query select(column){this}
    Query from(talbe){this}
    Query where(condition){this}
    def methodMissing(String name, args){
        def se = new SyntaxException(
                "No query verb '$name', only select/from/where allowed"
        )
        se.stackTrace = se.stackTrace.findAll{StackTraceElement ste ->
            ste.className != 'Query' &&
                    !(ste.methodName in ['invokeMethod', 'methodMissing'])
        }
        throw se

    }
}
@InheritConstructors
class SyntaxException extends Exception{}
def query = new Query();
query.get()