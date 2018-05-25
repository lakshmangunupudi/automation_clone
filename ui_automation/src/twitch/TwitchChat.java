package twitch;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

public class TwitchChat implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 15/11/2017
     * Content: This file contents steps to interact with Twitch Application to use its functionalities
     * All rights by CISCO
     *
     * Functionalities Covered:
     *     Chat
     *
     * String username = "p2padc";
     * String password = "starent123";
     **/

    private String appPackage = "tv.twitch.android.app";
    private String appActivity = "tv.twitch.android.app.core.LandingActivity";
    private String friend = "ciscostarent";
    private AppiumWebDriver appiumWebDriver;

    public TwitchChat(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(10000);

            /* Start a chat with friend */

            appiumWebDriver.findElementAndPerformAction("text", "Friends", "click", "Clicked Friends", 1000);
            appiumWebDriver.findElementAndPerformAction("text", "Whispers", "click", "Clicked Whispers", 100);
            appiumWebDriver.findElementAndPerformAction("id", "subtext", "click", "Selected a contact for chat", 100);
            appiumWebDriver.keyStroke = "hello";
            appiumWebDriver.findElementAndPerformAction("id", "message_input_view_container", "typeText", "Chatting", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_send", "click", "send message", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_input_view_container", "typeText", "Chatting", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_send", "click", "send message", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_input_view_container", "typeText", "Chatting", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_send", "click", "send message", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_input_view_container", "typeText", "Chatting", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_send", "click", "send message", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_input_view_container", "typeText", "Chatting", 100);
            appiumWebDriver.findElementAndPerformAction("id", "message_send", "click", "send message", 100);
            appiumWebDriver.backScreen(2, 2000);

            System.out.println("Completed TwitchChat Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in TwitchChat Execution");
        }
    }
}
