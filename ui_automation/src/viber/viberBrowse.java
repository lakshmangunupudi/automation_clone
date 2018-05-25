package viber;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class viberBrowse implements executeFunctionality {
    //SAVE TWO NUMBERS as "Mobile1(primary) & Mobile2(secondary)" IN TWO MOBILES AND LOGIN
    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.viber.voip";
    String activity = "com.viber.voip.WelcomeActivity";
    String mob1 = "Mobile1";
    String mob2 = "Mobile2";

    public viberBrowse(String udID1, String udID2) {
        System.out.println("Setup for Mobile1 Start");
        appiumWebDriver1 = new AppiumWebDriver(pkg,activity, udID1);
        appiumWebDriver1.getAppiumDriver();
        appiumWebDriver1.platformPackage = "android";
        System.out.println("Setup for Mobile1 complete");

        // Getting Driver Handle for WhatsApp.WhatsApp in 2ND mobile
        System.out.println("Setup for Mobile2 Start");
        appiumWebDriver2 = new AppiumWebDriver(pkg,activity,udID2);
        appiumWebDriver2.getAppiumDriver();
        appiumWebDriver2.platformPackage = "android";
        System.out.println("Setup for Mobile2 complete");
    }

    protected void viberBrowsing() throws Exception {
        int fl = 0;
        Random rand = new Random();
        int randNum = 2;
        System.out.println("Entering Func viberBrowsing");

        //DISCOVER
        appiumWebDriver2.findElementAndPerformAction("contentDesc","Navigate up","click","Discover Public Account",1000);
        appiumWebDriver2.findElementAndPerformAction("text","Discover","click","Clicked on Discover Public Account",10000);
        appiumWebDriver2.scrollScreenVertical(3);
        Thread.sleep(2000);
        appiumWebDriver2.touchAction.tap(50,600).perform();
        Thread.sleep(2000);

        //AGE confirmation - optional
        try {
            appiumWebDriver2.findElementAndPerformAction("osId", "button1", "click", "Confirmed Age", 2000);
        } catch (Exception ex) {
            System.out.println("No Age Restriction,continue...");
        }

        try {
            appiumWebDriver2.findElementAndPerformAction("id", "follow_btn", "click", "Clicked on Follow", 5000);
        } catch (Exception ex) {
            System.out.println("Follow option not available, continue....");
            fl = 1;
        }

        if(fl == 0) {
            //Follow confirmation - optional
            try {
                appiumWebDriver2.findElementAndPerformAction("osId", "button1", "click", "Started Following", 5000);
            } catch (Exception ex) {
                System.out.println("No confimation Required, continue....");
            }
            appiumWebDriver2.findElementAndPerformAction("id", "public_chat_btn", "click", "Clicked to view Public Chat", 2000);
            appiumWebDriver2.scrollScreenVerticalUp(5);
            appiumWebDriver2.backScreen(1,2000);
            appiumWebDriver2.findElementAndPerformAction("contentDesc", "More options", "click", "Clicked More Options", 1000);
            appiumWebDriver2.findElementAndPerformAction("text", "Unfollow", "click", "Clicked on Unfollow", 3000);
        }

        appiumWebDriver2.backScreen(3, 2000);

        //GROUP
        try {
            appiumWebDriver2.findElementAndPerformAction("id", "fab_compose", "click", "Composing a Group..", 2000);
        } catch (Exception ex) {
            System.out.println("+ Button not found, clicking on compose");
            appiumWebDriver2.findElementAndPerformAction("id", "compose_btn", "click", "Composing a Group..", 2000);
        }
        appiumWebDriver2.findElementAndPerformAction("id","new_group","click","Clicked on New Group",1000);
        appiumWebDriver2.keyStroke = mob1 + "\n";
        appiumWebDriver2.findElementAndPerformAction("id","participant_search","typeText","Searched Participant",1000);
        appiumWebDriver2.findElementAndPerformAction("id","root","click","Selected Participant",1000);
        appiumWebDriver2.findElementAndPerformAction("id","menu_done","click","Group Created",1000);
        appiumWebDriver2.backScreen(1,1000);

        //SECRET CHAT
        try {
            appiumWebDriver2.findElementAndPerformAction("id", "fab_compose", "click", "New Secret Chat...", 2000);
        } catch (Exception ex) {
            System.out.println("+ Button not found, clicking on compose");
            appiumWebDriver2.findElementAndPerformAction("id", "compose_btn", "click", "New Secret Chat...", 2000);
        }
        appiumWebDriver2.findElementAndPerformAction("id","new_secret_chat","click","Clicked on New Secret Chat",1000);
        appiumWebDriver2.keyStroke = mob1 + "\n";
        appiumWebDriver2.findElementAndPerformAction("id","participant_search","typeText","Searched Participant",1000);
        appiumWebDriver2.findElementAndPerformAction("id","root","click","Selected Participant",1000);
        appiumWebDriver2.findElementAndPerformAction("id","menu_done","click","Secret Chat Started",3000);
        appiumWebDriver2.keyStroke = "Hi";
        appiumWebDriver2.findElementAndPerformAction("id","send_text","typeText","Sending Hi Secretely....",1000);
        appiumWebDriver2.findElementAndPerformAction("id","send_icon_container","click","Sent",1000);
        appiumWebDriver2.backScreen(2,1000);

        //SHARE VIBER
        appiumWebDriver2.findElementAndPerformAction("contentDesc","Navigate up","click","Sharing Viber to friend",1000);
        appiumWebDriver2.findElementAndPerformAction("text","Share Viber with friends","click","clicked on share",2000);
        appiumWebDriver2.findElementAndPerformAction("text","Facebook","click","Selected Facebook Option",3000);
        appiumWebDriver2.findElementAndPerformAction("text","POST","click","Posted",3000);

        //DOWNLOAD STICKER
        appiumWebDriver2.findElementAndPerformAction("text","Sticker Market","click","Downloading Sticker",10000);
        appiumWebDriver2.keyStroke = "free\n";
        appiumWebDriver2.findElementAndPerformAction("text","Search","typeText","Searched some free stickers",5000);
        randNum = rand.nextInt(8);
        System.out.println("Random Value -> " + randNum);
        appiumWebDriver2.scrollScreenVertical(randNum);
        Thread.sleep(1000);
        appiumWebDriver2.touchAction.tap(50,700).perform();
        Thread.sleep(10000);
        try {
            appiumWebDriver2.findElementAndPerformAction("text", "FREE DOWNLOAD", "click", "Downloaded  Free Sticker", 10000);
        } catch (Exception ex) {
            System.out.println("Already Downloaded Sticker Selected, no issues..");
        }
        System.out.println("Exiting Func viberBrowsing");
    }

    @Override
    public void execute() {
        try {
            viberBrowsing();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception exp) {
            System.out.println("Exception in viberBrowsing Execution");
        }

        System.out.println("Closing Driver");
        appiumWebDriver1.closeDriver();
        appiumWebDriver2.closeDriver();
    }
}
