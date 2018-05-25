package whatsapp;

import P2pAppiumGuiAutomation.AppiumWebDriver;

import java.io.PrintWriter;
import P2pAppiumGuiAutomation.executeFunctionality;

public class WhatsAppVoiceCall implements executeFunctionality {

    //SAVE TWO NUMBERS as "Mobile1(primary) & Mobile2(secondary)" IN TWO MOBILES AND LOGIN
    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.whatsapp";
    String activity = "com.whatsapp.Main";

    public WhatsAppVoiceCall(String udID1, String udID2) {
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


    protected void whatsappVoiceCalling(int call_duration) throws Exception {
        System.out.println("Entering Func whatsappVoiceCalling");
        appiumWebDriver1.findElementAndPerformAction("text", "CALLS", "click", "Call TAB",1000);
        System.out.println("Clearing Old Call Logs -- Issue seen Call Logs has to be there");
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "More options", "click", "Clicked Option Button",0);
        appiumWebDriver1.findElementAndPerformAction("text", "Clear call log", "click", "Clicked Clear Call Log",0);
        appiumWebDriver1.findElementAndPerformAction("text", "OK", "click", "Log Cleared",5000);

        //DECLINE FIRST
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "New call", "click", "Clicked Call Button",1000);
        appiumWebDriver1.findElementAndPerformAction("id", "contactpicker_call_button", "click", "Calling Mobile1",2000);
        try {
            appiumWebDriver2.findElementAndPerformAction("id", "decline_incoming_call_view", "swipeUpShakingButton", "Call Declined",2000);
        } catch (Exception ex) {
            System.out.println("\n\nCall Missed, Trying Again");
            appiumWebDriver1.findElementAndPerformAction("id", "call_back_btn", "click", "Calling....",2000);
            appiumWebDriver2.findElementAndPerformAction("id", "decline_incoming_call_view", "swipeUpShakingButton", "Call Declined in 2nd Attempt",2000);
        }

        //ACCEPT
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "New call", "click", "Again Clicked Call Button",1000);
        appiumWebDriver1.findElementAndPerformAction("id", "contactpicker_call_button", "click", "Again Calling Mobile1",2000);
        try {
            appiumWebDriver2.findElementAndPerformAction("id", "accept_incoming_call_view", "swipeUpShakingButton", "Call Answered",0);
        } catch (Exception ex) {
            System.out.println("\n\nCall Missed, Trying Again");
            appiumWebDriver1.findElementAndPerformAction("id", "call_back_btn", "click", "Calling....",2000);
            appiumWebDriver2.findElementAndPerformAction("id", "accept_incoming_call_view", "swipeUpShakingButton", "Call Answered in 2nd Attempt",0);
        }
        Thread.sleep(call_duration);
        appiumWebDriver2.findElementAndPerformAction("id", "end_call_btn", "click", "Call Ended",0);
        System.out.println("Exiting Func whatsappVoiceCalling");
    }


    @Override
    public void execute() {
        try {
            whatsappVoiceCalling(120000);
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception exp) {
            System.out.println("Exception in whatsappVoiceCalling Execution");
        }

        System.out.println("Closing Driver");
        appiumWebDriver1.closeDriver();
        appiumWebDriver2.closeDriver();
    }

}
