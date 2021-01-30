package com.jack.groovy.ch11

import groovy.ant.AntBuilder

/**
 * @author liangchen* @date 2020/11/20
 */
ant = new AntBuilder()
if (!System.properties.'java.version'.contains('1.7')) {
    ant.fail 'This build script requires JDK 1.7.x but was '
        + System.properties.'java.version'
}