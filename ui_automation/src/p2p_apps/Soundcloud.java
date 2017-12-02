/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p_apps;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author lakshmangunupudi
 */

public class Soundcloud  {

    
    AppiumWebDriver appiumWebDriver;

    Soundcloud(String udID) {
        //com.soundcloud.android.main.LauncherActivity
        //facebook credentials are the Username and password
        appiumWebDriver = new AppiumWebDriver("com.soundcloud.android","com.soundcloud.android.main.MainActivity",udID);
        appiumWebDriver.getAppiumDriver();
    }

    private void playChannels()
    {
        try
        {
        int channels;
            //Here we are running different channales and for each channel we are  playing  5 songs
            appiumWebDriver.findElementAndPerformAction("scroll","Playlists for working out", "","scroll to playlist");
            
            
            for(channels=0;channels<2;channels++)
            {
                // clicking on one particular channel
                appiumWebDriver.findElementAndPerformAction("id","artwork", "click","Clicked on souncloud playlist1");
                //clicking on play button to play first song
                appiumWebDriver.findElementAndPerformAction("id","btn_play", "click","Clicked on souncloud btn_play");

                //Playing 5 different songs 
                for (int songs=0;songs<2;songs++)
                {
                    Thread.sleep(10);
                    //this loop is to change the songs bby swiping left when the song is playing after every 1000 milli seconds
                    appiumWebDriver.findElementAndPerformAction("id","artwork_container", "swipeLeft","Clicked on souncloud for nextsong");
                }
                System.out.println("going back");
                appiumWebDriver.backScreen();
                appiumWebDriver.backScreen();
                System.out.println("Scrolling Vertical");
                appiumWebDriver.scrollScreenVertical(2);
               
                
                appiumWebDriver.findElementAndPerformAction("id","selection_playlists_carousel", "swipeLeft","Clicked on souncloud for swipeLeft");
               
            }
            
        }
        catch(Exception ex)
        {
            System.out.println("====Exception Occurred while  playing songs in different channels of  soundcloud ====");
            System.out.println(ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
        
    }
    
    
    private void  searchSonogs()
    {
            try{
                
                
                //Now we are looking to search few songs anf generate traffic of that.
                appiumWebDriver.keyStroke = "latest songs";
                //we are scrolling till we get search button in sound cloud
                
                appiumWebDriver.findElementAndPerformAction("scroll","Search SoundCloud", "click","scroll to search button for live radios");
                //Typing latest songs which is mentioned in keystroke
                appiumWebDriver.findElementAndPerformAction("id", "search_edit_text", "typeText", "Search Live Radios");
                Thread.sleep(100);
                //clicking on first search option
                appiumWebDriver.findElementAndPerformAction("id", "search_title", "click", "Clicked on search");
                Thread.sleep(100);
                //clicking on first song in search result
                appiumWebDriver.findElementAndPerformAction("id", "image", "click", "Search for first song after search");
                Thread.sleep(100);
                //this loop is to change the songs bby swiping left when the song is playing after every 1000 milli seconds
                for (int songs=0;songs<3;songs++)
                    {
                        Thread.sleep(10);
                        appiumWebDriver.findElementAndPerformAction("id","ak_recycler_view", "swipeLeft","Clicked on souncloud for nextsong");
                    }
                
                appiumWebDriver.backScreen();
                appiumWebDriver.backScreen();
            }
            catch(Exception Ex)
            {
                System.out.println(Ex.getMessage());
                System.out.println(Arrays.toString(Ex.getStackTrace()));
                System.out.println("====Exception Occurred while searching songs in  soundcloud ====");
                
            }

    }
    
    
    private void recordSoundcloud()
    {
        try
        {
            appiumWebDriver.findElementAndPerformAction("accessId","More", "click","Clicked on more to search record button");
            appiumWebDriver.findElementAndPerformAction("id","more_record_link", "click","Clicked on record text");
            try{
            
                appiumWebDriver.findElementAndPerformAction("text","Allow", "click","Clicked on allow button");
            }
            catch (Exception Ex) {
                System.out.println("Already accepted to record");
            }
            appiumWebDriver.findElementAndPerformAction("id","btn_action", "click","Clicked on record button");
            Thread.sleep(10000);
            appiumWebDriver.findElementAndPerformAction("id","btn_action", "click","Clicked on record button");
            
            appiumWebDriver.findElementAndPerformAction("id","btn_next", "click","Clicked on next to save");
            appiumWebDriver.keyStroke="myrecord"+String.valueOf(new Date().getTime());
            appiumWebDriver.findElementAndPerformAction("id","title", "typeText","saving the file with name");
            appiumWebDriver.backScreen();
            appiumWebDriver.findElementAndPerformAction("id","btn_action", "click","uploading the record");
            Thread.sleep(10000);
            appiumWebDriver.backScreen();
         
            
        }
        
        catch(Exception Ex)
        {
                System.out.println(Ex.getMessage());
                System.out.println(Arrays.toString(Ex.getStackTrace()));
                System.out.println("====Exception Occurred while searching songs in  soundcloud ====");
                
        }
    }
    
    @SuppressWarnings("empty-statement")
    public void soundCloudExecution() {

        try {

            System.out.println("====Sound cloud Music app started ====");
            
            Thread.sleep(1000);
            // Playing different channels
            this.playChannels();
            
            //playing different songs by searching
            this.searchSonogs();
            
            this.recordSoundcloud();
            
            System.out.println("Done with Sound Cloud App Automation.");
            
        }
        
        
        
        catch (InterruptedException Ex) {
        
            System.out.println(Ex.getMessage());
            System.out.println(Arrays.toString(Ex.getStackTrace()));
            System.out.println("====Exception Occurred while running soundcloud java file====");
        }
        
        finally
        {
            appiumWebDriver.appiumDriver.closeApp();
            appiumWebDriver.closeDriver();
        }
    }    
}
