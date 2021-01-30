package com.jack.groovy.ch15

import groovy.json.JsonSlurper
@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')

//import groovyx.net.http.RESTClient
/**
 * @author liangchen* @date 2020/12/6
 */

// 使用jira的api
class Jira {
    def base = 'https://issues.apache.org/jira/rest/api/latest/issue/'
    def slurper = new JsonSlurper()


    def query(key) {
        def httpConnection = new URL(base + key).openConnection()
        assert httpConnection.responseCode == httpConnection.HTTP_OK
        slurper.parse(httpConnection.inputStream.newReader())
    }
}

def jira = new Jira()
def response = jira.query("GROOVY-5999")
response.fields.with{
    assert  summary == "Make @Delegate work with @DelegatesTo"
    assert fixVesions.name == ['2.1.1']
    assert  resolutiondate.startWith('2013-02-12')
}


// 使用HTTPBuilder简化操作
def base = "https:/issues.apache.org/jira/rest/api/latest"
//def jira = new RESTClient(base)

jira.get(path: 'issue/GROOVY-5999') { resp, json ->

    assert resp.status == 200

    json.fields.with {

        assert summary == "Make @Delegate work with @DelegatesTo"

        assert fixVersions.name == ['2.1.1']

        assert resolutiondate.startsWith('2013-02-14')

    }

}
// 使用web service
// 内容是这样
//        <double xmlns="http://www.webserviceX.NET/">0.882</double>
def url = 'http://www.webservicex.net/CurrencyConvertor.asmx/'

//def converter = new RESTClient(url)

def params = [FromCurrency: 'USD', ToCurrency: 'EUR']

converter.get(path: 'ConversionRate', query: params) { resp, data ->

    assert resp.status == 200

    assert data.name() == 'double'

    println data.text()

}

// 使用post方法
//import groovyx.net.http.RESTClient

//import static groovyx.net.http.ContentType.URLENC



 url = 'http://www.webservicex.net/CurrencyConvertor.asmx/'

//def converter = new RESTClient(url)

def postBody = [FromCurrency: 'USD', ToCurrency: 'EUR']

converter.post(path: 'ConversionRate', body: postBody,

        requestContentType: URLENC) { resp, data ->

    assert resp.status == 200

    assert data.name() == 'double'

    println data.text()

}