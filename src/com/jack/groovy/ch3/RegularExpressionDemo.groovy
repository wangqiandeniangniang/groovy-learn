package com.jack.groovy.ch3

/**
 * 正则表达式 示例
 * @author liangchen* @date 2020/10/24
 */
class RegularExpressionDemo {

    static void main(String[] args) {

        def  twister = 'she sells sea shells at the sea shore of seychelles'

        // twister 找到 以s开头， a结尾
        assert twister =~ /s.a/

        def finder = (twister =~ /s.a/)
        assert  finder instanceof  java.util.regex.Matcher

        // 单词，中间空格隔开

        assert  twister ==~ /(\w+ \w+)*/

        def WORD = /\w+/
        def   matches = (twister ==~ /($WORD $WORD)*/)
        assert  matches instanceof  java.lang.Boolean
        // 未匹配
        assert  !(twister ==~ /s.e/)

        //匹配替换单词成x
        def wordsByX = twister.replaceAll(WORD,'x')

        assert  wordsByX == 'x x x x x x x x x x'

        // 空格切割
        def words = twister.split(/ /)
        assert  words.size() == 10
        assert words[0] == 'she'


    }
}
