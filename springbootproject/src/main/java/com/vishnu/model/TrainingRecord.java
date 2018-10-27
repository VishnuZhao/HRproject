package com.vishnu.model;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
public class TrainingRecord {
    private int id;
    private int ta_id;
    private int emp_id;

    public TrainingRecord() {
    }

    public TrainingRecord(int ta_id, int uid) {
        this.ta_id = ta_id;
        this.emp_id = uid;
    }

    public TrainingRecord(int id, int ta_id, int uid) {
        this.id = id;
        this.ta_id = ta_id;
        this.emp_id = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTa_id() {
        return ta_id;
    }

    public void setTa_id(int ta_id) {
        this.ta_id = ta_id;
    }

    public int getUid() {
        return emp_id;
    }

    public void setUid(int uid) {
        this.emp_id = uid;
    }

    @Override
    public String toString() {
        return "TrainingRecord{" +
                "id=" + id +
                ", ta_id=" + ta_id +
                ", uid=" + emp_id +
                '}';
    }
}
