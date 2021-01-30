package com.jack.groovy.ch16

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer


/**
 * @author liangchen* @date 2020/12/12
 */
def  conf  = new CompilerConfiguration()

def customizer = new ImportCustomizer()

customizer.addStarImports 'java.lang.Math'

conf.addCompilationCustomizers(customizer)

def shell = new GroovyShell( conf )
// 抛错呢
//def value = shell.evaluate('cos(2d)')