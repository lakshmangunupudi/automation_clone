/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookmessenger;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author lakshmangunupudi
 */
public class facebookmessanger_audio implements executeFunctionality{

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;

    public facebookmessanger_audio(String udID1,String udID2) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application facebook
        appiumWebDriver1 = new AppiumWebDriver("com.facebook.orca","com.facebook.orca.auth.StartScreenActivity",udID1);        
        appiumWebDriver1.getAppiumDriver();
        
        appiumWebDriver2 = new AppiumWebDriver("com.facebook.orca","com.facebook.orca.auth.StartScreenActivity",udID2);        
        appiumWebDriver2.getAppiumDriver();
        
    }

    //this method is to play songs of different channels 
    private void facebookAudioCall() throws Exception {
 
            appiumWebDriver1.keyStroke = "starent.cisco";
            appiumWebDriver1.findElementAndPerformAction("text", "Search", "typeText", "Clicked on search fot starent cisco facebook im", 2000);
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "Starent Cisco", "click", "Clicked on starent cisco of facebook im", 2000);
        
        
            appiumWebDriver2.keyStroke = "cisconath.starent";
            appiumWebDriver2.findElementAndPerformAction("text", "Search", "typeText", "Clicked on search fot cisconath.starent facebook im", 2000);
            appiumWebDriver2.findElementAndPerformAction("contentDesc", "Cisconath Starent", "click", "Clicked on cisconath.starent of facebook im", 2000);
        
           
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "Voice call", "click", "Clicked on  audio call  icon of facebook im", 7000);
            
            (new WebDriverWait(appiumWebDriver2.appiumDriver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.ImageButton"))).get(1).click();

            Thread.sleep(10000);
            appiumWebDriver1.scrollScreenVerticalDown(1, 0);
            appiumWebDriver2.findElementAndPerformAction("contentDesc", "End call", "click", "Clicked on end call icon of facebook im", 2000);
            (new WebDriverWait(appiumWebDriver1.appiumDriver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.Button"))).get(0).click();
            (new WebDriverWait(appiumWebDriver2.appiumDriver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.Button"))).get(0).click();

            
        
            appiumWebDriver2.findElementAndPerformAction("contentDesc", "Voice call", "click", "Clicked on camera icon of facebook im", 7000);
            
            (new WebDriverWait(appiumWebDriver1.appiumDriver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.ImageButton"))).get(1).click();

            Thread.sleep(10000);
            appiumWebDriver1.scrollScreenVerticalDown(1, 0);
            appiumWebDriver2.findElementAndPerformAction("contentDesc", "End call", "click", "Clicked on camera of facebook im", 2000);
            (new WebDriverWait(appiumWebDriver1.appiumDriver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.Button"))).get(0).click();
            (new WebDriverWait(appiumWebDriver2.appiumDriver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.Button"))).get(0).click();
       
        }   
           
   
    /**
     *
     */
    @Override
    public void execute() {

        try {
  
            this.facebookAudioCall();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in Facebook audio Execution");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        }
        finally
        {
            appiumWebDriver1.appiumDriver.closeApp();
            appiumWebDriver1.closeDriver();
            appiumWebDriver2.appiumDriver.closeApp();
            appiumWebDriver2.closeDriver();
        }
    }
}