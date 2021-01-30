package com.jack.groovy.ch5

/**
 * 观察者模式
 * @author liangchen* @date 2020/11/6
 */
class VisitorPatternDemo {

    static void main(String[] args) {
        def picture = new Drawing(shapes: [new Square(width: 1), new Circle(radius: 1)])

        def total = 0
        // 累加的Closure
        picture.accept {total += it.area()}

        println "The shapes in this drawing cover an area of $total units."

        println "The individual contributions are: "

        picture.accept {println it.class.name + ":" + it.area()}
    }
}
class Drawing {
    List shapes

    def accept(Closure yield){
        shapes.each {it.accept(yield)}
    }
}

class Shape {
    def accept(Closure yield){
        yield(this)
    }
}

class Square extends  Shape{
    def width
    def area() { width**2 }

}
class Circle extends Shape{
    def radius

    def area() { Math.PI * radius**2 }

}

