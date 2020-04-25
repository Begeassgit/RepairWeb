package com.repair.web.Entity;

public class Worker {
    private int id;
    private String worker_id;
    private String worker_name;
    private int worker_takeTime;
    private String worker_sex;
    private int worker_age;
    private String worker_rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public int getWorker_takeTime() {
        return worker_takeTime;
    }

    public void setWorker_takeTime(int worker_takeTime) {
        this.worker_takeTime = worker_takeTime;
    }

    public String getWorker_sex() {
        return worker_sex;
    }

    public void setWorker_sex(String worker_sex) {
        this.worker_sex = worker_sex;
    }

    public int getWorker_age() {
        return worker_age;
    }

    public void setWorker_age(int worker_age) {
        this.worker_age = worker_age;
    }

    public String getWorker_rank() {
        return worker_rank;
    }

    public void setWorker_rank(String worker_rank) {
        this.worker_rank = worker_rank;
    }
}
