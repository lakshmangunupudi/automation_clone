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
public class linkedinpostimage implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;

    public linkedinpostimage(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application linkedin
        appiumWebDriver = new AppiumWebDriver("com.linkedin.android", "com.linkedin.android.authenticator.LaunchActivity", udID);
        //appium driver
        appiumWebDriver.getAppiumDriver();
    }

//this method is to browse the linkedin and uplaod the photo
    private void shareUploadArticlesLinkedin() throws Exception {

        
            for (int i = 0; i < 2; i++) {
               
                    appiumWebDriver.findElementAndPerformAction("id", "feed_fab", "click", "Clicked on new post  of linkedin post", 2000);

                    appiumWebDriver.findElementAndPerformAction("id", "sharing_compose_attach_image_button", "click", "Clicked on camera button of new post  of linkedin ", 2000);
                    appiumWebDriver.findElementAndPerformAction("osId", "text1", "click", "Clicked on capture image using camera option  of linkedin post", 5000);
                    appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_shutter_button_internal", "click", "Clicked on capture image using camera option  of linkedin post", 5000);

                    appiumWebDriver.findElementAndPerformAction("plainId", "com.android.camera:id/v6_btn_done", "click", "Clicked on accept image to upload of linkedin post", 5000);

                    appiumWebDriver.keyStroke = "latest linkedin message  from starent";
                    appiumWebDriver.findElementAndPerformAction("id", "sharing_compose_text_input", "typeText", "Clicked on camera button of new post  of linkedin ", 2000);
                    appiumWebDriver.findElementAndPerformAction("id", "sharing_compose_post_button", "click", "Clicked on camera button of new post  of linkedin ", 5000);
                
            }

       
    }

  
   
    
    
    
    /**
     *
     */
    @Override
    public void execute() {

        try {

            //function to play linkedinbrowse linkedinbrowse
            this.shareUploadArticlesLinkedin();
            
            
            
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

        } catch (Exception Ex) {

            System.out.println("Exception in Linkedin browse Execution");
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
