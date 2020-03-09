package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void contactCreationTest(){
        System.out.println("contactCreationTest started...");
        String expectedMessage = "Information entered into address book.\n" +
                "add next or return to home page.";
        int before = getCountContact();
        openAddNewPage();
        fillContactFields(new Contact( "firstName", "middleName", "lastname",
                "nickname", "title", "company", "address", "homePhone",
                "mobilePhone", "workPhone", "fax", "email", "email2",
                "email3", "homePage", "address2", "homePhone2", "notes"), before + 1);
        submitContact();
        //verification appearance of message
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("the message is displayed");
        returnToHomePage();
        int after = getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after,before+1);
        System.out.println("groupCreationTests finished");
    }

}
