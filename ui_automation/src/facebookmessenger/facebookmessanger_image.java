/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookmessenger;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class facebookmessanger_image implements executeFunctionality{

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;

    public facebookmessanger_image(String udID1,String udID2) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application facebook
        appiumWebDriver1 = new AppiumWebDriver("com.facebook.orca","com.facebook.orca.auth.StartScreenActivity",udID1);        
        appiumWebDriver1.getAppiumDriver();
        
        appiumWebDriver2 = new AppiumWebDriver("com.facebook.orca","com.facebook.orca.auth.StartScreenActivity",udID2);        
        appiumWebDriver2.getAppiumDriver();
        
    }

    //this method is to play songs of different channels 
    private void sendFacebookImage() throws Exception {
        appiumWebDriver1.keyStroke = "starent.cisco";
        appiumWebDriver1.findElementAndPerformAction("text", "Search", "typeText", "Clicked on search fot starent cisco facebook im", 2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "Starent Cisco", "click", "Clicked on starent cisco of facebook im", 2000);
        
        
        appiumWebDriver2.keyStroke = "cisconath.starent";
        appiumWebDriver2.findElementAndPerformAction("text", "Search", "typeText", "Clicked on search fot cisconath.starent facebook im", 2000);
        appiumWebDriver2.findElementAndPerformAction("contentDesc", "Cisconath Starent", "click", "Clicked on cisconath.starent of facebook im", 2000);
        
        for(int i=0;i<2;i++){
           
           
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "Take photo", "click", "Clicked on camera icon of facebook im", 2000);
            try{
                
               appiumWebDriver1.findElementAndPerformAction("contentDesc", "Empty", "click", "Clicked on capture image of facebook im", 2000);
                
            }
            catch (Exception Ex) {
                appiumWebDriver1.backScreen(1, 1000);
                appiumWebDriver1.findElementAndPerformAction("contentDesc", "Take photo", "click", "Clicked on camera icon of facebook im", 2000);
                appiumWebDriver1.findElementAndPerformAction("contentDesc", "Empty", "click", "Clicked on capture image facebook im", 2000);
            }
            try{
                appiumWebDriver1.findElementAndPerformAction("contentDesc", "Next", "click", "Clicked on send image of facebook im", 2000);
            }catch (Exception Ex) {
               
              
              appiumWebDriver1.findElementAndPerformAction("contentDesc", "Reset art or effect selection", "click", "Clicked on reset selection of facebook im", 2000);
              appiumWebDriver1.findElementAndPerformAction("contentDesc", "Empty", "click", "Clicked on capture image of facebook im", 2000);
              appiumWebDriver1.findElementAndPerformAction("contentDesc", "Next", "click", "Clicked on send image of facebook im", 2000);
                
            
            }


            appiumWebDriver2.findElementAndPerformAction("contentDesc", "Take photo", "click", "Clicked on camera of facebook im", 2000);
            try{
                appiumWebDriver2.findElementAndPerformAction("contentDesc", "Empty", "click", "Clicked on capture image of facebook im", 2000);
            }
            catch (Exception Ex) {
                appiumWebDriver2.backScreen(1, 1000);
                appiumWebDriver2.findElementAndPerformAction("contentDesc", "Take photo", "click", "Clicked on camera icon of facebook im", 2000);
                appiumWebDriver2.findElementAndPerformAction("contentDesc", "Empty", "click", "Clicked on capture image of facebook im", 2000);
            }
            try{
                appiumWebDriver2.findElementAndPerformAction("contentDesc", "Next", "click", "Clicked on send image of facebook im", 2000);
            }
            catch (Exception Ex) {
              //(new WebDriverWait(appiumWebDriver2.appiumDriver, 60)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.FrameLayout"))).get(3).click();
              appiumWebDriver2.findElementAndPerformAction("contentDesc", "Reset art or effect selection", "click", "Clicked on reset selection of facebook im", 2000);
              appiumWebDriver2.findElementAndPerformAction("contentDesc", "Empty", "click", "Clicked on capture image of facebook im", 2000);
              appiumWebDriver2.findElementAndPerformAction("contentDesc", "Next", "click", "Clicked on send image of facebook im", 2000);
                
            }
        }

       
        }   
           
   
    /**
     *
     */
    @Override
    public void execute() {

        try {
 
            this.sendFacebookImage();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in Facebook image Execution");
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