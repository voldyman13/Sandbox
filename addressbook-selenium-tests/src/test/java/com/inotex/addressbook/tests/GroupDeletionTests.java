package com.inotex.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    @Test
    public void groupDeletionTest() {
        System.out.println("groupDeletionTests started...");
        String expectedMessage = "Group has been removed.\n"+"return to the group page";
        openGroupPage();
        int before = getCountGroup();
        selectGroupByIndex(0);
        clickOnDeleteGroupButton();
        //verification appearance of message
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println(" the message is displayed");
        returnToGroupPage();
        int after = getCountGroup();
        System.out.println("groups before: " + before+ " - gruops after: " + after);
        Assert.assertEquals(after, before-1);
        System.out.println("groupDeletionTests finished");
    }

}
