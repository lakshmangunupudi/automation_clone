package skype;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class SkypeIM implements executeFunctionality {

    //APP LOGIN Details
    String UserNamePassword = "cisco.starent@gmail.com/cisco12345"+"p2padcstarent@gmail.com/starent123";

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.skype.raider";
    String activity = "com.skype4life.MainActivity";
    String mob1 = "P2PCisco111";
    String mob2 = "P2PCisco222";

    public SkypeIM(String udID1, String udID2) {
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

    protected void SkypeInstantMessaging() throws Exception {
        System.out.println("Entered function SkypeInstantMessaging");

        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search Skype","click","Clicked on Search User",1000);
        appiumWebDriver1.keyStroke = mob2+"\n";
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search","typeText","Searched Peer",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc",mob2,"click","Selected Peer",3000);

        //Text Msg
        appiumWebDriver1.keyStroke = "Hello!!!";
        appiumWebDriver1.findElementAndPerformAction("text","Type a message","typeText","Written Text Msg To Send",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send message","click","Msg Sent",1000);
        appiumWebDriver1.backScreen(1,1000);
        appiumWebDriver2.findElementAndPerformAction("text",mob1,"click","Selected Peer",3000);
        appiumWebDriver2.keyStroke = "Hello Received!!!";
        appiumWebDriver2.findElementAndPerformAction("text","Type a message","typeText","Replying Text Msg",1000);
        appiumWebDriver2.findElementAndPerformAction("contentDesc","Send message","click","Msg Sent",1000);
        appiumWebDriver2.backScreen(1,1000);

        //VOICE
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Record message","click","Recording Audio...",5000);
        appiumWebDriver1.findElementAndPerformAction("accessId", "Send audio message", "click", "Sent Recorded Audio", 3000);

        //PHOTO
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Open camera and media file picker","click","Sending a photo",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Capture photo or video","click","Captured a Photo",3000);
        appiumWebDriver1.findElementAndPerformAction("accessId","Send","click","Clicked on Send Button",5000);

        //VIDEO
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Open camera and media file picker","click","Sending a Video",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Capture photo or video","record","Recorded a video",2000);
        appiumWebDriver1.findElementAndPerformAction("accessId","Send","click","Clicked on Send Button",10000);

        //BING SEARCH AND SEND LINK
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test Bing Search",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search","click","Clicked on Bing Search",5000);
        appiumWebDriver1.keyStroke = "abcd\n";
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search the web Enter your search term","typeText","Typed Text to Search",5000);
        appiumWebDriver1.touchAction.tap(40,700).perform();
        System.out.println("Selected a random Video");
        Thread.sleep(5000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Bing Link",3000);
        appiumWebDriver1.backScreen(1,5000);
        
        //LOCATION
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test Location....",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","location","click","Clicked on Location Button",10000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send location","click","Sent Current Location",5000);

        //GIPHY
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test GIPHY....",2000);
        appiumWebDriver1.findElementAndPerformAction("text","GIPHY","click","Clicked on GIPHY Button",5000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent GIF",5000);

        //MSN Weather
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test Whether Link....",2000);
        appiumWebDriver1.findElementAndPerformAction("text","MSN Weather","click","Clicked on MSN Weather",10000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Whether Link",5000);

        //Scoop
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test Scoop....",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Scoop","click","Clicked on Scoop",4000);
        appiumWebDriver1.keyStroke = "cricket\n";
        appiumWebDriver1.findElementAndPerformAction("plainId","__search__","typeText","Searched cricket news",4000);
        System.out.println("Selecting a random Cricket News...");
        appiumWebDriver1.touchAction.tap(300,650).perform();
        Thread.sleep(7000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Cricket news by Scoop",5000);

        //YOUTUBE
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test YOUTUBE....",2000);
        appiumWebDriver1.findElementAndPerformAction("text","YouTube","click","Clicked on YouTube",5000);
        appiumWebDriver1.keyStroke = "Indian\n";
        appiumWebDriver1.findElementAndPerformAction("plainId","__search__","typeText","Searched Random Video",3000);
        System.out.println("Selecting a random Video...");
        appiumWebDriver1.touchAction.tap(300,650).perform();
        Thread.sleep(7000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Youtube Video",5000);

        //TENOR GIF
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test TENOR GIFs....",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Tenor","click","Clicked on Tenor",5000);
        System.out.println("Selecting a random GIF...");
        appiumWebDriver1.touchAction.tap(300,650).perform();
        Thread.sleep(4000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent GIF by TENOR",5000);

        //EVENT
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test EVENT Share....",2000);
        appiumWebDriver1.scrollScreenVertical(1);
        Thread.sleep(2000);
        appiumWebDriver1.findElementAndPerformAction("text","Events","click","Clicked on Events",7000);
        try {
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "Create new event", "click", "Clicked On Create New Event", 5000);
        } catch (Exception ex) {
            System.out.println("No Event in List, Continue..");
        }
        appiumWebDriver1.keyStroke = "TestEvent";
        appiumWebDriver1.findElementAndPerformAction("text", "Event Title", "typeText", "Added Event Title", 1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "Share", "click", "Shared Event", 5000);

        //Vlipsy
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test VLIPSY Share....",2000);
        appiumWebDriver1.scrollScreenVertical(1);
        Thread.sleep(2000);
        appiumWebDriver1.findElementAndPerformAction("text","Vlipsy","click","Clicked on Vlipsy",5000);
        appiumWebDriver1.keyStroke = "Indian\n";
        appiumWebDriver1.findElementAndPerformAction("text","Search video clips","click","Searched Video on Vlipsy",5000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Video By VLIPSY",5000);

        //TRIPADVISOR
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test Trip Advisor Share....",2000);
        appiumWebDriver1.scrollScreenVertical(1);
        Thread.sleep(2000);
        appiumWebDriver1.findElementAndPerformAction("text","TripAdvisor","click","Clicked on TripAdvisor",5000);
        System.out.println("Selecting a random holiday destination...");
        appiumWebDriver1.touchAction.tap(300,800).perform();
        Thread.sleep(5000);
        appiumWebDriver1.touchAction.tap(300,700).perform();
        Thread.sleep(5000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Trip Details By Trip Advisor",5000);

        //TUNEMOJI
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add to chat","click","Test Tune Moji Share....",2000);
        appiumWebDriver1.scrollScreenVertical(1);
        Thread.sleep(2000);
        appiumWebDriver1.findElementAndPerformAction("text","TuneMoji","click","Clicked on TuneMoji",7000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More","click","Clicked on More Options",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Forward","click","Clicked on Forward",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Peer",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Link by TuneMoji",5000);

        System.out.println("Exiting function SkypeInstantMessaging");
    }

    @Override
    public void execute() {
        try {
            Thread.sleep(3000);
            SkypeInstantMessaging();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception exp) {
            System.out.println("Exception in SkypeInstantMessaging Execution");
        }

        System.out.println("Closing Driver");
        appiumWebDriver1.closeDriver();
        appiumWebDriver2.closeDriver();
    }
}
