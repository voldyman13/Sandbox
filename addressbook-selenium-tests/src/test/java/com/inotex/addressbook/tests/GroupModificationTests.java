package com.inotex.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
    @Test
    public void groupModificationTest(){
        System.out.println("groupModificationTests started...");
        String expectedMessage ="Group record has been updated.\n" + "return to the group page";
        openGroupPage();
        int before = getCountGroup();
        System.out.println("Groups");
        printGroups(before);
        selectGroupByIndex(0);
        System.out.println("Choise Group #"+ 0);
        printGroupByIndex(0);
        clickOnEditButton();
        //Saving old value of fields
        String groupName = getGroupName();
        String groupHeader = getGroupHeader();
        String groupFooter = getGroupFooter();
        //Changing value
        String mod = "M"+ +System.currentTimeMillis()/1000+" ";
        editGroupName(mod+groupName);
        editGroupHeader(mod+groupHeader);
        editGroupFooter(mod+groupFooter);
        submitModification();
        //verification appearance of message
        String actualMessage = getMessageText();
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println(" the message is displayed");
        returnToGroupPage();
        //Checking for the Group Name Changing on the Group page
     //   printGroups(before);
        int last = before-1;
      //  printGroupByIndex(last);
        Assert.assertEquals(getGroupNameByIndex(last), mod + groupName);
        System.out.println("the changed group name on the group page is displayed correctly");
        selectGroupByIndex(last);
        clickOnEditButton();
        //Getting and checking changed values
        String newGroupName = getGroupName();
        String newGroupHeader = getGroupHeader();
        String newGroupFooter = getGroupFooter();
        Assert.assertEquals(newGroupName, mod+ groupName);
        Assert.assertEquals(newGroupHeader, mod+ groupHeader);
        Assert.assertEquals(newGroupFooter, mod+ groupFooter);
        returnToGroupPage();
        System.out.println("groupModificationTests finished...");
    }
}
