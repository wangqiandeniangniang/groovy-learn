package com.jack.groovy.ch3

/**
 * @author liangchen* @date 2020/10/23
 */
class GStringDemo {

    static void main(String[] args) {
        // $变量名，注意需要双引号引起来
        def me = 'Tarzan'
        def you = 'Jane'
        def line = "me $me - you $you"

        assert  line == 'me Tarzan - you Jane'

        TimeZone.default = TimeZone.getTimeZone("GMT")

        def  date = new Date(0)

        def dateMap = [y:date[Calendar.YEAR] - 1900, m:date[Calendar.MONTH], d:date[Calendar.DAY_OF_MONTH]]

        def out = "Year $dateMap.y Month $dateMap.m Day $dateMap.d"

        assert  out == 'Year 70 Month 0 Day 1'

        def tz=TimeZone.getTimeZone('GMT')
        def format = 'd MMM YYYY HH:mm:SS z'
        out = "Date is ${date.format(format, tz)} !"
        assert  out == 'Date is 1 一月 1970 00:00:00 GMT !'

        // 多行字符串
        def sql = """
        SELECT FROM MyTable WHERE Year = $dateMap.y 
        """

        assert  sql == """
        SELECT FROM MyTable WHERE Year = 70 
        """


        out = "my 0.02\$"
        assert  out == 'my 0.02$'


        // 语句拆分
        assert line instanceof  GString

        //字符串
        assert line.strings[0] == 'me '
        assert line.strings[1] == ' - you '

        // 占位值
        assert line.values[0] == 'Tarzan'
        assert line.values[1] == 'Jane'
    }
}
