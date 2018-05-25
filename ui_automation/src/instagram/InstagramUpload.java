package instagram;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class InstagramUpload implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 04/04/2017
     * Content: This file contents steps to interact with Instagram Application to use its functionalities
     *
     * Functionalities Covered:
     *     Upload Photo
     *     Upload Video
     *     Direct Message
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

    public InstagramUpload(String udID) {
        appiumWebDriver = new AppiumWebDriver(this.appPackage, this.appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {

        try {

            Thread.sleep(3000);

            appiumWebDriver.closeAlert("alertTitleContainer");

            /* Trying to upload a photo */

            appiumWebDriver.findElementAndPerformAction("contentDesc", "Camera", "click", "Clicking Upload Photo", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "camera_shutter_button", "click", "Click photo", 100);
            appiumWebDriver.findElementAndPerformAction("id", "recipients_picker_button", "click", "Accept photo", 100);
            appiumWebDriver.findElementAndPerformAction("id", "row_add_to_story_profile_picture", "click", "Select your story", 100);
            appiumWebDriver.findElementAndPerformAction("id", "button_send", "click", "Send to story", 5000);

            /* Trying to upload a video */

            appiumWebDriver.findElementAndPerformAction("contentDesc", "Camera", "click", "Clicking Upload Video", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "camera_shutter_button", "record", "Recording a video", 100);
            appiumWebDriver.findElementAndPerformAction("id", "recipients_picker_button", "click", "Accept video", 100);
            appiumWebDriver.findElementAndPerformAction("id", "row_add_to_story_checkbox", "click", "Select your story for video", 100);
            appiumWebDriver.findElementAndPerformAction("id", "button_send", "click", "Send video to story", 5000);

            /* Trying to send direct message */

            appiumWebDriver.findElementAndPerformAction("accessId", "Message", "click", "Try to send direct message", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Camera", "click", "Start Camera", 100);
            appiumWebDriver.findElementAndPerformAction("id", "camera_shutter_button", "record", "Recording a video", 100);
            appiumWebDriver.findElementAndPerformAction("id", "mode_picker_send_button_overlay", "click", "Choose recipient", 100);
            appiumWebDriver.findElementAndPerformAction("text", friend, "click", "Choose contact", 100);
            appiumWebDriver.findElementAndPerformAction("id", "button_send", "click", "Send video", 100);
            appiumWebDriver.backScreen(1,5000);

            System.out.println("Completed InstagramUpload Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in InstagramUpload Execution");
        }

    }
}
