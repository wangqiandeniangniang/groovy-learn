package com.jack.groovy.ch16

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

/**
 * @author liangchen* @date 2020/12/12
 */

ScriptEngineManager scriptEngineManager = new ScriptEngineManager()

ScriptEngine engins = scriptEngineManager.getEngineByName("groovy")

result = engins.eval("3+3")
println result

