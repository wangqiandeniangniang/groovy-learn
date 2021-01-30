package com.jack.groovy.ch18

import groovyx.gpars.actor.Actors

/**
 * @author liangchen* @date 2020/12/18
 */
// 是不是reactor模型？
def decrypt = Actors.reactor { code -> code.reverse() }

def audit = Actors.reactor {println it}

def main = Actors.actor{
    decrypt 'terces pot'
    Actors.reactor {
        plainText -> audit plainText
    }
}
main.join()
audit.stop()
audit.join()