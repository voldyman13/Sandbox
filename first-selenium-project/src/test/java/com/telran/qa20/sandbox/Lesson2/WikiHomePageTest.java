package com.telran.qa20.sandbox.Lesson2;

import com.telran.qa20.sandbox.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WikiHomePageTest extends TestBase {

    @Test
    public void testOpeningEnglishWiki(){
// findAndClickTheEnglishLink
        click(By.className("lang1"));
        System.out.println(getUrl());
        Assert.assertEquals(getUrl(),"https://en.wikipedia.org/wiki/Main_Page");
    }

}
