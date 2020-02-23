package com.telran.qa20.sandbox.Lesson1;

import com.telran.qa20.sandbox.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OpenChromeWikipedia extends TestBase {

    @Test
    public void openChromeWikipedia(){
        openSite("https://wikipedia.org/");
        click(By.id("js-link-box-en"));
        type(By.name("search"),"Banana");
        click(By.name("go"));
    }
}
