package com.jack.groovy.ch11

import groovy.swing.SwingBuilder
import groovy.transform.Canonical

import javax.swing.JLabel
import javax.swing.JTable
import javax.swing.table.TableCellRenderer
import java.awt.*

/** MVC
 * @author liangchen* @date 2020/11/20
 */
// data  定义数据 model
@Canonical
class NamedColor{
    String name
    Color foreground, background
}
purple = new NamedColor('Purple', Color.WHITE, new Color(127,0,255))
mediumBlue = new NamedColor('Blue', Color.WHITE, new Color(64, 128, 255))
brightYellow = new NamedColor('Yellow', Color.BLACK, Color.YELLOW)
brightRed = new NamedColor('Red', Color.BLACK, Color.RED)

data = [
        [name: 'Anthony', color: mediumBlue],
        [name: 'Greg', color: brightYellow],
        [name: 'Jeff', color: purple],
        [name: 'Murray', color: brightRed]
]

// 控制 control
swing = new SwingBuilder()
frame = swing.frame(title: 'Table Demo'){
    scrollPane {
        table(id: 'table'){
            tableModel(list: data) {
                propertyColumn(header: 'Name', propertyName: 'name')
                propertyColumn(header: 'Color',propertyName: 'color', type:NamedColor)
            }
        }

    }
}
frame.pack()
// view ， 渲染层
swing.table.setDefaultRenderer(NamedColor, new ColorRenderer())
frame.visible = true

class ColorRenderer extends JLabel implements TableCellRenderer{

    ColorRenderer(){opaque = true}
    @Override
    Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        background = color.background
        foreground = color.foreground
        text = color.name
        horizontalAlignment=CENTER
        this
    }
}