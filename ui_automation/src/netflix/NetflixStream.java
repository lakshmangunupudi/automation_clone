package netflix;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.PrintWriter;
import java.util.Random;

public class NetflixStream implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 14/11/2017
     * Content: This file contents steps to interact with Netflix Application to use its functionalities
     *
     * Functionalities Covered:
     *     Stream Movies
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

    public NetflixStream(String udID) {
        appiumWebDriver = new AppiumWebDriver(this.appPackage, this.appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(10000);

            /* Search and watch a 3 videos */

            List searchGenre = new ArrayList();
            searchGenre.add("recently");
            searchGenre.add("new release");
            searchGenre.add("murder");

            Iterator iterator = searchGenre.iterator();
            while (iterator.hasNext()) {
                appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click Search", 100);
                appiumWebDriver.keyStroke = (String) iterator.next();
                appiumWebDriver.findElementAndPerformAction("osId", "search_src_text", "typeText", "Search for a " + appiumWebDriver.keyStroke, 3000);
                appiumWebDriver.findElementAndPerformAction("id", "search_result_img", "click", "Click Top Result", 100);
                appiumWebDriver.findElementAndPerformAction("id", "video_play_icon", "click", "Play Movie", 30000);
                appiumWebDriver.backScreen(1, 1000);
            }

            appiumWebDriver.backScreen(1, 1000);

            System.out.println("Completed NetflixStream Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in NetflixStream Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
