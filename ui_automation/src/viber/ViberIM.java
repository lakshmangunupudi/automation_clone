package viber;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class ViberIM implements executeFunctionality {
    //SAVE TWO NUMBERS as "Mobile1(primary) & Mobile2(secondary)" IN TWO MOBILES AND LOGIN
    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.viber.voip";
    String activity = "com.viber.voip.WelcomeActivity";
    String mob1 = "Mobile1";
    String mob2 = "Mobile2";

    public ViberIM(String udID1, String udID2) {
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

    protected void viberInstantMessaging() throws Exception {
        System.out.println("Entering Func viberInstantMessaging");

        //CHAT WINDOW
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search","click","Clicked On search Button  in 1st Mobile",1000);
        appiumWebDriver1.keyStroke = mob2+"\n";
        appiumWebDriver1.findElementAndPerformAction("id","search_src_text","typeText","Searched Peer in 1st Mobile",2000);
        appiumWebDriver1.findElementAndPerformAction("id","root","click","Selected Peer in 1st Mobile",2000);

        appiumWebDriver2.findElementAndPerformAction("contentDesc","Search","click","Clicked On search Button  in 2nd Mobile",1000);
        appiumWebDriver2.keyStroke = mob1+"\n";
        appiumWebDriver2.findElementAndPerformAction("id","search_src_text","typeText","Searched Peer in 2nd Mobile",2000);
        appiumWebDriver2.findElementAndPerformAction("id","root","click","Selected Peer  in 2nd Mobile",2000);

        //TEXT
        appiumWebDriver1.keyStroke = "Hi";
        appiumWebDriver1.findElementAndPerformAction("id","send_text","typeText","Sending Hi....",1000);
        appiumWebDriver1.findElementAndPerformAction("id","send_icon_container","click","Sent",1000);
        appiumWebDriver1.backScreen(1,1000);

        appiumWebDriver2.keyStroke = "Received Hi";
        appiumWebDriver2.findElementAndPerformAction("id","send_text","typeText","Replying....",1000);
        appiumWebDriver2.findElementAndPerformAction("id","send_icon_container","click","Sent",1000);
        appiumWebDriver2.backScreen(1,1000);

        //STICKER
        appiumWebDriver1.findElementAndPerformAction("id","options_menu_open_stickers","click","Sharing Sticker",2000);
        appiumWebDriver1.findElementAndPerformAction("id","sticker_image","click","Sent",1000);
        appiumWebDriver1.backScreen(1,1000);

        //PHOTO
        appiumWebDriver1.findElementAndPerformAction("id","options_menu_open_custom_camera","click","Sharing Photo",2000);
        appiumWebDriver1.findElementAndPerformAction("id","take_photo","click","Clicked Photo",2000);
        appiumWebDriver1.keyStroke = "TestPic";
        appiumWebDriver1.findElementAndPerformAction("id","custom_cam_preview_media_description","typeText","Written Desc.",1000);
        appiumWebDriver1.findElementAndPerformAction("id","btn_send","click","Sent",4000);
        appiumWebDriver2.findElementAndPerformAction("id","preview","click","Watching at Receiving End",2000);
        appiumWebDriver2.backScreen(1,1000);

        //VIDEO
        appiumWebDriver1.findElementAndPerformAction("id","options_menu_open_custom_camera","click","Sharing Video",2000);
        appiumWebDriver1.findElementAndPerformAction("id","take_photo","record","Recorded Video",2000);
        appiumWebDriver1.keyStroke = "TestVideo";
        appiumWebDriver1.findElementAndPerformAction("id","custom_cam_preview_media_description","typeText","Written Desc.",1000);
        appiumWebDriver1.findElementAndPerformAction("id","btn_send","click","Sent",7000);
        appiumWebDriver2.findElementAndPerformAction("id","play_btn","click","Downloding at Receiving End",5000);

        //YOUTUBE VIDEO
        appiumWebDriver1.findElementAndPerformAction("id","options_menu_open_chat_extensions","click","Sharing Youtube Video Link",2000);
        System.out.println("Youtube should be selected by default");
        appiumWebDriver1.findElementAndPerformAction("text","SEND","click","Sent",3000);
        appiumWebDriver2.touchAction.tap(300,500).perform();
        System.out.println("Started video at Receiving End");
        Thread.sleep(5000);

        //DOODLE
        appiumWebDriver1.findElementAndPerformAction("id","options_menu_send_doodle","click","Sharing Doodle",2000);
        appiumWebDriver1.findElementAndPerformAction("id","btn_send","click","Sent",2000);

        //AUDIO
        appiumWebDriver1.findElementAndPerformAction("id","send_icon_container","record","Sharing Audio Msg",5000);

        //FILE
        appiumWebDriver1.findElementAndPerformAction("id","options_menu_open_extra_section","click","Sharing a File",2000);
        appiumWebDriver1.findElementAndPerformAction("id","extra_options_menu_send_file","click","Clicked on send File Button",2000);
        appiumWebDriver1.findElementAndPerformAction("scroll","sample.pdf","click","Sent",2000);
        appiumWebDriver2.findElementAndPerformAction("id","file_type_icon","click","Downloaded received file",3000);

        //LOCATION
        appiumWebDriver1.findElementAndPerformAction("id","extra_options_menu_send_location","click","Sharing Location",10000);
        appiumWebDriver1.findElementAndPerformAction("id","menu_send","click","Sent Location",5000);
        appiumWebDriver2.findElementAndPerformAction("id","play_btn","click","Watching peer Location",5000);
        appiumWebDriver2.backScreen(1,1000);


        //CONTACT
        appiumWebDriver1.findElementAndPerformAction("id","extra_options_menu_share_contact","click","Sharing Contact",2000);
        appiumWebDriver1.keyStroke = mob2+"\n";
        appiumWebDriver1.findElementAndPerformAction("id","search_src_text","typeText","Searched Contact",2000);
        appiumWebDriver1.findElementAndPerformAction("id","root","click","Shared Contact",2000);
        appiumWebDriver1.backScreen(1,1000);

        //CLEAR CHAT
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clearing Chat History in mobile1...",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Clear Chat","click","Clicked on Clear chat",1000);
        appiumWebDriver1.findElementAndPerformAction("osId","button1","click","Chat Cleared",2000);

        appiumWebDriver2.findElementAndPerformAction("contentDesc","More options","click","Closed Video...",2000);
        appiumWebDriver2.findElementAndPerformAction("contentDesc","More options","click","Clearing Chat History in mobile2...",1000);
        appiumWebDriver2.findElementAndPerformAction("text","Clear Chat","click","Clicked on Clear chat",1000);
        appiumWebDriver2.findElementAndPerformAction("osId","button1","click","Chat Cleared",2000);

        System.out.println("Exiting Func viberInstantMessaging");

    }

    @Override
    public void execute() {
        try {
            viberInstantMessaging();
            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");
        } catch (Exception exp) {
            System.out.println("Exception in viberInstantMessaging Execution");
        }

        System.out.println("Closing Driver");
        appiumWebDriver1.closeDriver();
        appiumWebDriver2.closeDriver();
    }
}
