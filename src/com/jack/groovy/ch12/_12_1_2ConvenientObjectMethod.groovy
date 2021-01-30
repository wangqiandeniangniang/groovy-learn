package com.jack.groovy.ch12

import com.jack.groovy.ch7.Address

/**
 * @author liangchen* @date 2020/11/22
 */
// 在java中,判断相等
int a = 1;
int b =1;
assert  a == b
// 在groovy中
assert a.is(b)

// switch 也不限于Integer char 类型
switch (new Date(0)) {
    case new Date(0): println 'dates are equal'

}

new Date().identity {
    println "$date.$month.$year"
}

//赋值
def address = new Address()
address.with {
    state = '中国'
    street = '天顶乡'


}

// 格式化打印
printf('PI=%2.5f and E = %2.5f', Math.PI, Math.E)

//直接use类的静态方法
class StringCasingCategory{
    static String lower(String string) {
        return string.toLowerCase()
    }
}

use(StringCasingCategory){
    assert "groovy" == "GROOvy".lower()
}

// sleep 打印
text = "间断打印"
for (c in text) {
    sleep(100)
    print c
}