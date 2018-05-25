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
public class facebookmessanger_recorder implements executeFunctionality{

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
     private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public facebookmessanger_recorder(String udID1,String udID2) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application facebook
        appiumWebDriver1 = new AppiumWebDriver("com.facebook.orca","com.facebook.orca.auth.StartScreenActivity",udID1);        
        appiumWebDriver1.getAppiumDriver();
        
        appiumWebDriver2 = new AppiumWebDriver("com.facebook.orca","com.facebook.orca.auth.StartScreenActivity",udID2);        
        appiumWebDriver2.getAppiumDriver();
        
    }
       
        private String randomAlphaNumeric(int count) {
            StringBuilder builder = new StringBuilder();
            while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
            }
            return builder.toString();
        }

    //this method is to play songs of different channels 
    private void facebookAudioCall() throws Exception {
 
        appiumWebDriver1.keyStroke = "starent.cisco";
        appiumWebDriver1.findElementAndPerformAction("text", "Search", "typeText", "Clicked on search fot starent cisco facebook im", 2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "Starent Cisco", "click", "Clicked on starent cisco of facebook im", 2000);
        
        
        appiumWebDriver2.keyStroke = "cisconath.starent";
        appiumWebDriver2.findElementAndPerformAction("text", "Search", "typeText", "Clicked on search fot cisconath.starent facebook im", 2000);
        appiumWebDriver2.findElementAndPerformAction("contentDesc", "Cisconath Starent", "click", "Clicked on cisconath.starent of facebook im", 2000);
        
        for (int i=0;i<5;i++){
            
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "Record voice", "locate", "Clicked on  audio call  icon of facebook im", 1000);    
            appiumWebDriver1.touchAction.longPress(appiumWebDriver1.currentButton, 10000).release().perform();
            appiumWebDriver2.findElementAndPerformAction("contentDesc", "Record voice", "record", "Clicked on  audio call  icon of facebook im", 1000);    
            appiumWebDriver2.touchAction.longPress(appiumWebDriver2.currentButton, 10000).release().perform();
        }
       
        }   
           
   
    /**
     *
     */
    @Override
    public void execute() {

        try {

            
            this.facebookAudioCall();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in Facebook record Execution");
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