package com.jack.groovy.ch2

/**
 * @author liangchen* @date 2020/10/22
 */
class ClosureDemo {

    static void main(String[] args) {
        [1,2,3].each {
            entry -> println entry
        }

        def totalClinks =0
        def partyPeople = 100
        1.upto(partyPeople) {
            guestNumber ->
               def clinksWithGuest = guestNumber -1
                totalClinks += clinksWithGuest
        }
        assert totalClinks  == (partyPeople *(partyPeople -1))/2
    }
}
