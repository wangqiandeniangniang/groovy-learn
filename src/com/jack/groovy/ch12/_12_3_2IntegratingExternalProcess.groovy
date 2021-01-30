package com.jack.groovy.ch12

/**
 * @author liangchen* @date 2020/11/24
 */
//
// 用groovy执行命令行的命令， 创建一个process， 也就是可以创建一个执行过程
def listFiles = 'ls'.execute()
// 这里创建一个文件夹aa
'mkdir aa'.execute()
def ignoreCase = "tr '[A-Z]' '[a-z]'".execute()
def reverseSort = 'sort -r'.execute()
println listFiles
listFiles | ignoreCase| reverseSort

reverseSort.waitForOrKill(1000)
if (reverseSort.exitValue()) {
    println reverseSort.err.text
}each {
    println reverseSort.text
}

// 发现list
def outputBuffer = new StringBuffer()
def errorBuffer = new StringBuffer()

zipProcess = 'gzip -c'.execute()
unzipProcess = 'gunzip -c'.execute()

unzipProcess.consumeProcessOutput(outputBuffer,errorBuffer)
zipProcess.consumeProcessErrorStream(errorBuffer)
zipProcess | unzipProcess
zipProcess.withWriter { writer->
    writer << 'Hello World'
}
unzipProcess.waitForOrKill(1000)
println 'outPut:' + outputBuffer
println 'Error:' + errorBuffer