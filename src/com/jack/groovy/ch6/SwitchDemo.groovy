package com.jack.groovy.ch6

/**
 * switch 语句
 * @author liangchen* @date 2020/11/6
 */
class SwitchDemo {

    static void main(String[] args) {
        // 中规中矩switch
        def a = 1
        def log = ''
        switch (a) {
                case 0 : log += '0'
                case 1: log += '1'
                case 2: log += '2'
                break;
                default: log += 'default'
        }
        assert  log == '12'

        // groovy switch
        switch (10) {
            case 0 :assert false; break
            case 0..9:assert false; break
            // a.contains(b)
            case [8,9,11]:assert false;break
            // a.isInstance(b)
            case Float : assert false;break
            case { it % 3 == 0 } : assert false;break
            // 正则表达式 a.matcher(b.toString()).matches()
            case ~/../ : assert true;break
            default:assert false; break


        }
    }
}
