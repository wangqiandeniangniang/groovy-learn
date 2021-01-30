package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstructorCallExpression

import org.codehaus.groovy.ast.stmt.ReturnStatement

import static org.codehaus.groovy.ast.ClassHelper.make

import static org.codehaus.groovy.ast.tools.GeneralUtils.*
/**
 * @author liangchen* @date 2020/11/13
 */
class Ast928 extends GroovyTestCase{

    void testCreateAst(){

       def ast = new ReturnStatement(
                new ConstructorCallExpression(
                        ClassHelper.make(Date), ArgumentListExpression.EMPTY_ARGUMENTS
                )
        )
        assert ast instanceof ReturnStatement

        //创建语法树返回再抽象
        def asts = returnS(ctorX(make(Date)))

        assert asts instanceof ReturnStatement
    }

}
