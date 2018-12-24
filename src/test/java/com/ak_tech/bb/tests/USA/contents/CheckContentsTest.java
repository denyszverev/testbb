package com.ak_tech.bb.tests.USA.contents;


import com.ak_tech.bb.appmanager.TestBase;
import com.ak_tech.bb.calculatorLogic.CalculatorUSA;
import com.ak_tech.bb.enums.*;
import com.ak_tech.bb.model.QuoteUSAData;
import com.ak_tech.bb.model.TempData;
import com.ak_tech.bb.pages.CommonPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.ak_tech.bb.enums.CountyGoingTo.USA;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;
import static org.testng.Assert.assertEquals;

public class CheckContentsTest extends TestBase {

    @BeforeClass
    public void ensurePrecondition() {
        app.goTo().homePage();
    }

    @Test()
    public void testCheckContents() {
        app.navigate().clickButton(Buttons.IMPORTVEHICLE);
        assertEquals(app.contentsPage().getTextHeaderWhatCountryIsItGoingTo(), "What country is it going to?");
        assertEquals(app.contentsPage().getTextFooterWhatCountryIsItGoingTo(), "Different rules and regulations per country.");
        app.navigate().countyGoingTo(USA);
        assertEquals(app.contentsPage().getTextHeaderWhatYearVehicle(), "What year vehicle?");
        assertEquals(app.contentsPage().getAttributeEnterYear(), "Or enter exact year");
        assertEquals(app.contentsPage().getTextFooterWhatYearVehicle(), "The year of vehicle can determine duty rate.");
        app.navigate().chooseYear(Year.enterYear, new TempData().withYear("200"));
        app.helperBase().click(CommonPage.enterYear);
        assertEquals(app.contentsPage().getTextYearError(), "Year can be 4 digits only");
        app.navigate().chooseYear(Year.enterYear, new TempData().withYear("2010"));
        assertEquals(app.contentsPage().getTextHeaderWhereAreYouShippingFrom(), "Where are you shipping from?");
        app.navigate().chooseShippingFrom(ShippingFrom.Canada);
        assertEquals(app.contentsPage().getTextHeaderWhereIsTheVehicleMade(), "Where is the vehicle made?");
        app.navigate().chooseMadeProduct(ProductMade.Canada);
        assertEquals(app.contentsPage().getTextHeaderApproximateValue(), "What is the approximate value?");
        assertEquals(app.contentsPage().getAttributeEnterValue(), "Enter value");
        assertEquals(app.contentsPage().getTextFooterApproximateValue(), "The value of vehicle can determine duty and tax.");
        app.navigate().enterValue(new TempData().withValue("10000"));
        assertEquals(app.contentsPage().getTextHeaderEmail(), "Would you like an email copy of the quote?");
        assertEquals(app.contentsPage().getTextFooterEmail(), "We won't ever share your email with anyone else.");
        app.navigate().chooseEmailCheckFills();
        assertEquals(app.contentsPage().getTextHeaderYourEmail(), "Enter your email");
        assertEquals(app.contentsPage().getAttributeEnterYourEmail(), "Type here");
        app.navigate().typeWrongEmail();
        assertEquals(app.contentsPage().getTextWrongEmail(), "Email is invalid");
        app.navigate().typeWrightEmail();
        assertEquals(app.contentsPage().getTextHeaderPurchased(), "Have you purchased the vehicle, yet?");
        app.navigate().choosePurchased();
        assertEquals(app.contentsPage().getTextHeaderShipping(), "How are you shipping?");
        app.navigate().chooseHowShipping(HowShipping.TRUCK);
        assertEquals(app.contentsPage().getTextHeaderShippingIt(), "Who is shipping it?");
        assertEquals(app.contentsPage().getTextButtonCommercial(), "COMMERCIAL CARRIER");
        assertEquals(app.contentsPage().getTextButtonDriving(), "I AM DRIVING IT ACROSS");
        app.navigate().backButton();
        app.navigate().chooseHowShipping(HowShipping.OCEAN);

        app.helperBase().isElementPresent(By.xpath("//tab[@class='text-center accordion tab-pane active']"));

    }
}