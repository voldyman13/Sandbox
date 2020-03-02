package com.inotex.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void groupCreationTest(){
        String expectedrMessage =
         "A new group has been entered into the address book.\n"+"return to the group page";
        openGroupPage();
        int before = getCountGroup();
        initGroupCreation();
        fillGroupForm(new Group("group name", "header", "footer"));
        submitGroupCreation();
        //verification appearance of message
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedrMessage);
        returnToGroupPage();
        int after = getCountGroup();
        Assert.assertEquals(after, before+1);
        System.out.println("Groups before: " + before + " Groups after: " + after);
    }


}
