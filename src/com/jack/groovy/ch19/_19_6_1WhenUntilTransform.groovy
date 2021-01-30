package com.jack.groovy.ch19

import jdk.internal.org.objectweb.asm.tree.MethodNode
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassCodeVisitorSupport
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformationClass

import javax.script.ScriptEngine
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * @author liangchen* @date 2020/12/19
 */

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class WhenUntilTransform implements  ASTTransformation{

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        ClassNode annotatedClass = nodes[1]
        new ClassCodeVisitorSupport(){
            def currentMethod
            def currentBlock
            def currentStatement

            void visitMethod(MethodNode methodNode) {
                currentMethod = methodNode
                super.visitMethod(methodNode)
            }
            void visitBlockStatement(BlockStatement block) {

                currentBlock = block

                super.visitBlockStatement(block)

            }

            void visitExpressionStatement(ExpressionStatement statement) {

                currentStatement = statement

                super.visitExpressionStatement(statement)

            }

            void visitMethodCallExpression(MethodCallExpression mCall) {

                super.visitMethodCallExpression(mCall)

            }

            protected SourceUnit getSourceUnit() { unit }
        }.visitClass(annotatedClass)
    }
}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@GroovyASTTransformationClass(classes = [WhenUntilTransform])
@interface CustomerControlStructure{}

abstract  class BusinessLogicScript extends Script{
    def when(boolean condition, Closure closure) {
        if(condition) closure()
    }
}

def binding = new Binding(customer: [name: 'John Doe', age: 32])
def config = new CompilerConfiguration()
config.scriptBaseClass = BusinessLogicScript.class.name
config.addCompilationCustomizers(
        new ASTTransformationCustomizer(CustomerControlStructure)
)
def shell = new GroovyShell(this.class.classLoader, binding, config)
def result = shell.evaluate '''
    when(customer.age >=21){
        "Alcohol allowed for ${customer.name}"
    }
'''
assert result == "Alcohol allowed for John Doe"