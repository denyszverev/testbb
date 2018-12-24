package com.ak_tech.bb.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class UtilityCapture {

    public static void captureScreenshots(WebDriver driver, String screenshotName) {

        try
        {
            TakesScreenshot screenshot = (TakesScreenshot)driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("./Screenshot/" +screenshotName+".png"));

        } catch (IOException e) {
            System.out.println("Exception while taking screenshots" + e.getMessage());
        }

    }

}
