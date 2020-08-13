package com.testinium;

import com.testinium.Base.BaseTest;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.MessageDigest;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class StepImplementation extends BaseTest {

    public static final int DEFAULT_WAIT = 20;
    public static final int MIN_WAIT = 5;
    public static final int MAX_WAIT = 20;
    protected WebDriver driver;
    private int id;
    private String element;
    private int rndNumber = 0;
    private int rndMarka = 0;
    private int rndUrun = 0;

    public static String Md5(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] byteData = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }

    @BeforeScenario
    public void setUp() throws Exception {
        super.setUp();
        this.driver = super.driver;
    }

    @Step("<ulr> adresine git")
    public void openPage(String address) {
        driver.get(super.baseUrl + address);
    }

    @Step("<text> yazisina tikla")
    public WebElement clickText(String text) {
        WebElement element = getElementBy(By.xpath("//*[contains(text(), '" + text + "')]"));
        element.click();
        return element;
    }

    @Step("ekranda <id> id nesnesini gormen gerekiyor")
    public void objectControl(String id) {
        getElementBy(By.id(id));


    }


    @Step("ekranda <id> id nesnesini gormen gerekiyor")
    public void objectContro1(String id) {
        getElementBy(By.xpath(id)).getAttribute("originalPrice");

    }


    public String urunEkle() throws InterruptedException {
        elementTikla(By.cssSelector("div.OldMyAccount-1BFaN > a"));
        elementTikla(By.cssSelector("div > button.increase"));
        Thread.sleep(3000);
        elementTikla(By.cssSelector("div > button.increase"));
        Thread.sleep(3000);
        return findElement(By.cssSelector(" div:nth-child(1) > p > span")).getText();
    }

    @Step("The number is increased by 2.")
    public void urunArttır() throws InterruptedException {
        String number = urunEkle();
        Assert.assertEquals(number , "3 ürün");
    }

    public WebElement submitObjectBy(By by) {
        WebElement element = getElementBy(by);
        element.submit();
        return element;
    }

    protected void scrollTo(int x, int y) {
        String jsStmt = String.format("window.scrollTo(%d, %d);", x, y);
        executeJS(jsStmt, true);
    }

    protected Object executeJS(String jsStmt, boolean wait) {
        return wait ? getJSExecutor().executeScript(jsStmt, "") : getJSExecutor().executeAsyncScript(jsStmt, "");
    }

    protected JavascriptExecutor getJSExecutor() {

        return (JavascriptExecutor) driver;
    }

    public WebElement setObjectBy(By by, String value) {

        WebElement element = getElementBy(by);
        element.clear();
        element.sendKeys(value);
        return element;
    }


    @Step("<id> id alanina <value> yaz")
    public WebElement setObjectById(String id, String value) {

        return setObjectBy(By.id(id), value);
    }


    @Step("<xpath> xpath alanina <value> yazdin")
    public WebElement setObjectByXpath(String xpath, String value) {

        return setObjectBy(By.xpath(xpath), value);
    }

    @Step("<xpath> className alanina <value> yazdin")
    public WebElement setObjectByClassName(String className, String value) {
        return setObjectBy(By.xpath(className), value);
    }

    @Step("<by> seçiminiz <value>")
    public WebElement selectValueObjectBy(By by, String value) {
        WebElement element = getElementBy(by);
        new Select(element).selectByVisibleText(value);
        return element;
    }


    public WebElement selectIndexObjectById(String name, int index) {
        WebElement element = driver.findElement(By.id(name));
        new Select(element).selectByIndex(index);
        return element;
    }

    @Step("<id> id nesnesine tikla")
    public WebElement clickObjectById(String id) {

        return clickObjectBy(By.id(id));
    }


    @Step("Login kontrol <text> ")
    public void kontrol(String text) {
        String a;
        a = By.xpath("//*[@id=\"myAccount\"]/span/a/span[2]").toString();
        if (a == text) {
            getElementBy(By.id("shoppingCart")).click();
        }

    }

    public void rndNumber(String className) {

        List<WebElement> elementList = driver.findElements(By.className(className));
        int size = elementList.size();
        rndNumber = new Random().nextInt(size);
        WebElement element = elementList.get(rndNumber);
        element.click();

    }

    @Step("Rastgele bir kategori ve alt kategori seçme")
    public void selectCategory() {
        rndNumber("MenuItems-1-U3X");
        waitSeconds(4);
        if (rndNumber == 0) {
            rndNumber("ChildMenuItems-3m2LI");
            rndNumber("ChildMenuItems-3R6bj");
        } else {
            rndNumber("ChildMenuItems-aeXwv");
        }

    }
    public void rndNumber1(String xpath){

        List<WebElement> elementList1 = driver.findElements(By.className(xpath));
        int size = elementList1.size();
        rndMarka= new Random().nextInt(size);
        WebElement element1 = elementList1.get(rndMarka);
        element1.click();


    }
    @Step("Rastgele Marka seç")
    public void selectCategory1() {
        rndNumber1("show-all-brands");
        waitSeconds(4);

        }

    public void rndNumber2(String xpath){

        List<WebElement> elementList1 = driver.findElements(By.className(xpath));
        int size = elementList1.size();
        rndUrun= new Random().nextInt(size);
        WebElement element1 = elementList1.get(rndUrun);
       System.out.println(element1.getAttribute("price"));
        element1.click();


    }

    public void degerGonder(By by, String text) {

        findElement(by).clear();
        findElement(by).sendKeys(text);
    }

    public void fiyatAraligi(String min ,String max)
    {
        degerGonder(By.cssSelector("li.box-container.fiyat  div:nth-child(1) > input"),min);
        degerGonder(By.cssSelector(" li.box-container.fiyat  div:nth-child(3) > input"),max);
        elementTikla(By.cssSelector("li.box-container.fiyat  div.range-contain-row.right > button"));
    }

    @Step("Fiyat aralığı <min> , <max>")
    public void fiyatAraligiStep(String min , String max)
    {
        fiyatAraligi(min,max);
    }

    public void elementTikla(By by) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    @Step("Rastgele Urun seç")
    public void selectCategory2() {
        rndNumber2("carousel-lazy-item");
        waitSeconds(4);

    }

    @Step("Mouse over")
    public void mouseOver() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"myAccount\"]"));
        action.moveToElement(we).build().perform();
    }

    @Step("<css> className nesnesine tikla")
    public WebElement clickObjectByClassName(String className) {
        return clickObjectBy(By.className(className));
    }

    @Step("<xpath> xpath nesnesine tikla")
    public WebElement clickObjectByXpath(String xpath) {
        return clickObjectBy(By.xpath(xpath));
    }
    @Step("Ürün Fiyat Karşılastırma <ilksayfa>,<detaySayfa>")
    public void urundeger(String ilksayfa,String detaySayfa){
        getElementsBy(By.className(ilksayfa));
        getElementsBy(By.className(detaySayfa));

    }
    //price product-price

    //originalPrice

    @Step("<id> id nesnesi varsa tikla")
    public WebElement clickObjectIfExist(String id) {
        if (isExistElement(3, By.id(id)))
            return clickObjectById(id);
        return null;

    }

    public WebElement clickObjectBy(By by) {
        WebElement element = getElementBy(by);
        element.click();
        return element;
    }

    public WebElement getElementBy(By by) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public WebElement getElementById(String id) {
        return getElementBy(By.id(id));
    }

    public WebElement getElementByClassName(String className) {
        return getElementBy(By.className(className));
    }

    public List<WebElement> getElementsBy(By by) {
        return driver.findElements(by);
    }

    public List<WebElement> getElementsById(String id) {
        return getElementsBy(By.id(id));
    }

    public List<WebElement> getElementsByCss(String css) {
        return getElementsBy(By.cssSelector(css));
    }

    public List<WebElement> getElementsByClassName(String className) {
        return getElementsBy(By.className(className));
    }

    public List<WebElement> getSelectOptionListById(String id) {
        Select select = new Select(getElementBy(By.id(id)));
        return select.getOptions();
    }

    public List<WebElement> getSelectOptionListByName(String name) {
        Select select = new Select(getElementBy(By.name(name)));
        return select.getOptions();
    }

    public boolean isDisplayBy(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public boolean isDisplayByPassException(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayById(String id) {
        try {
            return driver.findElement(By.id(id)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayByCss(String css) {
        return driver.findElement(By.cssSelector(css)).isDisplayed();
    }

    public boolean isDisplayByName(String name) {
        return driver.findElement(By.name(name)).isDisplayed();
    }

    public boolean isDisplayByClassName(String className) {
        return driver.findElement(By.className(className)).isDisplayed();

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl().trim();
    }

    public void goBack() {
        driver.navigate().back();
    }

    @Step("\"<time>\" ms bekle")
    public void sleep(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public void moveMouse(By by, By validateDisplayWebObject, int count) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        int i = 0;
        do {
            WebElement we = driver.findElement(by);
            Locatable hoverItem = (Locatable) we;
            Mouse mouse = ((HasInputDevices) driver).getMouse();
            mouse.mouseMove(hoverItem.getCoordinates());
            sleep(1000);
            if (count == i++)
                break;
        } while (!isDisplayByPassException(validateDisplayWebObject));

    }

    public void moveMouseWithJQuery(String id, By validateDisplayWebObject, int count) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

        int i = 0;
        do {
            ((JavascriptExecutor) driver).executeScript("$('" + id + "').mouseover();");
            sleep(1000);
            if (count == i++)
                break;
            System.out.println(i + ". mouseover deneme...");
        } while (!isDisplayByPassException(validateDisplayWebObject));

    }

    public void moveMouseWithJavascript(String id, By validateDisplayWebObject, int count) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

        int i = 0;
        do {
            ((JavascriptExecutor) driver).executeScript("$('" + id + "').mouseover();");
            String strJavaScript = "var element = arguments[0];"
                    + "var mouseEventObj = document.createEvent('MouseEvents');"
                    + "mouseEventObj.initEvent( 'mouseover', true, true );"
                    + "element.dispatchEvent(mouseEventObj);";

            executeJavascript(strJavaScript, getElementBy(By.id(id)));
            sleep(1000);
            if (count == i++)
                break;
            System.out.println(i + ". mouseover deneme...");
        } while (!isDisplayByPassException(validateDisplayWebObject));


    }

    public void executeJavascript(String script, Object... obj) {
        ((JavascriptExecutor) driver).executeScript(script, obj);
    }

    public void callPage(String page) {
        driver.get(getCurrentUrl() + page);
    }

    public boolean isTextPresent(By by, String text) {
        try {
            return driver.findElement(by).getText().contains(text);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isTextPresent(String text) {
        try {
            return driver.getPageSource().contains(text);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(By by, WebElement element) {
        try {
            element.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean areElementsPresent(By by) {
        try {
            driver.findElements(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresentAndDisplay(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresentAndDisplay(By by, WebElement element) {
        try {
            return element.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void javaScriptClicker(WebDriver driver, WebElement element) {

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);
    }

    public void waitForElement(WebDriver driver, int seconds, By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, seconds, 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    public boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public Object getRandomContent(List<?> contentList) {
        Random rand = new Random();
        int n = rand.nextInt(contentList.size());
        return contentList.get(n);
    }


    public boolean isExistElement(int sec, By by) {
        try {
            waitForElement(sec, by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitForElement(int seconds, By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, seconds, 1000);
        return wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    public List<WebElement> waitForElements(int seconds, By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, seconds, 30);
        List<WebElement> element = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(elementBy));
        return element;
    }


    protected boolean isElementDisplayedWait(By by, int waitTime) {
        try {
            return waitForElementPresent(by, waitTime).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitForElementPresent(By by, int timeOutInSeconds) {
        WebElement element;
        try {
            WebDriverWait waitSeconds = (WebDriverWait) new WebDriverWait(driver, timeOutInSeconds)
                    .ignoring(NoSuchElementException.class);
            element = waitSeconds.until(ExpectedConditions.presenceOfElementLocated(by));
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void untilElementAppear(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void selectOptionClick(By by, String value) {
        Select dropdown = new Select(findElement(by));
        dropdown.selectByVisibleText(value);
    }

    public WebElement findElement(By by, int... index) {
        return driver.findElement(by);
    }

    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
