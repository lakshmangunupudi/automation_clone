/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class facebook_browse implements executeFunctionality{

    AppiumWebDriver appiumWebDriver;

    public facebook_browse(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application facebook
        appiumWebDriver = new AppiumWebDriver("com.facebook.katana","com.facebook.katana.LoginActivity",udID);
        
        appiumWebDriver.getAppiumDriver();
    }

    //this method is to play songs of different channels 
    private void browseFacebook() throws Exception {

       
            //This is to scroll  up for few iterations so that we can generate twitter home page traffic 
            
            appiumWebDriver.findElementAndPerformAction("simpleScroll", "Share", "locate", "reached to comment", 1000);
            appiumWebDriver.findElementByID("feed_feedback_share_container", 3);
            appiumWebDriver.findElementAndPerformAction("id", "feed_feedback_like_container", "click", "Clicked on like of facebook post", 1000);
            appiumWebDriver.findElementAndPerformAction("id", "feed_feedback_comment_container", "click", "Clicked on comment of facebook post", 1000);
            
            // comment on facebook post
            appiumWebDriver.findElementAndPerformAction("id", "comment_edit_text", "click", "commenting  on facebook post", 1000);
            appiumWebDriver.keyStroke = "latest facebook  message  from here";
            appiumWebDriver.findElementAndPerformAction("id", "comment_edit_text", "typeText", "commenting  on facebook post", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "comment_post_button", "click", "commenting  on facebook post", 3000);
            
            //GIF comment
            appiumWebDriver.findElementAndPerformAction("id", "comment_gif_button", "click", "commenting  GIF image on facebook post", 1000);
            appiumWebDriver.findElementAndPerformAction("id", "content_search_item", "click", "commenting  GIF image on facebook post", 1000);
               
            
            // image and video comment on facebook post if option is available 
            try{
            appiumWebDriver.findElementAndPerformAction("id", "comment_add_photo_button", "click", "commenting image ", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "primary_action_button", "click", "commenting image ", 3000);
            appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_shutter_button_internal", "click", "commenting image ", 3000);
            appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_btn_done", "click", "commenting image ", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "comment_post_button", "click", "posting  image on facebook post", 3000);
            
            //Video  comment
            
            appiumWebDriver.findElementAndPerformAction("id", "comment_add_photo_button", "click", "commenting image ", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "secondary_action_button", "click", "commenting image ", 3000);
            appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_shutter_button_internal", "click", "commenting video ", 3000);
            appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_shutter_button_internal", "click", "commenting video captured ", 1000);
            appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/bottom_control_lower_panel", "click", "commenting video ", 1000);
            appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_btn_done", "click", "commenting image ", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "comment_post_button", "click", "posting  video on facebook post", 3000);
            
            
            }
            catch (Exception Ex) {

                    System.out.println("Exception in Facebook browse Execution while uplaoding image may be it is not a image post");  
           
            }
            
            appiumWebDriver.backScreen(1, 100);
            
            
            //Sharing the facebook post
            appiumWebDriver.findElementAndPerformAction("id", "feed_feedback_share_container", "click", "Sharing  on facebook post", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "fbui_popover_list_item_title", "click", "Sharing  on facebook post", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "composer_status_text", "click", "Wrinting message while sharing ", 5000);
            appiumWebDriver.keyStroke = "latest facebook  message  from here";
            appiumWebDriver.findElementAndPerformAction("id", "composer_status_text", "typeText", "Wrinting message while sharing", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "primary_named_button", "click", "Clicked on share post  ", 5000);
            
            appiumWebDriver.scrollScreenVertical(2);
        }   
           
    

    /**
     *
     */
    @Override
    public void execute() {

        try {

            appiumWebDriver.scrollScreenVertical(10);
            
            this.browseFacebook();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in Facebook browse Execution");
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