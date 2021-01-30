package com.jack.groovy.ch9


import org.codehaus.groovy.ast.*
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformationClass

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * 定义一下注解Main注解， 增加@GroovyASTransformationClass 表示这个注解处理的类
 * 是MainTransformation
 * RetentionPolicy 注解保持到源码阶段
 */
@Retention(RetentionPolicy.SOURCE)
@Target([ElementType.METHOD])
@GroovyASTTransformationClass(classes = [MainTransformation])
@interface Main{}


import static groovyjarjarasm.asm.Opcodes.ACC_PUBLIC
import static groovyjarjarasm.asm.Opcodes.ACC_STATIC
import static org.codehaus.groovy.ast.ClassHelper.VOID_TYPE
import static org.codehaus.groovy.ast.tools.GeneralUtils.*

// 确定那个时期处理，在指令选择处理
@GroovyASTTransformation(phase = CompilePhase.INSTRUCTION_SELECTION)
class MainTransformation implements ASTTransformation{
    // 定义默认节点
    private NO_EXCEPTIONS = ClassNode.EMPTY_ARRAY
    private STRING_ARRAY = ClassHelper.STRING_TYPE.makeArray()
    @Override
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        // 判断注解是否正确
        if(astNodes?.size() != 2) return
        if(!(astNodes[0] instanceof  AnnotationNode)) return
        if(astNodes[0].classNode.name != Main.name) return
        if(!(astNodes[1] instanceof MethodNode)) return

        // 获取目标方法、目标类，目标实例
        def targetMethod = astNodes[1]
        def targetClass = targetMethod.declaringClass
        def targetInstance = ctorX(targetClass)
        def callTarget = callX(targetInstance, targetMethod.name)
        def mainBody = block(stmt(callTarget))
        def visibility = ACC_STATIC | ACC_PUBLIC
        def parameters = params(param(STRING_ARRAY,'args'))
        //目标类增加main方法
        targetClass.addMethod('main', visibility, VOID_TYPE, parameters,NO_EXCEPTIONS, mainBody)
    }

}
new GroovyShell(getClass().classLoader).evaluate  """
class Greeter{
        @com.jack.groovy.ch9.Main
        def greet(){
        println "Hello from the greet() method!"
        }
} 
"""