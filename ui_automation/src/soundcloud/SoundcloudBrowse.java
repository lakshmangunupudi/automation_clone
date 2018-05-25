/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundcloud;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;


/**
 *
 * @author lakshmangunupudi
 */

public class SoundcloudBrowse implements executeFunctionality{

    
    AppiumWebDriver appiumWebDriver;

    public SoundcloudBrowse(String udID) {
        //com.soundcloud.android.main.LauncherActivity
        //facebook credentials are the Username and password
        //Login with facebook (p2padcstarent@gmail.com/starent123)
        appiumWebDriver = new AppiumWebDriver("com.soundcloud.android","com.soundcloud.android.main.MainActivity",udID);
        appiumWebDriver.getAppiumDriver();
    }

    private void playChannels() throws Exception
    {
        
        int channels;
            //Here we are running different channales and for each channel we are  playing  5 songs
            //appiumWebDriver.findElementAndPerformAction("scroll","Popular playlists from the SoundCloud community", "locate","scroll to playlist",0);
    
            for(channels=0;channels<3;channels++)
            {
              
                // clicking on one particular channel
                appiumWebDriver.findElementByID("artwork",5);
                appiumWebDriver.findElementAndPerformAction("id","artwork", "click","Clicked on souncloud playlist1",100);
                //clicking on play button to play first song
                appiumWebDriver.findElementAndPerformAction("id","btn_play", "click","Clicked on souncloud btn_play",1000);
                
                
                //Playing 5 different songs  in this method just by scrolling left after every 10K milliseconds
                appiumWebDriver.swipeWebelementLeftNtimes("id","ak_recycler_view", 5, 10000);
                
                appiumWebDriver.findElementAndPerformAction("id","btn_play", "click","Clicked on souncloud btn_play",1000);
                appiumWebDriver.backScreen(2,1000);
                
                appiumWebDriver.scrollScreenVertical(2);
            }

    }
  
    /**
     *
     * @throws Exception
     */
    @SuppressWarnings("empty-statement")
    @Override
    public void execute()  {

        try {
            System.out.println("Stareted  with Sound Cloud App Automation.");
            
            Thread.sleep(1000);

            // Playing different channels
            this.playChannels();
            
            System.out.println("Done with Sound Cloud App Automation.");
            
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        }
         
        catch (Exception Ex) {

            System.out.println("Exception in Soundcloud browse Execution");
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
