package tumblr;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;
import java.util.Random;

public class TumblrAudioPost implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 23/11/2017
     * Content: This file contents steps to interact with Tumblr Application to use its functionalities
     *
     *  Functionalities Covered:
     *     Create Audio Post
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

    public TumblrAudioPost(String udID) {

        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.platformPackage = "com.android.camera";
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);

            /* Creating Audio Post */

            appiumWebDriver.findElementAndPerformAction("accessId", "Compose a new post", "click", "Click compose a post", 100);
            appiumWebDriver.findElementAndPerformAction("accessId", "audio post", "click", "Click audio post", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "list_item_audio_thumbnail", "click", "Click top song", 100);
            appiumWebDriver.findElementAndPerformAction("id", "action_button", "click", "Click Post button", 10000);

            System.out.println("Completed TumblrAudioPost Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in TumblrAudioPost Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
