package com.ak_tech.bb.appmanager;

import com.ak_tech.bb.enums.ResultValues;
import com.ak_tech.bb.model.QuoteCAData;
import com.ak_tech.bb.model.QuoteUSAData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class QuoteHelper extends HelperBase {

    public QuoteHelper(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    By quoteID = By.xpath("//span[contains(., 'Quote ID:')]");

    By valuePay = By.xpath("(//div[@class='bg-grey short-description margin-right--10 red-background'])[1]");
    By exchangeRate = By.xpath("//calc-info-row[@title='Exchange Rate']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By valueForCustoms = By.xpath("//calc-info-row[@title='Value for Customs']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By AES = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'AES')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By RIV = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'RIV')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By AC = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'AC')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By Form1 = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Form 1')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsDuties = By.xpath("//calc-info-row[@title='Customs Duties']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsMPF = By.xpath("//calc-info-row[@title='Customs MPF']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsHMF = By.xpath("//calc-info-row[@title='Customs HMF']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsGST = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Customs GST')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsPST = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Customs PST')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsHST = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Customs HST')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsQST = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Customs QST')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsClearance = By.xpath("//calc-info-row[@title='Customs Clearance']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsClearanceGST = By.xpath("//calc-info-row[@title='Customs Clearance GST']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsClearancePST = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Customs Clearance PST')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsClearanceHST = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Customs Clearance HST')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsClearanceQST = By.xpath("//div[@class='tax-name col-lg-9 col-xs-7' and contains(., 'Customs Clearance QST')]/..//div[@class='bg-grey short-description margin-right--10 red-background']");
    By entryFee = By.xpath("//calc-info-row[@title='Entry Fee']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By classificationFee = By.xpath("//calc-info-row[@title='Classification Fee']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By bond = By.xpath("//calc-info-row[@title='Bond']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By bondUnderwritingFee = By.xpath("//calc-info-row[@title='Bond Underwriting Fee']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By dutyDisbursementFee = By.xpath("//calc-info-row[@title='Duty Disbursement Fee']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By NAFTA = By.xpath("//calc-info-row[@title='NAFTA']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By ABIFee = By.xpath("//calc-info-row[@title='ABI Fee']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By DOT_EPA = By.xpath("//calc-info-row[@title='DOT/EPA']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By importerRegistrationFee = By.xpath("//calc-info-row[@title='Importer Registration Fee']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By oneTimePAPSExemption = By.xpath("//calc-info-row[@title='One time PAPS Exemption']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By administrationFee = By.xpath("//div[contains(., 'Administration Fee (USD)')]/div/div[@class='bg-grey short-description margin-right--10 red-background']");
    By grandTotalFees = By.xpath("//calc-info-row[@class='border-0 margin-bottom-10 bold']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By customsISF = By.xpath("//calc-info-row[@title='Customs ISF']//div[@class='bg-grey short-description margin-right--10 red-background']");
    By eManifest = By.xpath("//calc-info-row[@title='E-Manifest']//div[@class='bg-grey short-description margin-right--10 red-background']");


    public List<QuoteCAData> getQuoteCAList() {
        List<QuoteCAData> quote = new ArrayList<>();
        QuoteCAData quoteCAData = new QuoteCAData()
                .withValue(getValue(ResultValues.Value))
                .withExchangeRate(Double.valueOf(getValue(ResultValues.ExchangeRate)))
                .withValueForCustoms(getValue(ResultValues.ValueForCustoms))
                .withAES(getValue(ResultValues.AES))
                .withRIV(getValue(ResultValues.RIV))
                .withAC(getValue(ResultValues.AC))
                .withForm1(getValue(ResultValues.Form1))
                .withCustomsDuties(getValue(ResultValues.CustomsDuties))
                .withCustomsGST(getValue(ResultValues.CustomsGST))
                .withCustomsPST(getValue(ResultValues.CustomsPST))
                .withCustomsHST(getValue(ResultValues.CustomsHST))
                .withCustomsQST(getValue(ResultValues.CustomsQST))
                .withCustomsClearance(getValue(ResultValues.CustomsClearance))
                .withCustomsClearanceGST(getValue(ResultValues.CustomsClearanceGST))
                .withCustomsClearanceHST(getValue(ResultValues.CustomsClearanceHST))
                .withCustomsClearancePST(getValue(ResultValues.CustomsClearancePST))
                .withCustomsClearanceQST(getValue(ResultValues.CustomsClearanceQST))
                .withGrandTotalFees(getValue(ResultValues.GrandTotalFees));
        quote.add(quoteCAData);
        System.out.println("getQuote" + quote);
        return quote;
    }

    public List<QuoteUSAData> getQuoteUSAList() {
        List<QuoteUSAData> quote = new ArrayList<>();
        QuoteUSAData quoteCAData = new QuoteUSAData()
                .withValue(getValue(ResultValues.Value))
                .withValueForCustoms(getValue(ResultValues.ValueForCustoms))
                .withCustomsDuties(getValue(ResultValues.CustomsDuties))
                .withCustomsMPF(getValue(ResultValues.CustomsMPF))
                .withCustomsHMF(getValue(ResultValues.CustomsHMF))
                .withEntryFee(getValue(ResultValues.EntryFee))
                .withClassificationFee(getValue(ResultValues.ClassificationFee))
                .withBond(getValue(ResultValues.Bond))
                .withBondUnderwritingFee(getValue(ResultValues.BondUnderwritingFee))
                .withE_Manifest(getValue(ResultValues.EManifest))
                .withCustomsISF(getValue(ResultValues.CustomsISF))
                .withDutyDisbursementFee(getValue(ResultValues.DutyDisbursementFee))
                .withNAFTA(getValue(ResultValues.NAFTA))
                .withABI_Fee(getValue(ResultValues.ABIFee))
                .withDOT_EPA(getValue(ResultValues.DotEpa))
                .withImporterRegistrationFee(getValue(ResultValues.ImporterRegistrationFee))
                .withOnetimePAPSExemption(getValue(ResultValues.OneTimePAPSExemption))
                .withAdministrationFee(getValue(ResultValues.AdministrationFee))
                .withGrandTotalFees(getValue(ResultValues.GrandTotalFees));
        quote.add(quoteCAData);
        System.out.println("quote" + quote);
        return quote;
    }

    public String getValue(ResultValues values) {
        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tax-name col-lg-9 col-xs-7'])[1]")));

            WebElement elementLocator = driver.findElement(locatorFactory(values));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementLocator);

            return elementLocator.getText().replaceAll("[$]|[CA$]", "");
        } catch (Exception e) {
            System.out.println(values + " Field not found");
        }

        return "0.00";
    }

    private By locatorFactory(ResultValues values) {
        switch (values) {
            case Value:
                return valuePay;
            case ExchangeRate:
                return exchangeRate;
            case ValueForCustoms:
                return valueForCustoms;
            case AES:
                return AES;
            case RIV:
                return RIV;
            case AC:
                return AC;
            case Form1:
                return Form1;
            case CustomsDuties:
                return customsDuties;
            case CustomsMPF:
                return customsMPF;
            case CustomsHMF:
                return customsHMF;
            case CustomsISF:
                return customsISF;
            case ClassificationFee:
                return classificationFee;
            case DutyDisbursementFee:
                return dutyDisbursementFee;
            case EManifest:
                return eManifest;
            case CustomsGST:
                return customsGST;
            case CustomsPST:
                return customsPST;
            case CustomsHST:
                return customsHST;
            case CustomsQST:
                return customsQST;
            case CustomsClearance:
                return customsClearance;
            case CustomsClearanceGST:
                return customsClearanceGST;
            case CustomsClearancePST:
                return customsClearancePST;
            case CustomsClearanceHST:
                return customsClearanceHST;
            case CustomsClearanceQST:
                return customsClearanceQST;
            case EntryFee:
                return entryFee;
            case Bond:
                return bond;
            case BondUnderwritingFee:
                return bondUnderwritingFee;
            case NAFTA:
                return NAFTA;
            case ABIFee:
                return ABIFee;
            case DotEpa:
                return DOT_EPA;
            case ImporterRegistrationFee:
                return importerRegistrationFee;
            case OneTimePAPSExemption:
                return oneTimePAPSExemption;
            case AdministrationFee:
                return administrationFee;
            case GrandTotalFees:
                return grandTotalFees;
        }
        return null;
    }
}
