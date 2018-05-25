package youtube;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class YoutubeBrowse implements executeFunctionality {

    AppiumWebDriver appiumWebDriver;
    String pkg = "com.google.android.youtube";
    String activity = "com.google.android.apps.youtube.app.WatchWhileActivity";

    public YoutubeBrowse(String udID) {
        appiumWebDriver = new AppiumWebDriver(pkg,activity,udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {

        try {

            System.out.println("========EXPLORING LIBRARY OPTIONS======");
            appiumWebDriver.findElementAndPerformAction("contentDesc","Library","click","Library Menu",2000);
            appiumWebDriver.findElementAndPerformAction("text","History","click","Clicked History Button",5000);
            appiumWebDriver.backScreen(1,1000);
            appiumWebDriver.findElementAndPerformAction("text","My videos","click","Clicked My Videos Button",2000);
            appiumWebDriver.backScreen(1,1000);
            appiumWebDriver.findElementAndPerformAction("text","Watch Later","click","Clicked Watch Later Button",2000);
            appiumWebDriver.backScreen(1,1000);
            appiumWebDriver.scrollScreenVertical(1);
            appiumWebDriver.findElementAndPerformAction("text","MyPlaylist","click","Removing Added Playlist",2000);
            appiumWebDriver.findElementAndPerformAction("contentDesc","More options","click","Clicked More Option",1000);
            appiumWebDriver.findElementAndPerformAction("text","Delete playlist","click","Delete Playlist",1000);
            appiumWebDriver.platformPackage = "android";
            appiumWebDriver.findElementAndPerformAction("osId","button1","click","Playlist Deleted",1000);
            appiumWebDriver.backScreen(1,5000);
            System.out.println("========EXPLORING LIBRARY OPTIONS SUCCESSFUL======");


            System.out.println("========EXPLORING OPTION MENU======");
            appiumWebDriver.findElementAndPerformAction("id","mobile_topbar_avatar","click","Options Menu",2000);
            appiumWebDriver.findElementAndPerformAction("text","My channel","click","Clicked on My Channel Button",4000);
            appiumWebDriver.backScreen(1,2000);
            appiumWebDriver.findElementAndPerformAction("id","mobile_topbar_avatar","click","Options Menu",1000);
            appiumWebDriver.findElementAndPerformAction("text","Switch account","click","Clicked on Switch Account",2000);
            appiumWebDriver.backScreen(1,2000);
            appiumWebDriver.findElementAndPerformAction("id","mobile_topbar_avatar","click","Options Menu",1000);
            appiumWebDriver.findElementAndPerformAction("text","Settings","click","Clicked on Settings",1000);
            appiumWebDriver.findElementAndPerformAction("text","Notifications","click","Clicked on Notifications",1000);
            appiumWebDriver.backScreen(2,2000);
            appiumWebDriver.findElementAndPerformAction("id","mobile_topbar_avatar","click","Options Menu",1000);
            appiumWebDriver.findElementAndPerformAction("text","Terms & privacy policy","click","Clicked on Terms & Privacy Policy",5000);
            appiumWebDriver.backScreen(1,2000);
            appiumWebDriver.findElementAndPerformAction("id","mobile_topbar_avatar","click","Options Menu",1000);
            appiumWebDriver.findElementAndPerformAction("text","Help & feedback","click","Clicked on Help & feedback",2000);
            appiumWebDriver.findElementAndPerformAction("text","Send feedback","click","Clicked on Send feedback",3000);
            appiumWebDriver.platformPackage = "com.google.android.gms";
            appiumWebDriver.keyStroke = "Awesome App, loving It";
            appiumWebDriver.findElementAndPerformAction("osId","gf_issue_description","typeText","Written Feedback",0);
            appiumWebDriver.findElementAndPerformAction("osId","common_send","click","Feedback Submitted",7000);
            appiumWebDriver.findElementAndPerformAction("osId","gh_browse_all_articles_title","click","Browsed All Help Articles",0);
            System.out.println("========EXPLORING OPTION MENU SUCCESSFUL======");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception ex) {
            System.out.println("======Exception in Youtube : Browsing=======");
        }

        System.out.println("Closing Driver");
        appiumWebDriver.closeDriver();
    }
}
