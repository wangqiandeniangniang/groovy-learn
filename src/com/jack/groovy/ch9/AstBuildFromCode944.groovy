package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.ReturnStatement

/**
 * 利用code构建ast node
 * @author liangchen* @date 2020/11/13
 */
class AstBuildFromCode944  extends GroovyTestCase{

    void testAstBuildFromCode(){
        def ast = new AstBuilder().buildFromCode {
            //直接使用代码
            new Date()
        }
        assert  ast[0].statements[0]  instanceof  ReturnStatement
    }
}
