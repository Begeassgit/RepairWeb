package com.repair.web.Entity;

import java.util.Date;

public class Device {
    private int id;
    private String device_id;
    private String device_name;
    private String device_type;
    private String device_brand;
    private Date device_time;
    private String device_info;
    private String device_company;
    private String device_department;

    public String getDevice_company() {
        return device_company;
    }

    public void setDevice_company(String device_company) {
        this.device_company = device_company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_brand() {
        return device_brand;
    }

    public void setDevice_brand(String device_brand) {
        this.device_brand = device_brand;
    }

    public Date getDevice_time() {
        return device_time;
    }

    public void setDevice_time(Date device_time) {
        this.device_time = device_time;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getDevice_department() {
        return device_department;
    }

    public void setDevice_department(String device_department) {
        this.device_department = device_department;
    }
}
