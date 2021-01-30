package com.jack.groovy.ch10

import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode
import groovy.xml.MarkupBuilder

/**
 * @author liangchen* @date 2020/11/18
 */

class HTMLExample{

    @TypeChecked(TypeCheckingMode.SKIP)
    private static String buildPage(String pageTitle) {
        def xml = new MarkupBuilder()
        xml.html{
            head{title(pageTitle)}
        }


    }

    @TypeChecked
    static String page404(){
        buildPage '404 - Not Found'
    }
}
HTMLExample.page404()

