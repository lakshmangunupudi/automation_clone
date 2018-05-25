package youtube;

import P2pAppiumGuiAutomation.AppiumWebDriver;
import P2pAppiumGuiAutomation.executeFunctionality;

import java.io.PrintWriter;

public class YoutubeUpload implements executeFunctionality {
    AppiumWebDriver appiumWebDriver;
    String pkg = "com.google.android.youtube";
    String activity = "com.google.android.apps.youtube.app.WatchWhileActivity";

    public YoutubeUpload(String udID) {
        appiumWebDriver = new AppiumWebDriver(pkg,activity,udID);
        appiumWebDriver.getAppiumDriver();
    }

    @Override
    public void execute() {

        try {
            System.out.println("======UPLOAD VIDEO=======");
            appiumWebDriver.findElementAndPerformAction("contentDesc","Video","click","Clicked Upload Button",2000);
            try {
                appiumWebDriver.findElementAndPerformAction("id","thumb_image_view","click","Selected 1st Video file to Upload",0);
            } catch (Exception e) {
                System.out.println("Granted Permissions and upload");
                appiumWebDriver.findElementAndPerformAction("id", "permission_request_button", "click", "Allowed Permission",2000);
                appiumWebDriver.findElementAndPerformAction("osId", "permission_allow_button", "click", "Allowed Permission",2000);
                appiumWebDriver.findElementAndPerformAction("osId", "permission_allow_button", "click", "Allowed Permission",2000);
                appiumWebDriver.findElementAndPerformAction("id","thumb_image_view","click","Selected 1st Video file to Upload",0);
            }
            Thread.sleep(2000);
            appiumWebDriver.keyStroke = "TestVideo";
            appiumWebDriver.findElementAndPerformAction("id", "title_edit", "typeText","Put a Name for Video",1000);
            appiumWebDriver.findElementAndPerformAction("id", "menu_upload_activity_done", "click","Clicked Upload Button",0);
            System.out.println("Waiting for Video to be Uploaded");
            Thread.sleep(60000);
            System.out.println("======UPLOAD VIDEO SUCCESSFUL=======");

            PrintWriter writer = new PrintWriter("/tmp/browsing_success", "UTF-8");
            writer.println("1");
            writer.close();
            System.out.println("Written Success Status");

        } catch (Exception ex) {
            System.out.println("======Exception in Youtube : Video Upload=======");
        }

        System.out.println("Closing Driver");
        appiumWebDriver.closeDriver();
    }

}
