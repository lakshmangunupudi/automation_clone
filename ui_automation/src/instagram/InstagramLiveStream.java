package instagram;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class InstagramLiveStream implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 04/04/2017
     * Content: This file contents steps to interact with Instagram Application to use its functionalities
     *
     * Functionalities Covered:
     *     Watch Live Stream
     *     Start Live Stream
     *
     * All rights by CISCO
     *
     * String username = "p2p.adc@gmail.com";
     * String password = "starent123";
     *
     **/

    private String appPackage = "com.instagram.android";
    private String appActivity = "com.instagram.mainactivity.MainTabActivity";
    private String friend = "starentcisco";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public InstagramLiveStream(String udID) {
        appiumWebDriver = new AppiumWebDriver(this.appPackage, this.appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {

        try {

            Thread.sleep(3000);

            appiumWebDriver.closeAlert("alertTitleContainer");

            /* Trying to start a Live Stream */

            appiumWebDriver.findElementAndPerformAction("contentDesc", "Camera", "click", "Clicking Upload Photo", 5000);
            appiumWebDriver.findElementAndPerformAction("text", "LIVE", "click", "Move to LIVE Session", 100);
            appiumWebDriver.findElementAndPerformAction("id", "start_iglive_button", "click", "Start LIVE Stream", 35000);
            appiumWebDriver.findElementAndPerformAction("id", "end_button", "click", "End LIVE Stream", 100);
            appiumWebDriver.findElementAndPerformAction("text", "End Live Video", "click", "Confirm End Stream", 100);
            appiumWebDriver.findElementAndPerformAction("id", "iglive_end_done_button", "click", "Stream Ended", 5000);
            Thread.sleep(5000);

            /* Search and Watch Live Streams */

            try {
                appiumWebDriver.findElementAndPerformAction("accessId", "Search and Explore", "click", "Search Live Streams", 3000);
            } catch (Exception exp) {
                appiumWebDriver.backScreen(1, 1000);
                appiumWebDriver.findElementAndPerformAction("accessId", "Search and Explore", "click", "Search Live Streams", 3000);
            }
            try {
                appiumWebDriver.findElementAndPerformAction("accessId", "Watch Top Live Broadcasts", "click", "Top Live Streams", 5000);
                appiumWebDriver.findElementAndPerformAction("id", "top_live_cover", "click", "Watch Live Stream", 10000);
                appiumWebDriver.backScreen(2, 2000);
            } catch (Exception exp) {
                System.out.println("No LIVE streams available currently");
            }

            System.out.println("Completed InstagramLiveStream Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in InstagramLiveStream Execution");
        }

    }
}
