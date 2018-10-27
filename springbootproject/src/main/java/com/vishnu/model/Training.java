package com.vishnu.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
public class Training implements Serializable {
    private int id;
    private String name;//培训主题
    private String text;//培训内容
    private String address;
    private Date startDate;
    private Date endDate;

    public Training() {
    }

    public Training(String name, String text, String address, Date startDate, Date endDate) {
        this.name = name;
        this.text = text;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Training(int id, String name, String text, String address, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", address='" + address + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
