package com.jack.groovy.ch8

/**
 * 撤销方法
 * @author liangchen* @date 2020/11/12
 */
class Undo826 {

    static void main(String[] args) {
        //原来的class元数据
       MetaClass oldMetaClass = String.metaClass
        MetaMethod alias = String.metaClass.metaMethods.find { it.name == 'size' }
        String.metaClass{
            // 调用size（）方法
            oldSize = { -> alias.invoke delegate }
            size = { -> oldSize() * 2 }

        }
        //调用新增的方法
        assert "abc".size() == 6
        assert "abc".oldSize() == 3

        if (oldMetaClass.is(String.metaClass)) { //false
            String.metaClass {
                size = { -> alias.invoke delegate }
                oldSize = { -> throw new UnsupportedOperationException() }
            }
        } else {
            // 恢复原来String的MetaClass
            String.metaClass = oldMetaClass
        }
        assert "abc".size() == 3
    }

}
