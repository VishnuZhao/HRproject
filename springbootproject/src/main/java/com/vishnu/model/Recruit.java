package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public class Recruit implements Serializable {
    private int id;
    private int department_id;
    private int position_id;
    private String requirement;
    private String treatment;
    private String address;
    private String education;
    private String name;
    private int status;

    public Recruit() {
    }

    public Recruit(int department_id, int position_id, String requirement, String treatment, String address, String education,String name, int status) {
        this.department_id = department_id;
        this.position_id = position_id;
        this.requirement = requirement;
        this.treatment = treatment;
        this.address = address;
        this.education = education;
        this.name=name;
        this.status = status;
    }

    public Recruit(int id, int department_id, int position_id, String requirement, String treatment, String address, String education,String name, int status) {
        this.id = id;
        this.department_id = department_id;
        this.position_id = position_id;
        this.requirement = requirement;
        this.treatment = treatment;
        this.address = address;
        this.education = education;
        this.name=name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", department_id=" + department_id +
                ", position_id=" + position_id +
                ", requirement='" + requirement + '\'' +
                ", treatment='" + treatment + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
