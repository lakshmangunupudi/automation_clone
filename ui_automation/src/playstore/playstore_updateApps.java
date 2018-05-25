/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playstore;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class playstore_updateApps implements executeFunctionality{

    AppiumWebDriver appiumWebDriver;

    public playstore_updateApps(String udID) {
       //p2p.adc@gmail.com/starent123 and cisco.starnt@gmail.com/starent123
        appiumWebDriver = new AppiumWebDriver("com.actionlauncher.playstore","com.actionlauncher.ActionLauncherActivity",udID);
        
        appiumWebDriver.getAppiumDriver();
    }

    //this method is to play songs of different channels 
    private void updateAllApps() throws Exception {

        appiumWebDriver.findElementAndPerformAction("id", "navigation_button", "click", "Clicked on like of appstore menu", 1000);

        appiumWebDriver.findElementAndPerformAction("text", "My apps & games", "click", "Clicked on myapps and games", 5000);

        appiumWebDriver.findElementAndPerformAction("id", "header_action_button", "click", "updating all the apps", 2000000);

        }   
           
   
    /**
     *
     */
    @Override
    public void execute() {

        try {

            System.out.println("Update all the apps");
            this.updateAllApps();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
            
        }
        catch (Exception Ex) {

            System.out.println("Exception in Facebook browse Execution");
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