package com.inotex.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
    @Test
    public void groupModificationTest(){
        System.out.println("groupModificationTests started...");
        String expectedMessage ="Group record has been updated.\n" + "return to the group page";
        app.openGroupPage();
        app.selectGroupByIndex(0);
        app.clickOnEditButton();
        //Saving old value of fields
        String groupName = app.getGroupName();
        String groupHeader = app.getGroupHeader();
        String groupFooter = app.getGroupFooter();
        //Changing value
        String mod = ""+ System.currentTimeMillis()/1000+"";
        app.editGroupName(mod+groupName);
        app.editGroupHeader(mod+groupHeader);
        app.editGroupFooter(mod+groupFooter);
        app.submitModification();
        //verification appearance of message
        String actualMessage = app.getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println(" the message is displayed");
        app.returnToGroupPage();
        //Checking for the Group Name Changing on the Group page
        Assert.assertEquals(app.getGroupNameMod(mod), mod + groupName);
        System.out.println("the changed group name on the group page is displayed correctly");
        app.selectGroupByMod(mod);
        app.clickOnEditButton();
        //Getting and checking changed values
        String newGroupName = app.getGroupName();
        String newGroupHeader = app.getGroupHeader();
        String newGroupFooter = app.getGroupFooter();
        Assert.assertEquals(newGroupName, mod+ groupName);
        Assert.assertEquals(newGroupHeader, mod+ groupHeader);
        Assert.assertEquals(newGroupFooter, mod+ groupFooter);
        app.returnToGroupPage();
        System.out.println("groupModificationTests finished...");
    }

}
