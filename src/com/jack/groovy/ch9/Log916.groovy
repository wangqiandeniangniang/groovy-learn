package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.util.logging.Log

/**
 * @Log注解
 * @author liangchen* @date 2020/11/12
 */

class Log916  extends GroovyTestCase{


    void testLog(){
        new Logs().search()
    }
}
@Log
class Logs{
    def search(){
        log.fine(runLongDatabaseQuery())
    }

    def runLongDatabaseQuery() {
        println 'Calling database'
        return 'query result'
    }
}

