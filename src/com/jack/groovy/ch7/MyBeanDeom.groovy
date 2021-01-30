package com.jack.groovy.ch7

/**
 * groovy bean 定义
 * @author liangchen* @date 2020/11/10
 */
class MyBeanDeom {

    static class MyBean implements Serializable{
        String myprop

        def untyped
        String typed

        def item1, item2

        def assigned = 'default value'
    }

    static void main(String[] args) {
      MyBean myBean =  new MyBean()
       assert 'default value' == myBean.getAssigned()
        myBean.setUntyped('some value')
        assert 'some value' == myBean.getUntyped()

    }
}


