package com.testinium.Base;

import com.testinium.ConstantsValues;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    public String baseUrl = "http://www.hepsiburada.com";
    public void setUp()  throws  Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--start-maximized");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, co);

        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
}
