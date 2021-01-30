package com.jack.groovy.ch2

/**
 * @author liangchen* @date 2020/10/22
 */
class BookTest {
     static void main(String[] args) {
       Book book = new Book("Groovy in Action")
         assert book.getTitle() == 'Groovy in Action'
         assert getTitleBackwards(book) == 'noitcA ni yvoorG'
    }

    static String getTitleBackwards(Book book) {
       String title = book.getTitle();
        return title.reverse();
    }
}
