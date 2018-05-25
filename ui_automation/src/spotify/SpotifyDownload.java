package spotify;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class SpotifyDownload implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 08/12/2017
     * Content: This file contents steps to interact with Spotify Application to use its functionalities
     *
     * Functionalities Covered:
     *     Download
     *
     * All rights by CISCO
     *
     * String username = "rajasekar.";
     * String password = "Raja13787";
     **/

    private String appPackage = "com.spotify.music";
    private String appActivity = "com.spotify.music.MainActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public SpotifyDownload(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);
            appiumWebDriver.platformPackage = "android";

            /* Search and download */

            appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click Search", 2000);
            appiumWebDriver.keyStroke = "download";
            appiumWebDriver.findElementAndPerformAction("id", "search_placeholder", "click", "Click input box", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "query", "typeText", "Type " + appiumWebDriver.keyStroke, 3000);
            appiumWebDriver.findElementAndPerformAction("osId", "icon", "click", "Click top result", 1000);
            appiumWebDriver.findElementAndPerformAction("text", "OFF", "click", "Click start download", 35000);
            appiumWebDriver.findElementAndPerformAction("text", "ON", "click", "Click stop download", 1000);

            System.out.println("Completed SpotifyDownload Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in SpotifyDownload Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
