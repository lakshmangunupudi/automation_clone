/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedin;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class linkedinbrowse implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;

    public linkedinbrowse(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application linkedin
        appiumWebDriver = new AppiumWebDriver("com.linkedin.android", "com.linkedin.android.authenticator.LaunchActivity", udID);
        //appium driver
        appiumWebDriver.getAppiumDriver();
    }

//this method is to browse the linkedin and comment,like and uplaod the photo
    private void browseArticlesLinkedin() throws Exception {

        
            //Here we are commenting and retweeting also liking the post , upto 10 post .
            for (int i = 0; i < 2; i++) {
                
                    
                    appiumWebDriver.scrollScreenVertical((i+1)*5);
                    appiumWebDriver.findElementAndPerformAction("scroll", "Share", "locate", "reached to comment", 1000);
                    
                    appiumWebDriver.findElementAndPerformAction("id", "feed_component_social_bar_like", "click", "Clicked on like of linkedin post", 1000);
                    appiumWebDriver.findElementAndPerformAction("id", "feed_component_social_bar_comment", "click", "Clicked on comment option  of linkedin post", 5000);
                    appiumWebDriver.findElementAndPerformAction("id", "feed_comment_bar_select_image", "click", "Clicked on image option  of linkedin post", 5000);
                    appiumWebDriver.findElementAndPerformAction("osId", "text1", "click", "Clicked on capture image using camera option  of linkedin post", 2000);

                    try {
                        //Incase of allowing  we have to do it again
                        appiumWebDriver.findElementAndPerformAction("contentDesc", "Shutter button", "click", "Clicked on capture image button", 5000);
                        
                    } catch (Exception Ex) {
                        appiumWebDriver.findElementAndPerformAction("plainId", "com.android.packageinstaller:id/permission_allow_button", "click", "Clicked on Allow option  of linkedin post", 0);
                        appiumWebDriver.findElementAndPerformAction("id", "feed_comment_bar_select_image", "click", "Clicked on comment option  of linkedin post", 5000);
                        appiumWebDriver.findElementAndPerformAction("osId", "text1", "click", "Clicked on capture image using camera option  of linkedin post", 5000);
                        appiumWebDriver.findElementAndPerformAction("contentDesc", "Shutter button", "click", "Clicked on capture image button", 5000);
                        System.out.println("Exception occurred while giving permission to camera, looks like permission already granted");
                    }

                    
                    appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_btn_done", "click", "Clicked on accept image to upload of linkedin post", 5000);
                    appiumWebDriver.keyStroke = "latest linkedin message  from here";
                    appiumWebDriver.findElementAndPerformAction("id", "feed_comment_bar_reply", "typeText", "Clicked on comment option  of linkedin post", 5000);

                    appiumWebDriver.findElementAndPerformAction("id", "feed_comment_bar_send", "click", "Clicked on comment option  of linkedin post", 50000);

                    appiumWebDriver.backScreen(1, 1000);


                    //this is to share the article
                    appiumWebDriver.scrollScreenVertical((i+1)*5);
                    appiumWebDriver.findElementAndPerformAction("scroll", "Share", "locate", "reached to comment", 1000);
                    appiumWebDriver.findElementAndPerformAction("id", "feed_component_social_bar_reshare", "click", "Clicked on share option  of linkedin post", 5000);
                    appiumWebDriver.findElementAndPerformAction("id", "sharing_compose_post_button_layout", "click", "Done with  sharing article  of linkedin post", 10000);

                    //this is to click on the main article after sharing the areticle
                    try{
                    appiumWebDriver.findElementAndPerformAction("scroll", "Share", "locate", "reached to click main article", 1000);
                    appiumWebDriver.findElementAndPerformAction("id", "feed_component_border_wrapper", "click", "click on the main articli after sharing the areticle", 10000);
                    } catch (Exception Ex) {
                        System.out.println("Exception occurred while clicking on main article");
                        Thread.sleep(1000);
                    }

                    appiumWebDriver.backScreen(1, 1000);
                    
                
            }   
    }
   
    
    

    /**
     *
     */
    @Override
    public void execute() {

        try {

            Thread.sleep(1000);
            //function to play linkedinbrowse linkedinbrowse
            this.browseArticlesLinkedin();
 
            
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

        } catch (Exception Ex) {

            System.out.println("Exception in Linkedin browse Execution");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        } finally {
            appiumWebDriver.appiumDriver.closeApp();
            appiumWebDriver.closeDriver();
        }

    }
}
