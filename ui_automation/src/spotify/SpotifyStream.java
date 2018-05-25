package spotify;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SpotifyStream implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 08/12/2017
     * Content: This file contents steps to interact with Spotify Application to use its functionalities
     *
     * Functionalities Covered:
     *     Stream
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

    public SpotifyStream(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);
            appiumWebDriver.platformPackage = "android";

            /* Search and play a song */

            appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click Search", 2000);
            appiumWebDriver.keyStroke = "ar rahman";
            appiumWebDriver.findElementAndPerformAction("id", "search_placeholder", "click", "Click input box", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "query", "typeText", "Type " + appiumWebDriver.keyStroke, 3000);
            appiumWebDriver.findElementAndPerformAction("osId", "icon", "click", "Click top result", 1000);
            appiumWebDriver.findElementAndPerformAction("text", "SHUFFLE PLAY", "click", "Click SHUFFLE PLAY", 45000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Pause", "click", "Click stop playing", 1000);

            /* Play a radio station */

            appiumWebDriver.findElementAndPerformAction("accessId", "Radio", "click", "Click Radio", 2000);
            appiumWebDriver.findElementAndPerformAction("osId", "icon", "click", "Click top result", 1000);
            appiumWebDriver.findElementAndPerformAction("text", "PLAY RADIO", "click", "Click PLAY RADIO", 45000);
            appiumWebDriver.findElementAndPerformAction("text", "PAUSE RADIO", "click", "Click stop playing", 1000);

            /* Browse and play few songs */

            List browseCategories = new ArrayList();
            browseCategories.add("Charts");
            browseCategories.add("Podcasts");

            Iterator browseIterator = browseCategories.iterator();
            while (browseIterator.hasNext()) {
                String subCategory = (String) browseIterator.next();
                appiumWebDriver.findElementAndPerformAction("accessId", "Browse", "click", "Click Browse", 2000);
                appiumWebDriver.findElementAndPerformAction("scroll", subCategory, "click", "Click " + subCategory, 2000);
                appiumWebDriver.findElementAndPerformAction("osId", "icon", "click", "Click top result", 1000);
                String text = "", id = "";
                switch (subCategory) {
                    case "Charts":
                        text = "SHUFFLE PLAY";
                        id = "text";
                        break;
                    case "Podcasts":
                        text = "text2";
                        id = "osId";
                        break;
                }
                appiumWebDriver.findElementAndPerformAction(id, text, "click", "Click SHUFFLE PLAY", 45000);
                appiumWebDriver.findElementAndPerformAction("accessId", "Pause", "click", "Click stop playing", 1000);
            }

            /* Play a video */

            appiumWebDriver.findElementAndPerformAction("accessId", "Browse", "click", "Click Browse", 2000);
            appiumWebDriver.findElementAndPerformAction("scroll", "Videos", "click", "Click Videos", 2000);
            appiumWebDriver.findElementAndPerformAction("scroll", "Trading Playlists", "click", "Click Trading Playlists", 2000);
            appiumWebDriver.findElementAndPerformAction("osId", "icon", "click", "Click top result", 45000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Pause", "click", "Click stop playing", 1000);

            System.out.println("Completed SpotifyStream Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in SpotifyStream Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
