package com.telran.qa20.sandbox;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NewTest extends TestBase{
    @Test
    public void newTest(){
        driver.get("http://localhost/addressbook");
        login("admin", "secret");
        click(By.cssSelector("a[href='edit.php?id=29']"));
        System.out.println("getAtribut: "+driver.findElement(By.name("firstname")).getAttribute("value"));
        System.out.println("getAtribut: "+driver.findElement(By.name("firstname")).getCssValue("value"));

    }


    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("input[type=submit]"));
    }
}
