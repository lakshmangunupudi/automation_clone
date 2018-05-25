package whatsapp;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class WhatsAppBrowse implements executeFunctionality {

    //SAVE TWO NUMBERS as "Mobile1(primary) & Mobile2(secondary)" IN TWO MOBILES AND LOGIN
    AppiumWebDriver appiumWebDriver1;
    AppiumWebDriver appiumWebDriver2;
    String pkg = "com.whatsapp";
    String activity = "com.whatsapp.Main";

    String mailId = "p2p.adc@gmail.com";
    String usb_id_mob1 = "";
    String usb_id_mob2 = "";

    public WhatsAppBrowse(String udID1, String udID2) {
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


    protected void whatsappExploreChatMenuOption() throws Exception {

        System.out.println("Entering Func whatsappExploreChatMenuOption");

        appiumWebDriver1.findElementAndPerformAction("id", "fab", "click", "New Chat Window",0);

        appiumWebDriver1.findElementAndPerformAction("id","menuitem_search","click","Clicked Search",0);
        appiumWebDriver1.keyStroke = "random";
        appiumWebDriver1.findElementAndPerformAction("id","search_src_text","typeText","Searched Ramdon contact",0);
        appiumWebDriver1.backScreen(2,1000);

        appiumWebDriver1.findElementAndPerformAction("id","menuitem_new_contact","click","Clicked New Contact",0);
        appiumWebDriver1.keyStroke = "TestNo";
        appiumWebDriver1.findElementAndPerformAction("text", "Name", "typeText", "Typed contact name",0);

        appiumWebDriver1.keyStroke = "1234567890";
        appiumWebDriver1.findElementAndPerformAction("text","Phone","typeText","Typed Number",0);
        appiumWebDriver1.findElementAndPerformAction("text","OK","click","Saved Dummy Contact",3000);
        appiumWebDriver1.backScreen(1,2000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clicked More Option : 1",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Invite a friend","click","Inviting a Friend",0);
        appiumWebDriver1.findElementAndPerformAction("osId","icon","click","Clicked on Messanger icon",0);
        appiumWebDriver1.backScreen(2,1000);
        appiumWebDriver1.findElementAndPerformAction("text","OK","click","Invite Msg Discarded",1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clicked MOre Option : 2",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Contacts","click","Clicked on Contacts",0);
        appiumWebDriver1.findElementAndPerformAction("text","Recents","click","Clicked on Recent call logs",0);
        appiumWebDriver1.backScreen(1,1000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clicked MOre Option : 3",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Refresh","click","Clicked on Refresh",5000);
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Clicked MOre Option : 4",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Help","click","Clicked on Help",2000);
        appiumWebDriver1.findElementAndPerformAction("id","count_invisible_button","click","Showing Invisible Contact",0);
        System.out.println("Exiting Func whatsappExploreChatMenuOption");
    }

    protected void whatsappProfileMisc() throws  Exception {
        System.out.println("Entering Func whatsappProfileMisc");
        //CHANGE PROFILE NAME
        appiumWebDriver1.findElementAndPerformAction("contentDesc","More options","click","Exploring Profile Setting....",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Settings","click","Clicked Settings",1000);
        appiumWebDriver1.findElementAndPerformAction("id","profile_info_photo","click","Changing Name...",1000);
        appiumWebDriver1.findElementAndPerformAction("id","change_registration_name_btn","click","Clicked Edit Name",1000);
        appiumWebDriver1.keyStroke = "CiscoStarent";
        appiumWebDriver1.findElementAndPerformAction("id","edit_text","typeText","Written Changed Name",0);
        appiumWebDriver1.findElementAndPerformAction("id","ok_btn","click","Saved New Name",1000);
        appiumWebDriver1.findElementAndPerformAction("id","status","click","changing Custom Msg",1000);
        appiumWebDriver1.findElementAndPerformAction("id","round_more_btn","click","Clicked Edit Button",1000);
        appiumWebDriver1.keyStroke = "LovingWhatsApp";
        appiumWebDriver1.findElementAndPerformAction("id","edit_text","typeText","Written Msg",0);
        appiumWebDriver1.findElementAndPerformAction("id","ok_btn","click","Saved New Msg",3000);
        appiumWebDriver1.backScreen(2,1000);

        //PIN VERIFICATION
        appiumWebDriver1.findElementAndPerformAction("id","account_info","click","Enabling 2 Step Verification",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Two-step verification","click","Clicked Verification Button",1000);
        appiumWebDriver1.findElementAndPerformAction("id","enable_button","click","Enabling Pin Verification",1000);
        appiumWebDriver1.keyStroke = "123456";
        appiumWebDriver1.findElementAndPerformAction("id","code","typeText","Entered Pin",1000);
        appiumWebDriver1.findElementAndPerformAction("id","code","typeText","Re-Entered Pin",1000);
        appiumWebDriver1.keyStroke = mailId;
        appiumWebDriver1.findElementAndPerformAction("id","email","typeText","Entered Mail",1000);
        appiumWebDriver1.findElementAndPerformAction("id","submit","typeText","Clicked Next",1000);
        appiumWebDriver1.findElementAndPerformAction("id","email","typeText","Entered Mail",1000);
        appiumWebDriver1.findElementAndPerformAction("id","submit","click","Saved Setting",2000);
        appiumWebDriver1.findElementAndPerformAction("id","done_button","click","DONE",3000);
        appiumWebDriver1.findElementAndPerformAction("id","disable_button","click","Disabling Pin Verification",1000);
        appiumWebDriver1.findElementAndPerformAction("text","DISABLE","click","Disabled",3000);
        appiumWebDriver1.backScreen(2,1000);

        //BACKUP
        appiumWebDriver1.findElementAndPerformAction("id","settings_chat","click","Backing UP Chat",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Chat backup","click","Clicked Backup Option",1000);
        appiumWebDriver1.findElementAndPerformAction("id","google_drive_backup_now_btn","click","Backup In Progress...",10000);
        appiumWebDriver1.backScreen(2,1000);

        //HELP
        appiumWebDriver1.findElementAndPerformAction("id","settings_help","click","Contacting Customer Service",1000);
        appiumWebDriver1.findElementAndPerformAction("text","Contact us","click","Clicked Contact Us Button",5000);
        appiumWebDriver1.keyStroke = "Facing Issue with Voice Quality";
        appiumWebDriver1.findElementAndPerformAction("id","describe_problem_description_et","typeText","Written Issue Desc",0);
        appiumWebDriver1.findElementAndPerformAction("id","action_done_text","click","Clicked Next",5000);
        appiumWebDriver1.findElementAndPerformAction("id","search_faq_footer","click","Clicked Send",10000);
        appiumWebDriver1.platformPackage = "android";
        appiumWebDriver1.findElementAndPerformAction("osId","icon","click","Selected Option Mail",2000);
        appiumWebDriver1.findElementAndPerformAction("text","Send","click","Sent Issue In Mail",2000);
        System.out.println("Exiting Func whatsappProfileMisc");
    }

    @Override
    public void execute(){
        int fail = 0;

        try {
            whatsappExploreChatMenuOption();
        } catch (Exception exp) {
            fail = 1;
            System.out.println("Exception in whatsappExploreChatMenuOption Execution, Resetting Drivers");
        }

        cleanUp();
        setUp();

        try {
            whatsappProfileMisc();
        } catch (Exception exp) {
            fail = 1;
            System.out.println("Exception in whatsappProfileMisc Execution");
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
