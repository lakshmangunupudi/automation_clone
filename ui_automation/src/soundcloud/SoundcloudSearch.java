/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundcloud;

import java.util.Date;
import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;


/**
 *
 * @author lakshmangunupudi
 */

public class SoundcloudSearch implements executeFunctionality{

    
    AppiumWebDriver appiumWebDriver;

    public SoundcloudSearch(String udID) {
        //com.soundcloud.android.main.LauncherActivity
        //facebook credentials are the Username and password
        //Login with facebook (p2padcstarent@gmail.com/starent123)
        appiumWebDriver = new AppiumWebDriver("com.soundcloud.android","com.soundcloud.android.main.MainActivity",udID);
        appiumWebDriver.getAppiumDriver();
    }

    
    
    private void  searchSonogs() throws Exception
    {
            
                appiumWebDriver.findElementAndPerformAction("contentDesc","Stream", "click","sClicked on stream  button for browsing",1000); 
               
                appiumWebDriver.scrollScreenVertical(10);
                
                appiumWebDriver.findElementAndPerformAction("contentDesc","Search", "click","scroll to search button for live radios",1000);
                
                appiumWebDriver.findElementAndPerformAction("id", "search_text", "click", "Search Live Radios",1000);
                
                
                //Now we are looking to search few songs anf generate traffic of that.
                appiumWebDriver.keyStroke = "latest songs";
                
                //Typing latest songs which is mentioned in keystroke
                appiumWebDriver.findElementAndPerformAction("id", "search_edit_text", "typeText", "Search Live Radios",1000);
                
                //clicking on first search option
                appiumWebDriver.findElementAndPerformAction("id", "search_title", "click", "Clicked on search",1000);
                
                //clicking on first song in search result
                appiumWebDriver.findElementAndPerformAction("id", "image", "click", "Search for first song after search",1000);
                
                
                //this loop is to change the songs bby swiping left when the song is playing after every 1000 milli seconds                
                appiumWebDriver.swipeWebelementLeftNtimes("id","ak_recycler_view", 10, 10000);

                appiumWebDriver.backScreen(2,1000);
                
            


    }

    private void recordSoundcloud() throws Exception
    {
        
            appiumWebDriver.findElementAndPerformAction("accessId","More", "click","Clicked on more to search record button",0);
            appiumWebDriver.findElementAndPerformAction("id","more_record_link", "click","Clicked on record text",1000);
            try{
            
                appiumWebDriver.findElementAndPerformAction("id","btn_action", "click","Clicked on record button",1000);
            }
            catch (Exception Ex) {
                appiumWebDriver.findElementAndPerformAction("text","ALLOW", "click","Clicked on allow button",1000);
                appiumWebDriver.findElementAndPerformAction("id","btn_action", "click","Clicked on record button",1000);
                System.out.println("Already accepted to record");
            }
            
            
            appiumWebDriver.findElementAndPerformAction("id","btn_action", "click","Clicked on record button",0);
            
            appiumWebDriver.findElementAndPerformAction("id","btn_next", "click","Clicked on next to save",0);
            appiumWebDriver.keyStroke="myrecord"+String.valueOf(new Date().getTime());
            appiumWebDriver.findElementAndPerformAction("id","title", "typeText","saving the file with name",0);
            appiumWebDriver.backScreen(1,0);
            appiumWebDriver.findElementAndPerformAction("id","btn_action", "click","uploading the record",10000);
            
            appiumWebDriver.backScreen(1,0);
         
            
       
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

            //playing different songs by searching
            this.searchSonogs();
            
            this.recordSoundcloud();
            
            System.out.println("Done with Sound Cloud App Automation.");
            
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        }
         
       catch (Exception Ex) {

            System.out.println("Exception in Soundcloud search Execution");
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
