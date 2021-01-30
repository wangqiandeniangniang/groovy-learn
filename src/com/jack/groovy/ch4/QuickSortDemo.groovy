package com.jack.groovy.ch4

/**
 * 快速排序
 * @author liangchen* @date 2020/10/30
 */
class QuickSortDemo {

    static void main(String[] args) {

        assert quickSort([]) == []
        assert  quickSort([1])==[1]
        assert quickSort([2,1]) == [1,2]
        assert quickSort([3, 1, 2]) == [1, 2, 3]
        assert quickSort([3,1,2,2]) == [1,2,2,3]
        assert quickSort([1.0f, 'a', 10, null]) == [null, 1.0f, 10, 'a']
        assert quickSort('bca') == 'abc'.toList()
    }

    def static quickSort(list) {
        if (list.size() < 2) {
            return list
        }
        def pivot = list[list.size().intdiv(2)]
        def left = list.findAll {
            item -> item < pivot
        }
        def middle = list.findAll{
            item -> item == pivot
        }
        def right = list.findAll{
            item -> item > pivot
        }
        return quickSort(left) + middle + quickSort(right)
    }

}
