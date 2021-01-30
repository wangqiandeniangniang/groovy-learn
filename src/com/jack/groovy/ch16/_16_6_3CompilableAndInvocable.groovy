package com.jack.groovy.ch16

import javax.script.Compilable
import javax.script.CompiledScript
import javax.script.Invocable
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

/**
 * @author liangchen* @date 2020/12/12
 */
ScriptEngineManager manager = new ScriptEngineManager()
ScriptEngine scriptEngine = manager.getEngineByName("groovy")
Compilable compilable = (Compilable) scriptEngine
//设置一个值
compilable.put("name", "Dierk")

//设置返回方法, 有点SQL预编译的味道
CompiledScript script = compilable.compile("return name")
String dierksName = script.eval()
println dierksName
compilable.put("name", "Guillaume")
String guillaumesName = script.eval()
println guillaumesName

// Invoke 调用方法
ScriptEngineManager managerInvoke = new ScriptEngineManager()
ScriptEngine engine = managerInvoke.getEngineByName("groovy")

Invocable invocable = (Invocable) engine
// 添加一个方法
invocable.eval("def upper(s) {s.toUpperCase()}")
// 调用方法（变成大写）
Object s = invocable.invokeFunction("upper", "Groovy")

// 添加一个加法的方法
invocable.eval("def add(a,b){a+b}")
invocable.invokeFunction("add", new Integer(1), new Integer(2))
// 调用String 的方法endsWith
assertTrue(invocable.invokeMethod(s, "endsWith", "Y"))



