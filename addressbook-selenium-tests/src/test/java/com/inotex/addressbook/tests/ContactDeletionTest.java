package com.inotex.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        if(!app.isContactPresent()){
            app.createContact();
        }
    }


    @Test
    public void contactDeletionTest(){
        System.out.println("contactDeletionTest started...");
        String expectedMessage = "Record successful deleted";
        int before = app.getCountContact();
        app.clickOnPencilImg(before-1);
        app.deleteContact();
        String actualMessage = app.getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("the message is displayed");
        int after = app.getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after, before-1);
        System.out.println("contactDeletionTest finished...");
   }

}
