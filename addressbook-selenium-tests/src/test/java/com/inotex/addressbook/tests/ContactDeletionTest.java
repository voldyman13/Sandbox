package com.inotex.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{
    @Test
    public void contactDeletionTest(){
        System.out.println("contactDeletionTest started...");
        String expectedMessage = "Record successful deleted";
        int before = getCountContact();
        if(before<1) {
            System.out.println("No contacts to delete\n"+
                    "contactDeletionTest finished...");
            return;
        }
//        selectContactByIndex(before-1);
        clickOnPencilImg(before-1);
        deleteContact();
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("the message is displayed");
        int after = getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after, before-1);
        System.out.println("contactDeletionTest finished...");
   }

}
