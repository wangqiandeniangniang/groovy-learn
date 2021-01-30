package com.jack.groovy.ch2

/**
 * map 直接是 [key:value]
 * @author liangchen* @date 2020/10/22
 */
class MapDemo {

    static void main(String[] args) {
        def http = [
                100: 'CONTINUE',
                200: 'OK',
                400: 'BAD REQUEST'

        ]
        assert http[200] == 'OK'

        http[500] = 'INTERNAL SERVER ERROR'

        assert  http.size() == 4
    }
}
