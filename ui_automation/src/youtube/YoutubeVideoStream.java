package youtube;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class YoutubeVideoStream implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;
    String pkg = "com.google.android.youtube";
    String activity = "com.google.android.apps.youtube.app.WatchWhileActivity";

    public YoutubeVideoStream(String udID) {
        appiumWebDriver = new AppiumWebDriver(pkg,activity,udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {

        try {
            System.out.println("====VIDEO STREAMING====");
            appiumWebDriver.findElementAndPerformAction("contentDesc", "Search", "click", "Clicked Search Button", 1000);
            appiumWebDriver.keyStroke = "hd free movie" + "\n";
            appiumWebDriver.findElementAndPerformAction("id", "search_edit_text", "typeText", "Searched Video", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "thumbnail_layout", "click", "Played very first Video", 20000);
            appiumWebDriver.findElementAndPerformAction("id", "like_button", "click", "Liked Video", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "dislike_button", "click", "Disliked Video", 5000);
            appiumWebDriver.findElementAndPerformAction("id", "offline_button", "click", "Starting Download running Video", 0);
            try {
                appiumWebDriver.findElementAndPerformAction("id", "remember_stream_setting", "click", "Selected streaming quality", 0);
            } catch (Exception ex) {
                System.out.println("Video already downloaded,delete and continue..");
                appiumWebDriver.findElementAndPerformAction("text", "DELETE", "click", "Already Downloaded, Deleting the same", 2000);
                appiumWebDriver.findElementAndPerformAction("id", "offline_button", "click", "Starting Download running Video", 2000);
                appiumWebDriver.findElementAndPerformAction("id", "remember_stream_setting", "click", "Selected streaming quality", 0);
            }
            appiumWebDriver.findElementAndPerformAction("text", "OK", "click", "Downloading Started", 5000);
            appiumWebDriver.findElementAndPerformAction("contentDesc", "Add to", "click", "Creating Playlist", 1000);
            appiumWebDriver.findElementAndPerformAction("text", "Create a new playlist", "click", "Clicked on Create Playlist", 1000);
            appiumWebDriver.keyStroke = "MyPlaylist";
            appiumWebDriver.findElementAndPerformAction("id", "name", "typeText", "Put name of Playlist", 1000);
            appiumWebDriver.findElementAndPerformAction("text", "OK", "click", "Clicked OK", 2000);
            appiumWebDriver.keyStroke = "Loving this App!!";
            appiumWebDriver.findElementAndPerformAction("scroll", "Add a public comment...", "typeText", "Adding a public comment", 0);
            appiumWebDriver.findElementAndPerformAction("id", "send_button", "click", "Added Public Comment", 0);
            Thread.sleep(40000);
            appiumWebDriver.backScreen(1, 3000);
            appiumWebDriver.findElementAndPerformAction("id", "watch_player", "swipeLeft", "Closed Video Running", 2000);
            appiumWebDriver.findElementAndPerformAction("contentDesc", "Home", "click", "Clicked on Home Button", 3000);
            System.out.println("====VIDEO STREAMING SUCCESSFUL====");

            System.out.println("======WATCH LIVE CHANNEL=======");
            appiumWebDriver.findElementAndPerformAction("contentDesc", "Trending", "click", "Live Channel Screen", 5000);
            appiumWebDriver.findElementAndPerformAction("text", "Live", "click", "Clicked Live Channel Button", 10000);
            appiumWebDriver.findElementAndPerformAction("id", "thumbnail_layout", "click", "Started 1st channel", 60000);
            appiumWebDriver.backScreen(1, 1000);
            appiumWebDriver.findElementAndPerformAction("id", "watch_player", "swipeLeft", "Closed Video Running", 2000);
            appiumWebDriver.findElementAndPerformAction("contentDesc", "Home", "click", "Clicked on Home Button", 3000);
            System.out.println("======WATCH LIVE CHANNEL SUCCESSFUL=======");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

        } catch (Exception ex) {
            System.out.println("======Exception in Youtube : Live Streaming=======");
        }

        System.out.println("Closing Driver");
        appiumWebDriver.closeDriver();
    }
}
