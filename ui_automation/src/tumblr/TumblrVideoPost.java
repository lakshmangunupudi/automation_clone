package tumblr;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class TumblrVideoPost implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 23/11/2017
     * Content: This file contents steps to interact with Tumblr Application to use its functionalities
     *
     *  Functionalities Covered:
     *     Create Video Post
     *
     * All rights by CISCO
     *
     * String username = "p2p.adc@gmail.com";
     * String password = "starent123";
     **/

    private String appPackage = "com.tumblr";
    private String appActivity = "com.tumblr.ui.activity.RootActivity";
    private String friend = "ciscostarenttumbler";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public TumblrVideoPost(String udID) {

        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.platformPackage = "com.android.camera";
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);

            /* Creating Video Post */

            appiumWebDriver.findElementAndPerformAction("accessId", "Compose a new post", "click", "Click compose a post", 100);
            appiumWebDriver.findElementAndPerformAction("accessId", "video post", "click", "Click video post", 100);
            appiumWebDriver.findElementAndPerformAction("id", "gallery_grid_header_camera_button", "click", "Click camera button", 100);
            appiumWebDriver.findElementAndPerformAction("accessId", "Shutter button", "click", "Click a photo", 30000);
            appiumWebDriver.currentButton.click();
            appiumWebDriver.findElementAndPerformAction("osId", "v6_btn_done", "click", "Select the video taken", 10000);
            appiumWebDriver.findElementAndPerformAction("contentDesc", "video2", "click", "Select video", 100);
            appiumWebDriver.keyStroke = "Trial Video Post";
            appiumWebDriver.findElementAndPerformAction("text", "Add a caption", "typeText", "Caption Added", 100);
            appiumWebDriver.findElementAndPerformAction("id", "action_button", "click", "Click Post button", 10000);

            System.out.println("Completed TumblrVideoPost Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in TumblrVideoPost Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
