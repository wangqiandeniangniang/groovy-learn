package com.jack.groovy.ch8

/**
 * 生成代理类替换原有的metaClass，实现拦截器功能
 * @author liangchen* @date 2020/11/11
 */
class ProxyMetaClass88 {

    static void main(String[] args) {
        //创建一个拦截器
        def tracer = new TracingInterceptor(writer: new StringWriter())
        // 生成代理原数据
        def proxyMetaClass = ProxyMetaClass.getInstance(InspectMe)
        // 代理类设置拦截器
        proxyMetaClass.interceptor = tracer

        InspectMe inspectMe = new InspectMe()
        // 手动定义aop切面
        proxyMetaClass.use(inspectMe){
            println "代理类开始"
            inspectMe.outer()
            println "代理类结束"

        }

        // 将inspectMe类的metaClass替换
        inspectMe.metaClass = proxyMetaClass
        assert  1 == inspectMe.outer()
        println tracer.writer.toString()
        assert  tracer.writer.toString() =="""before com.jack.groovy.ch8.InspectMe.outer()
                  before com.jack.groovy.ch8.InspectMe.inner()
                  after  com.jack.groovy.ch8.InspectMe.inner()
                after  com.jack.groovy.ch8.InspectMe.outer()"""
    }

}
class InspectMe{
    int outer(){
        return  inner()
    }

    private int inner(){
        return 1
    }
}
