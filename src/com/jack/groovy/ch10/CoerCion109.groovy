package com.jack.groovy.ch10

/**
 * @author liangchen* @date 2020/11/13
 */

enum MyEnum{
    var,val
}

@groovy.transform.TypeChecked
void testAssignmentsWithCoercion(){
    MyEnum val = 'val'
    assert val == MyEnum.val

    String blue = java.awt.Color.BLUE
    assert blue == 'java.awt.Color[r=0,g=0,b=255]'

    boolean nonEmpty = new Date()
    Boolean empty = ''
    assert nonEmpty
    assert !empty

    Class stringClass = 'java.lang.String'
    assert stringClass.interfaces.size() == 3
}

testAssignmentsWithCoercion()