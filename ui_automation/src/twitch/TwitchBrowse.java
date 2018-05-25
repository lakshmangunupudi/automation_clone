package twitch;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class TwitchBrowse implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 15/11/2017
     * Content: This file contents steps to interact with Twitch Application to use its functionalities
     * All rights by CISCO
     *
     * Functionalities Covered:
     *     Browse
     *     Play some streams
     *
     * String username = "p2padc";
     * String password = "starent123";
     **/

    private String appPackage = "tv.twitch.android.app";
    private String appActivity = "tv.twitch.android.app.core.LandingActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public TwitchBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(10000);

            /* Browse All Tabs */
            /* Browse Live Tab */

            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            System.out.println("Completed Stage: Browsing Live Videos");
            System.out.println("Completed Twitch Live Tab Execution");

            /* Browse Pulse Tabs */

            appiumWebDriver.findElementAndPerformAction("text", "Pulse", "click", "Clicked Pulse", 100);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            System.out.println("Completed Stage: Browsing Pulse Tab");
            Thread.sleep(40000);
            System.out.println("Completed Twitch Pulse Tab Execution");

            /* Browse Games Tabs */

            appiumWebDriver.findElementAndPerformAction("text", "Browse", "click", "Clicked Browse", 100);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            System.out.println("Completed Stage: Browsing Games Tab");
            appiumWebDriver.findElementAndPerformAction("id", "game_metadata", "click", "Clicked a game chanel", 100);
            appiumWebDriver.findElementAndPerformAction("id", "stream_thumbnail", "click", "Clicked Game Live Stream", 45000);
            appiumWebDriver.backScreen(1, 3000);
            appiumWebDriver.findElementAndPerformAction("id", "draggable_container", "swipeLeft", "Closed game video", 3000);
            System.out.println("Completed Twitch Game Tab Execution");

            /* Browse Game-Video Tabs */

            appiumWebDriver.findElementAndPerformAction("text", "Video", "click", "Clicked a game chanel video", 100);
            appiumWebDriver.findElementAndPerformAction("id", "vod_thumbnail", "click", "Clicked a game video", 45000);
            appiumWebDriver.backScreen(1, 1000);
            appiumWebDriver.findElementAndPerformAction("id", "draggable_container", "swipeLeft", "Closed game video", 3000);
            System.out.println("Completed Twitch Game-Video Tab Execution");

            /* Browse Game-Clip Tabs */

            appiumWebDriver.findElementAndPerformAction("text", "Clip", "click", "Clicked a game chanel clip", 100);
            appiumWebDriver.findElementAndPerformAction("text", "Watch", "click", "Watched a full video clip", 30000);
            appiumWebDriver.backScreen(1, 3000);
            appiumWebDriver.findElementAndPerformAction("id", "draggable_container", "swipeLeft", "Closed game video", 2000);
            appiumWebDriver.backScreen(1, 2000);
            System.out.println("Completed Twitch Game-Clip Tab Execution");

            /* Browse Popular Tabs */

            appiumWebDriver.findElementAndPerformAction("text", "Popular", "click", "Clicked Popular", 100);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            System.out.println("Completed Stage: Browsing Popular Tab");
            appiumWebDriver.findElementAndPerformAction("id", "stream_thumbnail", "click", "Clicked Popular Live Stream", 45000);
            appiumWebDriver.backScreen(1, 3000);
            appiumWebDriver.findElementAndPerformAction("id", "draggable_container", "swipeLeft", "Closed Video", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Live", "click", "Clicked Popular", 3000);
            System.out.println("Completed Twitch Popular Tab Execution");

            System.out.println("Completed TwitchBrowse Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in Twitch Execution");
        }
    }
}
