package com.jack.groovy.ch7

// 这里使用 as 为这个导入设置别名
import com.jack.groovy.ch7.thirdparty.MathLib as TypeMathLib
/**
 * @author liangchen* @date 2020/11/10
 */
class MathLib extends TypeMathLib  {

    /**
     * 订正 2倍
     * @param value
     * @return
     */
    Integer twice(Integer value) {
        return value * 2

    }

    static void main(String[] args) {
        def mathlib = new MathLib()
        assert 10 == mathlib.twice(5)
        assert  2 == mathlib.half(5)
    }

}
