package com.ak_tech.bb.tests.CA.vehicle.Individual.province;


import com.ak_tech.bb.appmanager.TestBase;
import com.ak_tech.bb.calculatorLogic.CalculatorCA;
import com.ak_tech.bb.enums.HowShipping;
import com.ak_tech.bb.enums.ProductMade;
import com.ak_tech.bb.enums.ShippingFrom;
import com.ak_tech.bb.enums.Year;
import com.ak_tech.bb.model.QuoteCAData;
import com.ak_tech.bb.model.TempData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ak_tech.bb.enums.AirCondition.YES;
import static com.ak_tech.bb.enums.CountyGoingTo.CANADA;
import static com.ak_tech.bb.enums.IndividualOrBusiness.INDIVIDUAL;
import static com.ak_tech.bb.enums.Province.Manitoba;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;


public class ManitobaTest extends TestBase {

    static List<QuoteCAData> expected = new ArrayList<>();


    @BeforeClass
    public void ensurePrecondition() {
        app.goTo().homePage();
    }

    @Test()
    public void testManitoba()  {
        app.navigate().whatImporting(VEHICLE);
        app.navigate().countyGoingTo(CANADA);
        app.provincePage().chooseProvince(Manitoba);
        app.navigate().chooseYear(Year.year1994_2002);
        app.navigate().chooseShippingFrom(ShippingFrom.USA);
        app.navigate().chooseMadeProduct(ProductMade.USA);
        app.navigate().enterValue(new TempData().withValue(CalculatorCA.valueUSD ="15000"));
        app.navigate().chooseHaveAirCondition(YES);
        app.navigate().chooseIndividualOrBusiness(INDIVIDUAL);
        app.navigate().chooseEmailNo();
        app.navigate().choosePurchased();
        app.navigate().chooseHowShipping(HowShipping.AIR);


        List<QuoteCAData> actualQuoteCADataList = app.quoteHelper().getQuoteCAList();
        List<QuoteCAData> expectedQuoteCADataList = app.calculatorCA().calculateQuoteCAList();
//        expected = calculatorCA.calculateValues(app.navigate().events);
//        System.out.println(expected);
        Assert.assertEquals(actualQuoteCADataList, expectedQuoteCADataList);

    }
}