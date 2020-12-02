package fixtures;

import static java.lang.System.getenv;

public class Constants {

    public static String
            APP_URL = getenv("APP_URL") != null ? getenv("APP_URL") : "https://my.whisk-dev.com/",
            SELENIUM_IP = getenv("SELENIUM_IP") != null ? getenv("SELENIUM_IP") : "localhost";
}
