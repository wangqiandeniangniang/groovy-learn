package com.jack.groovy.ch7

import javax.swing.JButton

/**
 * 调用groovy方法
 * @author liangchen* @date 2020/11/10
 */
class CallGroovyWayDemo {

   static class MrBean {
        String firstname, lastname
        String getName (){
            return "$firstname $lastname"
        }
    }

     static void main(String[] args) {
         def bean = new MrBean(firstname: 'Rowan')
         bean.lastname = 'Jack'
         // 自动调用name --> getName 方法
         assert 'Rowan Jack' == bean.name

         //获取成员变量，使用.@
         def beanss = new DoublerBean(value: 100)
         assert 200 == beanss.value
         assert 100 == beanss.@value


     }

    /**
     * 获取成员变量，使用.@
     *
     */

    static  class DoublerBean {
        public value

        void setValue(value) {
            this.value = value
        }

        def getValue() {
            value * 2
        }
    }
}
