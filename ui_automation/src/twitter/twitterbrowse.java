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
public class twitterbrowse implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;

    public twitterbrowse(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application twitter
        appiumWebDriver = new AppiumWebDriver("com.twitter.android", "com.twitter.android.StartActivity", udID);
        //appium driver
        appiumWebDriver.getAppiumDriver();
    }

    //this method is to play songs of different channels 
    private void browseTwitterHomePage() {

        try {

            //This is to scroll  up for few iterations so that we can generate twitter home page traffic 
            appiumWebDriver.scrollScreenVertical(10);
            //This is to scroll  down for few iterations so that we can generate twitter home page traffic 
            //appiumWebDriver.scrollScreenVerticalDown(10, 1000);
            Thread.sleep(1000);

            //Here we are commenting and retweeting also liking the post , upto 10 post .
            for (int i = 0; i < 2; i++) {
                appiumWebDriver.scrollScreenVertical(i);

                try {

                    //Replying to tweet
                    appiumWebDriver.findElementAndPerformAction("id", "inline_reply", "click", "Clicked on reply of twitter post", 1000);

                    appiumWebDriver.keyStroke = "latest tweet are tweeted from here";
                    appiumWebDriver.findElementAndPerformAction("id", "tweet_text", "typeText", "replying text (Latest tweet )", 1000);
                    
                    appiumWebDriver.findElementAndPerformAction("id", "button_tweet", "click", "Clicked on reply button", 1000);
                    //appiumWebDriver.backScreen(1, 5000);

                    //Here we are retweeting  the tweet
                    appiumWebDriver.findElementAndPerformAction("id", "inline_retweet", "click", "Clicked on retweet symbol", 20000);

                    appiumWebDriver.findElementAndPerformAction("osId", "text1", "click", "Clicked on retweet button", 20000);

                    //here we are clicking on like symbol
                    appiumWebDriver.findElementAndPerformAction("id", "inline_like", "click", "Clicked on like symbol", 2000);

                } catch (Exception Ex) {
                    System.out.println("Exception in Twitter browse Execution");
                    System.out.println(Ex.getMessage());
                    System.out.println(Ex.getStackTrace());

                }
            }

        } catch (Exception Ex) {

            System.out.println("Exception in Twitter browse Execution");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        }

    }

    private void browseTwitterNotifications() {
        try {
            appiumWebDriver.findElementAndPerformAction("id", "notifications", "click", "Clicked on notifications", 2000);
            //This is to scroll  up for few iterations so that we can generate twitter home page traffic 
            appiumWebDriver.scrollScreenVertical(10);
            //This is to scroll  down for few iterations so that we can generate twitter home page traffic 
            appiumWebDriver.scrollScreenVerticalDown(10, 1000);

        } catch (Exception Ex) {

            System.out.println("Exception in Twitter browse Execution");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        }

    }

    @Override
    public void execute() {

        try {

            Thread.sleep(1000);
            System.out.println("Started twitter application");
            
            this.browseTwitterHomePage();
            this.browseTwitterNotifications();
            System.out.println("Done with  twitter browse script");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception Ex) {

            System.out.println("Exception in Twitter browse Execution");
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
