package aut.testcreation.pages.rantagli;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumWrapper {

        //Definir los localizadores

    By locatorBtnRegistrarse = By.xpath("//span[contains(text(),'Registrate')]");
    By locatorBtnAyuda = By.xpath("//*[@id='header']/div[3]/div/ul[2]/li[1]/a");

    By locatorBtnContactanos = By.xpath("//*[@id=\"header\"]/div[3]/div/ul[2]/li[2]/a");
        public HomePage(WebDriver driver) {
            super(driver);
        }

        //Centralizar las acciones
        public void irARegistrarse(){
            //click(locatorBtnRegistrarte);
            click(esperarPorElementoLocalizado(locatorBtnRegistrarse));
            esperarXSegundos(4000);
        }

    public void irAyuda(){

        click(esperarPorElementoLocalizado(locatorBtnAyuda));
        esperarXSegundos(4000);
    }

    public void irContactanos(){

        click(esperarPorElementoLocalizado(locatorBtnContactanos));
        esperarXSegundos(4000);
    }
    }

