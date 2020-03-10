package com.inotex.addressbook.model;

import org.openqa.selenium.By;

public class Contact {
    private  String firstName;
    private  String middleName;
    private  String lastName;
    private  String nickName;
    private  String title;
    private  String company;
    private  String address;
    private  String homePhone;
    private  String mobilePhone;
    private  String workPhone;
    private  String fax;
    private  String email;
    private  String email2;
    private  String email3;
    private  String homePage;
    private String bday;
    private String bmonth;
    private String byear;
    private String aday;
    private String amonth;
    private String ayear;
    private  String address2;
    private  String homePhone2;
    private  String notes;


    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public void setBmonth(String bmonth) {
        this.bmonth = bmonth;
    }

    public String getByear() {
        return byear;
    }

    public void setByear(String byear) {
        this.byear = byear;
    }

    public String getAday() {
        return aday;
    }

    public void setAday(String aday) {
        this.aday = aday;
    }

    public String getAmonth() {
        return amonth;
    }

    public void setAmonth(String amonth) {
        this.amonth = amonth;
    }

    public String getAyear() {
        return ayear;
    }

    public void setAyear(String ayear) {
        this.ayear = ayear;
    }


//    public Contact(String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String fax, String email, String email2, String email3, String homePage, String address2, String homePhone2, String notes) {
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.nickName = nickName;
//        this.title = title;
//        this.company = company;
//        this.address = address;
//        this.homePhone = homePhone;
//        this.mobilePhone = mobilePhone;
//        this.workPhone = workPhone;
//        this.fax = fax;
//        this.email = email;
//        this.email2 = email2;
//        this.email3 = email3;
//        this.homePage = homePage;
//        this.address2 = address2;
//        this.homePhone2 = homePhone2;
//        this.notes = notes;
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setHomePhone2(String homePhone2) {
        this.homePhone2 = homePhone2;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomePage() {
        return homePage;
    }

    public String getAddress2() {
        return address2;
    }

    public String getHomePhone2() {
        return homePhone2;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Contact:\n" +
        "firstName: "+firstName+"\n"+
        "middleName: "+middleName+"\n"+
        "lastName: "+ lastName+"\n"+
        "nickName: " + nickName+"\n"+
        "title: " + title+"\n"+
        "company: " + company+"\n"+
        "address: " + address+"\n"+
        "homePhone: " + homePhone+"\n"+
        "mobilePhone: " + mobilePhone+"\n"+
        "workPhone: " + workPhone+"\n"+
        "fax: " + fax+"\n"+
        "email: " + email+"\n"+
        "email2: " + email2+"\n"+
        "email3: " + email3+"\n"+
        "homePage: " + homePage +"\n"+
        "bday: " + bday +"\n"+
        "bmonth: " + bmonth +"\n"+
        "byear: " + byear +"\n"+
        "aday: " + aday +"\n"+
        "amonth: " + amonth +"\n"+
        "ayear: " + ayear +"\n"+
        "address2: " + address2 +"\n" +
        "homePhone2: " + homePhone2 +"\n" +
        "notes: " + notes +"\n";
    }

}
