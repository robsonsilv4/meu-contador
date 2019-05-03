package com.robson.meucontador;

import java.io.Serializable;

public class Bill implements Serializable {

    private Long id;
    private String title;
    private String type;
    private Double price;

    // TODO: Adicionar datas


    public Bill() {
    }

    public Bill(String title, String type, Double price) {
        this.id = null;
        this.title = title;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title;
    }
}
