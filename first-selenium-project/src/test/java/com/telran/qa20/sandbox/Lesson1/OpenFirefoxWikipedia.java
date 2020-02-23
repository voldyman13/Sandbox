package com.telran.qa20.sandbox.Lesson1;

import com.telran.qa20.sandbox.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenFirefoxWikipedia extends TestBase {

    @Test
    public void openFirefoxWikipedia(){
        openSite("https://wikipedia.org/");
        click(By.cssSelector(".sprite.svg-arrow-down-blue"));
        click(By.linkText("English"));
        type(By.name("search"),"Orange");
        click(By.name("go"));
    }
}
