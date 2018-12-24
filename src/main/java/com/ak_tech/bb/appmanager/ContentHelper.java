package com.ak_tech.bb.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class ContentHelper extends HelperBase {

    public ContentHelper(WebDriver driver, WebDriverWait wait,Properties properties) {
        super(driver, wait, properties);
    }
}
