package com.jack.groovy.ch4

/**
 * list 集合
 * @author liangchen* @date 2020/10/24
 */
class ListSpecifyDemo {

    static void main(String[] args) {
        List myList = [1, 2, 3]

        assert myList.size() ==3
        assert myList[0] == 1

        assert  myList instanceof  ArrayList

        List emptyList =[]
        assert  emptyList.size() ==0
        // Rang转换成list
        List longList = (0..1000).toList()
        assert  longList[555] == 555

        List explicitList = new ArrayList()
        explicitList.addAll(myList)

        assert explicitList.size() == 3
        explicitList[0] = 10

        assert  explicitList[0] == 10

        explicitList = new LinkedList(myList)
        assert  explicitList.size() == 3
        explicitList[0] = 10
        assert explicitList[0] == 10
    }
}
