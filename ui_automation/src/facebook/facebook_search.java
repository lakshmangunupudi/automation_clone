/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

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
public class facebook_search implements executeFunctionality{

    AppiumWebDriver appiumWebDriver;

    public facebook_search(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application  facebook
        appiumWebDriver = new AppiumWebDriver("com.facebook.katana","com.facebook.katana.LoginActivity",udID);
        
        appiumWebDriver.getAppiumDriver();
    }

    //this method is to play songs of different channels 
    private void searchFacebook() throws Exception {

       
        
       
            appiumWebDriver.findElementAndPerformAction("id", "notifications_tab", "click", "Clicked on like of facebook post", 1000);
            appiumWebDriver.scrollScreenVertical(5);
            
            appiumWebDriver.backScreen(1, 100);
            
            appiumWebDriver.findElementAndPerformAction("id", "search_box", "click", "Search  on facebook post", 1000);
            
            appiumWebDriver.keyStroke = "sachin tendulkar";
            appiumWebDriver.findElementAndPerformAction("id", "search_box", "typeText", "commenting  on facebook post", 3000);
            
            appiumWebDriver.findElementAndPerformAction("contentDesc", "sachin tendulkar", "click", "Clicked on sachin tendulkar of facebook search", 2000);
            appiumWebDriver.scrollScreenVertical(5);
            
            (new WebDriverWait(appiumWebDriver.appiumDriver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.className("android.view.ViewGroup"))).click();
            appiumWebDriver.scrollScreenVertical(5);
        }   
           
   
    /**
     *
     */
    @Override
    public void execute() {

        try {

            appiumWebDriver.scrollScreenVertical(5);
            
            this.searchFacebook();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in Facebook search Execution");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        }
        finally
        {
            appiumWebDriver.appiumDriver.closeApp();
            appiumWebDriver.closeDriver();
        }
    }
}