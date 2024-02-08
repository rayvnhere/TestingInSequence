package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.PageInitializer.initializePageObjects;

public class CommonMethods extends PageInitializer{
    public static WebDriver driver; // is an interface
    public  void openBrowserAndLaunchApplication() {
//removed static cuz if want to create the instance of the class, if want to use the method
//no use of static when there's inheritance (commonMethod Parent)
//In inheritance we don’t have static methods, we just have methods
        switch (ConfigReader.read("browser")){
            case "Chrome":
                driver=new ChromeDriver();
                break;
            case "FireFox":
                driver=new FirefoxDriver();
                break;
            case "Edge":
                driver=new EdgeDriver();
                break;
            case "Safari":
                driver= new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
        //this method will call ALL objects
    }

    //
    public  void closeBrowser() {
        if(driver!= null) {
            driver.quit();
        }
    }

    public   void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }

    public  void selectFromDropDown(WebElement dropDown, String visibleText){
        Select sel =new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }
    public  void selectFromDropDown(String value, WebElement dropDown ){
        Select sel =new Select(dropDown);
        sel.selectByValue(value);
    }
    public  void selectFromDropDown( WebElement dropDown,int index ){
        Select sel =new Select(dropDown);
        sel.selectByIndex(index);
    }

    // below 3 click methods are connected to each other
    public WebDriverWait getwait(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return  wait;
    }
    public  void waitForElementToBeClickAble(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public  void click(WebElement element){
        waitForElementToBeClickAble(element);
        element.click();
    }


    //if .click doesnt work then can use JSExecutor method
    public JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
//this return will help to send data, highlight the element, click operation
    }
    public void jsClick(WebElement element){//this parameter cuz I want to perform clickOperation for all webelments
//now with the concept polyMorphism of mehthodOverridding, can use this method everywhere

        getJSExecutor().executeScript("arguments[0].click();",element); //element is any elementOfDom
    }
}
