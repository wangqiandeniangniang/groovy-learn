package com.jack.groovy.ch2

/**
 * @author liangchen* @date 2020/10/22
 */
@Grab(value = 'commons-lang:commons-lang:2.4')
import org.apache.commons.lang.ClassUtils
class GrabDemo {

     static void main(String[] args) {
         assert !ClassUtils.isInnerClass(Outer)

         assert ClassUtils.isInnerClass(Outer.Inner)
    }
}
class Outer{
    class Inner{}
}