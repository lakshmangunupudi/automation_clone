package spotify;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SpotifyBrowse implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 08/12/2017
     * Content: This file contents steps to interact with Spotify Application to use its functionalities
     *
     * Functionalities Covered:
     *     Browse
     *
     * All rights by CISCO
     *
     * String username = "rajasekar.";
     * String password = "Raja13787";
     **/

    private String appPackage = "com.spotify.music";
    private String appActivity = "com.spotify.music.MainActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public SpotifyBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(5000);
            appiumWebDriver.platformPackage = "android";

            /* Browse various tabs in Spotify */

            List searchGenre = new ArrayList();
            searchGenre.add("Home");
            searchGenre.add("Browse");
            searchGenre.add("Search");
            searchGenre.add("Radio");
            searchGenre.add("Your Library");

            Iterator iterator = searchGenre.iterator();
            while (iterator.hasNext()) {
                String category = (String) iterator.next();
                appiumWebDriver.findElementAndPerformAction("accessId", category, "click", "Click " + category, 2000);
                appiumWebDriver.scrollScreenVertical(random.nextInt(8) + 3);

                List browseCategories = new ArrayList();
                browseCategories.add("Charts");
                browseCategories.add("New Releases");
                browseCategories.add("Videos");
                browseCategories.add("Podcasts");
                browseCategories.add("Discover");
                browseCategories.add("Concerts");

                switch (category) {
                    case "Browse":
                        Iterator browseIterator = browseCategories.iterator();
                        while (browseIterator.hasNext()) {
                            String subCategory = (String) browseIterator.next();
                            appiumWebDriver.findElementAndPerformAction("scroll", subCategory, "click", "Click " + subCategory, 2000);
                            appiumWebDriver.scrollScreenVertical(random.nextInt(5) + 2);
                            appiumWebDriver.backScreen(1,2000);
                        }
                        break;
                    default:
                        break;
                }

            }

            System.out.println("Completed SpotifyBrowse Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in SpotifyBrowse Execution");
            appiumWebDriver.closeDriver();
        }
    }
}
