package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.control.CompilePhase

/**
 * 利用字符串直接创建Ast node
 * @author liangchen* @date 2020/11/13
 */
class AstBuildFromString931 extends GroovyTestCase{

    void testAstBuilderFromString(){
        def ast = new AstBuilder().buildFromString('new Date()')
        assert  ast[0] instanceof  BlockStatement
        assert ast[0].statements[0] instanceof  ReturnStatement
    }

    void testAstDynamicCode() {
        def approxPI = 3.14G
       // 直接添加方法，采用字符串
        def ast = new AstBuilder().buildFromString(
                CompilePhase.CLASS_GENERATION, false,
                'static double getTwoPI() { def pi = ' + approxPI + '; pi * 2 }'

        )

        assert ast[1] instanceof  ClassNode
        def method =ast[1].methods.find{
            it.name == 'getTwoPI'
        }
        assert method instanceof MethodNode
        
    }
}
