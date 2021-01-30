package com.jack.groovy.ch3

import javax.swing.Popup
import java.awt.Point
import java.awt.Rectangle

/**
 * @author liangchen* @date 2020/10/23
 */
class CastingDemo {

    static void main(String[] args) {

        // 典型模式
        Point topleft = new Point(0, 0)

        // List 转换
        Point botRight = [100,100]

        // Map cast
        Point center = [x:50, y:50]

        assert botRight instanceof  Point

        assert center instanceof  Point

        def rect = new Rectangle()
        // [] 相当于调用构造方法
        rect.location = [0, 0]

        // Dimension
        rect.size = [width:100, height:100]

    }
}
