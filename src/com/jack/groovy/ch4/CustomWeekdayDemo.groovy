package com.jack.groovy.ch4

/**
 * @author liangchen* @date 2020/10/24
 */
class CustomWeekdayDemo {


    static void main(String[] args) {
        def mon = new Weekday('Mon')
        def fri = new Weekday('Fri')
        def worklog =''
        for (day in mon..fri) {
            worklog += day.toString() + ' '
        }
        assert worklog == 'Mon Tue Wed Thu Fri '

    }
}

class Weekday implements  Comparable<Weekday> {

    static  final  DAYS = [
            'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'
    ]
    private  int index = 0

    Weekday(String day){
        index = DAYS.indexOf(day)
    }
    @Override
    int compareTo(Weekday o) {
        return this.index <=> o.index
    }

    Weekday next(){
        return new Weekday((DAYS[(index +1) % DAYS.size()]))
    }
    Weekday previous (){
        return  new Weekday(DAYS[(index-1) % DAYS.size()])
    }

    String toString(){
        return DAYS[index]
    }
}