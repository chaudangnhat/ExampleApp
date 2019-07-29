package com.example.examplefuturifuapplication.model;

public class ProductExtras {

    private int idl;
    private String title;
    private String price;

    public ProductExtras(int idl, String title, String price) {
        this.idl = idl;
        this.title = title;
        this.price = price;
    }

    public int getIdl() {
        return idl;
    }

    public void setIdl(int idl) {
        this.idl = idl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
