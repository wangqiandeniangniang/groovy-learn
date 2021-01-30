package com.jack.groovy.ch8

/**
 * 无参的方法调用
 * @author liangchen* @date 2020/11/11
 */
class GetProperty86 {

    def getProperty(String propertyName) {
        if (metaClass.hasProperty(this, propertyName)) {
            return metaClass.getProperty(this, propertyName)
        }
        // 调用空参数的构造方法
        invokeMethod propertyName,null
    }

    static void main(String[] args) {
        def user = new PropUser()
        assert  user.existingProperty
        // user.toString   invokeMethod  toString null
        assert  user.toString() == user.toString
    }
}

class PropUser extends GetProperty86 {
    boolean  existingProperty = true
}