package com.lpdm.msstock.controller;

import com.lpdm.msstock.dao.StockDao;
import com.lpdm.msstock.entity.Stock;
import com.lpdm.msstock.exception.StockNotFound;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;
import java.util.List;

@Api(description="Controller pour les opérations CRUD sur les stocks.")
@RestController
public class StockController {
    private Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private StockDao stockDao;

    @ApiOperation(value = "Récupère tous les stocks de la bdd")
    @GetMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> listStock(){
        log.info("StockController -> méthode listStock : entrée ");
        List<Stock> list = stockDao.findAll();

        if(list.size()==0){
            log.warn("StockController -> méthode listStock : list vide ");
            throw new StockNotFound("Aucun stock trouvé dans la base de données");
        }

        log.info("StockController -> méthode listStock : sortie ");
        return list;
    }

    @ApiOperation(value = "Récupère un stock grâce à son ID si celui-ci existe dans la bdd")
    @GetMapping(value="/stocks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock findStockById(@PathVariable int id){
        log.info("StockController -> méthode findStockById : entrée ");
        log.info("StockController -> méthode findStockById : id envoyé = "+id);
        Stock stock = stockDao.findById(id);

        if(stock == null){
            log.warn("StockController -> méthode findStockById : stock null ");
            throw new StockNotFound("Aucun stock trouvé pour l'id = "+id);
        }

        log.info("StockController -> méthode findStockById : sortie ");
        return stock;
    }

    @ApiOperation(value = "Enregistre un stock si celui-ci est conforme")
    @PostMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock addStock(@Valid @RequestBody Stock stock){
        log.info("StockController -> méthode addStock : entrée ");
        log.info("StockController -> méthode addStock : stock reçu = "+stock.toString());

        Stock stockAdded = stockDao.save(stock);

        if (stockAdded.equals(null)){
            log.info("StockController -> méthode addStock : Erreur lors de l'ajout ");
        }

        log.info("StockController -> méthode addStock : sortie ");
        return stockAdded;
    }

    @ApiOperation(value = "Supprime un stock grâce à son ID si celui-ci existe dans la bdd")
    @DeleteMapping(value="/stocks/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteStock(@PathVariable int id){
        log.info("StockController -> méthode deleteStock : entrée ");
        log.info("StockController -> méthode deleteStock : id envoyé = "+id);
        stockDao.deleteById(id);
        log.info("StockController -> méthode deleteStock : sortie ");
    }

    @ApiOperation(value = "Met à jour un stock si celui-ci est conforme")
    @PutMapping(value="/stocks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Stock updateStock(@Valid @RequestBody Stock stock){
        log.info("StockController -> méthode updateStock : entrée ");
        log.info("StockController -> méthode updateStock : stock reçu = "+stock.toString());
        Stock stockUpdate = stockDao.save(stock);

        log.info("StockController -> méthode updateStock : sortie ");
        return stockUpdate;
    }

    @ApiOperation(value = "Récupère tous les stocks pour l'id d'un produit")
    @GetMapping(value = "/stocks/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Stock> listStockByProductById(@PathVariable int id){
        log.info("StockController -> méthode listStockByProducerById : entrée ");
        log.info("StockController -> méthode listStockByProducerById : id envoyé = "+id);
        List<Stock> list = stockDao.findStockByProductId(id);
        log.debug("StockController -> méthode listStockByProducerById : test list vide = "+list.size());
        log.info("StockController -> méthode listStockByProducerById : entrée ");
        return list;
    }

}
