package com.jack.groovy.ch8

/**
 * 自定义方法不存在的时候调用
 * @author liangchen* @date 2020/11/10
 */
class CustomizingMethodMissing {



    def methodMissing(String name, Object args) {
        "called $name with $args"
    }

    static void main(String[] args) {
        def customer = new CustomizingMethodMissing()
        // 方法不存在，自动调用methodMissing 方法， 设计哲学是避免MissingMethodException 异常
        assert customer.hello('world') == 'called hello with [world]'

       def people = new MiniGorm()
        def dierk = [first:'Dierk', last:'Koenig']
        def paul = [first:'Paul', last: 'King']
        people.db << dierk << paul

        assert  people.findByFirst('Dierk') == dierk
        assert people.findByLast('King') == paul
    }


}
class MiniGorm{
    def db = []

    def methodMissing(String name, Object args) {
        db.find {it [name.toLowerCase()-'findby'] == args[0]}
    }
}
