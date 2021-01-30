package com.jack.groovy.ch19

import groovy.test.GroovyAssert
import org.codehaus.groovy.ast.ClassCodeVisitorSupport
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.classgen.GeneratorContext
import org.codehaus.groovy.control.CompilationFailedException
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.control.customizers.CompilationCustomizer
import org.codehaus.groovy.syntax.SyntaxException

/**
 * @author liangchen* @date 2020/12/20
 */

def config = new CompilerConfiguration()
// 在编译时候拦截System.exit方法
def filter = new CompilationCustomizer(CompilePhase.CANONICALIZATION) {

    @Override
    void call(SourceUnit source, GeneratorContext context, ClassNode classNode) throws CompilationFailedException {
            new ClassCodeVisitorSupport(){
                void visitMethodCallExpression(MethodCallExpression callExpression) {
                    if(callExpression.objectExpression.text == 'java.lang.System' &&
                    callExpression.method.text=='exit'){
                        source.addError(new SyntaxException(
                                'System.exit() forbidden',
                                callExpression.lineNumber, callExpression.columnNumber
                        ))
                    }
                    super.visitMethodCallExpression(callExpression)
                }

                @Override
                protected SourceUnit getSourceUnit() {
                    return source
                }
            }.visitClass(classNode)
        }
}

config.addCompilationCustomizers(filter)
def shell = new GroovyShell(config)
def ce = GroovyAssert.shouldFail (CompilationFailedException){
    shell.parse'''
    System.exit(0)
'''
}
println ce.message