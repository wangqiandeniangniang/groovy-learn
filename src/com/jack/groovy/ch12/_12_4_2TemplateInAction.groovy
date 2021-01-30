package com.jack.groovy.ch12

import groovy.text.SimpleTemplateEngine

/**
 * @author liangchen* @date 2020/11/24
 */
//注意是三单引号  ${} 对应不是迭代的， <% %> 迭代情况拼接字符串
mailReminder =
'''
Dear ${salutation?salutation+' ':''}$lastname,another month has passed and it's time for these
<%=tasks.size()%> tasks:<% tasks.each{%>- $it<%} %>
your collaboration is very much appreciated
'''


// 创建模板引擎，
def engine = new SimpleTemplateEngine()
// 创建模板
def template = engine.createTemplate(mailReminder)
// 创建绑定数据
def binding = [
        salutation:'Mrs.',
        lastname:'Davis',
        tasks :['visit the Groovy in Action (GinA) page', 'chat with GinA readers']
]
// 进行绑定
println template.make(binding).toString()