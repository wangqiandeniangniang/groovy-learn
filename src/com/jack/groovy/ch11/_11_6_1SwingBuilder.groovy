package com.jack.groovy.ch11

import groovy.swing.SwingBuilder

import java.awt.BorderLayout

/**
 * @author liangchen* @date 2020/11/20
 */
swing = new SwingBuilder()
frame = swing.frame(title: 'Password'){
    passwordField(columns:10, actionPerformed:{
        event -> println event.source.text
            System.exit(0)
    })
}

frame.pack()
frame.visible = true

// 11.6.2

swing = new SwingBuilder()
frame = swing.frame(title: 'Demo'){
    menuBar {
        menu('File'){
            menuItem 'New'
            menuItem 'Open'
        }
    }
    panel {
        label 'Label1'
        slider()
        comboBox(items:['one','two','three'])
    }
}

frame.pack()
frame.visible = true

// 11.6.3

swing = new SwingBuilder()
frame = swing.frame(title:'Layout Demo') {
    panel(layout: new BorderLayout()) {
        button(constraints: BorderLayout.NORTH, 'North')
        button(constraints: BorderLayout.CENTER, 'Center')
        button(constraints: BorderLayout.SOUTH, 'South')
        button(constraints: BorderLayout.EAST, 'East')
        button(constraints: BorderLayout.WEST, 'West')
       panel {
           textField(columns: 10, id:'message')
           button(text: 'Print', actionPerformed: {
               event -> println event.source.parent.components[0].text
                   println swing.message.text
                   println message.text
           })
       }

    }

}
frame.pack()
frame.visible = true


