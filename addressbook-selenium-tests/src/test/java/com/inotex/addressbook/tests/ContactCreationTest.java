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
        Contact contact =new Contact();
        contact.setFirstName("firstName");
        contact.setMiddleName("middleName");
        contact.setLastName("lastname");
        contact.setNickName("nickname");
        contact.setTitle("title");
        contact.setCompany("company");
        contact.setAddress("address");
        contact.setHomePhone("homePhone");
        contact.setMobilePhone("mobilePhone");
        contact.setWorkPhone("workPhone");
        contact.setFax("fax");
        contact.setEmail("email");
        contact.setEmail2("email2");
        contact.setEmail3("email3");
        contact.setHomePage("homePage");
        contact.setNotes("notes");
        contact.setAddress2("address2");
        contact.setHomePhone2("homePhone2");
        fillContactData(contact  , before + 1);
        submitContact();
        //verification appearance of message
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("the message is displayed");
        returnToHomePage();
        System.out.println(contact);
        int after = getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after,before+1);
        System.out.println("ContactCreationTests finished");
    }

}
