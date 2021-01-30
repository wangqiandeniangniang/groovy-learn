package com.jack.groovy.ch2.com.jack.groovy.ch2

/**
 * @author liangchen* @date 2020/10/22
 */
class BookBean {
    String title

    public static void main(String[] args) {
        def groovyBook = new BookBean();
        groovyBook.setTitle('Groovy in Action')
        assert  groovyBook.getTitle() == 'Groovy in Action'

        groovyBook.title = 'Groovy conquers the world'
        assert  groovyBook.title == 'Groovy conquers the world'
    }
}


