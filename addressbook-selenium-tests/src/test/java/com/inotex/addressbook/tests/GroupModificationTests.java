package com.inotex.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
    @Test
    public void groupModificationTest(){
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
        returnToGroupPage();
        //Checking for the Group Name Changing on the Group page
        System.out.println("Groups now:");
        printGroups(before);
        int last = before-1;
        System.out.println("Choise Group#"+last);
        printGroupByIndex(last);
        System.out.println("Verificate: " + getGroupNameByIndex(last)+" & "+mod+groupName);
        Assert.assertEquals(getGroupNameByIndex(last), mod + groupName);
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
    }
    public void printGroups(int lenght){
        for(int i=0; i<lenght; i++){
            System.out.println(i+": "+ getGroupNameByIndex(i));
        }
    }
    public void printGroupByIndex(int index){
        System.out.println("choise "+index+": "+ getGroupNameByIndex(index));

    }
}
