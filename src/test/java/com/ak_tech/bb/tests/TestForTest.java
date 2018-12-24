package com.ak_tech.bb.tests;


import com.ak_tech.bb.appmanager.TestBase;
import com.ak_tech.bb.helper.UtilityCapture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestForTest extends TestBase {
    WebDriver driver;

    @Test(enabled = false)
    public void ByPixel() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://bb-qa.ak-tech.org/calculator2/public/import");

        UtilityCapture.captureScreenshots(driver, "ByPixel");
        Thread.sleep(5000);

        UtilityCapture.captureScreenshots(driver,"ByPixel1");
    }
}
