package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.ToString

/**
 * @AutoExternal 序列化
 * @author liangchen* @date 2020/11/13
 */
class AutoExternalize922 extends GroovyTestCase{

    void testAutoExternalize() {
        def c = new Composer(name: 'Wolfgang Amadeus Mozart', born: 1756, married: true)
        //创建输出数组流
        def baos = new ByteArrayOutputStream()
        //写出流到baos中
        baos.withObjectOutputStream {
            os -> os.writeObject(c)
        }
        // 创建一个输入流
        def bais = new ByteArrayInputStream(baos.toByteArray())
        def loader = getClass().classLoader
        def result
        bais.withObjectInputStream(loader) {
            result = it.readObject().toString()
        }
        assert result == 'com.jack.groovy.ch9.Composer(Wolfgang Amadeus Mozart, 1756, true)'

    }

}

@groovy.transform.AutoExternalize
@ToString
class Composer{
    String name

    int born

    boolean married
}
