package com.jack.groovy.ch12

/**
 * @author liangchen* @date 2020/11/24
 */
// 12.11 在临时目录的复制

// 创建一个临时目录
File tempDir = File.createTempDir()
assert  tempDir.directorySize() == 0

// 创建一个临时文件input.data,
File source = new File(tempDir, 'input.dat')
source.bytes = "hello world".bytes
// 这个目录下所有文件大小之和
assert tempDir.directorySize() == 11

//创建一个新的文件，output.dat, 把input.dat的内容输出到output.dat中
File destination = new File(tempDir, 'output.dat')
destination.withDataOutputStream { os ->
    source.withDataInputStream {is ->
        os << is
    }
}
// 最后文件大小是 11*2 = 22
assert  tempDir.directorySize() == 22
// 删除临时文件夹
tempDir.deleteDir()