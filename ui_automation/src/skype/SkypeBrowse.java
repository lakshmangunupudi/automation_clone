package skype;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class SkypeBrowse implements executeFunctionality {

    //APP LOGIN Details
    String UserNamePassword = "cisco.starent@gmail.com/cisco12345"+"p2padcstarent@gmail.com/starent123";

    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.skype.raider";
    String activity = "com.skype4life.MainActivity";
    String mob1 = "P2PCisco111";
    String mob2 = "P2PCisco222";
    String groupName = "TestGroup";

    public SkypeBrowse(String udID1, String udID2) {
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

    protected void SkypeBrowse() throws Exception {
        System.out.println("Entered function SkypeBrowse");

        //GROUP
        appiumWebDriver1.findElementAndPerformAction("contentDesc","New Conversation or call","click","Clicked + Button",1000);
        appiumWebDriver1.findElementAndPerformAction("text","New Group","click","Selected New Group Option",2000);
        appiumWebDriver1.keyStroke = groupName;
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Group Name:","typeText","Written Group Name",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Select group profile picture","click","Selecting Profile Pic",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Upload photo","click","Selecting Pic...",3000);
        appiumWebDriver1.touchAction.tap(300,650).perform();
        Thread.sleep(2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Put Profile Pic",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Next, enabled","click","Clicked on NEXT",1000);
        appiumWebDriver1.findElementAndPerformAction("text",mob2,"click","Selected Participant",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Done","click","Group Created",10000);
        appiumWebDriver1.findElementAndPerformAction("text",groupName,"click","Inside Group Settings, Deleting Group...",2000);
        appiumWebDriver1.findElementAndPerformAction("scroll","Leave group","click","Deleting Group...",2000);
        appiumWebDriver1.findElementAndPerformAction("osId","button1","click","Left Group",5000);

        appiumWebDriver2.findElementAndPerformAction("text",groupName,"click","Inside Group, Deleting Group...",2000);
        appiumWebDriver2.findElementAndPerformAction("text",groupName,"click","Inside Group Settings, Deleting Group...",2000);
        appiumWebDriver2.findElementAndPerformAction("scroll","Leave group","click","Deleting Group...",2000);
        appiumWebDriver2.findElementAndPerformAction("osId","button1","click","Left Group",5000);

        //New Hightlight
        appiumWebDriver1.findElementAndPerformAction("contentDesc","New Conversation or call","click","Clicked + Button",1000);
        appiumWebDriver1.findElementAndPerformAction("text","New Highlight","click","Selected New Highlight Option",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Capture photo or video","click","Captured a Photo",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Send","click","Sent Highlight",2000);

        //INVITE PEOPLE using whatsapp
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "New Conversation or call", "click", "Clicked + Button", 1000);
        appiumWebDriver1.findElementAndPerformAction("text", "Invite People To Skype", "click", "Selected Invite People To Skype Option", 5000);
        appiumWebDriver1.findElementAndPerformAction("text", "WhatsApp", "click", "Selected WhatsApp", 4000);
        appiumWebDriver1.findElementAndPerformAction("text", "My status", "click", "Selected My Status", 1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "Send", "click", "Sending Invite Link", 2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc", "Send", "click", "Sent Invite Link", 2000);

        //Profile Settings - Help
        appiumWebDriver1.findElementAndPerformAction("contentDesc","My info, No new notifications.","click","Going Inside Profile Settings",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Settings","click","Clicked On Settings",2000);
        appiumWebDriver1.findElementAndPerformAction("scroll","Help and feedback","click","Clicked On Help and feedback",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Get help","click","Clicked on Get help",10000);
        appiumWebDriver1.scrollScreenVertical(2);
        Thread.sleep(2000);
        appiumWebDriver1.touchAction.tap(300,500).perform();
        Thread.sleep(7000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Play","click","Playing Help Topic Video",30000);

        System.out.println("Exiting function SkypeBrowse");
    }

    @Override
    public void execute() {
        try {
            Thread.sleep(5000);
            SkypeBrowse();
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
