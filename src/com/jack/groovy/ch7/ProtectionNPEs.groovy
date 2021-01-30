package com.jack.groovy.ch7

/**
 * ?. 避免空指针,连续判空
 * @author liangchen* @date 2020/11/9
 */
class ProtectionNPEs {

    static void main(String[] args) {
        def map = [a: [b: [c: 1]]]
        assert  map.a.b.c ==1

        if (map && map.a && map.a.x) {
            assert map.a.x.c == null
        }

        try {
            assert map.a.x.c == null
        } catch (NullPointerException ignore) {

        }
        assert map?.a?.x?.c==null
    }

}
