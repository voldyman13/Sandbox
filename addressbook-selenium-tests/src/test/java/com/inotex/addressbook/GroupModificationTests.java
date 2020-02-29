package com.inotex.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
    @Test
    public void editGroupTest(){
        String expectedMessage ="Group record has been updated.\n" +
                "return to the group page";
        openGroupPage();
        selectGroup(); // XPath ("//span[1]//input[1]")
        ClickOnEditButton();
        String groupName = getGroupName();
        String groupHeader = getGroupHeader();
        String groupFooter = getGroupFooter();
        editGroupName("New "+ groupName);
        editGroupHeader("Modified " + groupHeader);
        editGroupFooter("Modified "+ groupFooter);
        submitModification();
        String actualMessage = getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage);
        returnToGroupPage();
        String firstGroupName = getFirstGroupName();
        Assert.assertEquals(firstGroupName, "New " + groupName);
        selectGroup(); // XPath ("//span[1]//input[1]")
        ClickOnEditButton(); // name="edit"
        String newGroupName = getGroupName();
        String newGroupHeader = getGroupHeader();
        String newGroupFooter = getGroupFooter();
        Assert.assertEquals(newGroupName, "New " + groupName);
        Assert.assertEquals(newGroupHeader, "Modified " + groupHeader);
        Assert.assertEquals(newGroupFooter, "Modified " + groupFooter);
    }

}
