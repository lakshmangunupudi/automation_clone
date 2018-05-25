/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapchat;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import org.openqa.selenium.Keys;

/**
 *
 * @author lakshmangunupudi
 */
public class snapchat_message implements executeFunctionality{

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    
    public snapchat_message(String udID1,String udID2) {
        //account details  starent05@gmail.com / starent123 and rajasekar.13781 / rajasekar.13787@yahoo.com / Raja13787
        //getting the instance of AppiumWebDriver for this application snapchat
        appiumWebDriver1 = new AppiumWebDriver("com.snapchat.android","com.snapchat.android.LandingPageActivity",udID1);        
        appiumWebDriver1.getAppiumDriver();
        
        appiumWebDriver2 = new AppiumWebDriver("com.snapchat.android","com.snapchat.android.LandingPageActivity",udID2);        
        appiumWebDriver2.getAppiumDriver();
        
    }

    //this method is to play songs of different channels 
    private void sendSnapchatMessage() throws Exception {
 
        
        appiumWebDriver1.findElementAndPerformAction("id", "home_layout_container", "swipeRight", "Clicked on search friend  of snapchat app", 1000);     
            
        appiumWebDriver1.findElementAndPerformAction("text", "Rajasekar S", "click", "Clicked on user on snapchat app", 1000);
        
        
        appiumWebDriver2.findElementAndPerformAction("id", "home_layout_container", "swipeRight", "Clicked on search friend of snapchat app", 1000);     
            
        appiumWebDriver2.findElementAndPerformAction("text", "p2p.adc ADC", "click", "Clicked on user  on snapchat app", 1000);
        for(int i=0;i<4;i++){
         
            appiumWebDriver1.keyStroke = " hi how are you  yfkgkjgvjhfghdtstgshgdhgchch\n";
            appiumWebDriver1.findElementAndPerformAction("id", "chat_input_text_field", "typeText", "Clicked on mystory  on snapchat app", 1000);
            appiumWebDriver1.findElementAndPerformAction("id", "sticker_button_container", "click", "Clicked on stickers to send  on snapchat app", 1000);
            appiumWebDriver1.findElementAndPerformAction("id", "sticker_image_view", "click", "Clicked on stickers to send  on snapchat app", 1000);
            appiumWebDriver1.backScreen(1, 100);
            
            appiumWebDriver2.keyStroke = "I am fine   yfkgkjgvjhfghdtstgshgdhgchch\n";
            appiumWebDriver2.findElementAndPerformAction("id", "chat_input_text_field", "typeText", "Clicked on mystory  on snapchat app", 1000);
            appiumWebDriver2.findElementAndPerformAction("id", "sticker_button_container", "click", "Clicked on stickers to send  on snapchat app", 1000);
            appiumWebDriver2.findElementAndPerformAction("id", "sticker_image_view", "click", "Clicked on stickers to send  on snapchat app", 1000);
            appiumWebDriver2.backScreen(1, 100);
                        
        }
       
        }   

    
    /**
     *
     */
    @Override
    public void execute() {

        try {

            
            
            this.sendSnapchatMessage();
           
            
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