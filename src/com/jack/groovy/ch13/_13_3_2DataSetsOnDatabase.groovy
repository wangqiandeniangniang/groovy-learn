package com.jack.groovy.ch13

/**
 * @author liangchen* @date 2020/12/1
 */
def sql = DbUtil.create()
sql.execute '''
DROP VIEW IF EXISTS  AthleteRecord ;
CREATE VIEW AthleteRecord AS 
SELECT * FROM Athlete LEFT OUTER JOIN Record ON fkAthlete=athleteId
'''
def records = sql.dataSet('AthleteRecord').findAll {
    it.firstname == 'Khalid'
}
def result = records.rows().collect{
    "$it.lastname $it.venue"
}
assert ['Khannouchi London', 'Khannouchi Chicago'] == result