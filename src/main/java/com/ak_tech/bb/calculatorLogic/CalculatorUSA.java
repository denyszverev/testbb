package com.ak_tech.bb.calculatorLogic;

import com.ak_tech.bb.enums.Events;
import com.ak_tech.bb.model.QuoteUSAData;
import com.ak_tech.bb.pages.CommonPage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.ak_tech.bb.enums.Events.WhoIsShipping;
import static com.ak_tech.bb.enums.HowShipping.*;
import static com.ak_tech.bb.enums.ProductMade.*;
import static com.ak_tech.bb.enums.WhatImporting.VEHICLE;
import static com.ak_tech.bb.enums.WhoIsShipping.IAMDRIVINGACROSS;

public class CalculatorUSA {

    public static String valueUSD;

    public double valueUSD() {
        return Double.parseDouble(valueUSD);
    }

    public double rate() {
//        Object event = null;
//        if (! event.equals(null)) {
//            return RateParser.readRate();
//        }
        return 1;
    }

    public double valueForCustoms() {
        return valueUSD() * rate();
    }

    public double customsDuties() {
        if (isNAFTA())
            return 0.0;
        if (isVehicle())
            return valueForCustoms() * 0.025;
        return valueForCustoms() * 0.08;
    }

    public double customsMPF() {
        double customsMPF = valueForCustoms() * 0.003464;

        if (!isVehicle()) {

            if (isNAFTA())
                customsMPF = 0;

            if (customsMPF >= 485)
                return 485;

            if (customsMPF <= 25)
                return 25;

        }

        if (isNAFTA())
            customsMPF = 0;
//          else if (customsMPF >= 485.0)
//            customsMPF = 485.0;

        else if (customsMPF <= 25)
            customsMPF = 25;

        return customsMPF;
    }


    private double customsHMF() {
        if (isOcean())
            return valueForCustoms() * 0.00125;

        return 0;
    }

    private double entryFee() {
        double entryFee = 0;
        if (isTruck()) {
            if (!isVehicle()) {
                if (valueForCustoms() <= 500)
                    return 50;
                if (valueForCustoms() <= 2000)
                    return 80;
                if (valueForCustoms() <= 5000)
                    return 110;
                if (valueForCustoms() <= 10000)
                    return 160;
                if (valueForCustoms() <= 50000)
                    return 250;
                if (valueForCustoms() <= 150000)
                    return 350;
                if (valueForCustoms() >= 150000.01)
                    return 500;
            }
            return 250;
        } else {
            if (valueForCustoms() <= 10000)
                return 190;
            if (valueForCustoms() <= 100000)
                return 275;
            if (valueForCustoms() > 100000)
                return 475;
        }
        return entryFee;
    }

    private double classificationFee() {
        return 0;
    }

    private double bond() {
        if (!isVehicle()) {
            if (isOcean())
                return 490;
        }
        if (isVehicle()) {
            if (isOcean())
                return 450;
            double bond = valueForCustoms() / 1000 * 15 + 0.001;    // +0.001 for correct value
            if (bond < 50)
                return 50;
            return bond;
        }

        double bond = valueForCustoms() / 1000 * 15 + 0.001;    // +0.001 for correct value
        if (bond < 6)
            return 60;

        return bond;
    }

    private double bondUnderwritingFee() {
        if (isVehicle()) {
            return 40;
        }

        return 10;
    }

    private double customsISF() {
        if (isOcean())
            return 30;
        return 0;
    }

    private double dutyDisbursementFee() {
        if (isVehicle())
            return (customsMPF() + customsDuties()) * 0.03;
        else if (isNAFTA())
            return 0;
        else if (customsDuties() == 0)
            return 0;
        return (customsDuties() + customsMPF() + customsHMF()) * 0.03;
    }

    private double NAFTA() {
        if (isNAFTA())
            return 5;
        return 0;
    }


    private double ABI_Fee() {
        return 5;
    }

    private double DOT_EPA() {
        if (isVehicle())
            return 40;
        return 0;
    }

    private double importerRegistrationFee() {
        return 15;
    }

    private double onetimePAPSExemption() {
        return 0;
    }

    private double E_Manifest() {
        if (isTruck()) {
            if (CommonPage.events.get(WhoIsShipping).equals(IAMDRIVINGACROSS))
                return 50;
        }
        return 0;
    }

    private double administrationFee() {
        if (isVehicle() && isOcean())
            return (bond() + bondUnderwritingFee()) * 0.03;
        if (isVehicle())
            return (customsDuties()
                    + customsMPF()
                    + customsHMF()
                    + entryFee()
                    + classificationFee()
                    + bond()
                    + bondUnderwritingFee()
                    + E_Manifest()
                    + dutyDisbursementFee()
                    + customsISF()
                    + NAFTA()
                    + ABI_Fee()
                    + DOT_EPA()
                    + importerRegistrationFee()
                    + onetimePAPSExemption()) * 0.0035;
        return (customsDuties()
                + customsMPF()
                + customsHMF()
                + entryFee()
                + classificationFee()
                + bond()
                + bondUnderwritingFee()
                + dutyDisbursementFee()
                + customsISF()
                + E_Manifest()
                + NAFTA()
                + ABI_Fee()
                + DOT_EPA()
                + importerRegistrationFee()) * 0.03;
    }

    private Double grandTotalFees() {
        return customsDuties()
                + customsMPF()
                + customsHMF()
                + entryFee()
                + classificationFee()
                + bond()
                + bondUnderwritingFee()
                + E_Manifest()
                + dutyDisbursementFee()
                + customsISF()
                + NAFTA()
                + ABI_Fee()
                + DOT_EPA()
                + importerRegistrationFee()
                + onetimePAPSExemption()
                + administrationFee();
    }

    public List<QuoteUSAData> calculateQuoteUsaList() {
        List<QuoteUSAData> quoteUSAData = new ArrayList<>();
        QuoteUSAData usaData = new QuoteUSAData()
                .withValue(FormatNumber.format(valueUSD()))
                .withValueForCustoms(FormatNumber.format(valueForCustoms()))
                .withCustomsDuties(FormatNumber.format(customsDuties()))
                .withCustomsMPF(FormatNumber.format(customsMPF()))
                .withCustomsHMF(FormatNumber.format(customsHMF()))
                .withEntryFee(FormatNumber.format(entryFee()))
                .withClassificationFee(FormatNumber.format(classificationFee()))
                .withBond(FormatNumber.format(bond()))
                .withBondUnderwritingFee(FormatNumber.format(bondUnderwritingFee()))
                .withE_Manifest(FormatNumber.format(E_Manifest()))
                .withCustomsISF(FormatNumber.format(customsISF()))
                .withDutyDisbursementFee(FormatNumber.format(dutyDisbursementFee()))
                .withNAFTA(FormatNumber.format(NAFTA()))
                .withABI_Fee(FormatNumber.format(ABI_Fee()))
                .withDOT_EPA(FormatNumber.format(DOT_EPA()))
                .withImporterRegistrationFee(FormatNumber.format(importerRegistrationFee()))
                .withOnetimePAPSExemption(FormatNumber.format(onetimePAPSExemption()))
                .withAdministrationFee(FormatNumber.format(administrationFee()))
                .withGrandTotalFees(FormatNumber.format(grandTotalFees()));
        quoteUSAData.add(usaData);
        System.out.println("quoteUSAData" + quoteUSAData);
        return quoteUSAData;
    }

    public boolean isVehicle() {
        if (CommonPage.events.get(Events.WhatImporting).equals(VEHICLE)) {
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

    public boolean isOcean() {
        if (CommonPage.events.get(Events.ShippingMethod).equals(OCEAN)) {
            return true;
        }
        return false;
    }

    public boolean isAir() {
        if (CommonPage.events.get(Events.ShippingMethod).equals(AIR)) {
            return true;
        }
        return false;
    }

    public boolean isTruck() {
        if (CommonPage.events.get(Events.ShippingMethod).equals(TRUCK)) {
            return true;
        }
        return false;
    }
}
