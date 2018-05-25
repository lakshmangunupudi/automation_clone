/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedin;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

/**
 *
 * @author lakshmangunupudi
 */
public class linkedinsearch implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;

    public linkedinsearch(String udID) {
        //account details  dineshstarent1@gmail.com passwd:starent321 username:dineshstarent
        //getting the instance of AppiumWebDriver for this application linkedin
        appiumWebDriver = new AppiumWebDriver("com.linkedin.android", "com.linkedin.android.authenticator.LaunchActivity", udID);
        //appium driver
        appiumWebDriver.getAppiumDriver();
    }

    private void findLinkFriends() throws InterruptedException, Exception {


            Thread.sleep(1000);
            appiumWebDriver.scrollScreenVertical(2);
            appiumWebDriver.findElementAndPerformAction("id", "infra_activity_container", "swipeLeft", "click on the friends tab", 2000);            
            

            for (int i = 0; i < 2; i++) {

                    appiumWebDriver.findElementAndPerformAction("simpleScroll", "CONNECT", "locate", "reached to comment", 1000);
                    appiumWebDriver.findElementAndPerformAction("id", "mynetwork_pymk_connect", "click", "click on connect the friends tab", 10000);
                    appiumWebDriver.findElementAndPerformAction("id", "mynetwork_pymk_delete", "click", "click on connect the friends tab", 10000);
                    appiumWebDriver.scrollScreenVertical(3 * i);

            }
        } 
    

    
    
    private void searchLinkedin() {

        try {

            Thread.sleep(1000);
             appiumWebDriver.findElementAndPerformAction("id", "home_nav_tab_container", "click", "click on home of  linkedin tab", 2000);
            
            appiumWebDriver.findElementAndPerformAction("id", "search_bar_text", "click", "click on search of linkedin tab", 2000);
            appiumWebDriver.keyStroke = "cisco systems";
            appiumWebDriver.findElementAndPerformAction("id", "search_bar_text", "typeText", "searching cisco", 3000);

            appiumWebDriver.findElementAndPerformAction("id", "search_typeahead_entity_subtext", "click", "click on first search of linkedin tab", 3000);

            appiumWebDriver.scrollScreenVertical(20);
            appiumWebDriver.backScreen(3, 100);

        } catch (Exception Ex) {
            System.out.println("Exception in linkedin search Execution");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());

        }
    }

    /**
     *
     */
    @Override
    public void execute() {

        try {
            this.searchLinkedin();
            
            this.findLinkFriends();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

        } catch (Exception Ex) {

            System.out.println("Exception in Linkedin browse Execution");
            System.out.println(Ex.getMessage());
            System.out.println(Ex.getStackTrace());
        } finally {
            appiumWebDriver.appiumDriver.closeApp();
            appiumWebDriver.closeDriver();
        }

    }
}
