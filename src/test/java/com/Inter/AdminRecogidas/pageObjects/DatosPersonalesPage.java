package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataRandom;
import com.Inter.AdminRecogidas.utils.DataCvs;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DatosPersonalesPage extends PageObject {
    InteractorTime interactorTime = new InteractorTime();
    public By numeroidentificacion = By.id("NumeroIdentificacion");
    public By numerocelular = By.xpath("//input[@placeholder='Ej: 9991234567']");
    public By nombre = By.xpath("//div[@class='container form-container personal-data']/div/form/div[4]/input");
    public By razonsocial = By.xpath("//div[@class='container form-container personal-data']/div/form/div[6]/input");
    public By apellido = By.xpath("//div[@class='container form-container personal-data']/div/form/div[5]/input");
    public By correoelectronico = By.xpath("//div[@class='form-group col-md-4 col-xs-12 tooltip-focus email']/input");
    public By continuarDatosP = By.xpath("//div[@class='container form-container personal-data']/div[1]/form/div[9]/button");
    public By cargando = By.id("cargando");
    public By logointer = By.xpath("//div[@class='col-md-5 col-xs-6 logo']/a");
    public static String Url;
    int respuesta = 0;
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);

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
        }else if (Url.equals("https://recogidasencasadesarrollo.interrapidisimo.com/")){
            ambiente = "Apitesting";
        }else{
            ambiente = "";
        }
        return ambiente;
    }
    public void regresohome(){
        getDriver().findElement(continuarDatosP).isDisplayed();
        interactorTime.esperaMilis(2000);
    }

    public void DatosPersonales() {
        try {
            String cedula = DataRandom.Cedula();
            String celular = DataRandom.NumeroCelular();
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(numeroidentificacion));
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de datos personales");
            }
            getDriver().findElement(numeroidentificacion).sendKeys(cedula);
            getDriver().findElement(numerocelular).sendKeys(celular);
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
            if ((Long.parseLong(cedula) >= 8000000000L && Long.parseLong(cedula) <= 9999999999L) || (Long.parseLong(cedula) >= 800000000L && Long.parseLong(cedula) <= 999999999L)){
                getDriver().findElement(razonsocial).sendKeys(DataRandom.Nombre() + " " + DataRandom.Apellido());
            }else {
                getDriver().findElement(nombre).sendKeys(DataRandom.Nombre());
                getDriver().findElement(apellido).sendKeys(DataRandom.Apellido());
            }
            getDriver().findElement(correoelectronico).sendKeys(DataRandom.CorreoElectronico());
            getDriver().findElement(continuarDatosP).click();
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }
    public void DatosPersonalesF(String Cedula, String Celular) {
        try {
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(numeroidentificacion));
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de datos personales");
            }
            getDriver().findElement(numeroidentificacion).sendKeys(Cedula);
            getDriver().findElement(numerocelular).sendKeys(Celular);
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
            getDriver().findElement(continuarDatosP).click();
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }

    public void DatosPersonalesPOS(String Cedula, String Celular) {
        try {
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(numeroidentificacion));
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de datos personales");
            }
            getDriver().findElement(numeroidentificacion).sendKeys(Cedula);
            getDriver().findElement(numerocelular).sendKeys(Celular);
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
            getDriver().findElement(continuarDatosP).click();
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }

    public void DatosPersonalesCvs() {
        try {
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(numeroidentificacion));
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de datos personales");
            }
            getDriver().findElement(numeroidentificacion).sendKeys(DataCvs.cedula2());
            getDriver().findElement(numerocelular).sendKeys(DataCvs.celular2());
            getDriver().findElement(numerocelular).sendKeys(Keys.TAB);
            tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
            getDriver().findElement(continuarDatosP).click();
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de Recogidas");
        }
    }
    public void linkinterrapidisimo(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(logointer));
            HttpURLConnection http = null;
            String src = "";
            src = getDriver().findElement(logointer).getAttribute("href");
            try{
                http = (HttpURLConnection) (new URL(src).openConnection());
                http.setRequestMethod("HEAD");
                http.connect();
                respuesta = http.getResponseCode();
            }catch (Exception e){
                throw new RuntimeException("No se encuentra link del logo");
            }
        }catch (Exception e){
            throw new RuntimeException("No cargo la pagina de datos personales");
        }
    }

    public void linkexitosointer(){
        if (respuesta < 400){
            System.out.println("Link de interrapidisimo respondio corectamente");
        }else{
            try{
                fail("Link de interrapidisimo no responde");
            }catch (final RuntimeException e){
                assertTrue(true);
            }
        }
    }
}
