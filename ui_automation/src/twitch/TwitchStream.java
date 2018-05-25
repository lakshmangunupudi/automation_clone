package twitch;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

public class TwitchStream implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 15/11/2017
     * Content: This file contents steps to interact with Twitch Application to use its functionalities
     * All rights by CISCO
     *
     * Functionalities Covered:
     *     Live streams
     *
     * String username = "p2padc";
     * String password = "starent123";
     **/

    private String appPackage = "tv.twitch.android.app";
    private String appActivity = "tv.twitch.android.app.core.LandingActivity";
    private AppiumWebDriver appiumWebDriver;

    public TwitchStream(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(10000);

            /* Start a live stream */

            appiumWebDriver.findElementAndPerformAction("text", "Pulse", "click", "Clicked Pulse", 100);
            appiumWebDriver.findElementAndPerformAction("id", "start_broadcast", "click", "Start Broadcast", 100);
            appiumWebDriver.keyStroke = "HelloTrial";
            appiumWebDriver.findElementAndPerformAction("id", "broadcast_title_edit", "typeText", "Entered Title", 100);
            appiumWebDriver.backScreen(1, 1000);
            appiumWebDriver.findElementAndPerformAction("id", "start_broadcast", "click", "Start Live Stream Finally", 45000);
            appiumWebDriver.findElementAndPerformAction("id", "broadcast_end_stream_btn", "click", "End Live Stream Finally", 100);
            appiumWebDriver.findElementAndPerformAction("id", "confirm_btn", "click", "Confirm End Live Stream Finally", 100);
            appiumWebDriver.findElementAndPerformAction("id", "broadcast_review_save_btn", "click", "Save Live Stream Finally", 1000);

            System.out.println("Completed TwitchStream Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in TwitchStream Execution");
        }
    }
}
