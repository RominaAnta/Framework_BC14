package framework.engine.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumWrapper {

    private final WebDriver driver;

    //Constructor Base
    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
    }

    //Wrappers Selenium
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    public void write(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void sendKeys(Keys key, By locator){
        driver.findElement(locator).sendKeys(key);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public Boolean isEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public String getUrlTitle(){
        return driver.getTitle();
    }

    //MI CODIGO
//Atributos

    protected WebDriverWait espera;

    //Métodos


    public WebDriver getDriver() {
        return driver;
   }


    //Wrapper de las acciones de selenium

    public void click(WebElement elemento){
        elemento.click();
    }

    public void escribirTexto(By localizador,String texto){
        driver.findElement(localizador).sendKeys(texto);
    }

    public void escribirTexto(WebElement elemento,String texto){
        elemento.sendKeys(texto);
    }

    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    public void esperarXSegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            System.out.println("Ups...se pego");
        }
    }

    public void cargarPagina(String url){
        driver.get(url);
    }

    public WebElement esperarPorElementoLocalizado(By localizador){
        //Es un driver que espera HASTA 20 segundos, pero consultando
        //Cada 0.5 segundos si ocurre una condición esperada (ExpectedConditions)...
        espera = new WebDriverWait(this.getDriver(),20);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    public void maximizar(){
        driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        driver.quit();
    }

  // public WebDriver conexionDriver(String browser,String ruta,String property){
    //    if(browser.equalsIgnoreCase("Chrome")){
      //      System.setProperty(property,ruta);
        //    this.driver = new ChromeDriver();
        //}else if(browser.equalsIgnoreCase("Firefox")){
          //  System.setProperty(property,ruta);
            //this.driver = new FirefoxDriver();
       // }
        //return this.driver;
    //}

    public void seleccionarComboboxPorTextoVisible(By localizador,String texto){
        Select selectorMes = new Select(esperarPorElementoLocalizado(localizador));
        selectorMes.selectByVisibleText(texto);
    }

    public void seleccionarComboboxPorValue(By localizador,String value){
        Select selectorMes = new Select(esperarPorElementoLocalizado(localizador));
        selectorMes.selectByValue(value);
    }

    public void scrollByLocator(By localizador){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", esperarPorElementoLocalizado(localizador));
    }

    public void conexionDriver(String browser, String rutaDriver, String property) {
    }
}
