package com.jack.groovy.ch18

import groovyx.gpars.GParsPool
import groovyx.gpars.dataflow.Dataflow
import groovyx.gpars.dataflow.Dataflows

/**
 * @author liangchen* @date 2020/12/18
 */
//Date,      Open,  High,  Low,   Close, Volume,  Adj Close
//
//2009-12-01,202.24,213.95,188.68,210.73,19068700,210.73
class YahooService{
    static getYearEndClosingUnsafe(String ticker, int year) {
        def url = "http://real-chart.finance.yahoo.com/table.csv?" +

                "s=$ticker&a=11&b=1&c=$year&d=11&e=31&f=$year&g=d&ignore=.csv"
        def data = url.toURL().text
        return data.split("\n")[1].split(",")[4].toFloat()
    }

    static getYearEndClosing(String ticker, int year) {
        try {
            getYearEndClosing(ticker, year)
        } catch (all) {
            println "Could not get $ticker, returning -1. $all"
            return -1
        }
    }
}
def tickers = ['AAPL', 'GOOG', 'IBM','ORCL', 'MSFT']
def top = tickers.collect {[ticker:it, price : YahooService.getYearEndClosing(it, 2014)]}
.max{it.price}
assert  top == [ticker:'GOOG', price: 526.4f]

// 使用fork/join
GParsPool.withPool {
    def topFork = tickers.makeConcurrent()
    .collect { [ticker: it, price: YahooService.getYearEndClosing(it, 2014)] }
    .max{ it.price}
    assert  topFork == [ticker:'GOOG', price:526.4f]
}

//使用map/filter/reduce
GParsPool.withPool {
    def topFilter = tickers.parallel
        .map{[ticker: it, price:YahooService.getYearEndClosing(it, 2014)]}
        .max{it.price}
    assert topFilter == [ticker:'GOOG', price:526.4f]
}
// 使用Dataflows

def price = new Dataflows()
tickers.each {ticker ->
    Dataflow.task {price[ticker] = YahooService.getYearEndClosing(ticker, 2014)}
}
topFlow = tickers.max { price[it] }
assert topFlow == 'GOOG' && price[topFlow] == 526.4f