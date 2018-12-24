package com.ak_tech.bb.tests.USA.vehicle.yearAssert;


import com.ak_tech.bb.appmanager.TestBase;
import com.ak_tech.bb.calculatorLogic.CalculatorUSA;
import com.ak_tech.bb.enums.HowShipping;
import com.ak_tech.bb.enums.ProductMade;
import com.ak_tech.bb.enums.ShippingFrom;
import com.ak_tech.bb.enums.Year;
import com.ak_tech.bb.model.QuoteUSAData;
import com.ak_tech.bb.model.TempData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.ak_tech.bb.enums.CountyGoingTo.USA;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;

public class YearVehicle2018Test extends TestBase {

    CalculatorUSA calculatorUSA = new CalculatorUSA();

    @BeforeClass
    public void ensurePrecondition() {
        app.goTo().homePage();
    }


    @Test
    public void testForYear2003_2018() {
        app.navigate().whatImporting(VEHICLE);
        app.navigate().countyGoingTo(USA);
        app.navigate().chooseYear(Year.year2003_2018);
        app.navigate().chooseShippingFrom(ShippingFrom.Canada);
        app.navigate().chooseMadeProduct(ProductMade.Canada);
        app.navigate().enterValue(new TempData().withValue(CalculatorUSA.valueUSD = "10000"));
        app.navigate().chooseEmailNo();
        app.navigate().choosePurchased();
        app.navigate().chooseHowShipping(HowShipping.OCEAN);


        List<QuoteUSAData> actualQuoteUSADataList = app.quoteHelper().getQuoteUSAList();
        List<QuoteUSAData> expectedQuoteCADataList = app.calculatorUSA().calculateQuoteUsaList();
        Assert.assertEquals(actualQuoteUSADataList, expectedQuoteCADataList);
    }
}