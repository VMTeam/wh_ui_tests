package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static fixtures.Constants.APP_URL;
import static page_objects.PageObjects.*;

public class ExampleSteps extends BaseMethods {

    @Step
    public void openPage() {
        openPage(APP_URL);
    }

    @Step
    public void assertVisibleLoginPopup() {
        elementShouldBeVisible(LoginPopup.LOGIN_POPUP_EMAIL_FIELD);
        elementShouldBeVisible(LoginPopup.LOGIN_POPUP_CONTINUE_BUTTON);
    }

    @Step
    public void signInSystem(String EMAIL, String PASS) {
        sendKeysToElement(LoginPopup.LOGIN_POPUP_EMAIL_FIELD, EMAIL);
        clickOnElement(LoginPopup.LOGIN_POPUP_CONTINUE_BUTTON);
        elementShouldBeVisible(LoginPopup.LOGIN_POPUP_PASS_FIELD);
        clickOnElement(LoginPopup.LOGIN_POPUP_PASS_FIELD);
        sendKeysToElement(LoginPopup.LOGIN_POPUP_PASS_FIELD, PASS);
        clickOnElement(LoginPopup.LOGIN_POPUP_LOGIN_BUTTON);
    }

    @Step
    public void assertSuccessfullySignIn(String EMAIL) {
        elementShouldHaveText(NavigateMenu.NAVIGATE_MENU_USER_NAME, EMAIL);
    }

    @Step
    public void switchToShoppingPage() {
        clickOnElement(NavigateMenu.NAVIGATE_MENU_SHOPPING_BUTTON);
        elementShouldBeVisible(ShoppingPage.CREATE_NEW_SHOPPING_LIST_BUTTON);
    }

    @Step
    public void createNewShoppingList(String NAME, String... NAMES) {
        clickOnElement(ShoppingPage.CREATE_NEW_SHOPPING_LIST_BUTTON);
        ShoppingPage.CREATE_LIST_POPUP_NAME_FIELD.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        sendKeysToElement(ShoppingPage.CREATE_LIST_POPUP_NAME_FIELD, NAME);
        clickOnElement(ShoppingPage.CREATE_LIST_POPUP_CREATE_BUTTON);
        listShouldHaveTexts(ShoppingPage.SHOPPING_LIST_NAMES, NAMES);
    }

    @Step
    public void addItemsInShoppingList(String LISTNAME, String ITEM1, String ITEM2, String ITEM3, String ITEM4, String ITEM5) {
        elementShouldHaveText(ShoppingPage.SELECTED_LIST_TITLE, LISTNAME);
        clickOnElement(ShoppingPage.ADD_ITEM_LIST_BUTTON);
        clickOnElementByText(ShoppingPage.SHOPPING_LIST_ITEMS, ITEM1);
        clickOnElementByText(ShoppingPage.SHOPPING_LIST_ITEMS, ITEM2);
        clickOnElementByText(ShoppingPage.SHOPPING_LIST_ITEMS, ITEM3);
        clickOnElementByText(ShoppingPage.SHOPPING_LIST_ITEMS, ITEM4);
        clickOnElementByText(ShoppingPage.SHOPPING_LIST_ITEMS, ITEM5);
        ShoppingPage.ADD_ITEM_LIST_BUTTON.sendKeys(Keys.chord(Keys.ESCAPE));
    }

    @Step
    public void assertAddedItemsInList(String ITEM1, String ITEM2, String ITEM3, String ITEM4, String ITEM5) {
        elementShouldHaveText(ShoppingPage.SHOPPING_LIST_ADDED_ITEMS_NAMES.get(0), ITEM1);
        elementShouldHaveText(ShoppingPage.SHOPPING_LIST_ADDED_ITEMS_NAMES.get(1), ITEM2);
        elementShouldHaveText(ShoppingPage.SHOPPING_LIST_ADDED_ITEMS_NAMES.get(2), ITEM3);
        elementShouldHaveText(ShoppingPage.SHOPPING_LIST_ADDED_ITEMS_NAMES.get(3), ITEM4);
        elementShouldHaveText(ShoppingPage.SHOPPING_LIST_ADDED_ITEMS_NAMES.get(4), ITEM5);
    }

    @Step
    public void deleteShoppingList(String... NAMES) {
        clickOnElement(ShoppingPage.LIST_OPTION_BUTTON);
        clickOnElement(ShoppingPage.ACTION_MENU_DELETE_BUTTON);
        clickOnElement(ShoppingPage.CONFIRM_DELETE_BUTTON);
        listShouldHaveTexts(ShoppingPage.SHOPPING_LIST_NAMES, NAMES);
    }
}
