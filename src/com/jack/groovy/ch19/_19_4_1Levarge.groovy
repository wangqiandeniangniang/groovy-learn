package com.jack.groovy.ch19

import groovy.transform.TupleConstructor

/**
 * @author liangchen* @date 2020/12/19
 */

@TupleConstructor
class Speed{

    Number amount
    DistanceUnit unit;

    String toString(){"$amount $unit/h"}
}

enum  Duration{
    hour
}

def binding = new Binding([
        robot : new Robot(),
        h: Duration.hour
])

@TupleConstructor
class DistanceOverride{
    double amount
    DistanceUnit unit

    Speed div(Duration duration) {
        new Speed(amount, unit)
    }

    String toString(){
        "$amount$unit"
    }
}