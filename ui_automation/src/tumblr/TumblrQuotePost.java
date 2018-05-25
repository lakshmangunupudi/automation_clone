package tumblr;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;
import java.util.Random;

public class TumblrQuotePost implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 23/11/2017
     * Content: This file contents steps to interact with Tumblr Application to use its functionalities
     *
     *  Functionalities Covered:
     *     Create Quote Post
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

    public TumblrQuotePost(String udID) {

        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.platformPackage = "com.android.camera";
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);

            /* Creating Quote Post */

            appiumWebDriver.findElementAndPerformAction("accessId", "Compose a new post", "click", "Click compose a post", 100);
            appiumWebDriver.findElementAndPerformAction("accessId", "quote post", "click", "Click quote post", 100);
            appiumWebDriver.keyStroke = "Always Keep Moving Forward";
            appiumWebDriver.findElementAndPerformAction("id", "text", "typeText", "Quote Added", 100);
            appiumWebDriver.findElementAndPerformAction("id", "post_gif_btn", "click", "Click Add GIF", 10000);
            appiumWebDriver.findElementAndPerformAction("id", "photo", "click", "Select a GIF", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "action_button", "click", "Click Post button", 10000);

            System.out.println("Completed TumblrQuotePost Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in TumblrQuotePost Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
