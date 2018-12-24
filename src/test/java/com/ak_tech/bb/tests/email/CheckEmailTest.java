package com.ak_tech.bb.tests.email;


import com.ak_tech.bb.appmanager.TestBase;
import com.ak_tech.bb.enums.HowShipping;
import com.ak_tech.bb.enums.ProductMade;
import com.ak_tech.bb.enums.ShippingFrom;
import com.ak_tech.bb.enums.Year;
import com.ak_tech.bb.helper.Mail;
import com.ak_tech.bb.model.TempData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ak_tech.bb.enums.CountyGoingTo.USA;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;


public class CheckEmailTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().homePage();
    }

    @Test(enabled = false)
    public void testOne() throws Exception{
        app.navigate().whatImporting(VEHICLE);
        app.navigate().countyGoingTo(USA);
        app.navigate().chooseYear(Year.enterYear, new TempData().withYear("2015"));
        app.navigate().chooseShippingFrom(ShippingFrom.Canada);
        app.navigate().chooseMadeProduct(ProductMade.Canada);
        app.navigate().enterValue(new TempData().withValue("10000"));
        app.navigate().enterEmail(new TempData().withEmail("denis.z@ak-tech.ca"));
        app.navigate().choosePurchased();
        app.navigate().chooseHowShipping(HowShipping.AIR);

        app.helperBase().isElementPresent(By.xpath("//tab[@class='text-center accordion tab-pane active']"));



        this.checkActivationLink();
    }

    public void checkActivationLink() throws Exception {

        Mail mail = new Mail( );
        String activationLink = mail.ReceiveLastEmail();
        Assert.assertTrue(!activationLink.isEmpty());
    }
}