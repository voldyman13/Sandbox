package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void groupCreationTest(){
        System.out.println("groupCreationTests started...");
        String expectedrMessage =
         "A new group has been entered into the address book.\n"+"return to the group page";
        openGroupPage();
        int before = getCountGroup();
        initGroupCreation();
        fillGroupForm(new Group().
                setGroupName("group name").
                setGroupHeader("header").
                setGroupFooter("footer"));
        submitGroupCreation();
        //verification appearance of message
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedrMessage);
        System.out.println(" the message is displayed");
        returnToGroupPage();
        int after = getCountGroup();
        Assert.assertEquals(after, before+1);
        System.out.println("groups before: " + before + " - groups after: " + after);
        System.out.println("groupCreationTests finished");

    }
}
