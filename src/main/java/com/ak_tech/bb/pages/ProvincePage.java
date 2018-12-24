package com.ak_tech.bb.pages;

import com.ak_tech.bb.appmanager.HelperBase;
import com.ak_tech.bb.enums.Events;
import com.ak_tech.bb.enums.Province;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class ProvincePage extends HelperBase {
    public ProvincePage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    //Province Xpath
    private By allProvince = By.xpath("//button[@class='btn btn-round btn-white btn-small bold']");
    private By Alberta = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[1]");
    private By BritishColumbia = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[2]");
    private By Manitoba = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[3]");
    private By NewBrunswick = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[4]");
    private By NewfoundlandLabrador = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[5]");
    private By NorthwestTerritories = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[6]");
    private By NovaScotia = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[7]");
    private By Nunavut = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[8]");
    private By Ontario = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[9]");
    private By PrinceEdwardIsland = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[10]");
    private By Quebec = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[11]");
    private By Saskatchewan = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[12]");
    private By Yukon = By.xpath("(//button[@class='btn btn-round btn-white btn-small bold'])[13]");
    private By continueButton = By.xpath("//input[@value='Continue']");


    public void chooseProvince(Province province) {
        switch (province) {
            case Alberta:
                clickAndContinue(Alberta);
                break;
            case BritishColumbia:
                clickAndContinue(BritishColumbia);
                break;
            case Manitoba:
                clickAndContinue(Manitoba);
                break;
            case NewBrunswick:
                clickAndContinue(NewBrunswick);
                break;
            case NewfoundlandAndLabrador:
                clickAndContinue(NewfoundlandLabrador);
                break;
            case NorthwestTerritories:
                clickAndContinue(NorthwestTerritories);
                break;
            case NovaScotia:
                clickAndContinue(NovaScotia);
                break;
            case Nunavut:
                clickAndContinue(Nunavut);
                break;
            case Ontario:
                clickAndContinue(Ontario);
                break;
            case PrinceEdwardIsland:
                clickAndContinue(PrinceEdwardIsland);
                break;
            case Quebec:
                clickAndContinue(Quebec);
                break;
            case Saskatchewan:
                clickAndContinue(Saskatchewan);
                break;
            case Yukon:
                clickAndContinue(Yukon);
                break;
        }
        CommonPage.events.put(Events.Province, province);
    }
}
