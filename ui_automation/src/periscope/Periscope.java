package periscope;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class Periscope implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 20/11/2017
     * Content: This file contents steps to interact with Periscope Application to use its functionalities
     *
     * Functionalities Covered:
     *     Browse
     *     Watch Live Stream
     *     Stream
     *
     * All rights by CISCO
     *
     * String username = "p2p.adc@gmail.com";
     * String password = "starent123";
     **/

    private String appPackage = "tv.periscope.android";
    private String appActivity = "tv.periscope.android.ui.main.MainActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public Periscope(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);

            /* Browse recent activities */

            appiumWebDriver.scrollScreenVertical(random.nextInt(14));

            /* Watch and Browse a LIVE Stream */

            appiumWebDriver.findElementAndPerformAction("accessId", "Live broadcasts", "click", "Click Live broadcasts tab", 100);
            appiumWebDriver.findElementAndPerformAction("text", "LIVE", "click", "Click Live video", 45000);
            appiumWebDriver.backScreen(1, 2000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));

            /* Watch and Browse a LIVE Stream from Map View */

            appiumWebDriver.findElementAndPerformAction("accessId", "Map", "click", "Click Map tab", 100);
            appiumWebDriver.findElementAndPerformAction("accessId", "Google Map", "click", "Click a location", 100);
            appiumWebDriver.findElementAndPerformAction("text", "LIVE", "click", "Click Live map video", 45000);
            appiumWebDriver.backScreen(1, 1000);

            /* Go Home to start LIVE Stream */

            appiumWebDriver.findElementAndPerformAction("accessId", "Home feed", "click", "Click Home tab", 100);
            appiumWebDriver.findElementAndPerformAction("accessId", "Go Live", "click", "Click Go Live", 100);
            appiumWebDriver.keyStroke = "Automation Trial";
            appiumWebDriver.findElementAndPerformAction("text", "happening", "typeText", "Click Title for video", 100);
            appiumWebDriver.backScreen(1, 1000);
            appiumWebDriver.findElementAndPerformAction("text", "GO LIVE", "click", "Started Live Stream", 45000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Flip camera", "click", "Click Flip camera", 100);
            appiumWebDriver.findElementAndPerformAction("text", "STOP BROADCASTING", "click", "Click Stop Broadcase", 2000);
            appiumWebDriver.findElementAndPerformAction("accessId", "View Stats", "click", "Click View Stats", 5000);
            try {
                appiumWebDriver.findElementAndPerformAction("text", "Save", "click", "Click Save to Gallery", 10000);
            } catch (Exception exp) {
                System.out.println("No viewers at appiumWebDriver time so cant save.");
            }
            appiumWebDriver.backScreen(1, 1000);
            Thread.sleep(10000);

            appiumWebDriver.findElementAndPerformAction("accessId", "Find people", "click", "Click Find people", 3000);

            System.out.println("Completed Periscope Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in Periscope Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
