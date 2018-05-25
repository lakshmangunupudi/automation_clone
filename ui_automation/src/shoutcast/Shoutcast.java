package shoutcast;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import org.openqa.selenium.By;

import java.io.PrintWriter;
import java.util.Random;
import java.util.*;

public class Shoutcast implements executeFunctionality {

    /**
     *
     * Author: Rajasekar S <rajassub@cisco.com>
     * Created On: 07/12/2017
     * Content: This file contents steps to interact with Shoutcast Application to use its functionalities
     *
     * Functionalities Covered:
     *     Watch Radio Stations
     *
     * All rights by CISCO
     *
     **/

    private String appPackage = "it.floryn90.shoutcast";
    private String appActivity = "it.floryn90.shoutcast.MainActivity";
    private AppiumWebDriver appiumWebDriver;
    private Random random = new Random();

    public Shoutcast(String udID) {
        appiumWebDriver = new AppiumWebDriver(appPackage, appActivity, udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {
        try {

            Thread.sleep(3000);

            List searchGenre = new ArrayList();
            searchGenre.add("Alternative");
            searchGenre.add("public radio");
            searchGenre.add("sport");
            searchGenre.add("politics");
            searchGenre.add("college");
            searchGenre.add("india");
            searchGenre.add("symphony");
            searchGenre.add("anime");

            Iterator iterator = searchGenre.iterator();
            while (iterator.hasNext()) {
                String category = (String) iterator.next();
                appiumWebDriver.keyStroke = category + "\n";
                appiumWebDriver.findElementAndPerformAction("plainId", "search-focus", "typeText", "Search for " + category, 30000);
                appiumWebDriver.scrollScreenVertical(4);
                appiumWebDriver.currentButton = appiumWebDriver.appiumDriver.findElement(By.xpath("//*[contains(@text,'STATIONS')]/../../following-sibling::android.view.View/android.view.View"));
                appiumWebDriver.currentButton.click();
                Thread.sleep(30000);
                appiumWebDriver.scrollScreenVerticalUp(10);
            }

            System.out.println("Completed Shoutcast Execution");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

            appiumWebDriver.closeDriver();

        } catch (Exception exp) {
            System.out.println("Exception in Shoutcast Execution");
            System.out.println(exp.getMessage());
            System.out.println(exp.getStackTrace());
            appiumWebDriver.closeDriver();
        }
    }
}
