package com.jack.groovy.ch3

/**
 *  匹配特有的方法，先定义pattern，后匹配实际数据
 * @author liangchen* @date 2020/10/24
 */
class PatternClassificationDemo {

    static void main(String[] args) {
        def fourLetters = ~/\w{4}/

        // isCase 是否满足，四个字符要求
        assert  fourLetters.isCase('work')

        // in 是否满足要求 ，四个字符
        assert 'love' in fourLetters

        switch ('beer') {
            case  fourLetters: assert true; break
            default: assert false
        }

        // grep 查找四个字符数组内容
        def beats =['bear','wolf','tiger', 'regex']
        assert beats.grep(fourLetters) == ['bear', 'wolf']
    }
}
