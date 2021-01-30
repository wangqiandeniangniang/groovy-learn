package com.jack.groovy.ch13

import com.mysql.cj.jdbc.MysqlDataSource
import groovy.sql.Sql

import java.text.SimpleDateFormat
import java.util.logging.Level
import java.util.logging.Logger
Logger.getLogger('_13_1_2ExecutingSQL.groovy' ).level = Level.FINE

/**
 * @author liangchen* @date 2020/11/26
 */
// 这里需要注意mysql-connector的版本
@Grab(group='mysql', module='mysql-connector-java', version='8.0.17')
def dataSource = new MysqlDataSource(
        url:"jdbc:mysql://localhost:3306/test?characterEncoding=utf-8",
        user:'root',
        password:'cl123456'
)
sql = new Sql(dataSource)

sql.execute '''
    DROP TABLE  IF EXISTS Athlete;

  
'''
sql.execute '''
    CREATE TABLE Athlete (

    firstname   VARCHAR(64),

    lastname    VARCHAR(64),

    dateOfBirth DATE

  );
'''
sql.close()

// 定义数据库工具类
class DbUtil{
    static  Sql create(){
        def url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8"
        def user='root'
        def password = 'cl123456'
        def driver = 'com.mysql.cj.jdbc.Driver'
        def sql = Sql.newInstance(url, user, password, driver)

        sql.execute """
             DROP TABLE  IF EXISTS Record, Athlete,AAA;
 
"""
        sql.execute"""
    CREATE TABLE Athlete (

              athleteId   INTEGER ,

              firstname   VARCHAR(64),

              lastname    VARCHAR(64),

              dateOfBirth DATE,

              UNIQUE(athleteId)

            );
"""
        // 返回SQL语句
        sql
    }
    static  void init(sql){
        def qry = '''
    INSERT INTO Athlete(firstname, lastname, dateOfBirth) VALUES(?,?,?)
'''
        sql.withBatch (3, qry){ps->
            ps.addBatch('Paula',     'Radcliffe',   '1973-12-17')

            ps.addBatch('Catherine', 'Ndereba',     '1972-07-21')

            ps.addBatch('Naoko',     'Takahashi',   '1972-05-06')

            ps.addBatch('Tegla',     'Loroupe',     '1973-05-09')

            ps.addBatch('Ingrid',    'Kristiansen', '1956-03-21')

        }
    }

}

def sql = DbUtil.create()
sql.execute '''
    INSERT INTO Athlete(firstname, lastname, dateOfBirth) 
        VALUES('Paul', 'Tergat', '1969-06-17');
        
'''
//预编译
def athleteInsert='''
       INSERT INTO Athlete (firstname, lastname, dateOfBirth) 
       VALUES (?,?,?);
'''
//预编译插入数据
sql.execute athleteInsert, ['Khalid', 'Khannouchi', '1971-12-22']

// 使用变量插入数据

def data = [first: 'Ronaldo', last: 'da Costa', birth: '1970-06-07']
sql.execute """
    INSERT INTO Athlete (firstname, lastname, dateOfBirth)
    VALUES (${data.first}, ${data.last}, ${data.birth});
"""
//sql.close()

//  查询操作 居中，不足用-填充 （ 通过字段名获取）
println 'Athlete Info '.center(25, '-')
def fmt = new SimpleDateFormat('dd. MMM yyyy (E)', Locale.US)
sql.eachRow('SELECT * FROM Athlete'){
    athlete ->
        println athlete.firstname + ' ' + athlete.lastname
        println 'born on ' + fmt.format(athlete.dateOfBirth)
        print '-'*25
        println ''
}

//分行打印 ，通过索引下标获取
sql.eachRow('SELECT firstname, lastname FROM Athlete'){
    row->
        println row[0] + ' ' + row[1]
}

// 通过结果集（ResultSet)
sql.query('SELECT firstname, lastname FROM Athlete') { resultSet ->
    if (resultSet.next()) {
        print resultSet.getString(1)
        print ' '
        println resultSet.getString('lastname')
    }
}
//查询条数等于3条
assert  sql.firstRow('SELECT COUNT(*) AS num FROM Athlete').num == 3

// 插入数据
sql.execute '''
INSERT INTO Athlete(lastname) VALUES('da Costa')
'''
//更新数据
sql.execute '''
UPDATE Athlete SET firstname='Ronaldo' where lastname='da Costa'
'''
// 返回影响行数
def updateCount = sql.executeUpdate '''
    UPDATE Athlete SET dateOfBirth='1970-06-07' where lastname = 'da Costa'
'''
assert updateCount == 2

// 删除数据
sql.execute "DELETE FROM Athlete WHERE lastname='Tergat'"
assert  sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num ==3
sql.close()



