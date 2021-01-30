//package com.jack.groovy.ch7
//
///**
// * trait 有点类似 接口，只不过他有一些方法和属性， 应该说是抽象类和接口结合体
// * @author liangchen* @date 2020/11/10
// */
//class TraitDemo {
//
//    trait HashId{
//        long id
//    }
//
//    trait HasVersion{
//        long version
//    }
//    trait Persistent{
//        boolean save(){
//            println "saving ${this.dump()}"
//        }
//    }
//
//    trait  Entity implements Persistent ,HashId, HasVersion{
//        boolean save(){
//            version++
//            Persistent.super.save()
//        }
//    }
//    class Publication implements  Entity{
//        String title
//    }
//
//    class Book extends  Publication{
//        String isbn
//    }
//
//    static void main(String[] args) {
//        Entity gina = new Book(id:1,version: 1,title: 'gina', isbn: "11111")
//        gina.save()
//        assert gina.version == 2
//    }
//}
