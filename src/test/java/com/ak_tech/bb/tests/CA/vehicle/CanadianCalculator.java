package com.ak_tech.bb.tests.CA.vehicle;

import com.ak_tech.bb.appmanager.TestBase;
import com.ak_tech.bb.enums.*;
import com.ak_tech.bb.model.TempData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ak_tech.bb.enums.CountyGoingTo.CANADA;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;


public class CanadianCalculator extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().homePage();
    }

    @Test(enabled = false)
    public void testOne() {
        app.navigate().whatImporting(VEHICLE);
        app.navigate().countyGoingTo(CANADA);
        app.provincePage().chooseProvince(Province.Alberta);
        app.navigate().chooseYear(Year.enterYear);
        app.navigate().chooseShippingFrom(ShippingFrom.USA);
        app.navigate().chooseMadeProduct(ProductMade.USA);
        app.navigate().enterValue(new TempData().withValue("15000"));
        app.navigate().chooseHaveAirCondition(AirCondition.YES);
        app.navigate().chooseIndividualOrBusiness(IndividualOrBusiness.INDIVIDUAL);
        app.navigate().chooseEmailNo();
        app.navigate().choosePurchased();

    }
}