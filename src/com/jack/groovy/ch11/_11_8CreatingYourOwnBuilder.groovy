package com.jack.groovy.ch11

/**
 * @author liangchen* @date 2020/11/21
 */
// 使用BuilderSupport 构建自己builder
class CalorieBuilder extends BuilderSupport {

    def calories = 0.0
    def name = 'root'
    def calorieDatabase = [
            crust    : [thin: 169, classic: 212, deepdish: 259, stuffed: 360],
            topping  : [pepperoni: 24, veggies: 10, cheese: 180],
            appetizer: [wings: 60, 'garlic-bread': 180]

    ]

    @Override
    protected void setParent(parent,  child) {
        if (child.size && parent.size && child.size != parent.size) {
            throw new IllegalStateException("Conflicting size found")
        }
        if (child.size) {
            child.scale = (child.size == 'large') ? 1.5 : 1.0
        }
    }

    @Override
    protected Object createNode(name) {
        [name: name, calories: 0.0]

    }

    @Override
    protected Object createNode(name, value) {
        def result = createNode(name) + [value: value]
        findCalories(result,name,value)
        result
    }

    @Override
    protected Object createNode(name, Map attributes) {
        createNode(name) + [*: attributes]

    }

    @Override
    protected Object createNode(Object o, Map attributes, Object value) {
        createNode(name,value) + [*: attributes]
    }

    void nodeCompleted(parentOrNull, node) {
        def parent = parentOrNull ?: this
        def qty = node.quantity ?: 1
        def scale = node.scale ?: 1.0
        findCalories(node, parent.name, node.name)
        parent.calories += node.calories * qty * scale

    }

    private void findCalories(Map map, name, value) {
        if (calorieDatabase.containsKey(name)) {
            map.calories = calorieDatabase[name][value].toInteger()
        }
    }
}
def lunch = new CalorieBuilder()
lunch.count {
    pizza(size: 'large'){
        crust('thin')
        topping('pepperoni')
        topping('veggies')

    }
    appetizer {
        wings(quantity: 2)
        'garlic-bread'()
    }
}
assert  lunch.calories == 604.5

//使用FactoryBuilderSupport



class CalorieBuilder2 extends FactoryBuilderSupport{

    def calories = 0.0
    def factory = new CalorieBeanFactory(getClass().classLoader)

    @Override
    protected void postInstantiate( name, Map atrrs,  node) {
        super.postInstantiate(name, atrrs, node)
        atrrs.each { k, v -> node[k] = v }

    }

    @Override
    protected Factory resolveFactory(Object name, Map attributes, Object value) {
       return factory
    }

    @Override
    protected void setParent(Object parent, Object child) {
        if (child.hasProperty('size')) {
            child.scale = child.size == 'large' ? 1.5 : 1.0
        }
    }

    @Override
    protected void nodeCompleted(Object parentOrNull, Object node) {
        def parent = parentOrNull ?: this
        def qty = node.quantity ?: 1
        def scale = node.scale ?: 1.0
        parent.calories += node.calories * qty * scale

    }
}


class CalorieBeanFactory extends  AbstractFactory{

    private ClassLoader loader

    CalorieBeanFactory(ClassLoader classLoader) {
        this.loader = classLoader
    }
    @Override
    Object newInstance(FactoryBuilderSupport fbs, name, value, Map attrs) throws InstantiationException, IllegalAccessException {
        def className = name[0].toUpperCase() + name[1..-1].replaceAll(/-(.)/){it[1].toUpperCase()}
        def clazz = loader.loadClass("com.jack.groovy.ch11."+className)


        return value ? clazz.newInstance(value: value) : clazz.newInstance()

    }

}

class Countable {
    int quantity

    def scale

    def calories = 0.0
}

class Count extends  Countable{}

class Pizza extends  Countable{
    def size
}

abstract  class CountableGroup extends  Countable{
    String value

    abstract  getCalorieDB()

    def getCalories(){calorieDB[value]}
}

class Crust extends CountableGroup {

    def calorieDB = [thin: 169, classic: 212, deepdish: 259, stuffed: 360]
}
class Topping extends CountableGroup {

    def calorieDB = [pepperoni: 24, veggies: 10, cheese: 50]

}

class Appetizer extends Countable {}

class Wings extends Countable {
    def calories = 60
}

class GarlicBread extends Countable {
    def calories = 180
}

def lunch1 = new CalorieBuilder2()

lunch1.count {
    pizza(size: 'large'){
        crust('thin')
        topping('pepperoni')
        topping('veggies')

    }
    appetizer {
        wings(quantity: 2)
        'garlic-bread'()
    }
}
assert  lunch1.calories == 604.5