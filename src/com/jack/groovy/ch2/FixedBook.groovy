package com.jack.groovy.ch2

import groovy.transform.Immutable


/**
 * @author liangchen* @date 2020/10/22
 */
@Immutable class FixedBook {
    String title

     static void main(String[] args) {
        def  book = new FixedBook('Groovy in Action')
        def  region = new FixedBook(title: 'Groovy in Action')
        assert book.title == 'Groovy in Action'
        assert book == region
        try {
//            book.title = "Oops!"
            assert false, "should not reach here"
        } catch (ReadOnlyPropertyException expected) {
            println "Expected  Error : '$expected.message'"
        }
    }
}
