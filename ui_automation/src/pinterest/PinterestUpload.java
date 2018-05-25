package pinterest;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;
import java.util.Random;

public class PinterestUpload implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 21/11/2017
     * Content: This file contents steps to interact with Pinterest Application to use its functionalities
     *
     * Functionalities Covered:
     *     Upload New Pin
     *
     * All rights by CISCO
     *
     * String username = "p2p.adc@gmail.com";
     * String password = "starent123";
     **/

    private String appPackage = "com.pinterest";
    private String appActivity = "com.pinterest.activity.task.activity.MainActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public PinterestUpload(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);

            /* Create a photo pin */

            appiumWebDriver.findElementAndPerformAction("id", "profile_menu_view", "click", "Click profile", 5000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Create a Pin", "click", "Click Create new pin", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "create_photos", "click", "Click create photo", 100);
            appiumWebDriver.findElementAndPerformAction("id", "photo", "click", "Click choose photo", 100);
            appiumWebDriver.findElementAndPerformAction("id", "capture_button", "click", "Click capture photo", 100);
            appiumWebDriver.findElementAndPerformAction("id", "save_pinit_bt", "click", "Click save pin", 100);
            appiumWebDriver.findElementAndPerformAction("text", "Trial", "click", "Click add to board", 10000);

            /* Create a webpage pin */

            appiumWebDriver.findElementAndPerformAction("accessId", "Create a Pin", "click", "Click Create webpage pin", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "create_website", "click", "Click create website", 100);
            appiumWebDriver.keyStroke = "www.google.com";
            appiumWebDriver.findElementAndPerformAction("id", "website_url_et", "typeText", "Enter Url", 100);
            appiumWebDriver.findElementAndPerformAction("id", "modal_done_btn", "click", "Click parse webpage", 50000);
            appiumWebDriver.findElementAndPerformAction("id", "adapter_vw", "clickChild", "Click top image", 100);
            appiumWebDriver.findElementAndPerformAction("text", "Trial", "click", "Click add to board", 5000);

            System.out.println("Completed PinterestUpload Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in PinterestUpload Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
