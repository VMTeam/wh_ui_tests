package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import steps.ExampleSteps;

@Feature("UI tests Example")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExampleTest extends BaseClass {

    private steps.ExampleSteps ExampleSteps = new ExampleSteps();

    private static String AUTH_USER_EMAIL = "v.mejinskii777@gmail.com";
    private static String AUTH_USER_PASS = "Kr0k0dil123!";

    @BeforeEach
    public void before() {
        ExampleSteps.openPage();
    }

    @Story("Create new shopping list")
    @Test
    @Order(1)
    public void test01_Create_New_Shopping_List() {
        ExampleSteps.assertVisibleLoginPopup();
        ExampleSteps.signInSystem(AUTH_USER_EMAIL, AUTH_USER_PASS);
        ExampleSteps.assertSuccessfullySignIn(AUTH_USER_EMAIL);
        ExampleSteps.switchToShoppingPage();
        ExampleSteps.createNewShoppingList("QA Shop", "QA Shop", "Shopping List1");
        ExampleSteps.addItemsInShoppingList("QA Shop", "Milk", "Cheese", "Eggs", "Potatoes", "Chicken");
        ExampleSteps.assertAddedItemsInList("Cheese", "Eggs", "Milk", "Potatoes", "Chicken");
        ExampleSteps.deleteShoppingList("Shopping List1");
    }

    @Story("Delete shopping list")
    @Test
    @Order(2)
    public void test02_Delete_Shopping_List() {
        ExampleSteps.assertVisibleLoginPopup();
        ExampleSteps.signInSystem(AUTH_USER_EMAIL, AUTH_USER_PASS);
        ExampleSteps.assertSuccessfullySignIn(AUTH_USER_EMAIL);
        ExampleSteps.switchToShoppingPage();
        ExampleSteps.createNewShoppingList("Delete List", "Delete List", "Shopping List1");
        ExampleSteps.deleteShoppingList("Shopping List1");
    }
}
