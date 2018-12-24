package com.ak_tech.bb.calculatorLogic;

import com.ak_tech.bb.enums.Events;
import com.ak_tech.bb.model.QuoteCAData;
import com.ak_tech.bb.pages.CommonPage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ak_tech.bb.appmanager.TestBase.app;
import static com.ak_tech.bb.enums.AirCondition.YES;
import static com.ak_tech.bb.enums.HowShipping.TRUCK;
import static com.ak_tech.bb.enums.IndividualOrBusiness.BUSINESS;
import static com.ak_tech.bb.enums.IndividualOrBusiness.INDIVIDUAL;
import static com.ak_tech.bb.enums.ProductMade.Canada;
import static com.ak_tech.bb.enums.ProductMade.Mexico;
import static com.ak_tech.bb.enums.ProductMade.USA;
import static com.ak_tech.bb.enums.Province.*;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;
import static com.ak_tech.bb.enums.Year.year1800_1993;
import static com.ak_tech.bb.enums.Year.year1994_2002;

public class CalculatorCA {
    public static String valueUSD;

    private By xpathCountryMadeType = By.xpath("//span[@id='select2-manufacturerSelect-container']");


    public Double valueUSD() {
        return Double.parseDouble(valueUSD);
    }

    public Double rate() {
        return RateParser.readRate();
    }

    public Double valueForCustoms() {
        return valueUSD() * rate();
    }


    public double AES() {
        if (CommonPage.events.get(Events.CountryMade).equals(USA)) {
            return 129;
        }

        return 0;
    }

    public double RIV() {
        Object eventYear = CommonPage.events.get(Events.Year);
        if (eventYear.equals(year1800_1993) || eventYear.equals(year1994_2002)) {
            return 0;
        }

        return 90;

    }

    public double AC() {
        if (isHaveAirCondition()) {
            return 100;
        }

        return 0;
    }


    public double Form1() {
        Object eventYear = CommonPage.events.get(Events.Year);
        if (eventYear.equals(year1800_1993) ||
                eventYear.equals(year1994_2002)) {
            return 25;
        }

        return 40;
    }

    public double customsDuties() {
        String text1 = app.helperBase.getTextDivVehicleMade(xpathCountryMadeType);
        Object eventMade = CommonPage.events.get(Events.CountryMade);

        if (eventMade.equals(USA) || eventMade.equals(Canada) ||
                eventMade.equals(Mexico) ||
                text1.equals("Mexico")) {
            return 0;
        }

        return valueForCustoms() * 0.061;
    }

    public double customsGST() {
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventProvince.equals(Alberta) ||
                eventProvince.equals(BritishColumbia) ||
                eventProvince.equals(Manitoba) ||
                eventProvince.equals(NorthwestTerritories) ||
                eventProvince.equals(Nunavut) ||
                eventProvince.equals(Quebec) ||
                eventProvince.equals(Saskatchewan) ||
                eventProvince.equals(Yukon)) {
            return valueForCustoms() * 0.05;
        }
        return 0;
    }

    public double customsPST() {
        Object eventStatus = CommonPage.events.get(Events.IndividualOrBusiness);
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventStatus.equals(INDIVIDUAL)) {

            if (eventProvince.equals(Alberta) ||
                    eventProvince.equals(NorthwestTerritories) ||
                    eventProvince.equals(Nunavut) ||
                    eventProvince.equals(Yukon)) {
                return valueForCustoms() * 0;
            }
            if (eventProvince.equals(BritishColumbia)) {
                return valueForCustoms() * 0.07;
            }
            if (eventProvince.equals(Manitoba)) {
                return valueForCustoms() * 0.08;
            }
            if (eventProvince.equals(Saskatchewan)) {
                return valueForCustoms() * 0.06;
            }
        }

        return 0;
    }

    public double customsHST() {
        Object eventStatus = CommonPage.events.get(Events.IndividualOrBusiness);
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventStatus.equals(BUSINESS)) {

            if (eventProvince.equals(NewBrunswick) ||
                    eventProvince.equals(NewfoundlandAndLabrador) ||
                    eventProvince.equals(NovaScotia) ||
                    eventProvince.equals(Ontario) ||
                    eventProvince.equals(PrinceEdwardIsland)) {
                return valueForCustoms() * 0.05;
            }
        }
        if (eventStatus.equals(INDIVIDUAL)) {

            if (eventProvince.equals(NewBrunswick) ||
                    eventProvince.equals(NewfoundlandAndLabrador) ||
                    eventProvince.equals(NovaScotia) ||
                    eventProvince.equals(PrinceEdwardIsland)) {
                return valueForCustoms() * 0.15;
            }

            if (eventProvince.equals(Ontario)) {
                return valueForCustoms() * 0.13;
            }
        }
        return 0;
    }


    public double customsQST() {
        Object eventStatus = CommonPage.events.get(Events.IndividualOrBusiness);
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventStatus.equals(INDIVIDUAL)) {

            if (eventProvince.equals(Quebec)) {
                return valueForCustoms() * 0.09975;
            }
        }
        return 0;
    }

    public double CustomsClearance() {
        if (valueForCustoms() <= 50000) {
            return 103;
        } else {
            return 371;
        }
    }

    public double customsClearanceGST() {
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventProvince.equals(Alberta) ||
                eventProvince.equals(BritishColumbia) ||
                eventProvince.equals(Manitoba) ||
                eventProvince.equals(NorthwestTerritories) ||
                eventProvince.equals(Nunavut) ||
                eventProvince.equals(Quebec) ||
                eventProvince.equals(Saskatchewan) ||
                eventProvince.equals(Yukon)) {
            return CustomsClearance() * 0.05;
        }
        return 0;
    }

    public double customsClearancePST() {
        Object eventStatus = CommonPage.events.get(Events.IndividualOrBusiness);
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventStatus.equals(INDIVIDUAL)) {

            if (eventProvince.equals(Alberta) ||
                    eventProvince.equals(NorthwestTerritories) ||
                    eventProvince.equals(Nunavut) ||
                    eventProvince.equals(Yukon)) {
                return CustomsClearance() * 0;
            }
            if (eventProvince.equals(BritishColumbia)) {
                return CustomsClearance() * 0.07;
            }
            if (eventProvince.equals(Manitoba)) {
                return CustomsClearance() * 0.08;
            }
            if (eventProvince.equals(Saskatchewan)) {
                return CustomsClearance() * 0.06;
            }
        }

        return 0;
    }

    public double customsClearanceHST() {
        Object eventStatus = CommonPage.events.get(Events.IndividualOrBusiness);
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventStatus.equals(BUSINESS)) {

            if (eventProvince.equals(NewBrunswick) || eventProvince.equals(NewfoundlandAndLabrador) ||
                    eventProvince.equals(NovaScotia) || eventProvince.equals(Ontario) || eventProvince.equals(PrinceEdwardIsland)) {
                return CustomsClearance() * 0.05;
            }
        }
        if (eventStatus.equals(INDIVIDUAL)) {

            if (eventProvince.equals(NewBrunswick) ||
                    eventProvince.equals(NewfoundlandAndLabrador) ||
                    eventProvince.equals(NovaScotia) ||
                    eventProvince.equals(PrinceEdwardIsland)) {
                return CustomsClearance() * 0.15;
            }

            if (eventProvince.equals(Ontario)) {
                return CustomsClearance() * 0.13;
            }
        }
        return 0;
    }

    public double customsClearanceQST() {
        Object eventStatus = CommonPage.events.get(Events.IndividualOrBusiness);
        Object eventProvince = CommonPage.events.get(Events.Province);

        if (eventStatus.equals(INDIVIDUAL)) {

            if (eventProvince.equals(Quebec)) {
                return CustomsClearance() * 0.09975;
            }
        }
        return 0;
    }

    public Double grandTotalFees() {
        return AES()
                + RIV()
                + AC()
                + Form1()
                + customsGST()
                + customsPST()
                + customsHST()
                + customsQST()
                + CustomsClearance()
                + customsClearanceGST()
                + customsClearancePST()
                + customsClearanceHST()
                + customsClearanceQST();
    }

    public List<QuoteCAData> calculateQuoteCAList() {
        List<QuoteCAData> quote = new ArrayList<>();
        QuoteCAData quoteCAData = new QuoteCAData()
                .withValue(FormatNumber.format(valueUSD()))
                .withExchangeRate(rate())
                .withValueForCustoms(FormatNumber.format(valueForCustoms()))
                .withAES(FormatNumber.format(AES()))
                .withRIV(FormatNumber.format(RIV()))
                .withAC(FormatNumber.format(AC()))
                .withForm1(FormatNumber.format(Form1()))
                .withCustomsDuties(FormatNumber.format(customsDuties()))
                .withCustomsGST(FormatNumber.format(customsGST()))
                .withCustomsPST(FormatNumber.format(customsPST()))
                .withCustomsHST(FormatNumber.format(customsHST()))
                .withCustomsQST(FormatNumber.format(customsQST()))
                .withCustomsClearance(FormatNumber.format(CustomsClearance()))
                .withCustomsClearanceGST(FormatNumber.format(customsClearanceGST()))
                .withCustomsClearancePST(FormatNumber.format(customsClearancePST()))
                .withCustomsClearanceHST(FormatNumber.format(customsClearanceHST()))
                .withCustomsClearanceQST(FormatNumber.format(customsClearanceQST()))
                .withGrandTotalFees(FormatNumber.format(grandTotalFees()));
        quote.add(quoteCAData);
        System.out.println("calculateQuote" + quote);
        return quote;
    }

    public boolean isHaveAirCondition() {
        Object eventStatus = CommonPage.events.get(Events.YES);
        if (eventStatus.equals(YES)) {
            return true;
        }
        return false;
    }

    public boolean isNAFTA() {
        if (CommonPage.events.get(Events.CountryMade).equals(USA)
                || CommonPage.events.get(Events.CountryMade).equals(Canada)
                || CommonPage.events.get(Events.CountryMade).equals(Mexico)) {
            return true;
        }
        return false;
    }

    public boolean isVehicle() {
        if (CommonPage.events.get(Events.WhatImporting).equals(VEHICLE)) {
            return true;
        }
        return false;
    }
}