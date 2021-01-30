package com.jack.groovy.ch20


/**
 * @author liangchen* @date 2020/12/22
 */

@Grab(group='org.ccil.cowan.tagsoup', module='tagsoup', version='1.2')

import org.ccil.cowan.tagsoup.Parser
// 防爬虫，有限制403了

def parser = new XmlParser(new Parser())

def html = parser.parse("http://manning.com/koenig2")



def twitterUrls = html.body.'**'.a.@href.grep(~/.*twitter.*/)

println twitterUrls.join( "\n" )



assert 'http://www.twitter.com/mittie' in twitterUrls
