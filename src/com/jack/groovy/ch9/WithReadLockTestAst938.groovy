package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.WithReadLock

import java.lang.reflect.Modifier
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * ast 测试
 * @author liangchen* @date 2020/11/13
 */
class WithReadLockTestAst938 extends  GroovyTestCase{

    static class MyClass{
        @WithReadLock
        void readerMethod1(){}
    }
    void testLockFieldDefaultsForReadLock(){
        def dee =  MyClass.getDeclaredFields();
        def field = MyClass.getDeclaredField('$reentrantlock')
        assert Modifier.isPrivate(field.modifiers)

        assert !Modifier.isTransient(field.modifiers)

        assert Modifier.isFinal(field.modifiers)
        assert !Modifier.isStatic(field.modifiers)
        assert field.type == ReentrantReadWriteLock
    }

    /**
     * 这是类，不是实例
     */
    void testLockFieldDefaultsForReadLocks(){
        //字符串 直接解析类
        def tester = new GroovyClassLoader().parseClass("""
    class MyClass{
    @groovy.transform.WithReadLock
    public void readerMethod1(){}
    } 
""")
        def field = tester.getDeclaredField('$reentrantlock')
        assert Modifier.isPrivate(field.modifiers)

        assert !Modifier.isTransient(field.modifiers)

        assert Modifier.isFinal(field.modifiers)
        assert !Modifier.isStatic(field.modifiers)
        assert field.type == ReentrantReadWriteLock
    }

    /**
     * groovyShell evaluate 是一个实例，而不是类
     */
    void testLockFieldDefaultsForReadLockGroovyShell() {
        def tester = new GroovyShell().evaluate("""
        import groovy.transform.WithReadLock
        class MyClass{
            @WithReadLock
            public void readerMethod1(){}
        }
        new MyClass()
""")
        // 这里是getClass()
        def field = tester.getClass().getDeclaredField('$reentrantlock')
        assert Modifier.isPrivate(field.modifiers)

        assert !Modifier.isTransient(field.modifiers)

        assert Modifier.isFinal(field.modifiers)
        assert !Modifier.isStatic(field.modifiers)
        assert field.type == ReentrantReadWriteLock
    }

}
