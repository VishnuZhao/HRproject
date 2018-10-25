package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public class Delivery implements Serializable {
    private int id;
    private int re_id;
    private int rc_id;
    private int status;//0:未处理，1：已处理

    public Delivery() {
    }

    public Delivery(int re_id, int rc_id, int status) {
        this.re_id = re_id;
        this.rc_id = rc_id;
        this.status = status;
    }

    public Delivery(int id, int re_id, int rc_id, int status) {
        this.id = id;
        this.re_id = re_id;
        this.rc_id = rc_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getRc_id() {
        return rc_id;
    }

    public void setRc_id(int rc_id) {
        this.rc_id = rc_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", re_id=" + re_id +
                ", rc_id=" + rc_id +
                ", status=" + status +
                '}';
    }
}
