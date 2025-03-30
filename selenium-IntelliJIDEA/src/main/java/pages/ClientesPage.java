package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientesPage {
    private WebDriver driver;
    private By btnNuevoCliente = By.id("btnNuevo");
    private By campoNombre = By.id("nombreCliente");
    private By campoTelefono = By.id("telefonoCliente");
    private By campoDireccion = By.id("direccionCliente");
    private By btnGuardar = By.id("btnGuardar");

    public ClientesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void irAClientes() {
        driver.get("https://demo.serenity.is/Clientes");
    }

    public void clickNuevoCliente() {
        driver.findElement(btnNuevoCliente).click();
    }

    public void ingresarNombre(String nombre) {
        driver.findElement(campoNombre).sendKeys(nombre);
    }

    public void ingresarTelefono(String telefono) {
        driver.findElement(campoTelefono).sendKeys(telefono);
    }

    public void ingresarDireccion(String direccion) {
        driver.findElement(campoDireccion).sendKeys(direccion);
    }

    public void guardarCliente() {
        driver.findElement(btnGuardar).click();
    }
}

