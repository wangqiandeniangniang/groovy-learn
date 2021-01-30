package com.jack.groovy.ch13

/**
 * @author liangchen* @date 2020/12/1
 */

// 使用元数据闭包
def sql = DbUtil.create()
def dump2 (sql, tableName){
    def printColNames = { meta ->
        def width = meta.columnCount * 12
        println "CONTENT OF TABLE ${tableName}".center(width, '-')
        (1..meta.columnCount).each {
            print meta.getColumnLabel(it).padRight(12)
        }
        println()
        println '-'*width

    }
    def printRow = {row ->
        row.toRowResult().values().each{
            print it.toString().padRight(12)
        }
        println()
    }

    sql.eachRow('SELECT * FROM ' + tableName, printColNames, printRow)
}

def baos = new ByteArrayOutputStream()
System.setOut(new PrintStream(baos))
dump2(sql, 'Athlete')
println baos.toString().readLines()*.trim().join('\n')

baos.reset()
dump2(sql, 'Record')
