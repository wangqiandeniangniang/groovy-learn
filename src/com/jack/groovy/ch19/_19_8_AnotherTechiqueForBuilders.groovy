package com.jack.groovy.ch19

import groovy.transform.Canonical
import groovy.transform.ToString

/**
 * @author liangchen* @date 2020/12/20
 */

@ToString
class Car{
    String make
    String model
}
// ruby风格实例化对象
@Newify
def car = Car.new(make: 'Porsche', model: '911')
assert car.toString() == 'com.jack.groovy.ch19.Car(Porsche, 911)'

// python风格实例

@Canonical
class Country{
    String name
}

@Canonical
class City{
    String name
    String zipCode
    Country country
}

@Newify([City, Country])
def paris = City('Paris', '75000',Country('France'))
println paris.toString()