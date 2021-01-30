package com.jack.groovy.ch12

/**
 * 过滤行数
 * @author liangchen* @date 2020/11/23
 */
def n = System.lineSeparator()
reader = new StringReader("abc")
writer = new StringWriter()
//当前元素的下一个元素
reader.transformChar(writer){it.next()}
assert  'bcd' == writer.toString()

// 去掉 line字段
reader = new File("data/example.txt").newReader()
writer = new StringWriter()
reader.transformLine(writer) { it - 'line' }
assert " one${n} two${n} three${n}" == writer.toString()

input = new File('data/example.txt')
writer = new StringWriter()

// 匹配有one字符串的行
input.filterLine(writer) { it =~ /one/ }
assert "line one${n}" == writer.toString()

// 过滤长度大于8 的行数
writer = new StringWriter()
writer << input.filterLine {it.size() > 8}
assert "line three${n}" == writer.toString()

// base 64
byte[] data = new byte[256]
for(i in 0..255) {
    data[i] == i

}
store = data.encodeBase64().toString()

assert store.startsWith('AAECAWQFBg')

// 以。。结尾
assert store.endsWith  ('r7/P3+/w==')
//解码base64
restored = store.decodeBase64()
assert data.toList() == restored.toList()