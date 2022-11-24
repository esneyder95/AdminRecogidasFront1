package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
//import org.jruby.RubyProcess;
import org.openqa.selenium.By;

import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;

public class DatosRecogidaPage extends PageObject {

    InteractorTime interactorTime = new InteractorTime();


    public By ciudad = By.id("Ciudad");
    public By direccion = By.id("txtDireccion");
    public By completemetoDir = By.id("ComplementoDireccion");
    public By terminos = By.xpath("//div[@class='form-group col-md-5 col-xs-12']/div[1]/label/span");
    public By politica = By.xpath("//div[@class='form-group col-md-5 col-xs-12']/div[2]/label/span");
    public By guardar = By.id("Guardar");

    public By texto = By.xpath("//div[@class='container']/div/div[1]");

    public By nuevarecogida = By.xpath("//a[@class='col-md-2 btn-default']");

    public By regresar = By.xpath("//div[@class='col-xs-12 buttons-container']/a");

    public By home = By.xpath("//div[@class='menu-header hide-tablet-mobile']/a/span");

    public By preguntar = By.id("IdPregunta");

    public By fecha = By.id("FechaRecogida");

    public By tusrecogidas = By.xpath("//a[@class='link-home link-table']/span");

    public void DatosRecogida() {
        try {
            System.out.println("Ingresando Datos Recogida");
            getDriver().findElement(ciudad).sendKeys("BOGOTA\\CUND\\COL");
            getDriver().findElement(direccion).sendKeys("Cra 89 a # 8a 25");
            getDriver().findElement(completemetoDir).sendKeys("Torre 1 Apto 201");
            getDriver().findElement(terminos).click();
            getDriver().findElement(politica).click();
            interactorTime.esperaMilis(15000);
            getDriver().findElement(guardar).click();
            interactorTime.esperaMilis(20000);
        }catch (Exception e){
            throw new RuntimeException("No se cargó página datos Recogidas");
        }
    }

    public void IngresoTusRecogidas() {
        getDriver().findElement(tusrecogidas).click();
        interactorTime.esperaMilis(5000);
    }
    public void nuevarecogida(){
        getDriver().findElement(nuevarecogida).click();
        interactorTime.esperaMilis(2000);
    }

    public void regresarnuevarecogida(){
        getDriver().findElement(regresar).click();
        interactorTime.esperaMilis(2000);
    }

    public void regresarhome(){
        getDriver().findElement(home).click();
        interactorTime.esperaMilis(2000);
    }
    public void DatosRecogidaf() {
        try{
            getDriver().findElement(nuevarecogida).click();
            System.out.println("Ingresando Datos Recogida");
            interactorTime.esperaMilis(20000);
            interactorTime.esperaMilis(5000);
            getDriver().findElement(guardar).click();
            interactorTime.esperaMilis(20000);
        }catch (Exception e){
            throw new RuntimeException("No carga Data de cliente frecuente");
        }
    }

    public void DatosRecogidaCVS() {
        try{
            getDriver().findElement(nuevarecogida).click();
            System.out.println("Ingresando Datos Recogida");
            interactorTime.esperaMilis(20000);
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
            getDriver().findElement(guardar).click();
            interactorTime.esperaMilis(20000);
        }catch (Exception e){
            throw new RuntimeException("No carga Data de cliente frecuente");
        }
    }
    public void SeCargaPagina(){
        try {
            String Tex = getDriver().findElement(texto).getText();
            System.out.println("" + Tex);
        }catch (Exception e){
            throw new RuntimeException("No carga datos de recogida");
        }
    }

    public By numerodeRecogida = By.id("NuevaRecogida");
    /*public void EnviarFormulario(){
        
        getDriver().findElement(guardar).click();
        utils.esperaMilis(10000);  
  
    }*/

    public void EditarDatosRecogida(){
        try{
            interactorTime.esperaMilis(20000);
            getDriver().findElement(completemetoDir).clear();
            getDriver().findElement(preguntar).clear();
            interactorTime.esperaMilis(1000);
            getDriver().findElement(completemetoDir).sendKeys("Casa con jardin");
            getDriver().findElement(preguntar).sendKeys("BENITO PEREZ");
            getDriver().findElement(guardar).click();
            interactorTime.esperaMilis(20000);
        }catch (Exception e){
            throw new RuntimeException("No cargó ventana Datos Recogidas");
        }
    }

    public void DatosRecogidaCsv() {
        System.out.println("Ingresando Datos Recogida");
        interactorTime.esperaMilis(5000);
        //try{
            getDriver().findElement(ciudad).sendKeys(DataCvs.ciudad2());
            getDriver().findElement(direccion).sendKeys(DataCvs.direccion2());
            getDriver().findElement(completemetoDir).sendKeys(DataCvs.complemento2());
            getDriver().findElement(terminos).click();
            getDriver().findElement(politica).click();
            interactorTime.esperaMilis(10000);
            getDriver().findElement(guardar).click();
            interactorTime.esperaMilis(10000);
       /* }catch (Exception e){
            System.out.println("No se encontro el elemento");
        }*/
    }
    public void DatosRecogidaAPP() {
        try{
            interactorTime.esperaMilis(5000);
            getDriver().findElement(nuevarecogida).click();
            System.out.println("Ingresando Datos Recogida");
            interactorTime.esperaMilis(20000);
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
            getDriver().findElement(guardar).click();
            interactorTime.esperaMilis(20000);
        }catch (Exception e){
            throw new RuntimeException("No carga Data de cliente frecuente");
        }
    }
}



