package utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static fixtures.Constants.APP_URL;
import static fixtures.Constants.SELENIUM_IP;

public class HTTP {
    public static String getLocalIp() {
        String ipAddr = null;
        try {
            ipAddr = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ipAddr;
    }

    public static String getWebAppUrl() {
        if (APP_URL != null) {
            return "http://" + APP_URL;
        } else {
            return "https://my.whisk-dev.com/";
        }
    }

    public static String getSeleniumHost() {
        if (SELENIUM_IP != null) {
            return "http://" + SELENIUM_IP + ":4444/wd/hub";
        }
        return "http://" + getLocalIp() + ":4444/wd/hub";

    }

    public static void clearCookies() {
        open(APP_URL);
        if (getWebDriver().manage().getCookies() != null) {
            getWebDriver().manage().deleteAllCookies();
        }
    }

}
