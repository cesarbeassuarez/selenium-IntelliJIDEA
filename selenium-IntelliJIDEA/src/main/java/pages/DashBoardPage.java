package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import utils.CommonActions;
import utils.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import utils.CommonActions;

public class DashBoardPage {

    // Selectores
    //
    // icono en barra lateral
    private By userMenu = By.cssSelector("div.dropdown.dropend a[title='admin'].s-user-profile-link");
    // opcion Cerrar sesión
    private By logoutLink = By.cssSelector("a[href='/Account/Signout'].dropdown-item");

    // ✅ Constructor sin WebDriver: usamos DriverManager.getDriver() internamente
    public DashBoardPage() {}

    @Step("Cerrar sesión desde el dashboard")
    public void hacerLogout() {

    }

    /*public boolean existeElemento(By by) {
        return CommonActions.existeElemento(driver, by);
    }

     */
}
