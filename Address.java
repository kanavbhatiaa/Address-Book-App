/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookApp;

/**
 *
 * @author Birbal
 */
public class Address {

    private String streetinfo1;
    private String streetinfo2;
    String city;
    String postalCode;
    String province;
    String country;
    String streetInfo1;
    String streetInfo2;

    public Address() {
        streetinfo1 = "";
        streetinfo2 = "";
        city = "";
        postalCode = "";
        province = "";
        country = "";
    }

    public Address(String streetinfo1, String streetinfo2, String city, String postalCode, String province, String country) {
        this.streetinfo1 = streetinfo1;
        this.streetinfo2 = streetinfo2;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public void setStreetinfo1(String streetinfo1) {
        this.streetinfo1 = streetinfo1;
    }

    public String getStreetinfo1() {
        return streetinfo1;
    }

    public void setStreetinfo2(String streetinfo2) {
        this.streetinfo2 = streetinfo2;
    }

    public String getStreetinfo2() {
        return streetinfo2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        String result;
        result = streetinfo1 + " " + streetinfo2 + " " + city + " " + postalCode + " " + province + " " + country;
        return result;
    }
}
