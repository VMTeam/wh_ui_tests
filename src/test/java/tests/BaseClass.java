package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.CustomWatcher;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.util.ResourceBundle.clearCache;
import static utils.HTTP.clearCookies;
import static utils.HTTP.getWebAppUrl;

@ExtendWith(CustomWatcher.class)
public class BaseClass {

    @BeforeEach
    public void openURL() {
        Configuration.baseUrl = getWebAppUrl();
    }

    @BeforeEach
    public void beforeBase() {
        clearCache();
    }

    @AfterEach
    public void afterBase() {
        String script = "console.clear();";
        executeJavaScript(script);
    }
}
