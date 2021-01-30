package com.jack.groovy.ch4

/**
 *
 * @author liangchen* @date 2020/11/3
 */
class CountWordMap {
    static void main(String[] args) {

        def textCorpus = """ 
        Look for the bare necessities
        The simple bare necessities
        Forget about your worries and your strife
        I mean the bare necessities
        Old Mother Nature's recipes
        That bring the bare necessities of life
        """
        def words = textCorpus.tokenize()
        def wordFrequency = [:]
        words.each { word ->
            wordFrequency[word] = wordFrequency.get(word, 0) + 1
        }
        def wordList = wordFrequency.keySet().toList()
        wordList.sort { wordFrequency[it] }
        def statistic = ""
        wordList[-1..-5].each {word ->
            statistic +=word + ": "
            statistic += wordFrequency[word]+" "
        }

        assert statistic == "necessities: 4 bare: 4 the: 3 your: 2 life: 1 "

        // 过滤map数据
        def people = [peter: 40, paul: 30, mary: 20]

        assert  people
            .findAll { _, age -> age < 35 }
            .collect { name, _ -> name.toUpperCase() }
        .sort()
        .join(",") == 'MARY,PAUL'

    }
}
