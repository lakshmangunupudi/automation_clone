
/**
 *
 * Author: Rajasekar S <rajassub@cisco.com>
 * Created On: 14/11/2017
 * Content: This file acts as a framework for interaction with mobile phone through APPIUM Driver
 * All rights by CISCO
 *
 **/

package git_clone;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class AppiumWebDriver {

    AppiumDriver appiumDriver;
    DesiredCapabilities capabilities;
    WebElement currentButton;
    Dimension dimension;
    TouchAction touchAction;

    String deviceName;
    String andVer;
    String autoName;
    String ip;
    String port;
    String keyStroke;
    String appPackage;
    String appActivity;
    String platformPackage;
    String udID;

    AppiumWebDriver(String application, String activity,String udID) {
        this.appPackage = application;
        this.appActivity = activity;
        this.udID = udID;
        this.deviceName = "Redmi";
        this.andVer = "7.1.2";
        this.autoName = "Appium";
        this.ip = "localhost";
        this.port = "4723";
        this.platformPackage = "Android";
    }

    public void getAppiumDriver()
    {

        try {
            /* Appium Android Device Name is specified here */
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName",deviceName);
            capabilities.setCapability("version", andVer);
            capabilities.setCapability("automationName", autoName);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("udid",udID);
            capabilities.setCapability("newCommandTimeout",300);

            appiumDriver = new AndroidDriver(new URL("http://" + ip + ":" + port + "/wd/hub"), capabilities);
            touchAction = new TouchAction(appiumDriver);

        } catch (Exception exp) {

            System.out.println("Exception in AppiumWebDriver constructor");
            System.out.println(exp.getMessage());
            System.out.println(exp.getStackTrace());

        }


    }

    protected void closeDriver() {
        appiumDriver.closeApp();
        appiumDriver.quit();
    }

    protected void findElementAndPerformAction(String searchBy, String patternToIdentify, String actionToPerform, String stageCompleted) throws Exception {

        int startX, startY, endX, endY;
        System.out.println("Search option for findElementAndPerformAction function: "+searchBy);
        try {
            //Taking instance of webdriver element which can be used to perform actions and wait time is 60
            WebDriverWait Webdriver = new WebDriverWait(appiumDriver, 60);
            
            switch (searchBy) {
                case "id":
                    currentButton = Webdriver.until(ExpectedConditions.presenceOfElementLocated(By.id(appPackage + ":id/" + patternToIdentify)));
                    break;
                case "osId":
                    currentButton = Webdriver.until(ExpectedConditions.presenceOfElementLocated(By.id(platformPackage + ":id/" + patternToIdentify)));
                    break;
                case "contentDesc":
                    currentButton = Webdriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'" + patternToIdentify + "')]")));
                    break;
                case "password":
                    currentButton = Webdriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@password='" + patternToIdentify +"']")));
                    break;
                case "text":
                    currentButton = Webdriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'" + patternToIdentify + "')]")));
                    break;
                case "scroll":
                    currentButton = appiumDriver.scrollToExact(patternToIdentify);
                    break;
                case "accessId":
                    currentButton = appiumDriver.findElementByAccessibilityId(patternToIdentify);
                    break;
                default:
                    System.out.println("Unknown option for findElementAndPerformAction function: "+searchBy);
            }
            switch (actionToPerform) {
                
                case "click":
                    currentButton.click();
                    break;
                case "typeText":
                    currentButton.sendKeys(keyStroke);
                    break;
                case "record":
                    touchAction.longPress(currentButton, 4000).release().perform();
                    break;
            
                //Taking center point of web element so that for actions like left , right, up and down it is advisable to use center point
                case "swipeLeft":
                    startX = currentButton.getLocation().getX()+currentButton.getSize().getWidth()/2;
                    startY = currentButton.getLocation().getY()+currentButton.getSize().getHeight()/2;
                    endX = startX - 300;
                    if (endX < 0) {
                        endX = 0;
                    }
                    appiumDriver.swipe(startX, startY, endX, startY,500);
                    break;
                case "swipeRight":
                    startX = currentButton.getLocation().getX()+currentButton.getSize().getWidth()/2;
                    startY = currentButton.getLocation().getY()+currentButton.getSize().getHeight()/2;
                    appiumDriver.swipe(startX, startY, startX + 300,startY,500);
                    break;
                case "swipeUp":
                    startX = currentButton.getLocation().getX()+currentButton.getSize().getWidth()/2;
                    startY = currentButton.getLocation().getY()+currentButton.getSize().getHeight()/2;
                    endY = startY - 300;
                    if (endY < 0) {
                        endY = 0;
                    }
                    appiumDriver.swipe(startX, startY,startX, endY,1000);
                    break;
                case "swipeDown":
                    startX = currentButton.getLocation().getX()+currentButton.getSize().getWidth()/2;
                    startY = currentButton.getLocation().getY()+currentButton.getSize().getHeight()/2;
                    appiumDriver.swipe(startX, startY, startX,startY + 300,1000);
                    break;

                case "clickChild":
                    currentButton.findElements(By.className("android.view.View")).get(0).click();
                    break;
                default:
                    System.out.println("Unknown action for findElementAndPerformAction function: "+actionToPerform);
            }
            System.out.println("Completed Stage: "+stageCompleted);
        } catch (Exception exp) {
            System.out.println("Exception in findElementAndPerformAction function");
            System.out.println(exp.getMessage());
            System.out.println(exp.getStackTrace());
            throw new Exception(exp);
        }
    }

    protected void scrollScreenVertical(int scroolDepth) throws Exception {
        dimension = appiumDriver.manage().window().getSize();
        int x = (int) (dimension.getWidth() * 0.5);
        int startY = (int) (dimension.getHeight() * 0.5);
        int endY = (int) (dimension.getHeight() * 0.2);

        for (int i = 0; i < scroolDepth; i++) {
            appiumDriver.swipe(x, startY, x, endY, 400);
            Thread.sleep(2000);
        }

    }

    protected void backScreen() throws Exception {
        appiumDriver.navigate().back();
        Thread.sleep(100);
    }

    protected void closeAlert(String patternToIdentify) {
        try {
            currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(appPackage + ":id/" + patternToIdentify)));
            backScreen();
        } catch (Exception exp) {
            System.out.println("Alert Message not seen");
        }
    }
}
