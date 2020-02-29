package com.inotex.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook");
        login("admin", "secret");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("input[type=submit]"));
    }

    public int elementCounter(By locator) {
        return driver.findElements(locator).size();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }



    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void openSite(String url) {
        driver.navigate().to(url);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void selectGroup() {
        click(By.xpath("//span[1]//input[1]"));
    }

    public void returnToGroupPage() {
        click(By.cssSelector("i a[href='group.php']"));
    }
    public void openGroupPage() {
        click(By.cssSelector("[href='group.php']"));
    }

    public int getCountGroup() {
        return elementCounter(By.className("group"));
    }

    public void fillGroupForm(String groupName, String groupHeader, String groupFooter) {
        type(By.name("group_name"), groupName);
        type(By.name("group_header"), groupHeader);
        type(By.name("group_footer"), groupFooter);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public String getMessage() {
        return getText(By.className("msgbox"));
    }

    public void clickOnDeleteGroupButton() {
        click(By.name("delete"));
    }

    public void goHome() {
        click(By.cssSelector("[href='./']"));
    }

    public String getFirstGroupName() {
        return getText(By.xpath("//span[1][@class='group']"));
    }

    public String getMessageText() {
       return getText(By.className("msgbox"));
    }

    public void submitModification() {
        click(By.name("update"));
    }

    public String getGroupFooter() {
        return getText(By.name("group_footer"));
}

    public String getGroupHeader() {
       return getText(By.name("group_header"));
    }

    public String getGroupName() {
        return driver.findElement(By.name("group_name")).getAttribute("value");

    }

    public void ClickOnEditButton() {
        click(By.name("edit"));
    }

    public void editGroupFooter(String newGroupFooter) {
        type(By.name("group_footer"), newGroupFooter);
    }

    public void editGroupHeader(String newGroupHeader) {
        type(By.name("group_header"), newGroupHeader);
    }

    public void editGroupName(String newGroupName) {
        type(By.name("group_name"), newGroupName);
    }
}
