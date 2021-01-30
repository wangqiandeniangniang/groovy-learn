package com.jack.groovy.ch3

/**
 * 正则表达式执行效率 示例
 * @author liangchen* @date 2020/10/24
 */
class RegularPatternReuseDemo {

    static void main(String[] args) {

        def  twister = 'she sells sea shells at the sea shore of seychelles'

        def  regex =/\b(\w)\w*\1\b/
        def many = 100 * 1000

        // 隐模式匹配 比 显示慢 3-5倍
        def start =System.nanoTime()
        many.times {
            // 贪婪模式
            twister =~ regex
        }
        def timeImplicit = System.nanoTime() - start
        start = System.nanoTime()

        // 显示模式匹配
        def pattern = ~regex
        many.times {
            pattern.matcher(twister)
        }
        def  timePredef = System.nanoTime() - start

        assert  timeImplicit > timePredef * 2

    }
}
