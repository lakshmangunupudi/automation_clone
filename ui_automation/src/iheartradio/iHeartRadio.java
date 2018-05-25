package iheartradio;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;
import java.util.Random;

public class iHeartRadio implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 22/11/2017
     * Content: This file contents steps to interact with iHeartRadio Application to use its functionalities
     *
     *  Functionalities Covered:
     *     Browse
     *     Listen to stations
     *
     * All rights by CISCO
     *
     * String username = "p2p.adc@gmail.com";
     * String password = "starent123";
     **/

    private String appPackage = "com.clearchannel.iheartradio.controller";
    private String appActivity = "com.clearchannel.iheartradio.controller.activities.NavDrawerActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    /* Change settings to stop playing last station */

    public iHeartRadio(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(10000);

            /* Browse and play some stations presented as per iHeartRadio */

            for (int i = 1; i < 3; i++) {
                appiumWebDriver.findElementAndPerformAction("id", "event_sub_text", "click", "Clicked Radio Station " + Integer.toString(i), 45000);
                appiumWebDriver.backScreen(1, 2000);
                if (i < 2) {
                    appiumWebDriver.scrollScreenVertical(random.nextInt(14));
                }
            }

            /* Browse and play some Live Station */

            appiumWebDriver.keyStroke = "live radio";
            appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click search button", 100);
            appiumWebDriver.findElementAndPerformAction("id", "search_src_text", "typeText", "Search Live Radios", 100);
            appiumWebDriver.backScreen(1, 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Show All Live Stations", "click", "Click All Live Radios", 10000);
            for (int i = 1; i < 3; i++) {
                appiumWebDriver.findElementAndPerformAction("id", "name", "click", "Clicked Live Radio Station " + Integer.toString(i), 45000);
                appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            }
            appiumWebDriver.backScreen(3, 1000);
            appiumWebDriver.findElementAndPerformAction("id", "playPauseProgress", "click", "Stop Background play", 100);

            /* Browse and play some Artist Station */

            appiumWebDriver.keyStroke = "all artists";
            appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click search button", 100);
            appiumWebDriver.findElementAndPerformAction("id", "search_src_text", "typeText", "Search Artists Radios", 100);
            appiumWebDriver.backScreen(1, 3000);
            appiumWebDriver.findElementAndPerformAction("simpleScroll", "Show All Artists", "click", "Click All Artists Radios", 10000);
            for (int i = 1; i < 4; i++) {
                appiumWebDriver.findElementAndPerformAction("id", "name", "click", "Clicked Artist Radio Station " + Integer.toString(i), 45000);
                appiumWebDriver.backScreen(1, 3000);
                appiumWebDriver.findElementAndPerformAction("id", "playPauseProgress", "click", "Stop Background play", 100);
                appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            }
            appiumWebDriver.backScreen(3, 1000);

            /* Browse and play some Podcasts */

            appiumWebDriver.keyStroke = "all podxasts";
            appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click search button", 100);
            appiumWebDriver.findElementAndPerformAction("id", "search_src_text", "typeText", "Search Podcasts", 100);
            appiumWebDriver.backScreen(1, 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Show All Podcasts", "click", "Click All Podcasts", 10000);
            for (int i = 1; i < 5; i++) {
                appiumWebDriver.findElementAndPerformAction("id", "name", "click", "Clicked Podcast " + Integer.toString(i), 2000);
                appiumWebDriver.findElementAndPerformAction("id", "playPauseProgress", "click", "Clicked Top Podcast", 45000);
                appiumWebDriver.backScreen(1, 3000);
                appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            }
            appiumWebDriver.backScreen(1, 1000);

            appiumWebDriver.findElementAndPerformAction("id", "playPauseProgress", "click", "Stop Background play", 100);
            System.out.println("Completed iHeartRadio Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in iHeartRadio Execution");
        }
    }
}
