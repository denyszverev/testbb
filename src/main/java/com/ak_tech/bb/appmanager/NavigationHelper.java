package com.ak_tech.bb.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    private By logo = By.xpath("//div/h1");

    public void homePage() {
        if (isElementPresent(logo)
                && isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("ORDERS\n" + "WITHOUT\n" + "BORDERS.")) {
            return;
        }
        driver.navigate().to(properties.getProperty("web.baseUrl"));   //"https://bb-qa.ak-tech.org/calculator2/public");
    }
}


