package com.jack.groovy.ch11

import groovy.beans.Bindable
import groovy.beans.ListenerList
import groovy.beans.Vetoable
import groovy.swing.SwingBuilder

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.beans.PropertyVetoException

/**
 * @author liangchen* @date 2020/11/21
 */

class Person implements  ActionListener{

    @Bindable String name
    @Vetoable int age
    @Override
    void actionPerformed(ActionEvent e) {
        if (e.actionCommand == name) {
            setAge(age + 1)
        }
    }
}

class BirthdayNotifier{
    @ListenerList List<ActionListener> listeners

    def triggerBirthday(name) {
        def even = new ActionEvent(this, 0, name)
        fireActionPerformed(even)
    }
}
data = [
        [name: 'Anthony', age: 51],
        [name: 'Greg', age: 42],
        [name: 'Jeff', age: 60],
        [name: 'Murray', age: 54]
]
swing = new SwingBuilder()
frame = swing.frame(title: 'Binding Demo'){
    table {
        tableModel(list: data, id: 'tableModel') {
            propertyColumn(header: 'Name', propertyName: 'name', editable:true)
            propertyColumn(header: 'Age', propertyName: 'age', type: Integer, editable: true)

        }

    }
}
frame.pack()
frame.visible =true
notifier = new BirthdayNotifier()
// 为啥报错呢
data.each {
    it.addPropertyChangeListener {
        evt -> println "$evt.newValue has replaced $evt.oldValue"

    }
    it.addVetoableChangeListener {
        evt ->
            if (evt.newValue < 0) {
                throw new PropertyVetoException("Can't have - ve age", evt)
            }else{
                println "$evt.source.name now has age $evt.newValue"
            }
    }
    notifier.addActionListener(it)
}
try{
    data[0].age = -99

}catch(e) {
    println "Change ingored:$e.message"

}
data[1].name = 'Sam'
data[1].age = 36
notifier.triggerBirthday(data[2].name)
swing.tableModel.fireTableDataChanged()
