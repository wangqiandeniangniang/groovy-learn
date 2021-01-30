
import groovy.time.TimeCategory
import groovy.xml.MarkupBuilder

// --- doCompute并没打开TimeCategory类，而调用者打开TimeCategory,被调用者可以使用TImeCategory功能
class VacationHelper {
    static duration() {
        use(TimeCategory){
            doCompute()
        }
    }

    static doCompute(){
        1.week - 1.day
    }
}
assert VacationHelper.duration().toString() == '6 days'


//------ 10.29 使用ExpandoMetaClass, 动态定义方法， 接力的感觉
class Spy {
    static {
        def mc = new ExpandoMetaClass(Spy, false, true)
        mc.initialize()
        Spy.metaClass = mc
    }
    String name = "James"

    void methodMissing(String name, args) {
        if (name.startsWith("changeNameTo")) {
            println "Adding method $name"
            String newName = name.substring(12)
            def newMethod = {
                delegate.name = newName
            }
            //定义方法
            Spy.metaClass."$name" = newMethod
            newMethod()
        } else {
            throw new MissingMethodException(name, this.class, args)
        }

    }
}

def spy = new Spy()
assert  "James" == spy.name
spy.changeNameToAustin()
assert "Austin" == spy.name

spy.changeNameToMaxwell()
assert "Maxwell" == spy.name

spy.changeNameToAustin()
assert "Austin" == spy.name

// 10.30 ============输出xml格式文件

def writer = new StringWriter()
def xml = new MarkupBuilder(writer)
xml.html{
    head{
        title('An XHTML Page')
    }
    body{
      dev{
          dev("start")
      }
    }
}
println writer
