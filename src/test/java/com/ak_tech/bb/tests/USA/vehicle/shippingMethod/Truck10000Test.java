package com.ak_tech.bb.tests.USA.vehicle.shippingMethod;


import com.ak_tech.bb.appmanager.TestBase;
import com.ak_tech.bb.calculatorLogic.CalculatorUSA;
import com.ak_tech.bb.enums.*;
import com.ak_tech.bb.model.QuoteUSAData;
import com.ak_tech.bb.model.TempData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.ak_tech.bb.enums.CountyGoingTo.USA;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;

public class Truck10000Test extends TestBase {

    @BeforeClass
    public void ensurePrecondition() {
        app.goTo().homePage();
    }

    @Test()
    public void testTruck10000() {
        app.navigate().whatImporting(VEHICLE);
        app.navigate().countyGoingTo(USA);
        app.navigate().chooseYear(Year.enterYear, new TempData().withYear("2015"));
        app.navigate().chooseShippingFrom(ShippingFrom.Germany);
        app.navigate().chooseMadeProduct(ProductMade.Germany);
        app.navigate().enterValue(new TempData().withValue(CalculatorUSA.valueUSD = "10000"));
        app.navigate().chooseEmailNo();
        app.navigate().choosePurchased();
        app.navigate().chooseHowShipping(HowShipping.TRUCK);
        app.navigate().whoIsShipping(WhoIsShipping.COMMERCIALCARRIER);

        List<QuoteUSAData> actualQuoteUSADataList = app.quoteHelper().getQuoteUSAList();
        List<QuoteUSAData> expectedQuoteCADataList = app.calculatorUSA().calculateQuoteUsaList();
        Assert.assertEquals(actualQuoteUSADataList, expectedQuoteCADataList);
    }
}