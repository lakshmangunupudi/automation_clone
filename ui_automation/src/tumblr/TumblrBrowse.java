package tumblr;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;
import java.util.Random;

public class TumblrBrowse implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 23/11/2017
     * Content: This file contents steps to interact with Tumblr Application to use its functionalities
     *
     *  Functionalities Covered:
     *     Browse Posts
     *     Chat
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

    public TumblrBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.platformPackage = "com.android.camera";
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);

            /* Browse various tabs */

            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.findElementAndPerformAction("accessId", "EXPLORE", "click", "Click EXPLORE tab", 3000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.findElementAndPerformAction("accessId", "ACCOUNT", "click", "Click ACCOUNT tab", 5000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.findElementAndPerformAction("text", "LIKES", "click", "Click LIKES tab", 5000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.findElementAndPerformAction("text", "FOLLOWING", "click", "Click FOLLOWING tab", 5000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.findElementAndPerformAction("accessId", "MESSAGES", "click", "Click MESSAGES tab", 3000);

            /* Chat with friend */

            appiumWebDriver.findElementAndPerformAction("id", "action_button", "click", "Click chat", 100);
            appiumWebDriver.keyStroke = friend;
            appiumWebDriver.findElementAndPerformAction("id", "searchable_action_bar", "typeText", "Search contact", 100);
            appiumWebDriver.backScreen(1, 1000);
            appiumWebDriver.findElementAndPerformAction("id", "list_item_blog_avatar", "click", "Click choose contact", 100);
            appiumWebDriver.keyStroke = "hello";
            appiumWebDriver.findElementAndPerformAction("id", "edit_text", "typeText", "Type message", 100);
            appiumWebDriver.findElementAndPerformAction("id", "send", "click", "Click send", 100);
            appiumWebDriver.findElementAndPerformAction("id", "sticker_button", "click", "Click add sticker", 100);
            appiumWebDriver.findElementAndPerformAction("id", "sticker", "click", "Select a sticker", 100);
            appiumWebDriver.findElementAndPerformAction("id", "send", "click", "Click send", 10000);

            System.out.println("Completed TumblrBrowse Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in TumblrBrowse Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
