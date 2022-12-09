package org.example;

import org.example.intefaces.IStockService;

import java.util.List;

public class Portfolio {

    public Portfolio(IStockService stockService) {

        this.stockService = stockService;
    }

    private IStockService stockService;
    private List<Stock> stocks;

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue() {
        double marketValue = 0.0;
        for (Stock stock : stocks) {
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
