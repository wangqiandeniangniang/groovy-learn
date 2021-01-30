package com.jack.groovy.ch15

/**
 * @author liangchen* @date 2020/12/6
 */

//@Grab('org.codehaus.groovy:groovy-xmlrpc:0.8')
//import groovy.net.xmlrpc.XMLRPCServerProxy as Proxy
//import  groovy.net.xmlrcp.XMLRPCServer as Server
//def server = new Server();
//server.echo ={return it}
//def socket = new ServerSocket(8080)
//server.startServer(socket)
//remote = new Proxy("http://localhost:8080/")
//assert  'Hello world!' == remote.echo('Hello world!')
//server.stopServer()

// 打印apache所有项目

def remote = new Proxy("http://jira.codehaus.org/rpc/xmlrpc")
def loginToken = remote.jira1.login('user','****')
def projects = remote.jira1.getProjects(loginToken)
projects.each {println it.name}