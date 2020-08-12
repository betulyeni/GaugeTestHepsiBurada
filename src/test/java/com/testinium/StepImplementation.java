package com.testinium;

import com.testinium.Base.BaseTest;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {
    @BeforeScenario
    public void setUp() throws Exception{
        super.setUp();
        this.driver=super.driver;
    }
    protected  WebDriver driver;
    public static final int DEFAULT_WAIT = 20;
    public static final int MIN_WAIT = 5;
    public static final int MAX_WAIT = 20;

    @Step("<url> adresine git")
    public void openPage(String address) {
        driver.get(super.baseUrl + address);
    }


}
