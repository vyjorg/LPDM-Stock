package com.lpdm.msstock.controller;

import com.lpdm.msstock.dao.StockDao;
import com.lpdm.msstock.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockDao stockDao;

    @GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> listStock(){
        List<Stock> list = stockDao.findAll();

        return list;
    }

    @GetMapping(value="/stocks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock findStock(@PathVariable int id){
        Stock stock = stockDao.findById(id);

        return stock;
    }

    @PostMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock addStock(@RequestBody Stock stock){

        Stock stockAdded = stockDao.save(stock);

        if (stockAdded.equals(null)){
            System.out.println("Erreur lors de l'ajout");
        }

        return stockAdded;
    }

    @DeleteMapping(value="/stocks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteStock(@PathVariable int id){
        stockDao.deleteById(id);
    }

    @PutMapping(value="/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock updateStock(@RequestBody Stock stock){
        Stock stockUpdate = stockDao.save(stock);

        return stockUpdate;
    }

    @GetMapping(value = "/stocks/producer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> listStockByProducer(@PathVariable int id){
        List<Stock> list = stockDao.findStockByProductId(id);

        return list;
    }

}
