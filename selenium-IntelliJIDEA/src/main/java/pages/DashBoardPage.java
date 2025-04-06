package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import utils.WaitUtils;
import io.qameta.allure.Step;


public class DashBoardPage {
    WebDriver driver;

    // Selectores
    // icono en barra lateral
    private By userMenu = By.cssSelector("div.dropdown.dropend a[title='admin'].s-user-profile-link");
    // opcion Cerrar sesión
    private By logoutLink = By.cssSelector("a[href='/Account/Signout'].dropdown-item");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Cerrar sesión desde el dashboard")
    public void hacerLogout() {
        driver.findElement(userMenu).click(); // Abre el menú
        WaitUtils.esperarElementoClickeable(driver, logoutLink).click(); // Cierra sesión
        // Validación opcional: verificar que volvió a login
        WaitUtils.esperarElementoVisible(driver, By.cssSelector("input[name='Username']"));
    }
}
