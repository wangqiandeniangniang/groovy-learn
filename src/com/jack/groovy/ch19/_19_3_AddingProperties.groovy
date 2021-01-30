package com.jack.groovy.ch19

import groovy.transform.TupleConstructor
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer

/**
 * @author liangchen* @date 2020/12/19
 */

enum DistanceUnit{
    centimeter('cm', 0.01),
    meter ('m', 1),
    kilometer('km', 1000)

    String abbreviation
    double multiplier

    DistanceUnit(String abbr, double mult) {
        this.abbreviation = abbr
        this.multiplier = mult
    }
    String toString(){abbreviation}
}


@TupleConstructor
class Distance{
    Number amount
    DistanceUnit unit

    String toString() { "$amount$unit" }

}

class DistanceCategory{
    static Distance getCentimeters(Number number) {
        new Distance(number, DistanceUnit.centimeter)
    }

    static Distance getMeters(Number number) {
        new Distance(number, DistanceUnit.meter)
    }

    static Distance getKilometers(Number number) {
        new Distance(number, DistanceUnit.kilometer)
    }
    static Distance getCm(Number num) { getCentimeters(num) }



    static Distance getM(Number num) { getMeters(num) }



    static Distance getKm(Number num) { getKilometers(num) }
}
use(DistanceCategory) {
    def importCustomizer = new ImportCustomizer()
    importCustomizer.addStaticStars Direction.name
    def config = new CompilerConfiguration()
    config.scriptBaseClass = RobotBaseScript.name
    config.addCompilationCustomizers importCustomizer
   def  binding = new Binding(robot: new Robot())
    def shell = new GroovyShell(this.class.classLoader, binding,config)
    shell.evaluate '''
        move left
        move right, 3.meters

    '''

}