package com.inotex.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;

public class ContactCreationTest extends TestBase{

    @Test
    public void contactCreationTest(){
        System.out.println("contactCreationTest started...");
        String expectedrMessage = "Information entered into address book.\n" +
                "add next or return to home page.";
        int before = getCountContact();
        openAddNewPage();
        fillContactFields("firstName", "middleName", "lastname",
                "nickname", "title", "company", "address",
                "homePhone", "mobilePhone", "workPhone",
                "fax", "email", "email2", "email3", "homePage",
                "address2", "homePhone2", "notes");
        fillBdayAndAday();
        addContactPhoto();
        choiceGroup();
        submitContact();
        //verification appearance of message
        String actualMessage = getMessage();
        Assert.assertEquals(actualMessage, expectedrMessage);
        System.out.println(" the message is displayed");
        returnToHomePage();
        int after = getCountContact();
        System.out.println("contacts before: " + before + " - contacts after: " + after);
        Assert.assertEquals(after,before+1);
        System.out.println("groupCreationTests finished");
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

    public void addContactPhoto() {
        attach((By.name("photo")), new File("src/test/resources/Photo.jpg"));

    }
    public void attach(By locator, File file) {
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void fillAnniversary() {
        String bday = driver.findElement(By.name("bday")).getText();
        System.out.println("bday: "+bday);

        Select day = new Select(driver.findElement(By.name("aday")));
        day.selectByValue(bday);

        String bmonth = driver.findElement(By.name("bmonth")).getText();
        System.out.println("bmonth: "+bmonth);

        Select month = new Select(driver.findElement(By.name("amonth")));
        day.selectByValue(bmonth);

        int byear = Integer.parseInt(driver.findElement(By.name("byear")).getText().trim());
        int ayear = byear+((2020-byear)/10+1)*10;
        System.out.println("byear: "+byear+", ayear: "+ayear);
        type(By.name("ayear"), ""+ayear);
    }

    public void fillBdayAndAday() {
        Select day = new Select(driver.findElement(By.name("bday")));
        int bday=getRandomNumber(1,28);
        day.selectByIndex(bday);
        Select month = new Select(driver.findElement(By.name("bmonth")));
        int bmonth = getRandomNumber(1,12);
        month.selectByIndex(bmonth);
        int byear = 2020-getRandomNumber(1, 100);
        type(By.name("byear"), ""+byear);
        Select aday = new Select(driver.findElement(By.name("aday")));
        aday.selectByIndex(bday);
        Select amonth = new Select(driver.findElement(By.name("amonth")));
        amonth.selectByIndex(bmonth);
        int ayear = byear+((2020-byear)/10+1)*10;
        type(By.name("ayear"), ""+ayear);
    }

    public void openAddNewPage() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void fillContactFields(String firstName, String middleName, String lastName,
                                  String nickName, String title, String company, String address,
                                  String homePhone, String mobilePhone, String workPhone,
                                  String fax, String email, String email2, String email3,
                                  String homePage, String address2, String homePhone2,
                                  String notes) {
        String mod = System.currentTimeMillis()/1000+"";

        type(By.name("firstname"), mod+firstName);
        type(By.name("middlename"), mod+middleName);
        type(By.name("lastname"), mod+lastName);
        type(By.name("nickname"), mod+nickName);
        type(By.name("title"), mod+title);
        type(By.name("company"), mod+company);
        type(By.name("address"), mod+address);
        type(By.name("home"), mod+homePhone);
        type(By.name("mobile"), mod+mobilePhone);
        type(By.name("work"), mod+workPhone);
        type(By.name("fax"), mod+fax);
        type(By.name("email"), mod+email);
        type(By.name("email2"), mod+email2);
        type(By.name("email3"), mod+email3);
        type(By.name("homepage"), mod+homePage);
        type(By.name("address2"), mod+address2);
        type(By.name("phone2"), mod+homePhone2);
        type(By.name("notes"), mod+notes);
    }
    public static int getRandomNumber(int first, int last) {
        Random rd = new Random();
        int number = first-1;
        while (number <= first-1) {
            number = rd.nextInt(last-first-1);
        }
        return number;
    }

}
