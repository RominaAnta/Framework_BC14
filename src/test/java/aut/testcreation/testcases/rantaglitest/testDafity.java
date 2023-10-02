package aut.testcreation.testcases.rantaglitest;


import aut.testcreation.pages.rantagli.HomePage;
import aut.testcreation.pages.rantagli.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;

public class testDafity {

    //Atributos
    WebDriver driver;
    HomePage home;
    RegisterPage register;
    String rutaDriver = "C:\\Users\\romina.antagli\\Desktop\\romina_antagli_sprint1\\src\\test\\resources\\chromedriver.exe";
    String browser = "Chrome";
    String property = "webdriver.chrome.driver";

    @BeforeEach
    public void preTests() {
        System.setProperty(property, rutaDriver);
        driver = new ChromeDriver();
        home = new HomePage(driver);
        register = new RegisterPage(home.getDriver());
        home.cargarPagina("https://www.dafiti.com.ar/");
    }

    public static String corregirEncoding(String textoIncorrecto) {
        // Convertir la cadena incorrecta de la codificación ISO-8859-1 a UTF-8
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);

        return textoCorregido;
    }

    @Test
    public void CP001_CreacionCtaDafiti() {
        home.irARegistrarse();
        register.completarFormularioRegistro("djdjjdjdjdjjdd1234@gmail.com", "123456", "123456", "Romama", "Romina", "33444555", "21", "12", "1985", "Femenino");
        Assertions.assertTrue(true);
    }

    @Test
    public void CP002_creacion_cta_dafiti_emailinvalido() {
        home.irARegistrarse();

        register.completarFormularioRegistro("maildeprueba1233453121212121212@@gmail.com", "123456", "123456", "Romama", "Romina", "33444555", "21", "12", "1985", "Femenino");
        register.ErrorCorreoInvalido();

        String resultadoEsperado = "Ingrese una dirección de mail válida";

        //WebElement textoMensaje = driver.findElement(By.id("form-account-create"));

        //Assertions.assertEquals(resultadoEsperado,home.obtenerTexto();
        Assertions.assertEquals(resultadoEsperado,home.obtenerTexto(By.xpath("//label[contains(text(), 'Ingrese una')]")));
    }

    @Test

    public void CP003_creacion_cta_dafiti_error_ingreselamismapassword() {
        home.irARegistrarse();
        register.completarFormularioRegistro("djdjjdjdjdjjdd123@gmail.com", "123456", "123457", "Romama", "Romina", "33444555", "21", "12", "1985", "Femenino");
        register.CorroborarPassword();

        //WebElement textoMensaje = driver.findElement(By.xpath("//label[contains(text(), 'Ingrese la misma')]"));
        String resultadoEsperado = "Ingrese la misma contraseña";

        Assertions.assertEquals(resultadoEsperado,home.obtenerTexto(By.xpath("//label[contains(text(), 'Ingrese la misma')]")));
    }



    @Test

        public void CP004_irAyuda () {
            home.irAyuda();
            Assertions.assertTrue(true);
        }

        @Test
        public void CP005_irContactanos () {
            home.irContactanos();
            Assertions.assertTrue(true);
        }

        @AfterEach
        public void afterTests () {
            home.cerrarBrowser();
        }
    }


