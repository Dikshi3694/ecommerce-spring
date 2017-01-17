package com.allstate.entities;

import lombok.Data;

import org.springframework.data.annotation.Version;

import javax.persistence.*;
@Entity
@Table(name = "inventory")
@Data
public class Inventory {
    private int id;
    private int version;
    private String name;
    private String stockNumber;
    private int rating;
    private String description;
    private int noOfReviews;
    private int sellingPrice;
    private int discount;
    private int actualPrice;
    private int quantity;
    private boolean restriction;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false,unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false,unique = true)
    public String getStockNumber() {
        return stockNumber;
    }
    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoOfReviews() {
        return noOfReviews;
    }
    public void setNoOfReviews(int noOfReviews) {
        this.noOfReviews = noOfReviews;
    }

    @Column(nullable = false)
    public int getSellingPrice() {
        return sellingPrice;
    }
    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
        //this.sellingPrice = (int) (this.actualPrice - (this.actualPrice*0.01*this.discount));
    }


    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Column
    public int getActualPrice() {
        return actualPrice;
    }
    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isRestriction() {
        return restriction;
    }
    public void setRestriction(boolean restriction) {
        this.restriction = restriction;
    }

}
