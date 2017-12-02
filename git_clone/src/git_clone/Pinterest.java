
/**
 *
 * Author: Rajasekar S <rajassub@cisco.com>
 * Created On: 21/11/2017
 * Content: appiumWebDriver file contents steps to interact with Pinterest Application to use its functionalities
 * All rights by CISCO
 *
 **/

package git_clone;

import java.io.PrintWriter;


public class Pinterest {

    String username = "p2p.adc@gmail.com";
    String password = "starent123";
    AppiumWebDriver appiumWebDriver;

    Pinterest(String udID) {
        appiumWebDriver = new AppiumWebDriver("com.pinterest", "com.pinterest.activity.task.activity.MainActivity", udID);
        appiumWebDriver.getAppiumDriver();
    }

    public void pinterestExecution() {
        try {

            Thread.sleep(5000);

            /* Search and save pins to board */

            appiumWebDriver.findElementAndPerformAction("id", "adapter_vw", "clickChild", "Click a recent Pin");
            Thread.sleep(3000);
            appiumWebDriver.findElementAndPerformAction("id", "save_pinit_bt", "click", "Click save Pin");
            Thread.sleep(3000);
            appiumWebDriver.findElementAndPerformAction("text", "Trial", "click", "Click add to board");
            Thread.sleep(10000);
            appiumWebDriver.findElementAndPerformAction("accessId", "More…", "click", "Click More options");
            appiumWebDriver.findElementAndPerformAction("text", "Download", "click", "Click download");
            appiumWebDriver.scrollScreenVertical(15);
            appiumWebDriver.backScreen();
            appiumWebDriver.scrollScreenVertical(15);

            /* Search notifications and Profile */

            appiumWebDriver.findElementAndPerformAction("accessId", "Notifications", "click", "Click Notifications tab");
            Thread.sleep(3000);
            appiumWebDriver.backScreen();
            appiumWebDriver.findElementAndPerformAction("id", "profile_menu_view", "click", "Click profile");
            Thread.sleep(5000);
            appiumWebDriver.scrollScreenVertical(15);
            appiumWebDriver.findElementAndPerformAction("id", "content_pins_tab", "click", "Click profile contents tab");
            Thread.sleep(5000);
            appiumWebDriver.scrollScreenVertical(15);
            appiumWebDriver.findElementAndPerformAction("id", "content_tried_tab", "click", "Click profile tried tab");
            Thread.sleep(5000);
            appiumWebDriver.scrollScreenVertical(15);
            appiumWebDriver.backScreen();

            /* Create a photo pin */

            appiumWebDriver.findElementAndPerformAction("id", "profile_menu_view", "click", "Click profile");
            Thread.sleep(5000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Create a Pin", "click", "Click Create new pin");
            Thread.sleep(3000);
            appiumWebDriver.findElementAndPerformAction("id", "create_photos", "click", "Click create photo");
            appiumWebDriver.findElementAndPerformAction("id", "photo", "click", "Click choose photo");
            appiumWebDriver.findElementAndPerformAction("id", "capture_button", "click", "Click capture photo");
            appiumWebDriver.findElementAndPerformAction("id", "save_pinit_bt", "click", "Click save pin");
            appiumWebDriver.findElementAndPerformAction("text", "Trial", "click", "Click add to board");

            /* Create a webpage pin */

            appiumWebDriver.findElementAndPerformAction("accessId", "Create a Pin", "click", "Click Create webpage pin");
            Thread.sleep(3000);
            appiumWebDriver.findElementAndPerformAction("id", "create_website", "click", "Click create website");
            appiumWebDriver.keyStroke = "www.cisco.com";
            appiumWebDriver.findElementAndPerformAction("id", "website_url_et", "typeText", "Enter Url");
            appiumWebDriver.findElementAndPerformAction("id", "modal_done_btn", "click", "Click parse webpage");
            Thread.sleep(50000);
            appiumWebDriver.findElementAndPerformAction("id", "adapter_vw", "clickChild", "Click top image");
            appiumWebDriver.findElementAndPerformAction("text", "Trial", "click", "Click add to board");
            appiumWebDriver.findElementAndPerformAction("id", "pin_marklet_dismiss_bt", "click", "Click close board");

            System.out.println("Completed Pinterest Execution");

            PrintWriter writer = new PrintWriter("/Users/raj/Desktop/AlphaApps/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in Pinterest Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
