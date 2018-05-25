/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class twittersearch implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;

    public twittersearch(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application  twitter application
        appiumWebDriver = new AppiumWebDriver("com.twitter.android", "com.twitter.android.StartActivity", udID);
        //appium driver
        appiumWebDriver.getAppiumDriver();
    }

    //this method is to play songs of different channels 
    private void searchTwitterHomePage() throws Exception {

       

            appiumWebDriver.findElementAndPerformAction("id", "moments", "click", "Clicked on search of twitter post", 3000);

            appiumWebDriver.findElementAndPerformAction("id", "trend_title", "click", "searching latest trend", 5000);
            
            
            //Here I am searching different items like top,latest,people,photos,videos,news,periscope
            for (int i=0;i<7;i++){
                    //This is to scroll  up for few iterations so that we can generate twitter home page traffic 
                    appiumWebDriver.scrollScreenVertical(20);
                    //This is to scroll  down for few iterations so that we can generate twitter home page traffic 
                    appiumWebDriver.scrollScreenVerticalDown(20, 1000);
                    appiumWebDriver.findElementAndPerformAction("id", "dock", "swipeLeft", "swiping to next seacrh in twitter", 500);
                    Thread.sleep(1000);
            }
            
            
            appiumWebDriver.backScreen(1, 1000);
        

    }

    @Override
    public void execute() {

        try {

            System.out.println("Started twitter search script");

            this.searchTwitterHomePage();
            System.out.println("Done with  twitter search script");
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

        } catch (Exception Ex) {

            System.out.println("Exception in Twitter search Execution");
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
