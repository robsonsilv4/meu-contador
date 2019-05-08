package com.robson.meucontador;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class Bill implements Serializable {

    @NonNull
    @PrimaryKey
    private Long id;

    private String title;
    private String type;
    private Double price;

    public Bill() {

    }

    @Ignore
    public Bill(@NonNull Long id, String title, String type, Double price) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.price = price;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
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
}