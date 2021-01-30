package com.jack.groovy.ch6

/**
 *
 * 断言
 * @author liangchen* @date 2020/11/6
 */
class AssertDemo {
     static void main(String[] args) {
      def host = /\/\/([a-zA-Z0-9-])+(\.(a-zA-Z0-9-])*?)(:|\/)/

         assertHost 'http://a.b.c:8080/bla', host, 'a.b.c'
     }

   static def assertHost(candidate, regex, expected) {
        candidate.eachMatch(regex){ assert it[1] == expected}
    }
}
