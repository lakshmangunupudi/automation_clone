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
public class snapchat_video implements executeFunctionality{

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    
    public snapchat_video(String udID1,String udID2) {
        //account details  starent05@gmail.com / starent123 and rajasekar.13781 / rajasekar.13787@yahoo.com / Raja13787
        //getting the instance of AppiumWebDriver for this application snapchat
        appiumWebDriver1 = new AppiumWebDriver("com.snapchat.android","com.snapchat.android.LandingPageActivity",udID1);        
        appiumWebDriver1.getAppiumDriver();
        
        appiumWebDriver2 = new AppiumWebDriver("com.snapchat.android","com.snapchat.android.LandingPageActivity",udID2);        
        appiumWebDriver2.getAppiumDriver();
        
    }
     
    
    
    private void snapchatVideoCall() throws Exception {
 
        
        appiumWebDriver1.findElementAndPerformAction("id", "home_layout_container", "swipeRight", "Clicked on search friend  of snapchat app", 1000);     
            
        appiumWebDriver1.findElementAndPerformAction("text", "Rajasekar S", "click", "Clicked on user on snapchat app", 1000);
        
        
        appiumWebDriver2.findElementAndPerformAction("id", "home_layout_container", "swipeRight", "Clicked on search friend of snapchat app", 1000);     
            
        appiumWebDriver2.findElementAndPerformAction("text", "p2p.adc ADC", "click", "Clicked on user  on snapchat app", 1000);
   
         
        
        appiumWebDriver2.findElementAndPerformAction("id", "video_call_container", "click", "Clicked on video icon on snapchat app", 1000);
        appiumWebDriver1.findElementAndPerformAction("id", "call_prompt_join_button_container", "click", "Clicked on accept video call on snapchat app", 100000);
        
        appiumWebDriver2.findElementAndPerformAction("id", "end_stream_video_button", "click", "Clicked on camera icon on snapchat app", 1000);



        appiumWebDriver1.findElementAndPerformAction("id", "video_call_container", "click", "Clicked on video icon on snapchat app", 1000);
        appiumWebDriver2.findElementAndPerformAction("id", "call_prompt_join_button_container", "click", "Clicked on accept video call on snapchat app", 100000);
        appiumWebDriver1.findElementAndPerformAction("id", "end_stream_video_button", "click", "Clicked on camera icon on snapchat app", 1000);

          
            
        
    }
    
    /**
     *
     */
    @Override
    public void execute() {

        try {

 
            this.snapchatVideoCall();
           
            
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in snapchat video call Execution");
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