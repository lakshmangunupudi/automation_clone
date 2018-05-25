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
public class GoogleMusicPlay implements executeFunctionality{

    AppiumWebDriver appiumWebDriver;

   public GoogleMusicPlay(String udID) {
        //Uses google account p2padcstarent@gmail.com/starent123
        //getting the instance of AppiumWebDriver for this application google music
      
        appiumWebDriver = new AppiumWebDriver("com.google.android.music", "com.google.android.music.ui.HomeActivity", udID);
        
        //appium driver
        appiumWebDriver.getAppiumDriver();
        
    }

    //this method is to play songs of different channels 
    private void playSongsofChannels() throws Exception {

            for (int channels = 0; channels < 3; channels++) {

                appiumWebDriver.findElementAndPerformAction("id", "title_with_icon", "click", "Clicked on channel ",1000);
                
                
                        
                System.out.println("Here we are looking for play_button  OR li_play_button, so captured in try/catch ");
                
                try{
                    appiumWebDriver.findElementAndPerformAction("id", "play_button", "click", "Clicked on play button of song selected",10000);
                } catch (Exception ex) {
                    
                       appiumWebDriver.findElementAndPerformAction("id", "li_play_button", "click", "Clicked on play button of song selected",20000);
                }
                 
                
                appiumWebDriver.findElementAndPerformAction("id", "header_text", "click", "Clicked on playlist button of song selected",1000);
                

                //playing . 5 songs of each channel
                for (int songs = 0; songs < 2; songs++) {
                    //going to next song
                    appiumWebDriver.findElementAndPerformAction("id", "next", "click", "Clicked on next song",40000);
                    // lick and dislike  the song
                    appiumWebDriver.findElementAndPerformAction("id", "thumbsup", "click", "Clicked on like button",100);
                    appiumWebDriver.findElementAndPerformAction("id", "thumbsdown", "click", "Clicked on dislike button",100);

                }
                appiumWebDriver.scrollScreenVertical(2);
                appiumWebDriver.backScreen(2,1000);
                appiumWebDriver.scrollScreenVertical(1);
            }
            appiumWebDriver.findElementAndPerformAction("id", "header_text", "click", "Clicked on playlist button of song selected",1000);
            appiumWebDriver.findElementAndPerformAction("id", "pause", "click", "Clicked on pause button of song selected",1000);
    }

    
    @Override
    public void execute() {

        try {

            Logger.getLogger(P2pAppiumGuiAutomation.class.getName()).info("Starting google music play  application");
            //function to play the songs
            this.playSongsofChannels();
            
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
