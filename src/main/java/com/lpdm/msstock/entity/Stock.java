package com.lpdm.msstock.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="stock",schema = "public")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "la quantité ne peut être null")
    @Min(value = 1,message = "La quantité ne peut être à 0")
    private Integer quantity;

    @Column(name="expire_date")
    @NotNull(message = "la date d'expiration ne peut être null")
    @Future(message = "la date d'expiration ne peut être antérieure à la date du jour")
    private LocalDate expireDate;

    @Column
    @NotNull(message = "le packaging ne peut être null")
    private String packaging;

    @Column(name="unit_by_package")
    @NotNull(message = "la quantité dans un package ne peut être null")
    private Integer unitByPackage;

    @Column(name="product_id")
    @NotNull(message = "la référence produit ne peut être null")
    private Integer productId;

    @Column
    @NotNull(message = "la description ne peut être null")
    private String description;

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

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", expireDate=" + expireDate +
                ", packaging='" + packaging + '\'' +
                ", unitByPackage=" + unitByPackage +
                ", productId=" + productId +
                ", description='" + description + '\'' +
                '}';
    }
}
