package com.jack.groovy.ch12

import groovy.io.FileType

/**
 * @author liangchen* @date 2020/11/22
 */
file = new File('.')
// 打印文件名
println file.name

// 绝对路径
println file.absolutePath

// 规范路径
println file.canonicalPath

// 是否为目录
println file.directory



// File 遍历系统

def topDir = new File('../../../../')
def srcDir = new File(topDir,'')
dirs = []
srcDir.eachDir { dirs << it.name }
assert ['com'] == dirs

dirs=[]
// 递归遍历文件夹
topDir.eachDirRecurse {dirs << it.name}
assert dirs.containsAll(['jack','groovy', 'ch2'])

dirs = []
// 匹配第一个
topDir.eachDirMatch(~/[^1]*/) { dirs << it.name }
assert dirs == ['com']

// 遍历文件和目录
files=[]
topDir.eachFile { files << it.name }
assert  files.contains('com')
assert files.contains('.DS_Store')

files = []
topDir.eachFile ( FileType.FILES){files << it.name}
assert  files.contains('.DS_Store')

// 计数目录
count = 0
srcDir.eachFileRecurse {if(it.directory) count++}

count =0
srcDir.eachFileRecurse (FileType.DIRECTORIES) {count++}
assert 19 == count
topDir.eachFileMatch(~/_12_2_1.*/) { files << it.name }
assert ['.DS_Store'] == files