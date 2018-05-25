package P2pAppiumGuiAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class AppiumWebDriver {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 14/11/2017
     * Content: This file acts as a framework for interaction with mobile phone through APPIUM Driver
     * All rights by CISCO
     *
     **/

    public AppiumDriver appiumDriver;
    public WebElement currentButton;
    public TouchAction touchAction;

    public String keyStroke = "";
    public String platformPackage;

    private String deviceName;
    private String andVer;
    private String autoName;
    private String ip;
    private String port;
    private String appPackage;
    private String appActivity;
    private String udID;

    public AppiumWebDriver(String application, String activity,String udID) {
        this.appPackage = application;
        this.appActivity = activity;
        this.udID = udID;
        this.deviceName = "Redmi";
        this.andVer = "7.1.2";
        this.autoName = "Appium";
        this.ip = "localhost";
        this.port = "4723";
        this.platformPackage = "android";
    }

    public void getAppiumDriver()
    {

        try {
            /* Appium Android Device Name is specified here */
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName",deviceName);
            capabilities.setCapability("version", andVer);
            capabilities.setCapability("automationName", autoName);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("udid",udID);
            capabilities.setCapability("newCommandTimeout",3600);

            appiumDriver = new AndroidDriver(new URL("http://" + ip + ":" + port + "/wd/hub"), capabilities);
            touchAction = new TouchAction(appiumDriver);

        } catch (Exception exp) {

            System.out.println("Exception in P2pAppiumGuiAutomation.AppiumWebDriver constructor");
            System.out.println(exp.getMessage());

        }

    }

    public void closeDriver() {
        appiumDriver.closeApp();
        appiumDriver.quit();
    }

    public void findElementAndPerformAction(String searchBy, String patternToIdentify, String actionToPerform, String stageCompleted, int delay) throws Exception {

        int startX, startY, endX, endY;

        try {
            switch (searchBy) {
                case "id":
                    currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(appPackage + ":id/" + patternToIdentify)));
                    break;
                case "osId":
                    currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(platformPackage + ":id/" + patternToIdentify)));
                    break;
                case "plainId":
                    currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(patternToIdentify)));
                    break;
                case "contentDesc":
                    currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@content-desc,'" + patternToIdentify + "')]")));
                    break;
                case "password":
                    currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@password='" + patternToIdentify +"']")));
                    break;
                case "text":
                    currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'" + patternToIdentify + "')]")));
                    break;
                case "scroll":
                    currentButton = appiumDriver.scrollToExact(patternToIdentify);
                    break;
                case "simpleScroll":
                    currentButton = appiumDriver.scrollTo(patternToIdentify);
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
                case "swipeLeft":
                    startX = currentButton.getLocation().getX() + (currentButton.getSize().getWidth()/2);
                    startY = currentButton.getLocation().getY() + (currentButton.getSize().getHeight()/2);
                    endX = startX - 300;
                    if (endX < 0) {
                        endX = 0;
                    }
                    appiumDriver.swipe(startX, startY, endX, startY,500);
                    break;
                case "swipeRight":
                    startX = currentButton.getLocation().getX() + (currentButton.getSize().getWidth()/2);
                    startY = currentButton.getLocation().getY() + (currentButton.getSize().getHeight()/2);
                    endX = startX + 300;
                    if(endX > appiumDriver.manage().window().getSize().getWidth()){
                        endX = appiumDriver.manage().window().getSize().getWidth();
                    }
                    appiumDriver.swipe(startX, startY, endX,startY,500);
                    break;
                case "swipeUp":
                    startX = currentButton.getLocation().getX() + (currentButton.getSize().getWidth()/2);
                    startY = currentButton.getLocation().getY() + (currentButton.getSize().getHeight()/2);
                    endY = startY - 300;
                    if (endY < 0) {
                        endY = 0;
                    }
                    appiumDriver.swipe(startX, startY,startX, endY,1000);
                    break;
                case "swipeUpShakingButton":
                    startX = currentButton.getLocation().getX();
                    startY = currentButton.getLocation().getY();
                    endY = startY - 300;
                    if (endY < 0) {
                        endY = 0;
                    }
                    appiumDriver.swipe(startX, startY,startX, endY,1000);
                    break;
                case "swipeDown":
                    startX = currentButton.getLocation().getX() + (currentButton.getSize().getWidth()/2);
                    startY = currentButton.getLocation().getY() + (currentButton.getSize().getHeight()/2);
                    appiumDriver.swipe(startX, startY, startX,startY + 300,1000);
                    break;
                case "clickChild":
                    currentButton.findElements(By.className("android.view.View")).get(0).click();
                    break;
                case "locate":
                    break;
                default:
                    System.out.println("Unknown action for findElementAndPerformAction function: "+actionToPerform);
            }
            System.out.println("Completed Stage: "+stageCompleted);
            Thread.sleep(delay);
        } catch (Exception exp) {
            takeScreenShot();
            throw new Exception(exp);
        }
    }

    public void scrollScreenVertical(int scrollDepth) throws Exception {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int x = (int) (dimension.getWidth() * 0.5);
        int startY = (int) (dimension.getHeight() * 0.5);
        int endY = (int) (dimension.getHeight() * 0.2);

        for (int i = 0; i < scrollDepth; i++) {
            appiumDriver.swipe(x, startY, x, endY, 400);
            Thread.sleep(2000);
        }
        Thread.sleep(5000);
    }

    public void scrollScreenVerticalUp(int scrollDepth) throws Exception {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int x = (int) (dimension.getWidth() * 0.5);
        int startY = (int) (dimension.getHeight() * 0.2);
        int endY = (int) (dimension.getHeight() * 0.5);

        for (int i = 0; i < scrollDepth; i++) {
            appiumDriver.swipe(x, startY, x, endY, 400);
            Thread.sleep(2000);
        }
        Thread.sleep(5000);
    }

     //this method is to scroll down the current scree for  N number of times with some delay 
    public void scrollScreenVerticalDown(int scrollDepth,int delay) throws Exception {
        //currecnt window size and then get location from there try to swipe up .
        Dimension dimension = appiumDriver.manage().window().getSize();
        int x = (int) (dimension.getWidth() * 0.5);
        int startY = (int) (dimension.getHeight() * 0.2);
        int endY = (int) (dimension.getHeight() * 0.5);

        for (int i = 0; i < scrollDepth; i++) {
            appiumDriver.swipe(x, startY, x, endY, 400);
            Thread.sleep(delay);
        }
    }

    public void swipeWebelementLeftNtimes(String searchBy, String patternToIdentify, int scrollLeft, int delay) throws InterruptedException, Exception
    {
        this.findElementAndPerformAction(searchBy, patternToIdentify, "locate", "Swiping  Left", 1000);
        int startX = this.currentButton.getLocation().getX() + (currentButton.getSize().getWidth()/2);
        int startY = this.currentButton.getLocation().getY() + (currentButton.getSize().getHeight()/2);
        int endX = startX - 300;
        if (endX < 0) {
            endX = 0;
        }
        for (int startleft = 0; startleft < scrollLeft; startleft++) {
            appiumDriver.swipe(startX, startY, endX, startY,500);
            Thread.sleep(delay);
        }
    }

    public void swipeWebelementRightNtimes(String searchBy, String patternToIdentify, int scrollRight, int delay) throws InterruptedException, Exception
    {
        this.findElementAndPerformAction(searchBy, patternToIdentify, "locate", "Clicked on swipeRight", 1000);
        int startX = this.currentButton.getLocation().getX() + (currentButton.getSize().getWidth()/2);
        int startY = this.currentButton.getLocation().getY() + (currentButton.getSize().getHeight()/2);
        int endX = startX + 300;
        if (endX > appiumDriver.manage().window().getSize().getWidth()) {
            endX = appiumDriver.manage().window().getSize().getWidth();
        }
        for (int startRight = 0; startRight < scrollRight; startRight++) {
            appiumDriver.swipe(startX, startY, endX,startY,500);
            Thread.sleep(delay);
        }
    }

    public void backScreen(int index, int delay) throws Exception {
        for (int count = 1; count <= index; count++) {
            appiumDriver.navigate().back();
            Thread.sleep(delay);
        }
    }

    public void closeAlert(String patternToIdentify) {
        try {
            currentButton = (new WebDriverWait(appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(appPackage + ":id/" + patternToIdentify)));
            backScreen(1,3000);
        } catch (Exception exp) {
            System.out.println("Alert Message not seen");
        }
    }

    public void takeScreenShot() {
        try {

            File scrFile = appiumDriver.getScreenshotAs(OutputType.FILE);
            Thread.sleep(2000);
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
            String destDir = "screenshots";
            new File(destDir).mkdirs();
            String destFile = this.appPackage + "-" + dateFormat.format(new Date()) + ".png";
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
            Thread.sleep(2000);
            System.out.println("Screen shot saved to " + destFile + " at " + destDir);

        } catch (Exception exp) {
            System.out.println("Exception in takeScreenShot function");
            System.out.println(exp.getMessage());
        }
    }
    

    public boolean findElementByID(String id,int depth) throws Exception
    {
        for(int i=0;i<depth;i++)
        {
            try{
                
               this.findElementAndPerformAction("id",id, "locate","Found  given webelement ID",100);
                return true;
            }
            catch (Exception exp) {
              this.scrollScreenVertical(1);      
        }  
         
        }
           return false;
        
    }
    
    
}
