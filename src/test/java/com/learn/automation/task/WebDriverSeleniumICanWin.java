package com.learn.automation.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumICanWin {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test (description = "I can win task")
    public void newPasteWithCodeAndExparationAndNameTest() {

        driver.manage().window().maximize();
        driver.get("https://pastebin.com");

        WebElement textInput = driver.findElement(By.id("postform-text"));
        textInput.sendKeys("Hello from WebDriver");

        WebElement pasteExpirationList = driver.findElement(By.id("select2-postform-expiration-container"));
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.id("select2-postform-expiration-container")));
        pasteExpirationList.click();

        WebElement optionFromPasteExpirationList = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        optionFromPasteExpirationList.click();

        WebElement pasteNameInput = driver.findElement(By.id("postform-name"));
        pasteNameInput.sendKeys("helloweb");

        WebElement createBtn = driver.findElement(By.xpath("//*[@class='btn -big']"));
        createBtn.click();
    }

//    @AfterMethod (alwaysRun = true)
//    public void browserTearDown(){
//        driver.quit();
//                driver = null;
//    }
}