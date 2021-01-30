package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/19
 */

def move(Direction direction) {
    [by:{
        Direction dist->
            [at: { Speed speed ->
                println "robot moved $direction by $dist at $speed"

            }]
    }]
}

move Direction.right by 3.meter at 5.km/h