package com.jack.groovy.ch8

/**
 * @author liangchen* @date 2020/11/11
 */
class MarShalGlobalVisual {

    static void main(String[] args) {
        use MarShal, {

            assert 1.marshal() == "1"
            //等于
            assert "1".unMarshal() == 1
            [Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE].each {
                assert it.marshal().unMarshal() == it
            }
        }
    }
}
