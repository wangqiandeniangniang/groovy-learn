package com.jack.groovy.ch5

/**
 * @author liangchen* @date 2020/11/4
 */
class MultiMethodSample {

    static void main(String[] args) {
        SizeFilter filter1 = new SizeFilter(limit: 6)
        SizeFilter filter2 = new SizeFilter(limit: 5)

        // 方法闭包赋值
        Closure sizeUpTo6 =  filter1.&sizeUpTo
        def words = ['long string', 'medium', 'short', 'tiny']

        assert 'medium' == words.find(sizeUpTo6)
        assert 'short' == words.find(filter2.&sizeUpTo)

        //=========
        // 根据不同参数找到不同闭包对应方法
        MultiMethodSample methodSample =  new MultiMethodSample()
        Closure multi = methodSample.&mysteryMethod
        assert  10 == multi('string arg')
        assert  3 == multi(['list','of','values'])
        assert 14 == multi(6, 8)


    }

    int mysteryMethod (String value){
        return value.length();
    }

    int mysteryMethod(List list) {
        return list.size();
    }

    int mysteryMethod(int x, int y) {
        return x + y
    }

}

/**
 * 大小过滤
 */
class SizeFilter {
    Integer limit

    boolean sizeUpTo(String value) {
        return value.size() <= limit
    }
}
