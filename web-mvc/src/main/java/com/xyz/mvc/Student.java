package com.xyz.mvc;

public interface Student
{
    public String getName();
    public String getSSN();
    public String getPhone();
    public String getEmail();

    public void setName(String name);
    public void setSSN(String ssn);
    public void setPhone(String phone);
    public void setEmail(String email);

    public String getInsertSQL();
    public String getUpdateSQL();
    public String getDeleteSQL();

    // 특정인을 검색할 때 필요한 쿼리를 반환하는 메소드
    public String getSelectSQL();

    // 테이블 전체의 컬럼을 반환할 수 있는 쿼리를 반환하는 메소드
    public String getSelectAllSQL();

}
