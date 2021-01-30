package com.jack.groovy.ch11

import groovy.swing.SwingBuilder

import javax.swing.BorderFactory as BF
import javax.swing.JOptionPane
import javax.swing.WindowConstants as WC
import java.awt.BorderLayout as BL
import java.awt.Color

/**
 * @author liangchen* @date 2020/11/21
 */

swing = new SwingBuilder()
paint = swing.action(
        name: 'Paint',
        closure: this.&paintGraph,
        mnemonic: 'P',
        accelerator:'ctrl P'
)
about = swing.action(
        name:'About',
        closure:this.&showAbout,
        mnemonic:'A',
        accelerator:'F1'
)
frame = swing.frame(title: 'Plotter',
        location: [100,100],
        size: [500,500],
        defaultCloseOperation: WC.EXIT_ON_CLOSE){
    menuBar(){
        menu(mnemonic: 'A', 'Action') {
            menuItem(action: paint)
        }
        glue()
        menu(mnemonic: 'H', 'Help'){
            menuItem(action: about)
        }
    }
    panel (border: BF.createEmptyBorder(6, 6, 6, 6)){
        borderLayout()
        vbox (constraints: BL.NORTH){
            hbox{
                hstrut(width:10)
                label 'f(x)= '
                textField(id: 'function', action: paint, 'Math.sin(x)')
                button(action: paint)
            }
        }
        vbox(constraints: BL.WEST) {
            labeledSpinner('max', 1d)
            20.times { swing.vglue() }
            labeledSpinner('min', -1d)

        }
        vbox(constraints: BL.CENTER, border: BF.createTitledBorder('Function Plot')){
            panel(id:'canvas')
        }
        hbox(constraints: BL.SOUTH){
            hstrut(width: 10)
            labeledSpinner('from', 0d)
            10.times {swing.hglue()}
            labeledSpinner('to', 6.3d)
        }
    }
}
frame.visible=true
// 实现方法
def labeledSpinner(label, value){
    swing.label(label)
    swing.hstrut()
    swing.spinner(id: label, stateChanged: this.&paintGraph, model: swing.spinnerNumberModel(value: value))

}

def paintGraph(event) {
    calc = new Dynamo(swing.function.text)
    gfx = swing.canvas.graphics
    int width = swing.canvas.size.width
    int height = swing.canvas.size.height
    gfx.color = new Color(255, 255,150)
    gfx.fillRect(0, 0, width, height)
    gfx.color = Color.blue
    xFactor = (swing.to.value - swing.from.value) / width
    yFactor = height/(swing.max.value - swing.min.value)
    int celling = height + swing.min.value * yFactor
    int lastY = calc.f(swing.from.value) * yFactor
    for (x in (1..width)) {
        int y = calc.f(swing.from.value + x * xFactor) * yFactor
        gfx.drawLine(x - 1, celling - lastY, x, celling - y)
        lastY = y
    }
}

void showAbout(event){
    JOptionPane.showMessageDialog(frame, "A Function Plotter that serves as a SwingBuilder example for Groovy in Action")
}

// 动态调用
class Dynamo{
    static final GroovyShell SHELL = new GroovyShell()
    Script functionScript
    Dynamo(String function){
        functionScript = SHELL.parse(function)
    }

    Object f(x){
        functionScript.x = x
        return functionScript.run()
    }
}