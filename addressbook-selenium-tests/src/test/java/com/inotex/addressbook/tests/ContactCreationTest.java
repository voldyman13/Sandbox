package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        if(!app.isElementPresent(By.name("searchstring"))){
            app.returnToHomePage();
        }
    }

    @Test
    public void contactCreationTest(){
        System.out.println("contactCreationTest started...");
        String expectedMessage = "Information entered into address book.\n" +
                "add next or return to home page.";
        int before = app.getCountContact();
        app.openAddNewPage();
        app.fillContactData(new Contact().setFirstName("firstName").setMiddleName("middleName").setLastName("lastname")
                .setNickName("nickname").setTitle("title").setCompany("company").setAddress("address")
                .setHomePhone("homePhone").setMobilePhone("mobilePhone").setWorkPhone("workPhone")
                .setFax("fax").setEmail("email").setEmail2("email2").setEmail3("email3").setHomePage("homePage")
                .setNotes("notes").setAddress2("address2").setHomePhone2("homePhone2")  , before + 1);
        app.attachPhoto("src/test/resources/Photo.jpg");
        app.submitContact();
        //verification appearance of message
        String actualMessage = app.getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("the message is displayed");
        app.returnToHomePage();
        int after = app.getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after,before+1);
        System.out.println("ContactCreationTests finished");
    }
}
