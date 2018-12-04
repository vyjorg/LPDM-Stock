package com.lpdm.msstock.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="stock",schema = "public")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer quantity;

    @Column(name="expire_date")
    private LocalDateTime expireDate;

    @Column
    private String packaging;

    @Column(name="unit_by_package")
    private Integer unitByPackage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public Integer getUnitByPackage() {
        return unitByPackage;
    }

    public void setUnitByPackage(Integer unitByPackage) {
        this.unitByPackage = unitByPackage;
    }
}
