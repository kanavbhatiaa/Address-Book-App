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
public class Contact {

    private String firstName, lastName, homePhone, workPhone, email, notes;
    private Address homeAddress;
    private MyDate birthday;

    public Contact(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, String notes, MyDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAddress = homeAddress;
        this.email = email;
        this.notes = notes;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomeAddress() {
        return homeAddress.toString();
    }

    public String getAddress() {
        return homeAddress.toString();
    }

    public String getCity() {
        return homeAddress.city;
    }

    public void setHomeAddress(String streetInfo1, String streetInfo2, String province, String city, String postalCode, String country) {
        homeAddress.streetInfo1 = streetInfo1;
        homeAddress.streetInfo2 = streetInfo2;
        homeAddress.province = province;
        homeAddress.city = city;
        homeAddress.postalCode = postalCode;
        homeAddress.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBirthday() {
        int mo = getBirthMonth();
        return birthday.getDay() + "/" + birthday.getMonthShortForm(mo) + "/" + birthday.getYear();
    }

    public int getBirthDay() {
        return birthday.getDay();
    }

    public void setBirthday(int birthday) {
        this.birthday.setDay(birthday);
    }

    public void setBirthMonth(int birthMonth) {
        birthday.setMonth(birthMonth);
    }

    public int getBirthMonth() {
        return birthday.getMonth();
    }

    public String getBirthMonthShortForm(int mo) {
        return birthday.getMonthShortForm(mo);
    }

    public String getBirthMonthLongForm() {
        return birthday.getMonthLongForm();
    }

    public int getBirthYear() {
        return birthday.getYear();
    }

    public void setBirthYear(int birthYear) {
        birthday.setYear(birthYear);
    }

    @Override
    public String toString() {
        return "Contact{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", homePhone='" + homePhone + '\''
                + ", workPhone='" + workPhone + '\''
                + ", homeAddress='" + homeAddress + '\''
                + ", email='" + email + '\''
                + ", notes='" + notes + '\''
                + ", birthday=" + birthday
                + '}';
    }
}
