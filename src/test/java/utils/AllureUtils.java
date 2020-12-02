package utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class AllureUtils implements TestWatcher {

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Browser log", type = "text/plain")
    public String attachBrowserLog() {
        List<String> browserLogs = getWebDriverLogs(BROWSER, Level.SEVERE);
        if (browserLogs.size() > 0) {
            Stream<String> row = browserLogs.stream();
            return row.collect(Collectors.toList()).toString().replace(", ", "\n\n");
        }
        return "Logs not found";
    }
}
