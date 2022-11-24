package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataRandom;
import com.Inter.AdminRecogidas.utils.DataCvs;
//import org.apache.http.TruncatedChunkException;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Before;
import org.openqa.selenium.By;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import java.util.Optional;

public class DatosPersonalesPage extends PageObject {
    InteractorTime interactorTime = new InteractorTime();
    public By numeroidentificacion = By.id("NumeroIdentificacion");
    public By numerocelular = By.xpath("//input[@placeholder='Ej: 9991234567']");
    public By razonnombre = By.xpath("//div[@class='container form-container personal-data']/div/form/div[4]/input");
    public By correoelectronico = By.xpath("//div[@class='container form-container personal-data']/div/form/div[5]/input");
    public By continuarDatosP = By.xpath("//div[@class='container form-container personal-data']/div[1]/form/div[6]/button");
    public static String Url;

    public void OpenAdmin() {
        try {
            EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
            Url = variables.getProperty("webdriver.Url");
            getDriver().get(Url);
        }catch (Exception e){
            throw new RuntimeException("La pagina web no carga");
        }
    }
    public static String ambiente() {
        String ambiente;
        if (Url.equals("https://recogidasencasaqa.interrapidisimo.com/")){
            ambiente = "QA";
        }else {
            ambiente = "Apitesting";
        }
        return ambiente;
    }
    public void regresohome(){
        getDriver().findElement(continuarDatosP).isDisplayed();
        interactorTime.esperaMilis(2000);
    }

    public void DatosPersonales() {
        try {
            System.out.println("Ingresando Datos Personales");
            getDriver().findElement(numeroidentificacion).sendKeys(DataRandom.Cedula());
            getDriver().findElement(numerocelular).sendKeys(DataRandom.NumeroCelular());
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(5000);
            getDriver().findElement(razonnombre).sendKeys(DataRandom.Nombre());
            getDriver().findElement(correoelectronico).sendKeys(DataRandom.CorreoElectronico());
            interactorTime.esperaMilis(5000);
            getDriver().findElement(continuarDatosP).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }
    public void DatosPersonalesF(String Cedula, String Celular) {
        try {
            System.out.println("Ingresando Datos Personales");
            getDriver().findElement(numeroidentificacion).sendKeys(Cedula);
            getDriver().findElement(numerocelular).sendKeys(Celular);
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(5000);
            getDriver().findElement(continuarDatosP).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }

    public void DatosPersonalesPOS() {
        interactorTime.esperaMilis(10000);
        try {
            System.out.println("Ingrasando Datos Personales");
            getDriver().findElement(numeroidentificacion).sendKeys("1024567308");
            getDriver().findElement(numerocelular).sendKeys("3005761988");
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(5000);
            getDriver().findElement(continuarDatosP).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }

    public void DatosPersonalesCvs() {
        try {
            System.out.println("Ingresando Datos Personales");
            getDriver().findElement(numeroidentificacion).sendKeys(DataCvs.cedula2());
            getDriver().findElement(numerocelular).sendKeys(DataCvs.celular2());
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(5000);
            getDriver().findElement(continuarDatosP).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }
}
