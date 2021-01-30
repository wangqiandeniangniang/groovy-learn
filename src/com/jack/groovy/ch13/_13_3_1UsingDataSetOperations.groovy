package com.jack.groovy.ch13

/**
 * @author liangchen* @date 2020/12/1
 */

def sql = DbUtil.create()
def athletes = sql.dataSet('Athlete')

def result = []
athletes.each {result << it.firstname}
assert result == ['Paul', 'Khalid', 'Ronaldo']

athletes.add(
        firstname:'Paula',
        lastname:'Radcliffe',
        dateOfBirth: '1973-12-17'
)
result = athletes.rows().collect { it.firstname }
assert result == ['Paul', 'Khalid', 'Ronaldo', 'Paula']

// 查询大于 '1970-1-1'
youngsters = athletes.findAll { it.dateOfBirth > '1970-1-1' }
youngsters.each {
    println it.firstname
}

// 13.19 使用过滤器
athletes = sql.dataSet('Athlete')
athletes.add(
        firstname: 'Paula',
        lastname:'Radcliffe',
        dateOfBirth: '1973-12-17'

)
def query = athletes.findAll { it.firstname >= 'P' }
query = query.findAll {it.dateOfBirth > '1970-01-01'}
query = query.sort {it.dateOfBirth}
query = query.reverse()
assert query.sql == 'select * from Athlete where firstname >= ? and '
+ 'dateOfBirth > ? order by dateOfBirth DESC'
assert  query.parameters == ['P','1970-01-01']
assert query.rows()*.firstname == ['Paula', 'Ronaldo']