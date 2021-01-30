package com.jack.groovy.ch6

/**
 * while语句
 * @author liangchen* @date 2020/11/6
 */
class WhileDemo {

    static void main(String[] args) {
      def list = [1,2,3]
        while (list) {
            list.remove(0)
        }
        assert list == []

        while (list.size() < 3) {
            list << list.size() +1
        }
        assert list == [1,2,3]
    }
}
