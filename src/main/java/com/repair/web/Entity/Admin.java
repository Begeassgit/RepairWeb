package com.repair.web.Entity;

public class Admin {
    private int id;
    private String admin_username;
    private String admin_password;
    private String admin_company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_company() {
        return admin_company;
    }

    public void setAdmin_company(String admin_company) {
        this.admin_company = admin_company;
    }
}
