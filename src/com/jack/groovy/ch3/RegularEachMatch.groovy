package com.jack.groovy.ch3

/**
 * @author liangchen* @date 2020/10/24
 */
class RegularEachMatch {

    static void main(String[] args) {
       def myFairStringy = 'The rain in Spain stays mainly in the plain!'

        // 以ain结尾 \b 是单词边界
        def wordEnding = /\w*ain/
        def rhyme = /\b$wordEnding\b/

        // 找出所有匹配表达式字符串
        def found = ''
        myFairStringy.eachMatch(rhyme) {
            match ->
                found += match+' '
        }
        assert  found == 'rain Spain plain '

        // 找出所有匹配表达式
        found = ''
        (myFairStringy =~rhyme).each(match -> found +=match + ' ')
        assert  found == 'rain Spain plain '

        // 替换 单个字符it -> it-'ain'+'__' ， 去掉'ain' 加上__
        def cloze = myFairStringy.replaceAll(rhyme){
           it-'ain'+'__'
        }
        assert  cloze == 'The r__ in Sp__ stays mainly in the pl__!'


        // 取出部分数据
        def matcher = 'a b c' =~ /\S/

        assert  matcher[0] == 'a'

        assert matcher[1..2] == ['b','c']

        assert matcher.size() == 3

        def (a,b) = 'a b' =~ /\S/
        assert a =='a'
        assert b =='b'

        // 匹配map
        def matchMap = 'a:1 b:2 c:3' =~ /(\S+):(\S+)/
        assert  matchMap.hasGroup()
        // 匹配第一条数据
        assert  matchMap[0] == ['a:1', 'a', '1']
        // 第二匹配， 第2个组
        assert  matchMap[1][2] == '2'

        matchMap.each {full, key, value ->
            assert  full.size() == 3
            // a,b,c
            assert  key.size() ==1
            println key
            // 1,2,3
            assert value.size() == 1
            println( value)
        }
    }
}
