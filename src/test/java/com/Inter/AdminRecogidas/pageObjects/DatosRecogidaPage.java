package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
//import org.jruby.RubyProcess;
import com.Inter.AdminRecogidas.utils.GenerarReporte;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DatosRecogidaPage extends PageObject {

    InteractorTime interactorTime = new InteractorTime();
    GenerarReporte generarReporte = new GenerarReporte();
    int respuesta = 0;
    public By ciudad = By.id("Ciudad");
    public By direccion = By.id("txtDireccion");
    public By completemetoDir = By.id("ComplementoDireccion");
    public By terminos = By.xpath("//div[@class='form-group col-md-5 col-xs-12']/div[1]/label/span");
    public By linkpolitca = By.xpath("//div[@class='form-group col-md-5 col-xs-12']/div[1]/label/a");
    public By politica = By.xpath("//div[@class='form-group col-md-5 col-xs-12']/div[2]/label/span");
    public By linkterminos = By.xpath("//div[@class='form-group col-md-5 col-xs-12']/div[2]/label/a");
    public By guardar = By.xpath("//button[@id='Guardar']");
    public By texto = By.xpath("//div[@class='container']/div/div[1]");
    public By nuevarecogida = By.xpath("//a[@class='col-md-2 btn-default']");
    public By regresar = By.xpath("//form[@id='frmRecogida']/div[10]/a");
    public By home = By.xpath("//div[@class='menu-header hide-tablet-mobile']/a/span");
    public By preguntar = By.id("IdPregunta");
    public By fecha = By.id("FechaRecogida");
    public By tusrecogidas = By.xpath("//a[@class='link-home link-table']/span");
    public By recaptcha = By.xpath("//html[@dir]/body/div[2]/div[3]/div[1]/div[1]/div[1]/span");
    public By verrecogidas = By.xpath("//div[@class='active-shippings-message modal-container container']/div[1]/div[1]/div[1]/a[2]");
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);

    public void DatosRecogida() {
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(ciudad));
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No carga ventana de recogidas","");
            throw new RuntimeException("No carga pagina de recogidas");
        }
        getDriver().findElement(ciudad).sendKeys("BOGOTA\\CUND\\COL");
        getDriver().findElement(direccion).sendKeys("Cra 89 a # 8a 25");
        getDriver().findElement(completemetoDir).sendKeys("Torre 1 Apto 201");
        getDriver().findElement(terminos).click();
        getDriver().findElement(politica).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@style='width: 304px; height: 78px;']/div[1]/iframe")));
        getDriver().findElement(recaptcha).getAttribute("class");
        int i = 0;
        while (i==0){
            String captcha = "";
            captcha = getDriver().findElement(recaptcha).getAttribute("class");
            if (captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked") ||
                    captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-focused recaptcha-checkbox-checked")){
                try{
                    interactorTime.esperaMilis(2000);
                    getDriver().switchTo().defaultContent();
                    getDriver().findElement(guardar).click();
                    i=1;
                }catch (Exception e){
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","No carga Data de cliente frecuente","");
                    throw new RuntimeException("No carga Data de cliente frecuente");
                }
            }else{
                i = 0;
            }
        }
    }

    public void IngresoTusRecogidas() {
        try {
            tiempo.until(ExpectedConditions.attributeToBe(By.id("MensajeModalTieneRecogidas"),"class","active-shippings-message-container"));
            interactorTime.esperaMilis(1000);
            generarReporte.TomarPantallazo();
            getDriver().findElement(verrecogidas).click();
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","La ventana de crear/editar recogidas no cargo","");
            throw new RuntimeException("No cargo ventana de crear/editar recogidas");
        }
    }
    public void TusRecogidas() {
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(tusrecogidas));
            getDriver().findElement(tusrecogidas).click();
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","La ventana de crear/editar recogidas no cargo","");
            throw new RuntimeException("No cargo ventana de crear/editar recogidas");
        }
    }
    public void nuevarecogida(){
        getDriver().findElement(nuevarecogida).click();
    }

    public void regresarnuevarecogida(){
        getDriver().findElement(regresar).click();
    }

    public void regresarhome(){
        getDriver().findElement(home).click();
    }
    public void DatosRecogidaf() {
        getDriver().findElement(nuevarecogida).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@style='width: 304px; height: 78px;']/div[1]/iframe")));
        getDriver().findElement(recaptcha).getAttribute("class");
        int i = 0;
        while (i==0){
            String captcha = "";
            captcha = getDriver().findElement(recaptcha).getAttribute("class");
            if (captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked") ||
                    captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-focused recaptcha-checkbox-checked")){
                try{
                    interactorTime.esperaMilis(2000);
                    getDriver().switchTo().defaultContent();
                    generarReporte.TomarPantallazo();
                    getDriver().findElement(guardar).click();
                    i=1;
                }catch (Exception e){
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","No carga Data de cliente frecuente","");
                    throw new RuntimeException("No carga Data de cliente frecuente");
                }
            }else{
                i = 0;
            }
        }
    }

    public void DatosRecogidaCVS() {
        getDriver().findElement(nuevarecogida).click();
        interactorTime.esperaMilis(2000);
        getDriver().findElement(ciudad).clear();
        getDriver().findElement(direccion).clear();
        getDriver().findElement(completemetoDir).clear();
        interactorTime.esperaMilis(2000);
        getDriver().findElement(ciudad).sendKeys("BOGOTA\\CUND\\COL");
        interactorTime.esperaMilis(2000);
        getDriver().findElement(direccion).sendKeys("calle");
        interactorTime.esperaMilis(2000);
        getDriver().findElement(direccion).sendKeys(Keys.ARROW_DOWN);
        interactorTime.esperaMilis(2000);
        getDriver().findElement(direccion).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(2000);
        getDriver().findElement(completemetoDir).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(2000);
        getDriver().findElement(fecha).sendKeys(Keys.ENTER);
        interactorTime.esperaMilis(2000);
        getDriver().findElement(fecha).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(5000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@style='width: 304px; height: 78px;']/div[1]/iframe")));
        getDriver().findElement(recaptcha).getAttribute("class");
        int i = 0;
        while (i==0){
            String captcha = "";
            captcha = getDriver().findElement(recaptcha).getAttribute("class");
            if (captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked") ||
                    captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-focused recaptcha-checkbox-checked")){
                try{
                    interactorTime.esperaMilis(2000);
                    getDriver().switchTo().defaultContent();
                    getDriver().findElement(guardar).click();
                    i=1;
                }catch (Exception e){
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","No carga Data de cliente frecuente","");
                    throw new RuntimeException("No carga Data de cliente frecuente");
                }
            }else{
                i = 0;
            }
        }
    }
    public void SeCargaPagina(){
        try {
            String Tex = getDriver().findElement(texto).getText();
            System.out.println("" + Tex);
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No carga los datos de recogida","");
            throw new RuntimeException("No carga datos de recogida");
        }
    }

    public void EditarDatosRecogida(){
        getDriver().findElement(completemetoDir).clear();
        getDriver().findElement(preguntar).clear();
        interactorTime.esperaMilis(1000);
        getDriver().findElement(completemetoDir).sendKeys("Casa con jardin");
        getDriver().findElement(preguntar).sendKeys("BENITO PEREZ");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@style='width: 304px; height: 78px;']/div[1]/iframe")));
        getDriver().findElement(recaptcha).getAttribute("class");
        int i = 0;
        while (i==0){
            String captcha = "";
            captcha = getDriver().findElement(recaptcha).getAttribute("class");
            if (captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked") ||
                    captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-focused recaptcha-checkbox-checked")){
                try{
                    interactorTime.esperaMilis(2000);
                    getDriver().switchTo().defaultContent();
                    getDriver().findElement(guardar).click();
                    i=1;
                }catch (Exception e){
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","No carga Data de cliente frecuente","");
                    throw new RuntimeException("No carga Data de cliente frecuente");
                }
            }else{
                i = 0;
            }
        }
    }

    public void DatosRecogidaCsv() {
        getDriver().findElement(ciudad).sendKeys(DataCvs.ciudad2());
        getDriver().findElement(direccion).sendKeys(DataCvs.direccion2());
        getDriver().findElement(completemetoDir).sendKeys(DataCvs.complemento2());
        getDriver().findElement(terminos).click();
        getDriver().findElement(politica).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@style='width: 304px; height: 78px;']/div[1]/iframe")));
        getDriver().findElement(recaptcha).getAttribute("class");
        int i = 0;
        while (i==0){
            String captcha = "";
            captcha = getDriver().findElement(recaptcha).getAttribute("class");
            if (captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked") ||
                    captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-focused recaptcha-checkbox-checked")){
                try{
                    interactorTime.esperaMilis(2000);
                    getDriver().switchTo().defaultContent();
                    getDriver().findElement(guardar).click();
                    i=1;
                }catch (Exception e){
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","No carga Data de cliente frecuente","");
                    throw new RuntimeException("No carga Data de cliente frecuente");
                }
            }else{
                i = 0;
            }
        }
    }
    public void DatosRecogidaAPP() {
        tiempo.until(ExpectedConditions.elementToBeClickable(nuevarecogida));
        getDriver().findElement(nuevarecogida).click();
        interactorTime.esperaMilis(5000);
        getDriver().findElement(ciudad).clear();
        getDriver().findElement(direccion).clear();
        getDriver().findElement(completemetoDir).clear();
        interactorTime.esperaMilis(2000);
        getDriver().findElement(ciudad).sendKeys("BOGOTA\\CUND\\COL");
        interactorTime.esperaMilis(2000);
        getDriver().findElement(direccion).sendKeys("carrera 65a#18a01");
        interactorTime.esperaMilis(2000);
        getDriver().findElement(direccion).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(2000);
        getDriver().findElement(completemetoDir).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(2000);
        getDriver().findElement(fecha).sendKeys(Keys.ENTER);
        interactorTime.esperaMilis(2000);
        getDriver().findElement(fecha).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(2000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@style='width: 304px; height: 78px;']/div[1]/iframe")));
        getDriver().findElement(recaptcha).getAttribute("class");
        int i = 0;
        while (i==0){
            String captcha = "";
            captcha = getDriver().findElement(recaptcha).getAttribute("class");
            if (captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked") ||
                    captcha.equals("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-focused recaptcha-checkbox-checked")){
                try{
                    interactorTime.esperaMilis(2000);
                    getDriver().switchTo().defaultContent();
                    getDriver().findElement(guardar).click();
                    i=1;
                }catch (Exception e){
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","No carga Data de cliente frecuente","");
                    throw new RuntimeException("No carga Data de cliente frecuente");
                }
            }else{
                i = 0;
            }
        }
    }

    public void linkpoliticadatos(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(linkpolitca));
            HttpURLConnection http = null;
            String src = "";
            src = getDriver().findElement(linkpolitca).getAttribute("href");
            try{
                http = (HttpURLConnection) (new URL(src).openConnection());
                http.setRequestMethod("HEAD");
                http.connect();
                respuesta = http.getResponseCode();
            }catch (Exception e){
                generarReporte.TomarPantallazo();
                generarReporte.CasoFallido("","No se encuentra link de politica de datos","");
                throw new RuntimeException("No se encuentra link de politica de datos");
            }
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No cargo la pagina de datos de recogidas","");
            throw new RuntimeException("No cargo la pagina de datos de recogidas");
        }
    }

    public void linkexitosopoliticadatos(){
        if (respuesta < 400){
            System.out.println("Link de politica de datos respondio corectamente");
        }else{
            try{
                generarReporte.TomarPantallazo();
                generarReporte.CasoFallido("","El link de politicas no responde","");
                fail("El link no responde");
            }catch (final RuntimeException e){
                assertTrue(true);
            }
        }
    }

    public void linkterminos(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(linkterminos));
            HttpURLConnection http = null;
            String src = "";
            src = getDriver().findElement(linkterminos).getAttribute("href");
            try{
                http = (HttpURLConnection) (new URL(src).openConnection());
                http.setRequestMethod("HEAD");
                http.connect();
                respuesta = http.getResponseCode();
            }catch (Exception e){
                generarReporte.TomarPantallazo();
                generarReporte.CasoFallido("","No se encuentra link de terminos y condiciones","");
                throw new RuntimeException("No se encuentra link de terminos y condiciones");
            }
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No cargo la pagina de datos recogidas","");
            throw new RuntimeException("No cargo la pagina de datos recogidas");
        }
    }

    public void linkexitosoterminos(){
        if (respuesta < 400){
            System.out.println("Link de terminos y condicones respondio corectamente");
        }else{
            try{
                generarReporte.TomarPantallazo();
                generarReporte.CasoFallido("","El link de terminos y condicones no responde","");
                fail("El link de terminos y condicones no responde");
            }catch (final RuntimeException e){
                assertTrue(true);
            }
        }
    }

}



