package com.ak_tech.bb.appmanager;

import com.ak_tech.bb.calculatorLogic.CalculatorCA;
import com.ak_tech.bb.calculatorLogic.CalculatorUSA;
import com.ak_tech.bb.calculatorLogic.RateParser;
import com.ak_tech.bb.pages.CommonPage;
import com.ak_tech.bb.pages.ContentsPage;
import com.ak_tech.bb.pages.ProvincePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver driver;
    WebDriverWait wait;
    public HelperBase helperBase;
    private String browser;
    private QuoteHelper quoteHelper;
    private NavigationHelper navigationHelper;
    private CommonPage commonPage;
    private ProvincePage provincePage;
    private ContentsPage contentsPage;
    private CalculatorCA calculatorCA;
    private CalculatorUSA calculatorUSA;
    private RateParser rateParser;
    private ContentHelper contentHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        this.properties = new Properties();
    }

    protected void init() throws IOException {
        String target = System.getProperty("target", "config");
        properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));

        if (browser.equals(BrowserType.CHROME)) {                        //        System.setProperty("webdriver.chrome.driver", "path/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {               //        System.setProperty("webdriver.gecko.driver", "path/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        this.wait = new WebDriverWait(driver, 4);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
//            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Don't drag&drop browser window");
        }

        driver.get(properties.getProperty("web.baseUrl"));
        helperBase = new HelperBase(driver, wait, properties);
        navigationHelper = new NavigationHelper(driver, wait, properties);
        quoteHelper = new QuoteHelper(driver, wait, properties);
        commonPage = new CommonPage(driver, wait, properties);
        contentsPage = new ContentsPage(driver, wait, properties);
        provincePage = new ProvincePage(driver, wait, properties);
        calculatorCA = new CalculatorCA();
        calculatorUSA = new CalculatorUSA();
        rateParser = new RateParser(properties);
        contentHelper = new ContentHelper(driver, wait, properties);
    }

    protected void stop() {
        driver.quit();
    }

    public CommonPage navigate() {
        return commonPage;
    }

    public QuoteHelper quoteHelper() {
        return quoteHelper;
    }

    public ProvincePage provincePage() {
        return provincePage;
    }

    public HelperBase helperBase() {
        return helperBase;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContentsPage contentsPage() {
        return contentsPage;
    }

    public CalculatorCA calculatorCA() {
        return calculatorCA;
    }

    public CalculatorUSA calculatorUSA() {
        return calculatorUSA;
    }

    public RateParser rateParser() {
        return rateParser;
    }

    public ContentHelper contentHelper() {
        return contentHelper;
    }
}
