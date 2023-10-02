package aut.testcreation.pages.rantagli;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends SeleniumWrapper {

    //Definir localizadores
    By locatorEmail = By.id("RegistrationForm_email");
    By locatorPassword = By.id("RegistrationForm_password");
    By locatorPassword2 = By.id("RegistrationForm_password2");
    By locatorNombre = By.id("RegistrationForm_first_name");
    By locatorLastName = By.id("RegistrationForm_last_name");
    By locatorDni = By.id("RegistrationForm_identification");
    By locatorDay = By.name("RegistrationForm[day]");
    By locatorMonth = By.name("RegistrationForm[month]");
    By locatorYear = By.name("RegistrationForm[year]");

    By locatorGenero = By.name("RegistrationForm[gender]");

    By locatorIngresar = By.id("createAccountButton");

    By locatorErrorCorreoInvalido = By.xpath("//label[contains(text(), 'Ingrese una')]");

    By locatorPassword2noigual = By.xpath("//label[contains(text(), 'Ingrese la misma')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar Acciones

    public void completarFormularioRegistro(String correo, String password, String password2, String nombre, String apellido, String dni, String dia, String mes, String anio, String genero) {

        escribirTexto(esperarPorElementoLocalizado(locatorEmail), correo);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorPassword), password);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorPassword2), password2);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorNombre), nombre);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorLastName), apellido);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorDni), dni);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorDay), dia);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorMonth), mes);
        esperarXSegundos(2000);
        escribirTexto(esperarPorElementoLocalizado(locatorYear), anio);
        escribirTexto(esperarPorElementoLocalizado(locatorGenero), genero);
        esperarXSegundos(2000);
        click(esperarPorElementoLocalizado(locatorIngresar));
        esperarXSegundos(2000);
    }

    public void CorroborarPassword() {
       esperarPorElementoLocalizado(locatorPassword2noigual);
        esperarXSegundos(2000);
    }

    public void ErrorCorreoInvalido() {
      esperarPorElementoLocalizado(locatorErrorCorreoInvalido);
        esperarXSegundos(2000);
    }

}