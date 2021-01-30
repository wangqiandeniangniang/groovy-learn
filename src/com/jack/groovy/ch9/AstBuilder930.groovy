package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.ReturnStatement
/**
 * 利用AstBuilder 快速构建
 * @author liangchen* @date 2020/11/13
 */
class AstBuilder930  extends GroovyTestCase{

    void testAstBuilder(){
        def ast = new AstBuilder().buildFromSpec {
            returnStatement {
                constructorCall(Date){
                    argumentList {}
                }
            }
        }
        assert ast[0] instanceof  ReturnStatement
    }
}
