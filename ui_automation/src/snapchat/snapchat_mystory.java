/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapchat;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class snapchat_mystory implements executeFunctionality{

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;

    public snapchat_mystory(String udID1,String udID2) {
        //account details  starent05@gmail.com / starent123 and rajasekar.13781 / rajasekar.13787@yahoo.com / Raja13787
        //getting the instance of AppiumWebDriver for this application snapchat
        appiumWebDriver1 = new AppiumWebDriver("com.snapchat.android","com.snapchat.android.LandingPageActivity",udID1);        
        appiumWebDriver1.getAppiumDriver();
        
        appiumWebDriver2 = new AppiumWebDriver("com.snapchat.android","com.snapchat.android.LandingPageActivity",udID2);        
        appiumWebDriver2.getAppiumDriver();
        
    }

    //this method is to play songs of different channels 
    private void sendSnapchatStory() throws Exception {
 
        for(int i=0;i<3;i++){
           
            appiumWebDriver1.findElementAndPerformAction("id", "nueva_nav_default_camera_button", "click", "Clicked on snapchat camera icon of snapchat app", 100);     
            appiumWebDriver1.findElementAndPerformAction("id", "story_button_hint_container", "click", "Clicked on post mystory  on snapchat app", 100);
            appiumWebDriver1.findElementAndPerformAction("id", "send_to_bottom_panel_send_button_container", "click", "Clicked on send mystory  on snapchat app", 100);
            appiumWebDriver1.findElementAndPerformAction("id", "nueva_nav_camera_button_shadow", "click", "Clicked on mystory  on snapchat app", 100);
            
            appiumWebDriver2.findElementAndPerformAction("id", "nueva_nav_default_camera_button", "click", "Clicked on snapchat camera icon of snapchat app", 100);     
            appiumWebDriver2.findElementAndPerformAction("id", "story_button_hint_container", "click", "Clicked on post mystory  on snapchat app", 100);
            appiumWebDriver2.findElementAndPerformAction("id", "send_to_bottom_panel_send_button_container", "click", "Clicked on send mystory  on snapchat app", 100);
            appiumWebDriver2.findElementAndPerformAction("id", "nueva_nav_camera_button_shadow", "click", "Clicked on mystory  on snapchat app", 100);
            
        }

       
        }   
        
    private void searchMystory() throws Exception
    {
        appiumWebDriver1.findElementAndPerformAction("id", "neon_header_search_button", "click", "Clicked on search stories of snapchat app", 100);     
        appiumWebDriver1.findElementAndPerformAction("id", "cover_image", "click", "Clicked on top stories of snapchat app", 100);     
        appiumWebDriver1.swipeWebelementLeftNtimes("id", "search_recycler_parent_view", 3, 10000);
        appiumWebDriver1.backScreen(2, 100);
        
        appiumWebDriver2.findElementAndPerformAction("id", "neon_header_search_button", "click", "Clicked on search stories of snapchat app", 100);     
        appiumWebDriver2.findElementAndPerformAction("id", "cover_image", "click", "Clicked on top stories of snapchat app", 100);     
        appiumWebDriver2.swipeWebelementLeftNtimes("id", "search_recycler_parent_view", 3, 10000);
        appiumWebDriver2.backScreen(2, 100);
        
        
    }
   
    
    private void downloadMystory() throws Exception
    {
        
        appiumWebDriver1.findElementAndPerformAction("id", "home_layout_container", "swipeLeft", "Clicked on search stories of snapchat app", 1000);     
        appiumWebDriver1.findElementAndPerformAction("id", "progressive_save_view", "click", "Clicked on mystory snapchat app", 10000);     
        
        
        appiumWebDriver2.findElementAndPerformAction("id", "home_layout_container", "swipeLeft", "Clicked on search stories of snapchat app", 1000);     
        appiumWebDriver2.findElementAndPerformAction("id", "progressive_save_view", "click", "Clicked on mystory snapchat app", 10000);     
        
        
    }
    
    /**
     *
     */
    @Override
    public void execute() {

        try {

            
            
            this.sendSnapchatStory();
            this.searchMystory();
            this.downloadMystory();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in snapchat mystory Execution");
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