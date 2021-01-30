package com.jack.groovy.ch8

/**
 * marshal 和 unMarshal 方法转换
 * @author liangchen* @date 2020/11/11
 */
class MarShal {
    /**
     * 转换方法
     * @param self
     * @return
     */
    public static String marshal(Integer self) {
        self.toString()
    }

    /**
     * 转换
     * @param self
     * @return
     */
   public static Integer unMarshal(String self) {
        self.toInteger()
    }

    static void main(String[] args) {
        use MarShal, {

            assert 1.marshal() == "1"
            //等于
            assert marshal(1) == "1"
            assert "1".unMarshal() == 1
            unMarshal("1") == 1
            [Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE].each {
                assert it.marshal().unMarshal() == it
            }
        }
    }
}
