package com.jack.groovy.ch13

import com.mysql.cj.jdbc.MysqlDataSource
import groovy.sql.Sql

/**
 * @author liangchen* @date 2020/11/26
 */
@Grab(group='mysql', module='mysql-connector-java', version='8.0.17')
// 13.1 连接数据库
def  url = 'jdbc:mysql://localhost:3306/test?characterEncoding=utf-8'
def user ='root'
def password='cl123456'
def driver = 'com.mysql.cj.jdbc.Driver'
def sql = Sql.newInstance(url, user, password, driver)
// 连上数据库
sql.query('select * from demo', {it -> println it});
sql.close()


// 使用DataSource创建连接

def dataSource = new MysqlDataSource(
        url:"jdbc:mysql://localhost:3306/test?characterEncoding=utf-8",
        user:'root',
        password:'cl123456'
)
sql = new Sql(dataSource)
sql.close()