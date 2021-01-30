//package com.jack.groovy.ch15
//
///**
// * 使用HTTPBuilder使用SOAP
// * @author liangchen* @date 2020/12/6
// */
//
//@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
//import groovyx.net.http.RESTClient
//import static  groovyx.net.http.ContentType.XML
//
//def base = 'http://www.webserviceX.NET/CurrentConvertor.asmx'
//def soapEnv = 'http://www.w3.org/2003/05/soap-envelope'
//def contentType = 'application/soap+xml;charset=UTF-8'
//new RESTClient(base).with{
//    parser.'application/soap+xml' = parser.'applicaiton/xml'
//    headers = ['Content-Type' : contentType]
//    post(requestContentType:XML,body: {
//        'soap:Envelope'('xmlns:soap': soapEnv){
//            'soap:Body'{
//                ConversionRate(xmlns: 'http://www.webserviceX.NET/'){
//                    FromCurrency('USD')
//                    ToCurrency('EUR')
//
//                }
//            }
//        }
//    }){resp, data ->
//        assert  resp.status ==200
//        println data.text()
//    }
//}