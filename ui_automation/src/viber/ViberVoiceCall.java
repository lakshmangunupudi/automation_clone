package viber;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class ViberVoiceCall implements executeFunctionality {
    //SAVE TWO NUMBERS as "Mobile1(primary) & Mobile2(secondary)" IN TWO MOBILES AND LOGIN
    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.viber.voip";
    String activity = "com.viber.voip.WelcomeActivity";
    String mob1 = "Mobile1";
    String mob2 = "Mobile2";

    public ViberVoiceCall(String udID1, String udID2) {
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

    protected void viberVoiceCalling(int call_duration) throws Exception {
        System.out.println("Entering Func viberVoiceCalling");

        //ACCEPT
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search","click","Clicked On search Button",1000);
        appiumWebDriver1.keyStroke = mob2+"\n";
        appiumWebDriver1.findElementAndPerformAction("id","search_src_text","typeText","Searched Peer",2000);
        appiumWebDriver1.findElementAndPerformAction("id","root","click","Selected Peer",2000);
        appiumWebDriver1.findElementAndPerformAction("id","menu_viber_call","click","Calling.....",7000);
        appiumWebDriver2.touchAction.press(360,850).waitAction(1000).moveTo(540,850).release().perform();
        System.out.println("Call Answered");
        Thread.sleep(call_duration);
        appiumWebDriver2.findElementAndPerformAction("id","video","click","Made Video ON",30000);
        appiumWebDriver2.touchAction.tap(300,600).perform();
        Thread.sleep(1000);
        appiumWebDriver2.findElementAndPerformAction("id","hangup","click","Call Ended",3000);

        //DECLINE
        try {
            appiumWebDriver1.findElementAndPerformAction("id","menu_viber_call","click","Calling Again.....",7000);
        }catch (Exception ex) {
            System.out.println("Advertisement, go back n retry");
            appiumWebDriver1.backScreen(1,2000);
            appiumWebDriver1.findElementAndPerformAction("id","menu_viber_call","click","Calling Again.....",7000);
        }
        appiumWebDriver2.touchAction.press(360,850).waitAction(1000).moveTo(150,850).release().perform();
        System.out.println("Call Declined");
        Thread.sleep(5000);
        System.out.println("Exiting Func viberVoiceCalling");

    }

    @Override
    public void execute() {
        try {
            viberVoiceCalling(120000);
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception exp) {
            System.out.println("Exception in viberVoiceCalling Execution");
        }

        System.out.println("Closing Driver");
        appiumWebDriver1.closeDriver();
        appiumWebDriver2.closeDriver();
   }
}
