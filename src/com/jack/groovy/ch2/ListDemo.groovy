package com.jack.groovy.ch2

/**
 * @author liangchen* @date 2020/10/22
 */
class ListDemo {
// 也是从0开始的
    static void main(String[] args) {
        def roman = ['', 'I', "II", 'III', 'IV', 'V', 'VI', 'VII']
        assert roman[4]=='IV'
        roman[8] ='VIII'
        assert roman.size() == 9
    }
}
