package com.jack.groovy.ch19

import groovy.transform.Canonical
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer

/**
 * @author liangchen* @date 2020/12/20
 */
interface Term {}



@Canonical

class Value implements Term {

    def content

}



@Canonical

class Add implements Term {

    def left, right

}



@Canonical

class Mult implements Term {

    def left, right

}


def config = new CompilerConfiguration()
config.addCompilationCustomizers(
        new ASTTransformationCustomizer(
                value:[Value, Mult, Add], Newify
        )
)
def shell = new GroovyShell(
        this.class.classLoader, new Binding(), config
)
def term3 = shell.evaluate '''
    Mult(
        Value('a'),
        Add(
            Value('b'),
            Value('c')
        )
    )
'''
println term3.toString()