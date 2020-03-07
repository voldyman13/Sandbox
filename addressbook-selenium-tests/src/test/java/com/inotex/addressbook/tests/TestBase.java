package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //    driver.manage().window().maximize();
        driver.get("http://localhost/addressbook");
        login("admin", "secret");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
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
    public void selectGroupByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
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

//    public void selectGroup(int index) {
//        driver.findElements(By.cssSelector("form > span.group")).get(index).click();
//       click(By.xpath("//span[1]//input[1]"));
//    }

    public void returnToGroupPage() {
        click(By.cssSelector("a[href='group.php']"));
    }
    public void openGroupPage()  {
        click(By.cssSelector("li a[href='group.php']"));
    }

    public int getCountGroup() {
        return elementCounter(By.className("group"));
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
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

    public void returnToHomePage() {
        click(By.cssSelector("[href='./']"));
    }

    public String getGroupNameByIndex(int index) {
        return driver.findElements(By.cssSelector("form > span.group")).get(index).getText();
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

    public void clickOnEditButton() {
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

    public void initGroupCreation() {
        click(By.name("new"));
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
