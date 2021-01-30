package com.jack.groovy.ch11

/**
 *
 * @author liangchen* @date 2020/11/20
 */

// 11.3
def builder = new groovy.xml.MarkupBuilder()
builder.numbers {
    //文本
    description 'Square and factors of 10..15'
    for (i in 10..15) {
        // 括号中是属性
        number(value: i, square: i * i) {
            for (j in 2..<i) {
                if (i % j == 0) {
                    factor (value:j)
                }
            }
        }
    }
}
/**
 * 结果
 * <numbers>
 *   <description>Square and factors of 10..15</description>
 *   <number value='10' square='100'>
 *     <factor value='2' />
 *     <factor value='5' />
 *   </number>
 *   <number value='11' square='121' />
 *   <number value='12' square='144'>
 *     <factor value='2' />
 *     <factor value='3' />
 *     <factor value='4' />
 *     <factor value='6' />
 *   </number>
 *   <number value='13' square='169' />
 *   <number value='14' square='196'>
 *     <factor value='2' />
 *     <factor value='7' />
 *   </number>
 *   <number value='15' square='225'>
 *     <factor value='3' />
 *     <factor value='5' />
 *   </number>
 * </numbers>
 *
 */
