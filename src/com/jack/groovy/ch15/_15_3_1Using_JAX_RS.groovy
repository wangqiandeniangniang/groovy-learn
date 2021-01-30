package com.jack.groovy.ch15

/**
 * @author liangchen* @date 2020/12/6
 */
// 使用 jax-RS
@Grab('org.jboss.resteasy:resteasy-client:3.0.10.Final')
//import javax.ws.rs.client.ClientBuilder
def client = ClientBuilder.newClient()
def base = "http://www.webservicex.net/CurrencyConvertor.asmx"
def response = client.target(base+'/ConversionRate')
    .queryParam("FromCurrency", "USD")
    .queryParam("ToCurrency", "EUR")
    .request().get(String)

def rate = new XmlSlurper().parseText(response)
assert rate.name() == 'double'
println rate.text()
