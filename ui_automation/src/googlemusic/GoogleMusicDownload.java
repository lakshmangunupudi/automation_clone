/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlemusic;
import java.util.logging.Level;
import java.util.logging.Logger;
import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import P2pAppiumGuiAutomation.P2pAppiumGuiAutomation;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class GoogleMusicDownload implements executeFunctionality{

    AppiumWebDriver appiumWebDriver;

   public GoogleMusicDownload(String udID) {
        //Uses google account p2padcstarent@gmail.com/starent123
        //getting the instance of AppiumWebDriver for this application google music
      
        appiumWebDriver = new AppiumWebDriver("com.google.android.music", "com.google.android.music.ui.HomeActivity", udID);
        
        //appium driver
        appiumWebDriver.getAppiumDriver();
        
    }

   
    //this method is to play songs of different channels 
    private void downloadSongsofChannels() throws Exception {
        
            
            // playing songs of 4 channels which are randomly selected
            for (int channels = 0; channels < 2; channels++) {

                
                appiumWebDriver.findElementAndPerformAction("id", "title_with_icon", "click", "Clicked on channel ",1000);
                System.out.println("Here we are looking for ID art  OR li_thumbnail_frame, so captured in try/catch ");
                try{
                appiumWebDriver.findElementAndPerformAction("id", "art", "click", "Clicked on album selected button of song selected",1000);
                } catch (Exception ex) {
                    appiumWebDriver.findElementAndPerformAction("id", "li_thumbnail_frame", "click", "Clicked on album selected button of song selected",1000);
                  
                }
                                
                appiumWebDriver.findElementAndPerformAction("id", "overflow", "click", "Clicked on option to start radio",1000);
                appiumWebDriver.findElementAndPerformAction("osId", "text1", "locate", "Clicked on  start radio",1000);
                if(appiumWebDriver.currentButton.getText().compareTo("Start radio")==0)
                    appiumWebDriver.findElementAndPerformAction("osId", "text1", "click", "Clicked on  start radio",5000);
                
                
                appiumWebDriver.findElementAndPerformAction("id", "pin_button", "click", "Clicked on download button of song selected",30000);
                appiumWebDriver.findElementAndPerformAction("id", "pin_button", "click", "Clicked on download button of song selected",10000);
                  
                appiumWebDriver.backScreen(2,1000);
                appiumWebDriver.scrollScreenVertical(1);
                
            }
            appiumWebDriver.findElementAndPerformAction("id", "header_text", "click", "Clicked on playlist button of song selected",1000);
            appiumWebDriver.findElementAndPerformAction("id", "pause", "click", "Clicked on pause button of song selected",1000);
            
        

    }
    @Override
    public void execute() {

        try {

            Logger.getLogger(P2pAppiumGuiAutomation.class.getName()).info("Starting google music download program");
            this.downloadSongsofChannels();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        }
         
        catch (Exception Ex) {

            System.out.println("Exception in googlemusic browse Execution");
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
