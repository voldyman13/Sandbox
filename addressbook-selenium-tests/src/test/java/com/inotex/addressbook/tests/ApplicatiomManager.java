package com.inotex.addressbook.tests;

import com.inotex.addressbook.model.Contact;
import com.inotex.addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ApplicatiomManager {
    WebDriver driver;

    public static int getRandomNumber(int first, int last) {
        Random rd = new Random();
        int number = first-1;
        while (number <= first-1) {
            number = rd.nextInt(last-first-1);
        }
        return number;
    }

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //    driver.manage().window().maximize();
        openSite("http://localhost/addressbook");
        login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        if(elementCounter(locator)>0) return true;
        return false;
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
        return getValue(By.name("group_name"), "value");
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

    public void selectGroup() {
        Select group = new Select(driver.findElement(By.name("new_group")));
        group.selectByIndex(1);
    }

    public void attachPhoto(String fileName) {
        attach((By.name("photo")), new File(fileName));
    }

    public void attach(By locator, File file) {
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void fillBdayAndAnniversary() {
        Select day = new Select(driver.findElement(By.name("bday")));
        int bday = getRandomNumber(1,28);
        day.selectByIndex(bday+1);
        Select month = new Select(driver.findElement(By.name("bmonth")));
        int bmonth = getRandomNumber(1,12);
        month.selectByIndex(bmonth);
        int byear = 2020-getRandomNumber(1, 100);
        type(By.name("byear"), byear+"");
        System.out.println("Birsday: "+bday+" - "+bmonth+" - "+byear);
        Select aday = new Select(driver.findElement(By.name("aday")));
        aday.selectByIndex(bday+1);
        Select amonth = new Select(driver.findElement(By.name("amonth")));
        amonth.selectByIndex(bmonth);
        int ayear = byear+((2020-byear)/10+1)*10;
        type(By.name("ayear"), ""+ayear);
        System.out.println("Anniversary: "+bday+" - "+bmonth+" - "+ayear);
    }

    public void openAddNewPage() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void fillContactData(Contact contact, int before) {
        String num = "#"+ before +"_";
        type(By.name("firstname"), num+ contact.getFirstName());
        type(By.name("middlename"), num+ contact.getMiddleName());
        type(By.name("lastname"), num+ contact.getLastName());
        type(By.name("nickname"), num+ contact.getNickName());
        type(By.name("title"), num+ contact.getTitle());
        type(By.name("company"), num+ contact.getCompany());
        type(By.name("address"), num+ contact.getAddress());
        type(By.name("home"), num+ contact.getHomePhone());
        type(By.name("mobile"), num+ contact.getMobilePhone());
        type(By.name("work"), num+ contact.getWorkPhone());
        type(By.name("fax"), num+ contact.getFax());
        type(By.name("email"), num+ contact.getEmail());
        type(By.name("email2"), num+ contact.getEmail2());
        type(By.name("email3"), num+ contact.getEmail3());
        type(By.name("homepage"), num+ contact.getHomePage());
        fillBdayAndAnniversary();
        selectGroup();
        type(By.name("address2"), num+ contact.getAddress2());
        type(By.name("phone2"), num+ contact.getHomePhone2());
        type(By.name("notes"), num+ contact.getNotes());
    }

    public void deleteContact() {
      click(By.xpath("//form[2]//input[2]"));
    }

    public void clickOnPencilImg(int index) {
        driver.findElements(By.cssSelector("a img[title='Edit']")).get(index).click();
    }

    public void clicDetailsIcon(int index){
        driver.findElements(By.cssSelector("img[title='Details']")).get(index).click();
    }

    public void selectContactByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void createContact() {
        openAddNewPage();
        fillContactData(new Contact().setFirstName("firstName").setMiddleName("middleName").setLastName("lastname")
                .setNickName("nickname").setTitle("title").setCompany("company").setAddress("address")
                .setHomePhone("homePhone").setMobilePhone("mobilePhone").setWorkPhone("workPhone")
                .setFax("fax").setEmail("email").setEmail2("email2").setEmail3("email3").setHomePage("homePage")
                .setNotes("notes").setAddress2("address2").setHomePhone2("homePhone2")  , 1);
        attachPhoto("src/test/resources/Photo.jpg");
        submitContact();
        returnToHomePage();
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    protected void confirmContactModification() {
        click(By.cssSelector("input[name='update']:nth-child(1)"));
    }

    public void modifyContactData(Contact contact, String modifier) {
        type(By.name("firstname"), contact.getFirstName()+modifier);
        type(By.name("middlename"), contact.getMiddleName()+modifier);
        type(By.name("lastname"), contact.getLastName()+modifier);
        type(By.name("nickname"), contact.getNickName()+modifier);
        attachPhoto("src/test/resources/Photo.jpg");
        type(By.name("title"), contact.getTitle()+modifier);
        type(By.name("company"), contact.getCompany()+modifier);
        type(By.name("address"), contact.getAddress()+modifier);
        type(By.name("home"), contact.getHomePhone()+modifier);
        type(By.name("mobile"), contact.getMobilePhone()+modifier);
        type(By.name("work"), contact.getWorkPhone()+modifier);
        type(By.name("fax"), contact.getFax()+modifier);
        type(By.name("email"), contact.getEmail()+modifier);
        type(By.name("email2"), contact.getEmail2()+modifier);
        type(By.name("email3"), contact.getEmail3()+modifier);
        type(By.name("homepage"), contact.getHomePage()+modifier);
        fillBdayAndAnniversary();
        type(By.name("address2"), contact.getAddress2()+modifier);
        type(By.name("phone2"), contact.getHomePhone2()+modifier);
        type(By.name("notes"), contact.getNotes()+modifier);
    }

    public Contact getContactData() {
       Contact cont = new Contact()
               .setFirstName(getValue(By.name("firstname"), "value")).setMiddleName(getValue(By.name("middlename"), "value"))
               .setLastName(getValue(By.name("lastname"), "value")).setNickName(getValue(By.name("nickname"), "value"))
               .setTitle(getValue(By.name("title"), "value")) .setCompany(getValue(By.name("company"), "value"))
               .setAddress(getText(By.name("address"))) .setHomePhone(getValue(By.name("home"), "value"))
               .setMobilePhone(getValue(By.name("mobile"), "value")) .setWorkPhone(getValue(By.name("work"), "value"))
               .setFax(getValue(By.name("fax"), "value")) .setEmail(getValue(By.name("email"), "value"))
               .setEmail2(getValue(By.name("email2"), "value")) .setEmail3(getValue(By.name("email3"), "value"))
               .setHomePage(getValue(By.name("homepage"), "value"))
               .setBday(getText(By.cssSelector("select[name='bday'] option[selected='selected']")))
               .setBmonth(getText(By.cssSelector("select[name='bmonth'] option[selected='selected']")))
               .setByear(getValue(By.name("byear"), "value"))
               .setAday(getValue(By.cssSelector("select[name='aday'] option[selected='selected']"), "value"))
               .setAmonth(getText(By.cssSelector("select[name='amonth'] option[selected='selected']")))
               .setAyear(getValue(By.name("ayear"), "value")) .setAddress2(getText(By.name("address2")))
               .setHomePhone2(getValue(By.name("phone2"), "value")) .setNotes(getValue(By.name("notes"), "value"));
        return cont;
    }

    public void getFileData(){
        String value = getValue(By.xpath("/div[@id='content']//img"), "value");
        System.out.println("value: "+value);
    }

    public String getValue(By locator, String attribute){
        return driver.findElement(locator).getAttribute(attribute);
    }

    public String getFileIdentificator(int index) {
        returnToHomePage();
        clicDetailsIcon(index);
        String fileIdentificator = getValue(By.xpath("//div[@id='content']//img"), "src");
        System.out.println("Src: " +fileIdentificator);
        clickModifyButton();
        return fileIdentificator;
    }

    public void clickModifyButton() {
        click(By.name("modifiy"));
    }
}
