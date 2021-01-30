package com.jack.groovy.ch9

import groovy.test.GroovyTestCase

/**
 *
 * @author liangchen* @date 2020/11/12
 */
class InheritConstructors extends GroovyTestCase{

    void testInheritConstructors(){
        def pw1 = new MyPrintWriter(new File('out1.txt'))
        def pw2 = new MyPrintWriter('out2.txt', 'US-ASCII')
        [pw1, pw2].each {
            //将foo 字符写到 out1.txt和out2.txt文件中
            it << 'foo'
            //关闭流
            it.close()
        }
        //获取文本
        assert new File('out1.txt').text == new File('out2.txt').text
        // 删除文件
        ['out1.txt','out2.txt'].each{new File(it).delete()}
    }

}
/**
 * 继承父类构造方法
 */
@groovy.transform.InheritConstructors
class MyPrintWriter extends PrintWriter{}
