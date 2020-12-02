package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CustomWatcher implements TestWatcher {
    private utils.AllureUtils AllureUtils = new AllureUtils();
    private boolean onSucceededTest = false;
    public CustomWatcher logSucceededTest() {
        this.onSucceededTest = true;
        return this;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        if (onSucceededTest) {
            AllureUtils.makeScreenshotOnFailure();
            AllureUtils.attachBrowserLog();
            executeJavaScript("console.clear();");
            executeJavaScript("localStorage.clear();");
        }
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        AllureUtils.makeScreenshotOnFailure();
        AllureUtils.attachBrowserLog();
        executeJavaScript("console.clear();");
        executeJavaScript("localStorage.clear();");
    }
}

