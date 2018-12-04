package com.lpdm.msstock.dao;

import com.lpdm.msstock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer> {

    Stock findById(int id);
}
