package com.inotex.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    @Test
    public void groupDeletionTest() {
        String expectedMessage = "Group has been removed.\n"+"return to the group page";
        openGroupPage();
        int before = getCountGroup();
        selectGroup();
        clickOnDeleteGroupButton();
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        returnToGroupPage();
        int after = getCountGroup();
        System.out.println("Groups before: " + before+ " Gruops after: " + after);
        Assert.assertEquals(after, before-1);
    }

}
