package com.repair.web.Entity;

import java.util.Date;

public class Order {
    private int id;
    private String order_id;
    private Date order_time;
    private String order_address;
    private String order_deviceName;
    private String order_deviceType;
    private String order_info;
    private String order_status;
    private String order_department;
    private String order_company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_deviceName() {
        return order_deviceName;
    }

    public void setOrder_deviceName(String order_deviceName) {
        this.order_deviceName = order_deviceName;
    }

    public String getOrder_deviceType() {
        return order_deviceType;
    }

    public void setOrder_deviceType(String order_deviceType) {
        this.order_deviceType = order_deviceType;
    }

    public String getOrder_info() {
        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_department() {
        return order_department;
    }

    public void setOrder_department(String order_department) {
        this.order_department = order_department;
    }

    public String getOrder_company() {
        return order_company;
    }

    public void setOrder_company(String order_company) {
        this.order_company = order_company;
    }
}
