package com.lpdm.msstock.controller;

import com.lpdm.msstock.dao.StockDao;
import com.lpdm.msstock.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
public class StockController {
    private Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private StockDao stockDao;

    @GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> listStock(){
        log.info("StockController -> méthode listStock : entrée ");
        List<Stock> list = stockDao.findAll();
        log.debug("StockController -> méthode listStock : test list vide = "+list.size());

        log.info("StockController -> méthode listStock : sortie ");
        return list;
    }

    @GetMapping(value="/stocks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock findStockById(@PathVariable int id){
        log.info("StockController -> méthode findStockById : entrée ");
        log.info("StockController -> méthode findStockById : id envoyé = "+id);
        Stock stock = stockDao.findById(id);

        log.info("StockController -> méthode findStockById : sortie ");
        return stock;
    }

    @PostMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock addStock(@RequestBody Stock stock){
        log.info("StockController -> méthode addStock : entrée ");
        log.info("StockController -> méthode addStock : stock reçu = "+stock.toString());

        Stock stockAdded = stockDao.save(stock);

        if (stockAdded.equals(null)){
            log.info("StockController -> méthode addStock : Erreur lors de l'ajout ");
        }

        log.info("StockController -> méthode addStock : sortie ");
        return stockAdded;
    }

    @DeleteMapping(value="/stocks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteStock(@PathVariable int id){
        log.info("StockController -> méthode deleteStock : entrée ");
        log.info("StockController -> méthode deleteStock : id envoyé = "+id);
        stockDao.deleteById(id);
        log.info("StockController -> méthode deleteStock : sortie ");
    }

    @PutMapping(value="/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock updateStock(@RequestBody Stock stock){
        log.info("StockController -> méthode updateStock : entrée ");
        log.info("StockController -> méthode updateStock : stock reçu = "+stock.toString());
        Stock stockUpdate = stockDao.save(stock);

        log.info("StockController -> méthode updateStock : sortie ");
        return stockUpdate;
    }

    @GetMapping(value = "/stocks/producer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> listStockByProducerById(@PathVariable int id){
        log.info("StockController -> méthode listStockByProducerById : entrée ");
        log.info("StockController -> méthode listStockByProducerById : id envoyé = "+id);
        List<Stock> list = stockDao.findStockByProductId(id);
        log.debug("StockController -> méthode listStockByProducerById : test list vide = "+list.size());
        log.info("StockController -> méthode listStockByProducerById : entrée ");
        return list;
    }

}
