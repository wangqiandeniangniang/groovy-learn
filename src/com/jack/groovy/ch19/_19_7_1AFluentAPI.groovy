package com.jack.groovy.ch19

/**
 * @author liangchen* @date 2020/12/20
 */

final class FetchOptions{
    private int limit, offset, chunkSize, prefetchSize

    private FetchOptions(){}

    FetchOptions limit(int lim) {
        this.limit = lim
        return this
    }

    FetchOptions offset(int offs) {
        this.offset = offs
        return  this
    }

    FetchOptions chunkSize(int cs) {
        this.chunkSize = cs
        return this
    }

    FetchOptions prefetchSize(int ps) {
        this.prefetchSize = ps
        return this
    }

    static  final class Builder{
        private Builder(){

        }
        static  FetchOptions withDefaults(){
            new FetchOptions()
        }

        static FetchOptions withLimit(int lim) {
            new FetchOptions().limit(lim)
        }

        static FetchOptions withOffset(int ofs) {
            new FetchOptions().offset(ofs)
        }

        static FetchOptions withChunkSize(int cs) {
            new FetchOptions().chunkSize(cs)
        }

        static FetchOptions withPrefetchSize(int ps) {
            new FetchOptions().prefetchSize(ps)
        }
    }
}
def options = FetchOptions.Builder.withLimit(10).offset(60).chunkSize(1000)
import static com.jack.groovy.ch19.FetchOptions.Builder.*

options = withLimit(10).offset(60).chunkSize(1000)
//继续简写,去掉括号
withLimit 10 offset 60 chunkSize 10

// 定义构建器
class FetchOptionsBuilder{
    static FetchOptions fetchOptions(Closure closure) {
        def opts = FetchOptions.Builder.withDefaults()
        opts.with  closure
        return opts
    }
}
import  static  com.jack.groovy.ch19.FetchOptionsBuilder.*
fetchOptions {
    limit 10 offset 60
    chunkSize 1000
}