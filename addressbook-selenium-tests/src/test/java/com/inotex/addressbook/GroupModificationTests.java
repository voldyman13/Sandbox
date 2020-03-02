package com.inotex.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
    @Test
    public void groupModificationTest(){
        String expectedMessage ="Group record has been updated.\n" +
                "return to the group page";
        openGroupPage();
        selectGroup(); // XPath ("//span[1]//input[1]")
        ClickOnEditButton();
        //Saving old value of fields
        String groupName = getGroupName();
        String groupHeader = getGroupHeader();
        String groupFooter = getGroupFooter();
        //Changing value
        editGroupName("New "+ groupName);
        editGroupHeader("Modified " + groupHeader);
        editGroupFooter("Changed "+ groupFooter);
        submitModification();
        //verification appearance of message
        String actualMessage = getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage);
        returnToGroupPage();
        //Checking for the Group Name Changing on the Group page
        String firstGroupName = getFirstGroupName();
        Assert.assertEquals(firstGroupName, "New " + groupName);
        selectGroup(); // XPath ("//span[1]//input[1]")
        ClickOnEditButton();
        //Getting and validation changed value
        String newGroupName = getGroupName();
        String newGroupHeader = getGroupHeader();
        String newGroupFooter = getGroupFooter();
        Assert.assertEquals(newGroupName, "New " + groupName);
        Assert.assertEquals(newGroupHeader, "Modified " + groupHeader);
        Assert.assertEquals(newGroupFooter, "Modified " + groupFooter);
        returnToGroupPage();

    }

}
