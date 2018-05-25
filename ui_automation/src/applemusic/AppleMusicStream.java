package applemusic;

import java.util.*;
import java.io.PrintWriter;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppleMusicStream implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 28/11/2017
     * Content: This file contents steps to interact with AppleMusic Application to use its functionalities
     *
     * Functionalities Covered:
     *     Stream
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

    public AppleMusicStream(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(15000);

            /* Download a song */

            appiumWebDriver.findElementAndPerformAction("accessId", "Show navigation drawer", "click", "Click Navigation tab", 3000);
            appiumWebDriver.findElementAndPerformAction("text", "For You", "click", "Click For You", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "title", "click", "Click Top Result", 5000);
            appiumWebDriver.findElementAndPerformAction("contentDesc", "Add to Library", "click", "Click Add to Library", 5000);
            appiumWebDriver.findElementAndPerformAction("accessId", "Download", "click", "Click Download", 60000);
            appiumWebDriver.backScreen(1, 1000);

            /* Search and Play songs */

            Map<String, List> categoriesInterrested = new HashMap<>();
            int backScreen;

            List<String> albumCategories = new ArrayList<>();
            albumCategories.add("Albums");
            albumCategories.add("Shared Playlist");

            List<String> tvCategories = new ArrayList<>();
            tvCategories.add("TV Episodes");
            tvCategories.add("TV & Movies");

            List<String> movieCategories = new ArrayList<>();
            movieCategories.add("Songs");
            movieCategories.add("Music Videos");
            movieCategories.add("Connect");

            List<String> radioCategories = new ArrayList<>();
            radioCategories.add("Stations");
            radioCategories.add("Playlists");
            radioCategories.add("Curators");
            radioCategories.add("Shows");

            List<String> beats1Categories = new ArrayList<>();
            beats1Categories.add("Music Videos");
            beats1Categories.add("Connect");

            categoriesInterrested.put("album", albumCategories);
            categoriesInterrested.put("tv episodes", tvCategories);
            categoriesInterrested.put("movies", movieCategories);
            categoriesInterrested.put("radio stations", radioCategories);
            categoriesInterrested.put("beats1", beats1Categories);

            Iterator categoryIterator = categoriesInterrested.entrySet().iterator();
            while (categoryIterator.hasNext()) {
                Map.Entry mEntry = (Map.Entry) categoryIterator.next();
                ArrayList subCategories = (ArrayList) mEntry.getValue();
                Iterator subCategoriesIterator = subCategories.iterator();
                while (subCategoriesIterator.hasNext()) {
                    String subCategory = (String) subCategoriesIterator.next();
                    backScreen = 1;

                    appiumWebDriver.findElementAndPerformAction("accessId", "Search", "click", "Click Search", 100);
                    appiumWebDriver.keyStroke = mEntry.getKey() + "\n\n";
                    appiumWebDriver.findElementAndPerformAction("osId", "search_src_text", "typeText", "Entered search text " + mEntry.getKey(), 10000);
                    appiumWebDriver.findElementAndPerformAction("simpleScroll", subCategory, "locate", "Scroll to " + subCategory + " in " + mEntry.getKey(), 3000);
                    findProfilePic(subCategory);

                    switch (subCategory) {
                        case "Songs":
                        case "Connect":
                        case "Stations":
                        case "Beats 1 Episodes":
                            profilePic.click();
                            Thread.sleep(30000);
                            try {
                                appiumWebDriver.findElementAndPerformAction("accessId", "Pause", "click", "Click Pause", 2000);
                            } catch (Exception exp) {
                                Thread.sleep(15000);
                                backScreen = 2;
                            }
                            break;
                        case "TV & Movies":
                        case "Music Videos":
                        case "TV Episodes":
                            profilePic.click();
                            Thread.sleep(15000);
                            appiumWebDriver.findElementAndPerformAction("id", "header_play_button", "click", "Click Start TV", 30000);
                            backScreen = 3;
                            break;
                        case "Albums":
                        case "Playlists":
                        case "Shared Playlist":
                            profilePic.click();
                            Thread.sleep(10000);
                            appiumWebDriver.findElementAndPerformAction("text", "SHUFFLE", "click", "Click Album Shuffle Play", 30000);
                            appiumWebDriver.findElementAndPerformAction("accessId", "Pause", "click", "Click Pause", 2000);
                            backScreen = 2;
                            break;
                        case "Curators":
                            profilePic.click();
                            Thread.sleep(5000);
                            backScreen = 2;
                            break;
                        case "Shows":
                            profilePic.click();
                            Thread.sleep(10000);
                            appiumWebDriver.findElementAndPerformAction("id", "list_profile_icon", "click", "Click Show", 30000);
                            appiumWebDriver.findElementAndPerformAction("accessId", "Pause", "click", "Click Pause", 2000);
                            backScreen = 2;
                            break;
                        default:
                            break;
                    }

                    appiumWebDriver.backScreen(backScreen, 3000);

                }

            }

            System.out.println("Completed AppleMusicStream Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            appiumWebDriver.closeDriver();
            System.out.println("Exception in AppleMusicStream Execution");
        }
    }

    private void findProfilePic(String category) {
        this.profilePic = appiumWebDriver.appiumDriver.findElement(By.xpath("//*[contains(@text,'" + category + "')]/../following-sibling::android.widget.RelativeLayout")).findElement(By.id(appPackage + ":id/" + "list_profile_icon"));
    }
}
