package com.jack.groovy.ch18

import groovyx.gpars.actor.Actors

/**
 * @author liangchen* @date 2020/12/18
 */
def manual = Actors.reactor { message ->
    switch (message) {
        case Number: reply 'number'; break
        case String: reply 'string'; break
    }

}

def auto = Actors.messageHandler {
    when{String message -> reply 'string'}
    when{Number message -> reply 'number'}
}
