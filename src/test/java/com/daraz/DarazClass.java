package com.daraz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DarazClass {


    @Test
    public void runner() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.daraz.com.bd");

        String mail = "xirah61137@boersy.com";
        String password = "Haris123";
        register( driver,  mail,  password);
        logOut(driver);
        logIn( driver,  mail,  password);



    }


    public void selecGender(WebDriver driver){
        driver.findElement(By.xpath("//span[@id='gender']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='next-menu-content']/li"));
        String gender = "male";

        for(int i = 0; i<elements.size(); i++){
            String temp = elements.get(i).getText();
            if(gender.contains(temp)){
                elements.get(i).click();
                break;
            }
        }
    }
    public void selecYear(WebDriver driver){
        driver.findElement(By.xpath("//span[@id='year']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='next-menu-content']/li"));
        String year = "1994";

        for(int i = 0; i<elements.size(); i++){
            String temp = elements.get(i).getText();
            if(year.contains(temp)){
                elements.get(i).click();
                break;
            }
        }
    }
    public void selectDay(WebDriver driver){
        driver.findElement(By.xpath("//span[@id='day']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='next-menu-content']/li"));
        String day = "24";

        for(int i = 0; i<elements.size(); i++){
            String temp = elements.get(i).getText();
            if(day.contains(temp)){
                elements.get(i).click();
                break;
            }
        }
    }
    public void selectMonth(WebDriver driver){
        driver.findElement(By.xpath("//span[@id='month']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='next-menu-content']/li"));
        String month = "December";

        for(int i = 0; i<elements.size(); i++){
            String temp = elements.get(i).getText();
            if(month.contains(temp)){
                elements.get(i).click();
                break;
            }
        }
    }
    public void register(WebDriver driver, String mail, String password) throws InterruptedException {

           driver.findElement(By.xpath("//div[@id='anonLogin']")).click();

//                                          Click Register Button
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

//                                          Click Sign up with Email Button
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'Sign up with Email')]")).click();


//                                          Fill Information
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class,'mod-login-col1')]/div[1]/input")).sendKeys(mail);

        WebElement drag = driver.findElement(By.xpath("//*[@id=\"nc_2_n1z\"]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(340, 0).release(drag).build().perform();
        driver.findElement(By.xpath("//div[contains(@class,'mod-login-col1')]/div[3]/input")).sendKeys(password);
        driver.findElement(By.xpath("//div[contains(@class,'mod-login-col2')]/div/input")).sendKeys("Haris Chandra Roy");



        Thread.sleep(60000);
        WebElement text = driver.findElement(By.xpath("//input[contains(@type,'number')]"));


        selectMonth(driver);
        selectDay(driver);
        selecYear(driver);
        selecGender(driver);

        driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();

    }
    public void logOut(WebDriver driver) throws InterruptedException {
        Thread.sleep(60000);
        driver.findElement(By.xpath("//*[@id=\"myAccountTrigger\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[1]/div/div[5]/div/div/ul/li[6]/a")).click();

    }
    public void logIn(WebDriver driver , String mail, String password){
        driver.findElement(By.xpath("//div[@id='anonLogin']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(mail);
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();


    }
    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching firefox browser nad Start testing Daraz.com");
    }


}
