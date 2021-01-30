package com.jack.groovy.ch15

/**
 * @author liangchen* @date 2020/12/6
 */

import groovy.xml.Namespace



def url  = 'http://www.webservicex.net/CurrencyConvertor.asmx?WSDL'

def wsdl = new Namespace('http://schemas.xmlsoap.org/wsdl/','wsdl')

def doc  = new XmlParser().parse(url)



println doc[wsdl.portType][wsdl.operation].'@name'


// 使用 Conversion Rate SOAP服务
// 使用模板生成数据
import groovy.text.SimpleTemplateEngine as STE
import groovy.xml.Namespace
def file = new File('data/conv.templ.xml')
def template = new STE().createTemplate(file)
def params = [from:'USD', to:'EUR']
def request = template.make(params).toString().getBytes('UTF-8')

// 定义请求
url = 'http://www.webservicex.net/CurrencyConvertor.asmx'
def conn = new URL(url).openConnection()
def reqProps = [
        'Content-Type' : 'text/xml; charset=UTF-8',
        'SOAPAction' : 'http://www.webserviceX.NET/ConversionRate',
        'Accept': 'application/soap+xml, text/*'
]
reqProps.each { key, value -> conn.addRequestProperty(key, value) }
conn.requestMethod = 'POST'
conn.doOutput = true
// 发送请求
conn.outputStream << new ByteArrayOutputStream(request)

// 处理请求响应数据
if (conn.responseCode != conn.HTTP_OK) {
 println "Error - HTTP:${conn.responseCode}"
 return
}
def resp = new XmlParser().parse(conn.inputStream)
def serv = new Namespace('http://www.webserviceX.NET/')
def result = serv.ConversionRateResult
print "Current USD to EUR conversion rate: "
println resp.depthFirst().find{result == it.name()}.text()