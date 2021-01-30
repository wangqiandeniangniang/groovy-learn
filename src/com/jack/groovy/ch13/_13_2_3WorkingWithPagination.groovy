package com.jack.groovy.ch13

/**
 * @author liangchen* @date 2020/12/1
 */
// 分页
def sql = DbUtil.create()
DbUtil.init(sql)
def qry = 'SELECT * FROM Athlete'
assert sql.rows(qry, 1, 2)*.lastname == ['Radcliffe', 'Ndereba']
assert sql.rows(qry, 3,2)*.lastname ==  ['Takahashi', 'Loroupe']
