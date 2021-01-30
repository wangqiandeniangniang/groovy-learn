package com.jack.groovy.ch9

import groovy.transform.ASTTest
import org.codehaus.groovy.ast.stmt.ForStatement
import org.codehaus.groovy.control.CompilePhase

/**
 * @author liangchen* @date 2020/11/13
 */

@ASTTest(phase = CompilePhase.SEMANTIC_ANALYSIS, value={
    lookup('anchor').each{
        n-> assert n instanceof ForStatement
    }
})
void doSomenthing(){
    println "Hello, Groovy"
    anchor:for(int i=0; i<10; i++){println "Iteration $i"}
}