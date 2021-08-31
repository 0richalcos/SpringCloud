package com.orichalcos.entity;

import java.util.Date;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Date bir;

    public Product() {
    }

    public Product(Integer id, String name, Double price, Date bir) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bir = bir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bir=" + bir +
                '}';
    }
}
