package com.repair.web.Entity;

import java.util.Date;

public class Company {
    private String company_name;
    private String company_info;
    private String company_address;
    private String company_business;
    private String company_phone;
    private Date company_time;

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_info() {
        return company_info;
    }

    public void setCompany_info(String company_info) {
        this.company_info = company_info;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_business() {
        return company_business;
    }

    public void setCompany_business(String company_business) {
        this.company_business = company_business;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public Date getCompany_time() {
        return company_time;
    }

    public void setCompany_time(Date company_time) {
        this.company_time = company_time;
    }
}
