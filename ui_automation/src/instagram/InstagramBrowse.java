package instagram;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class InstagramBrowse implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 04/04/2017
     * Content: This file contents steps to interact with Instagram Application to use its functionalities
     *
     * Functionalities Covered:
     *     Browse Posts
     *     View Profile
     *     View My story
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

    public InstagramBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(this.appPackage, this.appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {

        try {

            Thread.sleep(3000);

            appiumWebDriver.closeAlert("alertTitleContainer");

            /* Trying to view profile */

            appiumWebDriver.findElementAndPerformAction("accessId", "Profile", "click", "View profile", 3000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Home", "click", "View home", 3000);
            appiumWebDriver.currentButton.click();
            Thread.sleep(10000);

            /* Trying to view my story */

            appiumWebDriver.findElementAndPerformAction("contentDesc", "p2p.adc", "click", "View My Story", 100);
            appiumWebDriver.backScreen(1,5000);

            /* Browse Posts */

            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            System.out.println("Completed Stage: Browsing Posts");

            System.out.println("Completed InstagramBrowse Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in InstagramBrowse Execution");
        }

    }
}
