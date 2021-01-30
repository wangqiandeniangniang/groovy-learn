package com.jack.groovy.ch7

/**
 * 获取bean的属性
 * 获取def 修饰的变量
 * @author liangchen* @date 2020/11/10
 */
class GDKBeanProperties {

    static class ClassWithProperties{
        def someProperty
        public someField
        private somePrivateField
    }

    static void main(String[] args) {
       def obj = new ClassWithProperties()
        def store = []
        obj.properties.each { property ->
            store += property.key
            store += property.value
        }
        assert store.contains('someProperty')
        assert store.contains('someField')  == false
        assert store.contains('somePrivateField') == false
        assert store.contains('class')

        assert obj.properties.size() == 2
    }

}
