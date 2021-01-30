package com.jack.groovy.ch9

import groovy.test.GroovyTestCase

/**
 * 延迟加载 @Lazy 并没有立即实例化，在使用时候才实例化
 * @author liangchen* @date 2020/11/12
 */
class Lazy95  extends  GroovyTestCase{

    void testLazyDelayProperty(){
        new ResourceMain().with {
            assert Resource.stats() == '1 alive, 0 used'
            res2.use()
            res3.use()
            res4.use()
            assert Resource.stats() == '4 alive, 3 used'
            assert res4 instanceof Resource
            def expected = 'res4=java.lang.ref.SoftReference'
            assert  it.dump().contains(expected)
        }
    }
}

class  Resource{
    private  static alive = 0
    private static used =0
    Resource(){
        alive++
    }
    def use(){
        used++
    }
    static stats(){
        "$alive alive, $used used"
    }
}


class ResourceMain{
    def rea1 = new Resource()
    @Lazy res2 = new Resource()
    @Lazy static res3 = {new Resource()}()
    @Lazy (soft = true) volatile  Resource res4
}