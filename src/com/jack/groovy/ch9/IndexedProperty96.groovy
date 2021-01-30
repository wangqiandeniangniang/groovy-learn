package com.jack.groovy.ch9

import groovy.test.GroovyTestCase
import groovy.transform.IndexedProperty

/**
 * 类似生成数组的下标
 * @author liangchen* @date 2020/11/12
 */
class IndexedProperty96 extends GroovyTestCase{

    void testUsingIndexedProperty(){
        def books = ['The Mysterious Affair at Styles','The Murder at the Vicarage']
        new Author(name:'Agatha Christie', books:books).with {
            books[0] = 'Murder on the Orient Express'
            setBooks(0,'Death on the Nile')
            assert getBooks(0) == 'Death on the Nile'
            assert getBooks(1) =='The Murder at the Vicarage'
        }
    }
}

class Author{
    String name
    @IndexedProperty List<String> books
}
