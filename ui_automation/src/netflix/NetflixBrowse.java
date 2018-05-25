package netflix;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.Random;

public class NetflixBrowse implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 14/11/2017
     * Content: This file contents steps to interact with Netflix Application to use its functionalities
     *
     * Functionalities Covered:
     *     Browse
     *     Download
     *
     * All rights by CISCO
     *
     * String username = "p2p.adc@gmail.com";
     * String password = "testnetflixp2p";
     **/

    private String appPackage = "com.netflix.mediaclient";
    private String appActivity = "com.netflix.mediaclient.ui.launch.UIWebViewActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public NetflixBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(this.appPackage, this.appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(10000);

            /* Search and download a video */

            appiumWebDriver.findElementAndPerformAction("accessId", "Downloads", "click", "Click Downloads", 10000);
            appiumWebDriver.findElementAndPerformAction("text", "DOWNLOAD", "click", "Choose FIND SOMETHING TO DOWNLOAD", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "movie_boxart", "click", "Select a Movie", 5000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Download", "click", "Download Movie", 45000);
            appiumWebDriver.currentButton.click();
            Thread.sleep(3000);
            appiumWebDriver.findElementAndPerformAction("text", "Cancel", "click", "Cancel Download", 100);
            appiumWebDriver.backScreen(3, 3000);

            /* Browse Posts */

            appiumWebDriver.scrollScreenVertical(random.nextInt(14));
            System.out.println("Completed Stage: Browsing Posts");

            System.out.println("Completed NetflixBrowse Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in NetflixBrowse Execution");
            appiumWebDriver.closeDriver();
        }

    }
}
