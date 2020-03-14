package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(!app.isContactPresent()){
            app.createContact();
        }
    }

    @Test
    public void contactModificationTest(){
        System.out.println("contactModificationTest started...");
        String expectedMessage = "Address book updated\n" +
                "return to home page";
        int before = app.getCountContact();
        app.clickOnPencilImg(before-1);
        Contact con1 = app.getContactData();
        String file1 = app.getFileIdentificator(before-1);
        app.modifyContactData(con1, "***");
        app.confirmContactModification();
        //verification appearance of message
        String actualMessage = app.getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("the message is displayed");
        int after = app.getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after, before);
        app.clickOnPencilImg(before-1);
        Contact con2 = app.getContactData();
        String file2 = app.getFileIdentificator(before-1);
        System.out.println(con2);
        Assert.assertNotEquals(con2, con1);
        Assert.assertEquals(file2, file1);
        System.out.println("contactModificationTest finished");

    }

}
