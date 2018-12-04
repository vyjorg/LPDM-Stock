package com.lpdm.msstock.controller;

import com.lpdm.msstock.dao.StockDao;
import com.lpdm.msstock.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockDao stockDao;

    @GetMapping(value = "/stocks")
    public List<Stock> listStock(){
        List<Stock> list = stockDao.findAll();

        return list;
    }

    @GetMapping(value="/stocks/{id}")
    public Stock findProduct(@PathVariable int id){
        Stock stock = stockDao.findById(id);

        return stock;
    }
}
