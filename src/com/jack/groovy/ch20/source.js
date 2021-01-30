var gs = require('grooscript');
function Hello() {
  var gSobject = gs.init('Hello');
  gSobject.clazz = { name: 'com.jack.groovy.ch20.Hello', simpleName: 'Hello'};
  gSobject.clazz.superclass = { name: 'java.lang.Object', simpleName: 'Object'};
  Object.defineProperty(gSobject, '$GCONTRACTS_ENABLED', { get: function() { return Hello.$GCONTRACTS_ENABLED; }, set: function(gSval) { Hello.$GCONTRACTS_ENABLED = gSval; }, enumerable: true });
  gSobject['methodMissing'] = function(name, args) {
    return gs.println("Hello " + (name) + "!");
  }
  if (arguments.length == 1) {gs.passMapToObject(arguments[0],gSobject);};
  
  return gSobject;
};
Hello.$GCONTRACTS_ENABLED = Configurator.checkAssertionsEnabled("com.jack.groovy.ch20.Hello");


var hello = Hello();
gs.mc(hello,"Groovy",[]);
gs.mc(hello,"Javascript",[]);
gs.mc(hello,"grooscript",[]);
