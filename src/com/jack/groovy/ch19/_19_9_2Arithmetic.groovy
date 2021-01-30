package com.jack.groovy.ch19

import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.BinaryExpression
import org.codehaus.groovy.ast.expr.BooleanExpression
import org.codehaus.groovy.ast.expr.ClassExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.ElvisOperatorExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.PostfixExpression
import org.codehaus.groovy.ast.expr.PrefixExpression
import org.codehaus.groovy.ast.expr.PropertyExpression
import org.codehaus.groovy.ast.expr.StaticMethodCallExpression
import org.codehaus.groovy.ast.expr.TernaryExpression
import org.codehaus.groovy.ast.expr.UnaryMinusExpression
import org.codehaus.groovy.ast.expr.UnaryPlusExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.codehaus.groovy.control.customizers.SecureASTCustomizer
import static org.codehaus.groovy.syntax.Types.*

/**
 * @author liangchen* @date 2020/12/20
 */

def imports = new ImportCustomizer().addStaticStars('java.lang.Math')
def secure = new SecureASTCustomizer()

secure.with {
    closuresAllowed = false
    methodDefinitionAllowed = false

    importsWhitelist = []
    staticImportsWhitelist = []
    staticStarImportsWhitelist = ['java.lang.Math']
    tokensWhitelist = [
            PLUS,MINUS,MULTIPLY,DIVIDE,MOD, POWER, PLUS_PLUS,MINUS_MINUS,
            COMPARE_EQUAL, COMPARE_NOT_EQUAL, COMPARE_LESS_THAN,
            COMPARE_LESS_THAN_EQUAL, COMPARE_GREATER_THAN, COMPARE_GREATER_THAN_EQUAL
    ]
    constantTypesClassesWhiteList = [
            Integer,Float, Long, Double, BigDecimal,
            Integer.TYPE,Long.TYPE, Float.TYPE, Double.TYPE
    ]
    receiversClassesWhiteList = [
            Math, Integer, Float, Double, Long, BigDecimal
    ]
    statementsWhitelist = [
            BlockStatement, ExpressionStatement
    ]
    expressionsWhitelist = [
            BinaryExpression, ConstantExpression,
            MethodCallExpression, StaticMethodCallExpression,
            ArgumentListExpression, PropertyExpression,
            UnaryMinusExpression, UnaryPlusExpression,
            PrefixExpression, PostfixExpression,
            TernaryExpression, ElvisOperatorExpression,
            BooleanExpression, ClassExpression
    ]
}
def config = new CompilerConfiguration()
config.addCompilationCustomizers(imports, secure)
def shell = new GroovyShell(config)
def result = shell.evaluate('1+cos(PI/2)')
assert result == 1
