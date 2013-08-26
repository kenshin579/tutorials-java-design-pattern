package com.xyz.mvc;

public class FullTimeStudent implements Student
{
    private String name;
    private String ssn;
    private String phone;
    private String email;

    public FullTimeStudent(){}

    public String getName(){
        return name;
    }
    public String getSSN(){
        return ssn;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public FullTimeStudent(String ssn){
        this.ssn = ssn;
    }
    public FullTimeStudent(String name,String ssn,String phone,String email){
        this.name = name;
        this.ssn = ssn;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSSN(String ssn){
        this.ssn = ssn;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getInsertSQL(){
        String query = "insert into fulltime values ( " + make(name) + "," + make(ssn) + "," + make(phone) + "," + make(email) + ")";
        return query;
    }
    public String getUpdateSQL(){
        String query =
                "update fulltime set name = " + make(name) + ", phone = " + make(phone) + " , email = " + make(email) + " where ssn = " + make(ssn);
        return query;
    }
    public String getDeleteSQL(){
        String query = "delete from fulltime where ssn = " + make(ssn);
        return query;
    }
    public String getSelectSQL(){
        String query = "select * from fulltime where ssn = " + make(ssn);
        return query;
    }
    public String getSelectAllSQL(){
        String query = "select * from fulltime";
        return query;
    }
    private String make(String s){
        return "'" + s + "'";
    }
}
