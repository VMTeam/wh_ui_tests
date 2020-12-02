package page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageObjects {

    public static class LoginPopup {
        public static final SelenideElement
                LOGIN_POPUP_EMAIL_FIELD = $(byAttribute("data-testid", "UI_KIT_INPUT")),
                LOGIN_POPUP_PASS_FIELD = $(byAttribute("data-testid", "UI_KIT_INPUT")),
                LOGIN_POPUP_CONTINUE_BUTTON = $(byAttribute("data-testid", "auth-continue-button")),
                LOGIN_POPUP_LOGIN_BUTTON = $(byAttribute("data-testid", "auth-login-button")),
                CAPTCHA_CHECKBOX = $("#recaptcha-anchor");
    }

    public static class NavigateMenu {
        public static final SelenideElement
            NAVIGATE_MENU_USER_NAME = $(".sc-cm2nzr.kGnucA"),
            NAVIGATE_MENU_SHOPPING_BUTTON = $(byAttribute("data-testid","shopping-list-nav-link"));
    }

    public static class ShoppingPage {
        public static final SelenideElement
                CREATE_NEW_SHOPPING_LIST_BUTTON = $(byAttribute("data-testid", "create-new-shopping-list-button")),
                CREATE_LIST_POPUP_NAME_FIELD = $(byAttribute("data-testid", "UI_KIT_INPUT")),
                CREATE_LIST_POPUP_CREATE_BUTTON = $(byAttribute("data-testid", "create-new-shopping-list-create-button")),
                SELECTED_LIST_TITLE = $(byAttribute("data-testid", "shopping-list-name")),
                ADD_ITEM_LIST_BUTTON = $(byAttribute("data-testid", "desktop-add-item-autocomplete")),
                ACTION_MENU_DELETE_BUTTON = $(byAttribute("data-testid", "shopping-list-delete-menu-button")),
                LIST_OPTION_BUTTON = $(byAttribute("data-testid", "vertical-dots-shopping-list-button")),
                CONFIRM_DELETE_BUTTON = $(byAttribute("data-testid", "confirm-delete-button"));

        public static final ElementsCollection
                SHOPPING_LIST_NAMES = $$(byAttribute("data-testid", "shopping-lists-list-name")),
                SHOPPING_LIST_ITEMS = $$(byAttribute("data-testid", "autocomplete-item")),
                SHOPPING_LIST_ADDED_ITEMS_NAMES = $$(byAttribute("data-testid", "shopping-list-item-name"));
    }
}
