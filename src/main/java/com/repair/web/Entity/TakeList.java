package com.repair.web.Entity;

import java.util.Date;

public class TakeList {
    private int id;
    private String take_list_list_id;
    private String take_list_id;
    private String take_list_name;
    private String take_list_department;
    private Date take_list_time;
    private String take_list_company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTake_list_list_id() {
        return take_list_list_id;
    }

    public void setTake_list_list_id(String take_list_list_id) {
        this.take_list_list_id = take_list_list_id;
    }

    public String getTake_list_id() {
        return take_list_id;
    }

    public void setTake_list_id(String take_list_id) {
        this.take_list_id = take_list_id;
    }

    public String getTake_list_name() {
        return take_list_name;
    }

    public void setTake_list_name(String take_list_name) {
        this.take_list_name = take_list_name;
    }

    public String getTake_list_department() {
        return take_list_department;
    }

    public void setTake_list_department(String take_list_department) {
        this.take_list_department = take_list_department;
    }

    public Date getTake_list_time() {
        return take_list_time;
    }

    public void setTake_list_time(Date take_list_time) {
        this.take_list_time = take_list_time;
    }

    public String getTake_list_company() {
        return take_list_company;
    }

    public void setTake_list_company(String take_list_company) {
        this.take_list_company = take_list_company;
    }
}
