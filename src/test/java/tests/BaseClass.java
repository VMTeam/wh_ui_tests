package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.CustomWatcher;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static utils.HTTP.getWebAppUrl;
import static utils.HTTP.clearCookies;

@ExtendWith(CustomWatcher.class)
public class BaseClass {

    @BeforeEach
    public void openURL() {
        Configuration.baseUrl = getWebAppUrl();
    }

    @BeforeEach
    public void beforeBase() {
        clearCookies();
    }

    @AfterEach
    public void afterBase() {
        String script = "console.clear();";
        executeJavaScript(script);
    }
}
