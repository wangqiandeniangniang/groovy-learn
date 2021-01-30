package com.jack.groovy.ch9

import com.beust.jcommander.IValueValidator
import groovy.test.GroovyTestCase
import groovy.transform.Synchronized
import groovy.transform.WithReadLock
import groovy.transform.WithWriteLock
import groovy.util.logging.Log

/**
 * @author liangchen* @date 2020/11/12
 */
class Synchronized917  extends GroovyTestCase{

    void testSynchronized(){
        def p1 = new PhoneBook1()
        (0..99).collect{num ->
            //开启一个线程
            Thread.start {
                p1.addNumber('Number' + num, '98765' + num)
            }
            //主函数等待
        }*.join()
        assert p1.getNumber('Number43') == '9876543'
    }

    void testCustomsSynchronized(){
        def p2 = new PhoneBook2()
        (0..99).collect{num ->
            Thread.start {
                p2.addNumber('Number' +num, '98765' + num)
            }
        }*.join()
        assert p2.getNumber('Number43') == '9876543'
    }

    void testReadAndWriteLock(){
        def p3 = new PhoneBook3()
        (3..4).collect{num ->
            Thread.start {
                sleep 100*num
                p3.addNumber('Number' +num, '98765' + num)
            }
        }
        (2..7).collect{count ->
            Thread.start {
                sleep 100 * count
                p3.getNumber('Number'+ count)
            }
        }*.join()
    }
}

class PhoneBook1{
    private final phoneNumbers = [:]

    @Synchronized
    def getNumber(key) {
        phoneNumbers[key]
    }

    @Synchronized
    void addNumber(key, value) {
        phoneNumbers[key] = value
    }
}

/**
 * 自定义锁块
 */
@Log
class PhoneBook2 {
    private final phoneNumbers = [:]
    private final lock = new Object[0]

    @Synchronized('lock')
    def getNumber(key) {
        phoneNumbers[key]
    }

    void addNumber(key, value) {
        log.info("Adding phone number $value")
        synchronized (lock) {
            phoneNumbers[key] = value
        }
    }
}


/**
 * 读写锁
 */
class PhoneBook3 {
    private final phoneNumbers = dummyNums()

    private dummyNums() {
        (1..8).collectEntries{
            ['Number'+it, '765432' + it]
        }
    }

    @WithReadLock
    def getNumber(key) {
        println "Reading started for $key"
        phoneNumbers[key]
        sleep 80
        println "Reading done for $key"
    }

    @WithWriteLock
    def addNumber(key,value){
        println "Writing started for $key"
        phoneNumbers[key] = value
        sleep 100
        println "Writing done for $key"
    }
}
