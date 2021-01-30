package com.jack.groovy.ch20

/**
 * @author liangchen* @date 2020/12/22
 */

// 建立一个build.gradle 文件
apply plugin:'groovy'

repositories{
    mavenCentral()
}

dependencies {

    compile     'org.codehaus.groovy:groovy-all:2.4.0'

    testCompile 'junit:junit:4.12'

}

// 建立一个jar
version = '1.0'
jar{
    baseName = 'mySample'
    manifest {
        attributes  'Implementation-Title': 'My Sample',

                'Implementation-Version':  version
    }
}

//发布一个jar
uploadArchives{
    repositories{
        flatDir(dirs: file('my_repository'))
    }
}