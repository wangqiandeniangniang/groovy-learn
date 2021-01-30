package com.jack.groovy.ch19

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.SecureASTCustomizer

/**
 * @author liangchen* @date 2020/12/20
 */

def secure = new SecureASTCustomizer()
// java.io.*包类不能使用
secure.starImportsBlacklist = ['java.io.*']
secure.indirectImportCheckEnabled = true

def config = new CompilerConfiguration()
config.addCompilationCustomizers(secure)
def shell = new GroovyShell(config)

groovy.test.GroovyAssert.shouldFail {
    shell.evaluate '''
    new File('.')
'''
}
