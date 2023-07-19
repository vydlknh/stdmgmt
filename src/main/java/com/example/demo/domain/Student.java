package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    private Integer code;
    private String name;
    private Timestamp dob;
    private String gender;
    private String address;
    private String parent;
    private String tel;
    private String note;

    public Student() {
    }

    public Student(Integer code, String name, Timestamp dob, String gender, String address, String parent, String tel, String note) {
        this.code = code;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.parent = parent;
        this.tel = tel;
        this.note = note;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
