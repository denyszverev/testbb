package com.ak_tech.bb.pages;

import com.ak_tech.bb.appmanager.HelperBase;
import com.ak_tech.bb.enums.*;
import com.ak_tech.bb.model.TempData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import static com.ak_tech.bb.enums.CountyGoingTo.USA;

public class CommonPage extends HelperBase {

    public static final Map<Events, Object> events = new LinkedHashMap<>();

    public CommonPage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    public CommonPage() {
    }

    public static By enterYear = By.xpath("//input[@placeholder='Or enter exact year']");
    By importVehicle = By.xpath("//button[contains(.,'Import a Vehicle')]");
    By importItem = By.xpath("//button[contains(.,'Import any item')]");
    By goToCanada = By.xpath("(//button[contains(.,'Canada')])[1]");
    By goToUSA = By.xpath("(//button[contains(.,'USA')])[1]");
    By yearTo1993 = By.xpath("//button[contains(.,'1800-1993')]");
    By yearTo2002 = By.xpath("//button[contains(.,'1994-2002')]");
    By yearTo2018 = By.xpath("//button[contains(.,'2003-2018')]");
    By continueButton = By.xpath("//input[@value='Continue']");
    By fromUSA = By.xpath("//div[contains(., 'Where are you shipping from?')]/div/button[contains(., 'USA')]");
    By fromCanada = By.xpath("//div[contains(., 'Where are you shipping from?')]/div/button[contains(., 'Canada')]");
    By fromChina = By.xpath("//div[contains(., 'Where are you shipping from?')]/div/button[contains(., 'China')]");
    By fromJapan = By.xpath("//div[contains(., 'Where are you shipping from?')]/div/button[contains(., 'Japan')]");
    By fromGermany = By.xpath("//div[contains(., 'Where are you shipping from?')]/div/button[contains(., 'Germany')]");
    By fromOtherCountry = By.xpath("(//span[@role='combobox'])[1]");
    By inputFromOtherCountry = By.xpath("//input[@class='select2-search__field']");
    By madeUSA = By.xpath("//div[contains(., 'Where is the vehicle made?')]/div/button[contains(., 'USA')]");
    By madeCanada = By.xpath("//div[contains(., 'Where is the vehicle made?')]/div/button[contains(., 'Canada')]");
    By madeChina = By.xpath("//div[contains(., 'Where is the vehicle made?')]/div/button[contains(., 'China')]");
    By madeJapan = By.xpath("//div[contains(., 'Where is the vehicle made?')]/div/button[contains(., 'Japan')]");
    By madeGermany = By.xpath("//div[contains(., 'Where is the vehicle made?')]/div/button[contains(., 'Germany')]");
    By madeOtherCountry = By.xpath("(//span[@role='combobox'])[2]");
    //    By inputMadeOtherCountry = By.xpath("//input[@class='select2-search__field']");
    By valueLocator = By.xpath("//input[@name='productValueInput']");
    By haveAirConditionYes = By.xpath("//div[contains(., 'Does the vehicle have Air Condition?')]/div/button[contains(., 'Yes')]");
    By haveAirConditionNo = By.xpath("//div[contains(., 'Does the vehicle have Air Condition?')]/div/button[contains(., 'No')]");
    By Individual = By.xpath("//div[contains(., 'Individual or Business use?')]/div/button[contains(., 'Individual')]");
    By Business = By.xpath("//div[contains(., 'Individual or Business use?')]/div/button[contains(., 'Business')]");
    By emailCopyYes = By.xpath("(//button[contains(.,'Yes')])[2]");
    By emailCopyNo = By.xpath("(//button[contains(.,'No ')])[2]");
    By enterEmail = By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']");
    By purchasedYes = By.xpath("//div[contains(., 'Have you purchased the vehicle, yet?')]/div/button[contains(., 'Yes')]");
    By purchasedNo = By.xpath("//div[contains(., 'Have you purchased the vehicle, yet?')]/div/button[contains(., 'No')]");
    By truck = By.xpath("//button[contains(.,'Truck')]");
    By air = By.xpath("//button[contains(.,'Air')]");
    By ocean = By.xpath("//button[contains(.,'Ocean')]");
    By CommercialCarrier = By.xpath("//button[contains(.,' Commercial Carrier')]");
    By IAmDrivingItAcross = By.xpath("//button[contains(.,' I am driving it across')]");
    By backButton = By.xpath("//input[@value='back']");


    public void clickButton(Buttons button){
        switch(button){
            case IMPORTVEHICLE:
                click(importVehicle);
                break;
            case USA:
                click(goToUSA);
        }
    }

    private void typing(By locator, String text) {
        String existingText = driver.findElement(locator).getAttribute("value");
        if (existingText.equals("")) {
            waitElement(locator);
            driver.findElement(locator).sendKeys(text);
        } else {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);

        }
    }

    public void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void whatImporting (WhatImporting button) {
        switch (button){
            case VEHICLE:
                clickAndContinue(importVehicle);
                break;
            case ANY_PRODUCT:
                clickAndContinue(importItem);
                break;
        }
        events.put(Events.WhatImporting, button);
    }

    public void countyGoingTo(CountyGoingTo button) {
        switch (button){
            case CANADA:
                clickAndContinue(goToCanada);
                break;
            case USA:
                clickAndContinue(goToUSA);
                break;
        }
    }

    public void enterValue(TempData tempData) {
        typing(valueLocator, tempData.getValue());
        click(continueButton);
    }

    public void chooseHaveAirCondition(AirCondition button) {
        switch (button){
            case YES:
                clickAndContinue(haveAirConditionYes);
                break;
            case NO:
                clickAndContinue(haveAirConditionNo);
                break;
        }

        events.put(Events.YES, button);
    }

    public void chooseIndividualOrBusiness(IndividualOrBusiness button) {
        switch (button){
            case INDIVIDUAL:
                clickAndContinue(Individual);
                break;
            case BUSINESS:
                clickAndContinue(Business);
                break;
        }
        events.put(Events.IndividualOrBusiness, button);
    }

    public void chooseEmailNo() {
        click(emailCopyNo);
        click(continueButton);
    }

    public void chooseEmailCheckFills() {
        click(emailCopyYes);
        click(continueButton);
    }

    public void typeWrongEmail() {
        typing(enterEmail, "WrongEmail");
//        click(enterEmail);
    }

    public void typeWrightEmail() {
        By enterEmailAfterWrong = By.xpath("//input[@class='form-control ng-untouched ng-invalid ng-dirty']");
        typing(enterEmailAfterWrong, "anyemail@gmail.com");
        click(continueButton);
    }

    public void enterEmail(TempData tempData) {
        click(emailCopyYes);
        click(continueButton);
        typing(enterEmail, tempData.getEmail());
        click(continueButton);
    }

    public void choosePurchased() {
        click(purchasedYes);
        click(continueButton);
    }

    public void chooseHowShipping(HowShipping type) {
        switch (type) {
            case TRUCK:
                clickAndContinue(truck);
                break;
            case AIR:
                clickAndContinue(air);
                break;
            case OCEAN:
                clickAndContinue(ocean);
                break;
        }
        events.put(Events.ShippingMethod, type);
    }

    public void whoIsShipping(WhoIsShipping button) {
        switch (button){
            case COMMERCIALCARRIER:
                clickAndContinue(CommercialCarrier);
                break;
            case IAMDRIVINGACROSS:
                clickAndContinue(IAmDrivingItAcross);
                break;
        }
        events.put(Events.WhoIsShipping, button);

    }

    public void chooseShippingFrom(ShippingFrom country) {
        switch (country) {
            case USA:
                clickAndContinue(fromUSA);
                break;
            case Canada:
                clickAndContinue(fromCanada);
                break;
            case China:
                clickAndContinue(fromChina);
                break;
            case Japan:
                clickAndContinue(fromJapan);
                break;
            case Germany:
                clickAndContinue(fromGermany);
                break;
            case OtherCountry:
                typeAndContinue(fromOtherCountry, "Italy");
                break;
        }
        events.put(Events.ShippingMethod, country);
    }

    public void chooseMadeProduct(ProductMade countryMade) {
        switch (countryMade) {
            case USA:
                clickAndContinue(madeUSA);
                break;
            case Canada:
                clickAndContinue(madeCanada);
                break;
            case China:
                clickAndContinue(madeChina);
                break;
            case Japan:
                clickAndContinue(madeJapan);
                break;
            case Germany:
                clickAndContinue(madeGermany);
                break;
            case OtherCountry:
                typeAndContinue(madeOtherCountry, "France");
                break;
        }
        events.put(Events.CountryMade, countryMade);
    }

    private void typeAndContinue(By fromOtherCountry, String text) {
        click(fromOtherCountry);
        typing((By.xpath("//input[@class='select2-search__field']")), text);
        click(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']"));
        click(continueButton);
    }

    public void chooseYear(Year year) {
        switch (year) {
            case year1800_1993:
                clickAndContinue(yearTo1993);
                break;
            case year1994_2002:
                clickAndContinue(yearTo2002);
                break;
            case year2003_2018:
                clickAndContinue(yearTo2018);
                break;
            case enterYear:
                typing(enterYear, "2015");
                click(continueButton);
                break;
        }
        events.put(Events.Year, year);
    }

    public void chooseYear(Year year, TempData tempData) {
        switch (year) {
            case year1800_1993:
                clickAndContinue(yearTo1993);
                break;
            case year1994_2002:
                clickAndContinue(yearTo2002);
                break;
            case year2003_2018:
                clickAndContinue(yearTo2018);
                break;
            case enterYear:
                typing(enterYear, tempData.getYear());
                click(continueButton);
                break;
        }
        events.put(Events.Year, year);
    }

    public void backButton() {
        click(backButton);
    }


    public void whoIsShippingCommercialCarrier() {
        click(CommercialCarrier);
        click(continueButton);
    }

    public void whoIsShippingIAmDrivingItAcross() {
        click(IAmDrivingItAcross);
        click(continueButton);
    }
}