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
public class twitteruploadweets implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;

    public twitteruploadweets(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application twitter
        appiumWebDriver = new AppiumWebDriver("com.twitter.android", "com.twitter.android.StartActivity", udID);
        //appium driver
        appiumWebDriver.getAppiumDriver();
    }

    
    private void tweetNewimage()
    {
        try
        {
            appiumWebDriver.findElementAndPerformAction("id", "home", "click", "Clicked on new tweet icon",5000);
            appiumWebDriver.findElementAndPerformAction("id", "composer_write", "click", "Clicked on compose  new tweet icon",1000);
            appiumWebDriver.findElementAndPerformAction("id", "media_rail_tile_photo", "click", "Clicked on camera icon",2000);
            appiumWebDriver.findElementAndPerformAction("id", "image_camera_shutter", "click", "Captured new photo",10000);
            appiumWebDriver.findElementAndPerformAction("id", "speed_bump_use", "click", "Captured and ready to upload new photo",3000);
            
            appiumWebDriver.keyStroke = "latest tweet are tweeted from here";
            appiumWebDriver.findElementAndPerformAction("id", "tweet_text", "typeText", "Tweeting text (Latest tweet )", 1000);
            appiumWebDriver.findElementAndPerformAction("id", "button_tweet", "click", "Captured and uploaded new photo",10000);
            
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in Twitter while tweeting new twitters");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        }
        
    }

    
    private void tweetNewVideo()
    {
        try
        {
            
            appiumWebDriver.findElementAndPerformAction("id", "home", "click", "Clicked on new tweet icon",5000);
            appiumWebDriver.findElementAndPerformAction("id", "composer_write", "click", "Clicked on compose  new tweet icon",1000);
            appiumWebDriver.findElementAndPerformAction("id", "media_rail_tile_photo", "click", "Clicked on camera icon",2000);
            appiumWebDriver.findElementAndPerformAction("id", "button_camera_mode", "click", "Captured new video",10000);
            appiumWebDriver.findElementAndPerformAction("id", "image_camera_prev_shutter", "record", "Captured and ready to upload new video",3000);
            appiumWebDriver.findElementAndPerformAction("id", "done", "click", "Captured new video",10000);
            appiumWebDriver.keyStroke = "latest tweet are tweeted from here";
            appiumWebDriver.findElementAndPerformAction("id", "tweet_text", "typeText", "Tweeting text (Latest tweet )", 1000);
            appiumWebDriver.findElementAndPerformAction("id", "button_tweet", "click", "Captured and uploaded new photo",10000);
           
        }
        catch (Exception Ex) {

            System.out.println("Exception in Twitter while tweeting new twitters");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        }
    }
    
    private void periscopeLive()
    {
        try{
            appiumWebDriver.findElementAndPerformAction("id", "home", "click", "Clicked on new tweet icon",5000);
            appiumWebDriver.findElementAndPerformAction("id", "composer_write", "click", "Clicked on compose  new tweet icon",1000);
            appiumWebDriver.findElementAndPerformAction("id", "media_rail_tile_periscope", "click", "Clicked on periscope icon",20000);
            appiumWebDriver.findElementAndPerformAction("id", "chat_status", "click", "Clicked on periscope live icon",20000);
            appiumWebDriver.scrollScreenVerticalDown(1, 100);
            appiumWebDriver.findElementAndPerformAction("id", "btn_stop_broadcast", "click", "Clicked on stop perisocpe live button",20000);
            appiumWebDriver.backScreen(1, 10000);
        }
        catch (Exception Ex) {

            System.out.println("Exception in Twitter while tweeting new twitters");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        }
       
        
    }
    
    
    /**
     *
     */
    @Override
    public void execute() {

        try {

            System.out.println("Started twitter  new tweet script");
            
           
            this.tweetNewimage();
            this.tweetNewimage();
            
            this.tweetNewVideo();
            this.tweetNewVideo();
            
            this.periscopeLive();
            this.periscopeLive();

            System.out.println("Done with  twitter new tweets upload  script");
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
