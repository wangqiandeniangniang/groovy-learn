package com.jack.groovy.ch11

import groovy.xml.MarkupBuilder

/**
 * @author liangchen* @date 2020/11/20
 */
// 11.7. HTML GUI markupBuilder
def writer = new FileWriter('markup.html')
def html = new MarkupBuilder(writer)
html.html{
    head{
        title 'Constructed by MarkupBuilder'
    }
    body{
        h1 'What can I do with MarkupBuilder?'
        form(action: 'whatever'){
            for (line in ['Produce HTML', 'Produce XML', 'Have some fun']) {
                input(type: 'checkbox', checked: 'checked', id: line, '')
                label(for: line, line)
                br()
            }
        }
    }
}

/**
 * <html>
 *   <head>
 *     <title>Constructed by MarkupBuilder</title>
 *   </head>
 *   <body>
 *     <h1>What can I do with MarkupBuilder?</h1>
 *     <form action='whatever'>
 *       <input type='checkbox' checked='checked' id='Produce HTML'></input>
 *       <label for='Produce HTML'>Produce HTML</label>
 *       <br />
 *       <input type='checkbox' checked='checked' id='Produce XML'></input>
 *       <label for='Produce XML'>Produce XML</label>
 *       <br />
 *       <input type='checkbox' checked='checked' id='Have some fun'></input>
 *       <label for='Have some fun'>Have some fun</label>
 *       <br />
 *     </form>
 *   </body>
 * </html>
 */