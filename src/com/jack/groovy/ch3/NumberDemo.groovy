package com.jack.groovy.ch3

/**
 * @author liangchen* @date 2020/10/24
 */
class NumberDemo {

    static void main(String[] args) {
       assert  1 == (-1).abs()

        assert 2 == 2.5.toInteger()

        assert 2 == 2.5 as Integer

        assert 2 == (int) 2.5

        assert 3== 2.5f.round()

        assert 3.142 == Math.PI.round(3)

        assert 4 == 4.5f.trunc()

        assert 2.718 == Math.E.trunc(3)

        assert '2.718'.isNumber()

        assert 5 == '5'.toInteger()

        assert 5 == '5' as Integer
        // char 代表数字
        assert  53 == (int) '5'

        assert  '6 times' == 6 + ' times'

        // 步长

        def  store =''
        10.times {
            store += 'x'
        }
        assert  store == 'xxxxxxxxxx'
        store =''

        1.upto(5) {
            number -> store += number
        }
        assert  store == '12345'

        store = ''
        2.downto(-2) {
            number -> store += number +' '
        }
        assert  store == '2 1 0 -1 -2 '

        store = ''
        0.step(0.5,0.1){
            number -> store += number +' '
        }
        assert  store == '0 0.1 0.2 0.3 0.4 '
    }
}
