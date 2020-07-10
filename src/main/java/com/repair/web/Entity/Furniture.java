package com.repair.web.Entity;/*
    Author:Yin
*/

public class Furniture {
    private int id;
    private String furniture_id;
    private String furniture_name;
    private String furniture_brand;
    private String furniture_type;
    private int furniture_count;
    private String furniture_department;
    private String furniture_company;

    public int getId() {
        return id;
    }

    public String getFurniture_type() {
        return furniture_type;
    }

    public void setFurniture_type(String furniture_type) {
        this.furniture_type = furniture_type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFurniture_id() {
        return furniture_id;
    }

    public void setFurniture_id(String furniture_id) {
        this.furniture_id = furniture_id;
    }

    public String getFurniture_name() {
        return furniture_name;
    }

    public void setFurniture_name(String furniture_name) {
        this.furniture_name = furniture_name;
    }

    public String getFurniture_brand() {
        return furniture_brand;
    }

    public void setFurniture_brand(String furniture_brand) {
        this.furniture_brand = furniture_brand;
    }

    public int getFurniture_count() {
        return furniture_count;
    }

    public void setFurniture_count(int furniture_count) {
        this.furniture_count = furniture_count;
    }

    public String getFurniture_department() {
        return furniture_department;
    }

    public void setFurniture_department(String furniture_department) {
        this.furniture_department = furniture_department;
    }

    public String getFurniture_company() {
        return furniture_company;
    }

    public void setFurniture_company(String furniture_company) {
        this.furniture_company = furniture_company;
    }
}
