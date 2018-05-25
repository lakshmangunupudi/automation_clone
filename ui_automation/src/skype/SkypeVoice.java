package skype;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class SkypeVoice implements executeFunctionality {

    //APP LOGIN Details
    String UserNamePassword = "cisco.starent@gmail.com/cisco12345"+"p2padcstarent@gmail.com/starent123";

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.skype.raider";
    String activity = "com.skype4life.MainActivity";
    String mob1 = "P2PCisco111";
    String mob2 = "P2PCisco222";

    public SkypeVoice(String udID1, String udID2) {
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

    protected void SkypeVoiceCall(int call_duration) throws Exception {
        System.out.println("Entered function SkypeVoiceCall");

        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search Skype","click","Clicked on Search User",1000);
        appiumWebDriver1.keyStroke = mob2+"\n";
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search","typeText","Searched Peer",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc",mob2,"click","Selected Peer",3000);

        //ACCEPT SCENARIO
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Audio Call","click","Calling....",2000);
        appiumWebDriver2.findElementAndPerformAction("contentDesc","Answer call from "+mob1+" with voice only","click","Answered Voice Call",call_duration);
        appiumWebDriver1.touchAction.tap(360,550).perform();
        Thread.sleep(1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Turn video on","click","Made Video ON",10000);
        appiumWebDriver1.touchAction.tap(360,550).perform();
        Thread.sleep(1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","End call","click","Call Ended",3000);

        //DECLINE SCENARIO
        try {
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "Audio Call", "click", "Calling Again....", 2000);
            appiumWebDriver2.findElementAndPerformAction("contentDesc","Decline","click","Rejected Voice Call",2000);
        } catch (Exception ex) {
            System.out.println("Unexpected Screen.. Going back and retry");
            appiumWebDriver1.backScreen(1,2000);
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "Audio Call", "click", "Calling Again...", 1000);
            appiumWebDriver2.findElementAndPerformAction("contentDesc","Decline","click","Rejected Voice Call",2000);
        }

        System.out.println("Exiting function SkypeVoiceCall");
    }

    @Override
    public void execute() {
        try {
            Thread.sleep(3000);
            SkypeVoiceCall(120000);
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception exp) {
            System.out.println("Exception in SkypeVoiceCall Execution");
        }

        System.out.println("Closing Driver");
        appiumWebDriver1.closeDriver();
        appiumWebDriver2.closeDriver();
    }

}

