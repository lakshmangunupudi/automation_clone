package whatsapp;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;
import java.io.PrintWriter;

public class WhatsAppIM implements executeFunctionality {

    //SAVE TWO NUMBERS as "Mobile1(primary) & Mobile2(secondary)" IN TWO MOBILES AND LOGIN
    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.whatsapp";
    String activity = "com.whatsapp.Main";

    String groupName = "TestGrp";
    String changedGrpName = "TestGrpNew";
    String mob1 = "Mobile1";
    String mob2 = "Mobile2";
    String mailId = "p2p.adc@gmail.com";
    String fileName = "sample.pdf";
    String usb_id_mob1 = "";
    String usb_id_mob2 = "";

    public WhatsAppIM(String udID1, String udID2) {
        usb_id_mob1 = udID1;
        usb_id_mob2 = udID2;
        setUp();
    }

    protected void setUp() {
        System.out.println("Setup for Mobile1 Start");
        appiumWebDriver1 = new AppiumWebDriver(pkg,activity, usb_id_mob1);
        appiumWebDriver1.getAppiumDriver();
        appiumWebDriver1.platformPackage = "android";
        System.out.println("Setup for Mobile1 complete");

        // Getting Driver Handle for WhatsApp.WhatsApp in 2ND mobile
        System.out.println("Setup for Mobile2 Start");
        appiumWebDriver2 = new AppiumWebDriver(pkg,activity,usb_id_mob2);
        appiumWebDriver2.getAppiumDriver();
        appiumWebDriver2.platformPackage = "android";
        System.out.println("Setup for Mobile2 complete");
    }

    protected void cleanUp() {
        System.out.println("Closing Driver");
        appiumWebDriver1.closeDriver();
        appiumWebDriver2.closeDriver();
    }

    protected void whatsappChatAndShare(String Sender,String Receiver) throws Exception {

        System.out.println("Entering Func whatsappChatAndShare");

        appiumWebDriver1.findElementAndPerformAction("id","fab","click","CLicked on New Chat Button",1000);
        appiumWebDriver1.findElementAndPerformAction("text","New group","click","Clicked on New Group",2000);
        appiumWebDriver1.findElementAndPerformAction("id","chat_able_contacts_row_name","click","Selected contact",2000);
        appiumWebDriver1.findElementAndPerformAction("id","next_btn","click","Clicked on NEXT",2000);
        appiumWebDriver1.keyStroke = groupName;
        appiumWebDriver1.findElementAndPerformAction("id","group_name","typeText","Written Group Name",0);
        appiumWebDriver1.findElementAndPerformAction("id","ok_btn","click","New Group Created",5000);

        //CHAT
        appiumWebDriver1.findElementAndPerformAction("text",Sender,"click","Entering Group....",1000);
        try {
            appiumWebDriver1.keyStroke = "Hello All";
            appiumWebDriver1.findElementAndPerformAction("id", "entry", "typeText", "Written Hello",0);
        } catch (Exception ex) {
            System.out.println("Unexpected Screen, go back n retry");
            appiumWebDriver1.backScreen(1,1000);
            appiumWebDriver1.keyStroke = "Hello All";
            appiumWebDriver1.findElementAndPerformAction("id", "entry", "typeText", "Written Hello",0);
        }
        appiumWebDriver1.backScreen(1,1000);

        appiumWebDriver1.findElementAndPerformAction("id","send","click","Sent Hello",2000);
        appiumWebDriver2.findElementAndPerformAction("text",Receiver,"click","Replying with text....",1000);
        try {
            appiumWebDriver2.keyStroke = "Received Hello";
            appiumWebDriver2.findElementAndPerformAction("id", "entry", "typeText", "Written Reply",0);
        } catch (Exception ex) {
            System.out.println("Unexpected Screen, go back n retry");
            appiumWebDriver2.backScreen(1,1000);
            appiumWebDriver2.keyStroke = "Received Hello";
            appiumWebDriver2.findElementAndPerformAction("id", "entry", "typeText", "Written Reply",0);
        }
        appiumWebDriver2.findElementAndPerformAction("id","send","click","Sent Reply",2000);
        appiumWebDriver2.backScreen(1,1000);

        //AUDIO
        appiumWebDriver1.findElementAndPerformAction("id","voice_note_btn","record","Sent Audio",5000);
        appiumWebDriver2.findElementAndPerformAction("id","voice_note_btn","record","Replied with Audio",5000);


        //PHOTO
        appiumWebDriver1.findElementAndPerformAction("id","camera_btn","click","Sending Photo",2000);
        appiumWebDriver1.findElementAndPerformAction("id","switch_camera_btn","click","Selfie Mode",2000);
        appiumWebDriver1.findElementAndPerformAction("id","shutter","click","Clicked Pic",1000);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Sent Pic",5000);

        appiumWebDriver2.findElementAndPerformAction("id","camera_btn","click","Replying a Photo back",2000);
        appiumWebDriver2.findElementAndPerformAction("id","switch_camera_btn","click","Selfie Mode",2000);
        appiumWebDriver2.findElementAndPerformAction("id","shutter","click","Clicked Pic",1000);
        appiumWebDriver2.findElementAndPerformAction("id","send","click","Replied with Pic",5000);


        //VIDEO
        appiumWebDriver1.findElementAndPerformAction("id","camera_btn","click","Sending Video",2000);
        appiumWebDriver1.findElementAndPerformAction("id","shutter","record","Recorded Video",1000);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Sent Video",0);

        appiumWebDriver2.findElementAndPerformAction("id","camera_btn","click","Replying a Video back",2000);
        appiumWebDriver2.findElementAndPerformAction("id","shutter","record","Recorded Video",1000);
        appiumWebDriver2.findElementAndPerformAction("id","send","click","Replied with Video",0);


        //DOCUMENT
        appiumWebDriver1.findElementAndPerformAction("id","input_attach_button","click","Sending Document....",1000);
        appiumWebDriver1.findElementAndPerformAction("id","pickfiletype_document","click","Pick one Existing Doc",3000);
        appiumWebDriver1.findElementAndPerformAction("text",fileName,"click","Selected file to send",1000);
        appiumWebDriver1.findElementAndPerformAction("text","SEND","click","Sent File",5000);


        //LOCATION
        appiumWebDriver1.findElementAndPerformAction("id","input_attach_button","click","Sharing Location",1000);
        appiumWebDriver1.findElementAndPerformAction("id","pickfiletype_location","click","Sending Location....",0);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Refresh","click","Refresh once",3000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Search","click","Search something",0);
        appiumWebDriver1.keyStroke = "DELHI\n";
        appiumWebDriver1.findElementAndPerformAction("id","search_src_text","typeText","Search Delhi",3000);
        appiumWebDriver1.findElementAndPerformAction("id","send_current_location_text","click","Sent Current Location",5000);
        appiumWebDriver1.findElementAndPerformAction("id","input_attach_button","click","Live Location....",1000);
        appiumWebDriver1.findElementAndPerformAction("id","pickfiletype_location","click","Sharing Live Location for 15 mins....",0);
        appiumWebDriver1.findElementAndPerformAction("id","my_location","click","Clicked My Location",2000);
        appiumWebDriver1.findElementAndPerformAction("id","live_location_btn","click","Clicked on Share Location",1000);
        appiumWebDriver1.findElementAndPerformAction("id","duration_15_min","click","Selected duration 15 mins",0);
        appiumWebDriver1.keyStroke = "DummyShare";
        appiumWebDriver1.findElementAndPerformAction("id","comment","typeText","Given comment",0);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Started Sharing Location",5000);
        appiumWebDriver2.findElementAndPerformAction("text","View live location","click","Viewing Live Location of Mobile2",5000);
        appiumWebDriver1.findElementAndPerformAction("id","stop_share_btn","click","Stop Sharing Live Location",1000);
        appiumWebDriver1.findElementAndPerformAction("text","STOP","click","Stopped Live Location Sharing",0);
        appiumWebDriver2.backScreen(1,0);


        //CONTACT
        appiumWebDriver1.findElementAndPerformAction("id","input_attach_button","click","Sending CONTACT....",1000);
        appiumWebDriver1.findElementAndPerformAction("id","pickfiletype_contact","click","Sharing a Contact",2000);
        appiumWebDriver1.findElementAndPerformAction("text","TestNo","click","Picked Contact",1000);
        appiumWebDriver1.findElementAndPerformAction("id","next_btn","click","Clicked Next Button",1000);
        appiumWebDriver1.findElementAndPerformAction("id","send_btn","click","Sent Contact",3000);

        whatsappGroupMiscActivity();
        System.out.println("Exiting Func whatsappChatAndShare");
    }


    protected void whatsappGroupMiscActivity() throws Exception {

        System.out.println("Entering Func whatsappGroupMiscActivity");
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clicked Group More Option : 1",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Group info","click","Clicked on Group info",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add participant…","click","Clicked on Add participant",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Invite to group via link","click","Group Invite",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Send link via WhatsApp","click","SHare Invite Link Via Whatsapp",2000);
        appiumWebDriver1.findElementAndPerformAction("text",mob1,"click","Selected MObile1",0);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Sending Invite Link.....",2000);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Sending Invite Sent",3000);
        appiumWebDriver2.backScreen(1,1000);

        appiumWebDriver1.backScreen(1,1000);
        appiumWebDriver1.findElementAndPerformAction("text",groupName,"click","Inside Group",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clicked Group More Option : 1",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Group info","click","Clicked on Group info",1000);

        appiumWebDriver1.findElementAndPerformAction("contentDesc","Add participant…","click","Clicked on Add participant",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Invite to group via link","click","Group Invite",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Group Invite More Option",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Print group QR code","click","Generating QR Code...",3000);
        appiumWebDriver1.backScreen(1,1000);
        appiumWebDriver1.findElementAndPerformAction("text","Revoke link","click","Revoking Invite Link",1000);
        appiumWebDriver1.findElementAndPerformAction("text","REVOKE LINK","click","Revoked Invite Link",2000);
        appiumWebDriver1.findElementAndPerformAction("text","OK","click","Clicked Ok",1000);
        appiumWebDriver1.backScreen(2,1000);

        appiumWebDriver1.findElementAndPerformAction("id","change_subject_btn","click","Editing Group Name",1000);
        appiumWebDriver1.keyStroke = changedGrpName;
        appiumWebDriver1.findElementAndPerformAction("id","edit_text","typeText","Written New Group Name",0);
        appiumWebDriver1.findElementAndPerformAction("id","ok_btn","click","Changed Group Name",1000);
        appiumWebDriver2.findElementAndPerformAction("text",changedGrpName,"click","Opened New Group in Mobile1",1000);

        appiumWebDriver1.findElementAndPerformAction("id","mute_switch","click","Enabling Mute Notifications....",1000);
        appiumWebDriver1.findElementAndPerformAction("text","OK","click","Enabled!!!",2000);
        appiumWebDriver1.findElementAndPerformAction("id","mute_switch","click","Disabling Mute Notifications....",1000);
        appiumWebDriver1.findElementAndPerformAction("id","encryption_indicator","click","Clicked Encryption Button",1000);
        appiumWebDriver1.findElementAndPerformAction("text","LEARN MORE","click","Learn More about Encryption",5000);
        appiumWebDriver1.backScreen(1,1000);

        appiumWebDriver1.scrollScreenVertical(1);
        appiumWebDriver1.findElementAndPerformAction("text",mob1,"click","Make Mobile1 Admin",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Make group admin","click","Made MObile1 Group Admin",3000);

        appiumWebDriver1.findElementAndPerformAction("text",mob1,"click","Verifying Security Code...",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Verify security code","click","Verifying...",1000);
        appiumWebDriver1.findElementAndPerformAction("id","scan_code","click","Scanning Code...",3000);
        appiumWebDriver1.backScreen(3,1000);

        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Viewing Group Media....",0);
        appiumWebDriver1.findElementAndPerformAction("text","Group media","click","Clicked on More",3000);
        appiumWebDriver1.backScreen(1,1000);

        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Email Chat....",0);
        appiumWebDriver1.findElementAndPerformAction("text","More","click","Clicked on More",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Email chat","click","Selected Email Chat option",1000);
        try {
            appiumWebDriver1.findElementAndPerformAction("text","WITHOUT MEDIA","click","Selected Without Media Option",0);
        } catch(Exception ex) {
            System.out.println("Din't get attach Option, continue....");
        }
        Thread.sleep(2000);
        try {
            appiumWebDriver1.findElementAndPerformAction("osId","icon","click","Selected 1st Mailing Option",0);
        } catch(Exception ex) {
            System.out.println("Din't get mailing multiple Option, continue....");
        }
        Thread.sleep(1000);
        appiumWebDriver1.keyStroke = mailId;
        appiumWebDriver1.findElementAndPerformAction("contentDesc","To","typeText","Entered Mail ID",0);
        appiumWebDriver1.findElementAndPerformAction("text","Send","click","Sent Chat History...",2000);

        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clearing Chat....",0);
        appiumWebDriver1.findElementAndPerformAction("text","More","click","Clicked on More",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Clear chat","click","Clicked Cleared Chat",1000);
        appiumWebDriver1.findElementAndPerformAction("id","checkbox","click","Deletign Starred Msgs as well",0);
        appiumWebDriver1.findElementAndPerformAction("text","CLEAR","click","Cleared Chat History",0);

        appiumWebDriver1.findElementAndPerformAction("id","conversation_contact_name","click","Inside Group Info",0);
        appiumWebDriver1.findElementAndPerformAction("scroll","Report spam","click","Reporting Spam and Leave...",1000);
        appiumWebDriver1.findElementAndPerformAction("text","REPORT AND LEAVE","click","Left Group",3000);
        appiumWebDriver1.findElementAndPerformAction("id","exit_group_icon","click","Deleting Group...",1000);
        appiumWebDriver1.findElementAndPerformAction("text","DELETE","click","Group Deleted from Mobile2",0);

        appiumWebDriver2.findElementAndPerformAction("id","conversation_contact_name","click","Deleting Group from mobile1",1000);
        appiumWebDriver2.findElementAndPerformAction("scroll","Exit group","click","Clicked Exit Group",1000);
        appiumWebDriver2.findElementAndPerformAction("text","EXIT","click","Exited....",5000);

        appiumWebDriver2.backScreen(2,1000);
        appiumWebDriver2.findElementAndPerformAction("text",changedGrpName,"click","Again going inside",1000);
        appiumWebDriver2.findElementAndPerformAction("id","conversation_contact_name","click","Deleting Group from mobile1",1000);

        appiumWebDriver2.findElementAndPerformAction("id","exit_group_icon","click","Deleting Group....",1000);
        appiumWebDriver2.findElementAndPerformAction("text","DELETE","click","Deleted group from Mobile1",3000);
        System.out.println("Exiting Func whatsappGroupMiscActivity");
    }


    protected void whatsappMyStatus() throws Exception {
        System.out.println("Entering Func whatsappMyStatus");
        //STATUS Msg Creation
        appiumWebDriver1.findElementAndPerformAction("text","STATUS","click","STATUS TAB",1000);
        //PHOTO
        appiumWebDriver1.findElementAndPerformAction("id","fab","click","Clicked Add Status Button",2000);
        appiumWebDriver1.findElementAndPerformAction("id","shutter","click","Clicked Photo",1000);
        appiumWebDriver1.findElementAndPerformAction("id","caption_layout","click","Adding Caption..",1000);
        appiumWebDriver1.keyStroke = "MyPic";
        appiumWebDriver1.findElementAndPerformAction("id","caption","typeText","Written Caption",0);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Added Pic in Status",5000);
        //VIDEO
        appiumWebDriver1.findElementAndPerformAction("id","fab","click","Clicked Add Status Button",2000);
        appiumWebDriver1.findElementAndPerformAction("id","shutter","record","Recorded Video",1000);
        appiumWebDriver1.findElementAndPerformAction("id","caption_layout","click","Adding Caption..",1000);
        appiumWebDriver1.keyStroke = "MyVideo";
        appiumWebDriver1.findElementAndPerformAction("id","caption","typeText","Written Caption",0);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Added Video in Status",5000);
        //TEXT
        appiumWebDriver1.findElementAndPerformAction("id","fab_aux","click","Clicked Add Status Button",2000);
        appiumWebDriver1.keyStroke = "IAmLovingWhatsapp";
        appiumWebDriver1.findElementAndPerformAction("id","entry","typeText","Added Status Msg",0);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Added Video in Status",0);

        //VIEW STATUS IN MOBILE1
        appiumWebDriver2.findElementAndPerformAction("text","STATUS","click","STATUS TAB",1000);
        appiumWebDriver2.findElementAndPerformAction("text",mob2,"click","Viewing Status Message of Mobile2",1000);
        appiumWebDriver2.touchAction.tap(360,550).perform();
        Thread.sleep(1000);
        appiumWebDriver2.touchAction.tap(360,550).perform();
        Thread.sleep(1000);
        appiumWebDriver2.backScreen(1,1000);

        //DELETE STATUS
        appiumWebDriver1.findElementAndPerformAction("id","action","click","Action on Status Msgs",1000);
        appiumWebDriver1.findElementAndPerformAction("id","contact_photo","click","Viewing Status",5000);
        appiumWebDriver1.findElementAndPerformAction("id","views","click","Watching No of Views",2000);
        appiumWebDriver1.findElementAndPerformAction("id","forward","click","Forwarding Status Msg",1000);
        appiumWebDriver1.findElementAndPerformAction("id","contactpicker_row_name","click","Selected Contact",1000);
        appiumWebDriver1.findElementAndPerformAction("id","send","click","Sent....",2000);
        appiumWebDriver1.backScreen(1,1000);
        appiumWebDriver1.findElementAndPerformAction("id","delete","click","Deleting Status 1",1000);
        appiumWebDriver1.findElementAndPerformAction("text","DELETE","click","Deleted",2000);
        appiumWebDriver1.findElementAndPerformAction("id","views","click","Clicked on Views",2000);
        appiumWebDriver1.findElementAndPerformAction("id","delete","click","Deleting Status 2",1000);
        appiumWebDriver1.findElementAndPerformAction("text","DELETE","click","Deleted",2000);
        appiumWebDriver1.findElementAndPerformAction("id","views","click","Clicked on Views",2000);
        appiumWebDriver1.findElementAndPerformAction("id","delete","click","Deleting Status 3",1000);
        appiumWebDriver1.findElementAndPerformAction("text","DELETE","click","Deleted",2000);

        try {
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "More options", "click", "Doing Status Privacy Setting....",0);
        } catch (Exception ex) {
            System.out.println("Unexpected Screen, going back and Retry..");
            appiumWebDriver1.backScreen(1,1000);
            appiumWebDriver1.findElementAndPerformAction("contentDesc", "More options", "click", "Doing Status Privacy Setting....",0);
        }
        Thread.sleep(1000);
        appiumWebDriver1.findElementAndPerformAction("text","Status privacy","click","Clicked Status Privacy Button",1000);
        appiumWebDriver1.findElementAndPerformAction("id","white_list","click","Selecting Friends",2000);
        appiumWebDriver1.findElementAndPerformAction("id","contactpicker_row_photo","click","1st Contact Selected",1000);
        appiumWebDriver1.findElementAndPerformAction("id","done","click","Done Privacy Settings",2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Roll Back Privacy Setting....",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Status privacy","click","Clicked Status Privacy Button",1000);
        appiumWebDriver1.findElementAndPerformAction("id","my_contacts","click","Selected My Contacts",2000);
        System.out.println("Exiting Func whatsappMyStatus");
    }

    @Override
    public void execute() {
        int fail = 0;

        try {
            whatsappChatAndShare(groupName,groupName);
        } catch (Exception exp) {
            fail = 1;
            System.out.println("Exception in whatsappChatAndShare Execution, Resetting Drivers");
        }

        cleanUp();
        setUp();

        try {
            whatsappMyStatus();
        } catch (Exception exp) {
            fail = 1;
            System.out.println("Exception in whatsappMyStatus Execution");
        }

        cleanUp();

        if(fail == 0) {
            try {
                PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
                writer.println("1");
                writer.close();
                System.out.println("Written Success Status");
            } catch (Exception ex) {
                System.out.println("\n======Exception in writing success=====");
            }
        }
        else {
            System.out.println("\n======WhatsApp Execution Failed=====");
        }

    }



}
