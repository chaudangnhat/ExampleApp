package com.example.examplefuturifuapplication.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    private int id;
    private String name;
    private String subName;
    private String description;
    private String urlImage;
    private double rate;
    private String ingredients;
    private String price;
    private String mass;
    private String type;
    private int count;
    private String calories;
    private String protein;
    private String totalFat;
    private String totalCarbs;

    public Product(int id,String name, String subName, String description,String urlImage, double rate,
                   String ingredients, String price, String mass, String type) {
        this.id = id;
        this.name = name;
        this.subName = subName;
        this.description = description;
        this.urlImage = urlImage;
        this.rate = rate;
        this.ingredients = ingredients;
        this.price = price;
        this.mass = mass;
        this.type = type;
    }

    public Product(int id, String name, String subName, String description, String urlImage, double rate, String ingredients, String price, String mass,
                   String type, int count, String calories, String protein, String totalFat, String totalCarbs) {
        this.id = id;
        this.name = name;
        this.subName = subName;
        this.description = description;
        this.urlImage = urlImage;
        this.rate = rate;
        this.ingredients = ingredients;
        this.price = price;
        this.mass = mass;
        this.type = type;
        this.count = count;
        this.calories = calories;
        this.protein = protein;
        this.totalFat = totalFat;
        this.totalCarbs = totalCarbs;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(String totalFat) {
        this.totalFat = totalFat;
    }

    public String getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(String totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
