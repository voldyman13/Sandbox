package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{
    @Test
    public void contactModificationTest(){

        System.out.println("contactModificationTest started...");
        String expectedMessage = "Address book updated\n" +
                "return to home page";
        int before = getCountContact();
        clickOnPencilImg(before-1);
        Contact con1 = readContactData();
        System.out.println(con1);
        modifyContactData(con1, "***");
        confirmContactModification(); //input[name="update"]:nth-child(1)
        //verification appearance of message
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("the message is displayed");
        int after = getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after, before);
        clickOnPencilImg(before-1);
        Contact con2 = readContactData();
        System.out.println(con2);
        Assert.assertNotEquals(con2, con1);
        System.out.println("contactModificationTest finished");
    }

    private void confirmContactModification() {
        click(By.cssSelector("input[name='update']:nth-child(1)"));
    }

    public void modifyContactData(Contact contact, String modifier) {
        type(By.name("firstname"), contact.getFirstName()+modifier);
        type(By.name("middlename"), contact.getMiddleName()+modifier);
        type(By.name("lastname"), contact.getLastName()+modifier);
        type(By.name("nickname"), contact.getNickName()+modifier);
        attachPhoto();
        type(By.name("title"), contact.getTitle()+modifier);
        type(By.name("company"), contact.getCompany()+modifier);
        type(By.name("address"), contact.getAddress()+modifier);
        type(By.name("home"), contact.getHomePhone()+modifier);
        type(By.name("mobile"), contact.getMobilePhone()+modifier);
        type(By.name("work"), contact.getWorkPhone()+modifier);
        type(By.name("fax"), contact.getFax()+modifier);
        type(By.name("email"), contact.getEmail()+modifier);
        type(By.name("email2"), contact.getEmail2()+modifier);
        type(By.name("email3"), contact.getEmail3()+modifier);
        type(By.name("homepage"), contact.getHomePage()+modifier);
        fillBdayAndAnniversary();
        type(By.name("address2"), contact.getAddress2()+modifier);
        type(By.name("phone2"), contact.getHomePhone2()+modifier);
        type(By.name("notes"), contact.getNotes()+modifier);
    }

    public Contact readContactData() {
        Contact con = new Contact();
        con.setFirstName(getValue(By.name("firstname")));
        con.setMiddleName(getValue(By.name("middlename")));
        con.setLastName(getValue(By.name("lastname")));
        con.setNickName(getValue(By.name("nickname")));
        con.setTitle(getValue(By.name("title")));
        con.setCompany(getValue(By.name("company")));
        con.setAddress(getText(By.name("address")));
        con.setHomePhone(getValue(By.name("home")));
        con.setMobilePhone(getValue(By.name("mobile")));
        con.setWorkPhone(getValue(By.name("work")));
        con.setFax(getValue(By.name("fax")));
        con.setEmail(getValue(By.name("email")));
        con.setEmail2(getValue(By.name("email2")));
        con.setEmail3(getValue(By.name("email3")));
        con.setHomePage(getValue(By.name("homepage")));
        con.setBday(getText(By.cssSelector("select[name='bday'] option[selected='selected']")));
        con.setBmonth(getText(By.cssSelector("select[name='bmonth'] option[selected='selected']")));
        con.setByear(getValue(By.name("byear")));
        con.setAday(getValue(By.cssSelector("select[name='aday'] option[selected='selected']")));
        con.setAmonth(getText(By.cssSelector("select[name='amonth'] option[selected='selected']")));
        con.setAyear(getValue(By.name("ayear")));
        con.setAddress2(getText(By.name("address2")));
        con.setHomePhone2(getValue(By.name("phone2")));
        con.setNotes(getValue(By.name("notes")));
        return con;
    }

    public String getValue(By locator){
        return driver.findElement(locator).getAttribute("value");
    }

    public void selectFirstContactForEdit() {
        click(By.xpath("//tr[2]//td[8]//a[1]//img[1]"));
    }

}
