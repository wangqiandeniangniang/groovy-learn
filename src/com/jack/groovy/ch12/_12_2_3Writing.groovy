package com.jack.groovy.ch12

/**
 * 写出文件
 * @author liangchen* @date 2020/11/22
 */

def outFile = new File('data/example.txt')
def lines = ['line one', 'line two', 'line three']
outFile.write(lines[0..1].join("\n"))
outFile.append("\n" + lines[2])
assert lines == outFile.readLines()
outFile.withWriter {writer ->
    writer.writeLine(lines[0])
}

outFile.withWriterAppend ('ISO8859-1') {
    writer -> writer << lines[1] << "\n"

}
outFile << lines[2]


TimeZone.default = TimeZone.getTimeZone("CET")
reader = new StringReader('abc')
writer = new StringWriter()


writer << "\nsome String" << "\n"
writer << [a: 1, b: 2] << "\n"
writer << [3, 4] << "\n"
writer << new Date(0) << "\n"
// ready可直接做writer入参
writer << reader << "\n"

println writer.toString()

