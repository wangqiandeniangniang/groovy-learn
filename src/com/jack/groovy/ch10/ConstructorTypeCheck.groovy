package com.jack.groovy.ch10

/**
 * @author liangchen* @date 2020/11/13
 */
//@groovy.transform.TypeChecked

void oneDimensional(){
    java.awt.Dimension d = [100]
}

shouldFail(ClassCastException){
    oneDimensional()
}
