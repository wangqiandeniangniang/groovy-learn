package com.jack.groovy.ch8

import groovy.time.TimeCategory

/**
 * 使用groovy 自带集合
 * @author liangchen* @date 2020/11/11
 */
class UseTimeCateGategory {

    static void main(String[] args) {
       def janFirst1970 = new Date(0)
        use TimeCategory, {
            Date  xmas = janFirst1970 + 1.year - 7.day
            assert xmas.month == Calendar.DECEMBER
            assert xmas.date == 25
        }



       use Collection, {
            def list = [0,1,2,3]
            list.rotate 1
            assert list == [3,0,1,2]
        }
    }
}

