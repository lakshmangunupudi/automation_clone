package applemusic;

import java.util.*;
import java.io.PrintWriter;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppleMusicBrowse implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 28/11/2017
     * Content: This file contents steps to interact with AppleMusic Application to use its functionalities
     *
     * Functionalities Covered:
     *     Browse
     *
     * All rights by CISCO
     *
     * String username = "p2padcstarent@gmail.com";
     * String password = "Starent123";
     **/

    private String appPackage = "com.apple.android.music";
    private String appActivity = "com.apple.android.music.onboarding.activities.SplashActivity";
    private AppiumWebDriver appiumWebDriver;
    private WebElement profilePic;
    private Random random = new Random();

    public AppleMusicBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(15000);

            /* Browse various tabs of Apple Music */

            appiumWebDriver.findElementAndPerformAction("accessId", "Show navigation drawer", "click", "Click Navigation tab", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "For You", "click", "Click For You", 5000);
            appiumWebDriver.scrollScreenVertical(random.nextInt(7) + 4);
            System.out.println("Completed Stage: For You");

            List<String> libraryTabs = new ArrayList<>();

            appiumWebDriver.findElementAndPerformAction("accessId", "Show navigation drawer", "click", "Click Navigation tab", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Library", "click", "Click Library", 5000);

            libraryTabs.add("Artists");
            libraryTabs.add("Albums");
            libraryTabs.add("Songs");
            libraryTabs.add("Movies");
            libraryTabs.add("Playlists");

            Iterator libIterator = libraryTabs.iterator();
            while (libIterator.hasNext()) {
                String searchPattern = (String) libIterator.next();
                appiumWebDriver.findElementAndPerformAction("text", searchPattern, "click", "Click " + searchPattern, 5000);
                appiumWebDriver.backScreen(1, 3000);
            }

            appiumWebDriver.scrollScreenVertical(random.nextInt(7));
            System.out.println("Completed Stage: Library");

            appiumWebDriver.findElementAndPerformAction("contentDesc", "Show navigation drawer", "click", "Click Navigation tab", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Radio", "click", "Click Radio", 5000);

            List<String> radioTabs = new ArrayList<>();
            radioTabs.add("Beats");
            radioTabs.add("Radio Stations");

            Iterator radioIterator = radioTabs.iterator();
            while (radioIterator.hasNext()) {
                String searchPattern = (String) radioIterator.next();
                appiumWebDriver.findElementAndPerformAction("text", searchPattern, "click", "Click " + searchPattern, 5000);
                appiumWebDriver.scrollScreenVertical(random.nextInt(4));
                appiumWebDriver.backScreen(1, 3000);
            }

            appiumWebDriver.scrollScreenVertical(random.nextInt(4));
            System.out.println("Completed Stage: Radio");

            appiumWebDriver.findElementAndPerformAction("accessId", "Show navigation drawer", "click", "Click Navigation tab", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "Browse", "click", "Click Browse", 5000);

            appiumWebDriver.scrollScreenVertical(random.nextInt(7) + 3);

            List<String> searchGenre = new ArrayList<>();
            searchGenre.add("New Music");
            searchGenre.add("Playlists");
            searchGenre.add("Films");
            searchGenre.add("Top Charts");
            searchGenre.add("Genres");

            Iterator iterator = searchGenre.iterator();
            while (iterator.hasNext()) {
                String searchPattern = (String) iterator.next();
                appiumWebDriver.findElementAndPerformAction("text", searchPattern, "click", "Click " + searchPattern, 5000);
                appiumWebDriver.scrollScreenVertical(random.nextInt(7));
                appiumWebDriver.backScreen(1, 5000);
                appiumWebDriver.scrollScreenVertical(random.nextInt(7) + 3);
            }
            System.out.println("Completed Stage: Browse");

            System.out.println("Completed AppleMusicBrowse Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in AppleMusicBrowse Execution");
        }
    }

    private void findProfilePic(String category) {
        this.profilePic = appiumWebDriver.appiumDriver.findElement(By.xpath("//*[contains(@text,'" + category + "')]/../following-sibling::android.widget.RelativeLayout")).findElement(By.id(appPackage + ":id/" + "list_profile_icon"));
    }
}
