package com.inotex.addressbook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void groupCreationTest(){
        String expectedrMessage = "A new group has been entered into the address book.\n" +
                "return to the group page";
        openGroupPage();
        int before = getCountGroup();
        initGroupCreation();
        fillGroupForm("This is group name", "This is header", "This is comment");
        submitGroupCreation();
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedrMessage);
        returnToGroupPage();
        int after = getCountGroup();
        Assert.assertEquals(after, before+1);
        System.out.println("Groups before: " + before + " Groups after: " + after);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }


}
