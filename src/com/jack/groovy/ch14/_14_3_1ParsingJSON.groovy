package com.jack.groovy.ch14

import groovy.json.JsonSlurper

/**
 * @author liangchen* @date 2020/12/5
 */
// 利用JsonSlurper 解析json
def plan = new JsonSlurper().parse(new File('data/plan.json'))
assert plan.weeks[0].tasks[0].status == 'easy'
assert plan.weeks[1].capacity == 8
assert plan.weeks[1].tasks[0].title =='re-read DB chapter'
