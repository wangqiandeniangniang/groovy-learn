package com.jack.groovy.ch12

/**
 * @author liangchen* @date 2020/11/24
 */
// 序列化
file = new File('objects.dat')
// 在jvm退出时候删除文件
file.deleteOnExit()

objects = [1,'Hello Groovy!', new Date()]
// 写入对象到文件中
file.withObjectOutputStream { outstream ->
    objects.each{
        outstream << it
    }
}

// 从文件中读取对象到retrieved中
retrieved = []
file.withObjectInputStream {instream ->
    instream.eachObject {
        retrieved << it
    }
}

assert  retrieved == objects