package pinterest;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;
import java.util.Random;

public class PinterestBrowse implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 21/11/2017
     * Content: This file contents steps to interact with Pinterest Application to use its functionalities
     *
     * Functionalities Covered:
     *     Browse
     *     Save Pins
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

    public PinterestBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);

            /* Search and save pins to board */

            appiumWebDriver.findElementAndPerformAction("id", "adapter_vw", "clickChild", "Click a recent Pin", 3000);
            appiumWebDriver.findElementAndPerformAction("id", "save_pinit_bt", "click", "Click save Pin", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Trial", "click", "Click add to board", 10000);
            appiumWebDriver.findElementAndPerformAction("accessId", "More…", "click", "Click More options", 100);
            appiumWebDriver.findElementAndPerformAction("text", "Download", "click", "Click download", 100);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.backScreen(1, 1000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));

            /* Search notifications and Profile */

            appiumWebDriver.findElementAndPerformAction("accessId", "Notifications", "click", "Click Notifications tab", 3000);
            appiumWebDriver.backScreen(1, 1000);
            appiumWebDriver.findElementAndPerformAction("id", "profile_menu_view", "click", "Click profile", 5000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.findElementAndPerformAction("id", "content_pins_tab", "click", "Click profile contents tab", 5000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.findElementAndPerformAction("id", "content_tried_tab", "click", "Click profile tried tab", 5000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            appiumWebDriver.backScreen(1, 1000);

            System.out.println("Completed PinterestBrowse Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in PinterestBrowse Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
