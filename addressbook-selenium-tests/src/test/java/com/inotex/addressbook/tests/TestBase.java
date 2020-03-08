package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    public static int getRandomNumber(int first, int last) {
        Random rd = new Random();
        int number = first-1;
        while (number <= first-1) {
            number = rd.nextInt(last-first-1);
        }
        System.out.println("Random number: "+number);
        return number;
    }

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
    public int getCountContacts() {
        return elementCounter(By.name("selected[]"));
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

    public String getGroupNameMod(String mod) {
        return  driver.findElement(By.xpath("//span[contains(text(),'"+mod+"')]")).getText();
    }

    public void selectGroupByMod(String mod) {
        driver.findElement(By.xpath("//span[contains(text(),'"+mod+"')]/input")).click();
    }

    public int getCountContact() {
        return elementCounter(By.name("selected[]"));
    }

    public void submitContact() {
        click(By.cssSelector("[name='submit']:nth-child(1)"));
    }

    public void choiceGroup() {
        Select group = new Select(driver.findElement(By.name("new_group")));
        group.selectByIndex(1);
    }

    public void attachPhoto() {
        attach((By.name("photo")), new File("src/test/resources/Photo.jpg"));
    }

    public void attach(By locator, File file) {
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void fillBdayAndAnniversary() {
        Select day = new Select(driver.findElement(By.name("bday")));
        int bday=getRandomNumber(1,28);
        day.selectByIndex(bday);
        Select month = new Select(driver.findElement(By.name("bmonth")));
        int bmonth = getRandomNumber(1,12);
        month.selectByIndex(bmonth);
        int byear = 2020-getRandomNumber(1, 100);
        type(By.name("byear"), ""+byear);
        System.out.println("Birsday: "+bday+" - "+bmonth+" - "+byear);
        Select aday = new Select(driver.findElement(By.name("aday")));
        aday.selectByIndex(bday);
        Select amonth = new Select(driver.findElement(By.name("amonth")));
        amonth.selectByIndex(bmonth);
        int ayear = byear+((2020-byear)/10+1)*10;
        type(By.name("ayear"), ""+ayear);
        System.out.println("Anniversary: "+bday+" - "+bmonth+" - "+ayear);
    }

    public void openAddNewPage() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void fillContactFields(int before, String firstName, String middleName, String lastName,
                                  String nickName, String title, String company, String address,
                                  String homePhone, String mobilePhone, String workPhone,
                                  String fax, String email, String email2, String email3,
                                  String homePage, String address2, String homePhone2,
                                  String notes) {
        String num = "#"+ before+"_";
        type(By.name("firstname"), num+firstName);
        type(By.name("middlename"), num+middleName);
        type(By.name("lastname"), num+lastName);
        type(By.name("nickname"), num+nickName);
        attachPhoto();
        type(By.name("title"), num+title);
        type(By.name("company"), num+company);
        type(By.name("address"), num+address);
        type(By.name("home"), num+homePhone);
        type(By.name("mobile"), num+mobilePhone);
        type(By.name("work"), num+workPhone);
        type(By.name("fax"), num+fax);
        type(By.name("email"), num+email);
        type(By.name("email2"), num+email2);
        type(By.name("email3"), num+email3);
        type(By.name("homepage"), num+homePage);
        fillBdayAndAnniversary();
        choiceGroup();
        type(By.name("address2"), num+address2);
        type(By.name("phone2"), num+homePhone2);
        type(By.name("notes"), num+notes);
    }
}
