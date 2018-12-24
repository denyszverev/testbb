package com.ak_tech.bb.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class HelperBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    public HelperBase(WebDriver driver, WebDriverWait wait, Properties properties) {
        this.driver = driver;
        this.wait = wait;
        this.properties = properties;
    }

    public HelperBase() {
    }


    public void waitElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            System.out.println("Web element not found" + " Locator: " + locator);
            return false;
        }
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        WebElement elementLocator = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementLocator);

        return elementLocator.getText();
    }


    public String getTextInput(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        WebElement elementLocator = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementLocator);

        if (elementLocator.getAttribute("placeholder") != null) {
            return elementLocator.getAttribute("placeholder");
        } else
            return elementLocator.getAttribute("help-block");
    }


    public String getTextDivVehicleMade(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        return (jse.executeScript("return arguments[0].textContent", element)).toString();
    }

    public void clickAndContinue(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(locator);

        click(By.xpath("//input[@value='Continue']"));
    }

    public void sleepTest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
