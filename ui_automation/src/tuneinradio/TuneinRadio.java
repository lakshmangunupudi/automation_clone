package tuneinradio;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.PrintWriter;

public class TuneinRadio implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 27/11/2017
     * Content: This file contents steps to interact with TuneinRadio Application to use its functionalities
     *
     * Functionalities Covered:
     *     Browse
     *     Listen to stations
     *
     * All rights by CISCO
     *
     * String username = "p2p.adc@gmail.com";
     * String password = "starent123";
     **/

    private String appPackage = "tunein.player";
    private String appActivity = "tunein.ui.actvities.HomeActivity";
    private AppiumWebDriver appiumWebDriver;

    /* Change settings to stop playing last station */

    public TuneinRadio(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            int flag = 0;
            Thread.sleep(10000);

            /* Search and watch stations */

            List searchGenre = new ArrayList();
            searchGenre.add("radio girmit");
            searchGenre.add("all pod");
            searchGenre.add("all audiobook");
            searchGenre.add("espn");
            searchGenre.add("nbc");
            searchGenre.add("new");
            searchGenre.add("ndtv india");
            searchGenre.add("live music");
            searchGenre.add("dallas");
            searchGenre.add("traffic news");
            searchGenre.add("indian station");
            searchGenre.add("idea");

            Iterator iterator = searchGenre.iterator();
            while (iterator.hasNext()) {
                flag = 0;
                appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click Search", 100);
                appiumWebDriver.keyStroke = (String) iterator.next();
                appiumWebDriver.findElementAndPerformAction("id", "search_src_text", "typeText", "Search for *** " + appiumWebDriver.keyStroke, 3000);
                appiumWebDriver.findElementAndPerformAction("id", "row_square_cell_image", "click", "Click Top Result", 100);
                try {
                    appiumWebDriver.findElementAndPerformAction("id", "profile_primary_button", "click", "Start to play the station", 100);
                } catch (Exception exp) {
                    flag = 1;
                    System.out.println("Station already playing");
                }
                Thread.sleep(20000);
                try {
                    appiumWebDriver.findElementAndPerformAction("id", "mini_player_button_pause", "click", "Stop playing the station", 100);
                } catch (Exception exp) {
                    appiumWebDriver.findElementAndPerformAction("id", "mini_player_button_play", "click", "Start playing the station", 20000);
                    appiumWebDriver.findElementAndPerformAction("id", "mini_player_button_pause", "click", "Stop playing the station", 100);
                }
                if (flag == 0) {
                    appiumWebDriver.backScreen(2, 1000);
                }
                appiumWebDriver.backScreen(2, 10000);
            }

            System.out.println("Completed TuneinRadio Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in TuneinRadio Execution");
        }
    }
}

