package freelec.noprototype;

import java.io.Serializable;

public class Address implements Serializable {

    private String ssn;
    private String name;
    private String tel;
    private String address;
    private int gender;

    public Address(String ssn, String name, String tel, String address, int gender) {
        this.ssn = ssn;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.gender = gender;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

}

