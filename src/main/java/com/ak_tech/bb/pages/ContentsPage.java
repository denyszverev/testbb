package com.ak_tech.bb.pages;

import com.ak_tech.bb.appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class ContentsPage extends HelperBase {

    public ContentsPage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    private By textHeader_WhatCountryIsItGoingTo = By.xpath("//div[@class='col-xs-12 text-center']/div[contains(., 'What country is it going to?')]");
    private By textFooter_WhatCountryIsItGoingTo = By.xpath("//div[@class='note text-italic-gray col-xs-12']");
    private By textHeader_WhatYearVehicle = By.xpath("//div[@class='col-xs-12 text-center']/div[contains(., 'What year vehicle?')]");
    private By textFooter_WhatYearVehicle = By.xpath("//div[@class='note text-italic-gray col-xs-12']");
    private By textEnterYear = By.xpath("//input[@placeholder='Or enter exact year']");
    private By textEnterYearError = By.xpath("//span[@class='help-block']");
    private By textHeader_WhereAreYouShippingFrom = By.xpath("//div[@class='col-xs-12 text-center manufacturer']/div[contains(., 'Where are you shipping from?')]");
    private By textHeader_WhereIsTheVehicleMade = By.xpath("//div[@class='col-xs-12 text-center manufacturer']/div[contains(., 'Where is the vehicle made?')]");
    private By textHeader_ApproximateValue = By.xpath("//div[@class='title small-title currency-btn-block']/div[contains(., 'What is the approximate value?')]");
    private By textEnterValue = By.xpath("//input[@name='productValueInput']");
    private By textFooter_ApproximateValue = By.xpath("//div[@class='note text-italic-gray col-xs-12']");
    private By textHeader_Email = By.xpath("//div[@class='col-xs-12 text-center']/div[contains(., 'Would you like an email copy of the quote?')]");
    private By textFooter_Email = By.xpath("//div[@class='note text-italic-gray col-xs-12']");
    private By textHeader_YourEmail = By.xpath("//div[@class='col-xs-12 text-center']/div[contains(., 'Enter your email')]");
    private By textEnterYourEmail = By.xpath("//input[@placeholder='Type here']");
    private By textWrongEmail = By.xpath("//span[@class='help-block']");
    private By textHeader_Purchased = By.xpath("//div[@class='col-xs-12 text-center']/div[contains(., 'Have you purchased the vehicle, yet?')]");
    private By textHeader_Shipping = By.xpath("//div[@class='col-xs-12 text-center']/div[contains(., 'How are you shipping?')]");
    private By CommercialCarrier = By.xpath("//button[contains(.,' Commercial Carrier')]");
    private By IAmDrivingItAcross = By.xpath("//button[contains(.,' I am driving it across')]");
    private By textHeader_ShippingIt = By.xpath("//div[@class='col-xs-12 text-center']/div[contains(., 'Who is shipping it?')]");


    public String getTextHeaderWhatCountryIsItGoingTo() {
        return getText(textHeader_WhatCountryIsItGoingTo);
    }

    public String getTextFooterWhatCountryIsItGoingTo() {
        return getText(textFooter_WhatCountryIsItGoingTo);
    }

    public String getTextHeaderWhatYearVehicle() {
        return getText(textHeader_WhatYearVehicle);
    }

    public String getTextFooterWhatYearVehicle() {
        return getText(textFooter_WhatYearVehicle);
    }

    public String getAttributeEnterYear() {
        return getTextInput(textEnterYear);
    }

    public String getTextYearError() {
        return getText(textEnterYearError);
    }


    public String getTextHeaderWhereAreYouShippingFrom() {
        return getText(textHeader_WhereAreYouShippingFrom);
    }

    public String getTextHeaderWhereIsTheVehicleMade() {
        return getText(textHeader_WhereIsTheVehicleMade);
    }

    public String getTextHeaderApproximateValue() {
        return getText(textHeader_ApproximateValue);
    }

    public String getAttributeEnterValue() {
        return getTextInput(textEnterValue);
    }

    public String getTextFooterApproximateValue() {
        return getText(textFooter_ApproximateValue);
    }

    public String getTextHeaderEmail() {
        return getText(textHeader_Email);
    }

    public String getTextFooterEmail() {
        return getText(textFooter_Email);
    }

    public String getTextHeaderYourEmail() {
        return getText(textHeader_YourEmail);
    }

    public String getAttributeEnterYourEmail() {
        return getTextInput(textEnterYourEmail);
    }

    public String getTextWrongEmail() {
        return getText(textWrongEmail);
    }

    public String getTextHeaderPurchased() {
        return getText(textHeader_Purchased);
    }

    public String getTextHeaderShipping() {
        return getText(textHeader_Shipping);
    }

    public String getTextHeaderShippingIt() {
        return getText(textHeader_ShippingIt);
    }

    public String getTextButtonCommercial() {
        return getText(CommercialCarrier);
    }

    public String getTextButtonDriving() {
        return getText(IAmDrivingItAcross);
    }




}
