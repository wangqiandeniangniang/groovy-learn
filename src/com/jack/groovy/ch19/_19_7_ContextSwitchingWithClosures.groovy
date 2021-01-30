package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/20
 */
class Address {

    String line1

    String line2

    String city

    String zipCode

    String country

}
addr = new Address()
addr.with {
    line1   = '1st, Main Street'

    line2   = 'Suite 345'

    city    = 'Metropolis'

    zipCode = '12345'
}

def robot = new Robot()
robot.with {
    move Direction.right
    move Direction.forward
}

robot.execute{
    move Direction.left
    move Direction.forward
}