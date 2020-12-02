package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class BaseMethods {
    @Step
    public void openPage(String url) {
        open(url);
    }

    @Step
    public void clickOnElement(SelenideElement element) {
        element.shouldBe(enabled).click();
    }

    @Step
    public void clickOnElementByText(ElementsCollection elements, String text) {
        elements.findBy(text(text)).click();
    }

    @Step
    public void sendKeysToElement(SelenideElement element, String text) {
        element.sendKeys(text);
    }

    @Step
    public void elementShouldHaveText(SelenideElement element, String text) {
        element.shouldHave(text(text));
    }

    @Step
    public void elementShouldBeVisible(SelenideElement element) {
        element.shouldBe(visible);
    }

    @Step
    public void listShouldHaveTexts(ElementsCollection collection, String... listTexts) {
        collection.shouldHave(texts(listTexts));
    }
}
