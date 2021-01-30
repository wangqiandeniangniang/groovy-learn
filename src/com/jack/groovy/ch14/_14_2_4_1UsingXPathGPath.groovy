package com.jack.groovy.ch14

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory
import groovy.text.SimpleTemplateEngine as STE
/**
 * @author liangchen* @date 2020/12/4
 */

def doc = DOMBuilder.parse(new FileReader('data/plan.xml'))
def plan = doc.documentElement
def xpath = XPathFactory.newInstance().newXPath()

def binding = [scale: 1, weeks: []]
use(DOMCategory){
    xpath.evaluate('//week',plan, XPathConstants.NODESET).each { week ->
        binding.weeks << [
                total   : (int) xpath.evaluate('sum(task/@total)', week, XPathConstants.NUMBER),
                done    : (int) xpath.evaluate('sum(task/@done)', week, XPathConstants.NUMBER),
                capacity: week.'@capacity'.toInteger()

        ]

    }
}
def max = binding.weeks.capacity.max()
if(max >0) binding.scale = 200.intdiv(max)
def templateFile = new File('data/GroovyPlans.template.html')
def template = new STE().createTemplate(templateFile)
new File('data/XPathGroovyPlans.html').withWriter {
    it << template.make(binding)
}
