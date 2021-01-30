package com.jack.groovy.ch13

import groovy.transform.Canonical

/**
 * @author liangchen* @date 2020/12/1
 */

sql = DbUtil.create()
def  insertPrefix = '''
INSERT INTO Athlete (firstname, lastname, dateOfBirth)
VALUES
'''
def loroup = [first: 'Tegla', last: 'Loroupe', dob: '1973-05-09']

sql.execute insertPrefix + '(:first, :last,:dob)', loroup

// 或者
sql.execute insertPrefix + '(:first,:last,:dbo)',
first: 'Ingrid', last:'Kristiansm', dob:'1956-03-21'

//或者声明一个域对象
@Canonical
class Athlete{
    String first,last,dob
}
def ndereba = new Athlete('Catherine', 'Ndereba', '1972-07-21')
sql.execute insertPrefix + '(?.first,?.last,?.dob)', ndereba

//或者如下
def takahashi = new Athlete('Naoka', 'Takahashi')
def takahashiExtra = [dob:'1972-05-06']
sql.execute insertPrefix + '(?1.first,?1.last,?2.dob)', takahashi, takahashiExtra

assert  sql.firstRow('SELECT COUNT(1) as num FROM Athlete').num ==4