package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataRandom;
import com.Inter.AdminRecogidas.utils.GenerarReporte;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import com.Inter.AdminRecogidas.utils.ListadoRecogidasRandom;
import com.github.rjeschke.txtmark.Run;
import net.serenitybdd.core.pages.PageObject;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ListadoTusRecogidas extends PageObject {

    InteractorTime interactorTime = new InteractorTime();
    ListadoRecogidasRandom listadoRecogidasRandom = new ListadoRecogidasRandom();
    GenerarReporte generarReporte = new GenerarReporte();
    public By EditaRecogida = By.xpath("//div[@name='registros']/ul[1]/li[7]/a[2]");
    public By AgregarPreenvio = By.xpath("//div[@name='registros']/ul[1]/li[7]/a[1]");
    public By cancelar = By.xpath("//div[@name='registros']/ul[1]/li[7]/a[3]");
    public By cancelarconfirmacion = By.id("GuardarCancelacionRecogida");
    public By filtradoId = By.id("filtroIdRecogida");
    public By Nrecogida = By.xpath("//div[@name='registros']/ul[1]/li[1]");
    public By filtradoEstado = By.id("filtroEstadoRecogida");
    public By listarecogida = By.xpath("//div[@name='registros']/ul[1]/li[3]");
    WebDriverWait tiempo = new WebDriverWait(getDriver(), 30);

    public void EditarRecogida(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(EditaRecogida));
            getDriver().findElement(EditaRecogida).click();
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No se encontró funcionalidad Editar Recogida","");
            throw new RuntimeException("No se encontró funcionalidad Editar Recogida");
        }
    }

    public void cancelorecogidalis(){
        tiempo.until(ExpectedConditions.elementToBeClickable(cancelar));
        getDriver().findElement(cancelar).click();
        tiempo.until(ExpectedConditions.elementToBeClickable(cancelarconfirmacion));
        getDriver().findElement(cancelarconfirmacion).click();
    }

    public void regrezoExitoso(){
        try {
            getDriver().findElement(EditaRecogida).isDisplayed();
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","El regreso no fue exitoso","");
            throw new RuntimeException("El regreso no fue exitoso");
        }
    }

    public void MensajeNotificacion(){
        try{
            tiempo.until(ExpectedConditions.attributeToBe(By.id("MensajeNotificacion"),"class","message-fixed-button"));
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No se edito/cancelo la recogida","");
            throw new RuntimeException("No se edito/cancelo la recogida");
        }
    }

    public void AgregarPreenvio(){
        try {
            getDriver().findElement(AgregarPreenvio).click();
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No se encontró funcionalidad Agregar Preenvio","");
            throw new RuntimeException("No se encontró funcionalidad Agregar Preenvio");
        }
    }

    public void filtrarporId(){
        listadoRecogidasRandom.contarrecogidas();
        getDriver().findElement(filtradoId).sendKeys(ListadoRecogidasRandom.IdlistadoRecogida());
    }

    public void filtrarIdexitoso(){
        String Idrecogida = "";
        Idrecogida = getDriver().findElement(Nrecogida).getText();
        if (ListadoRecogidasRandom.IdlistadoRecogida().equals(Idrecogida)){
            System.out.println("El filtrado por Id = " + ListadoRecogidasRandom.IdlistadoRecogida() + " fue exitosa");
        }else{
            try{
                generarReporte.TomarPantallazo();
                generarReporte.CasoFallido("","El filtrado no fue lo esperado","");
                fail("El filtrado no fue lo esperado");
            }catch (final RuntimeException e){
                assertTrue(true);
            }
        }
    }

    public void filtrarestado(String estado){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(AgregarPreenvio));
            getDriver().findElement(filtradoEstado).sendKeys(Keys.ENTER);
            getDriver().findElement(filtradoEstado).sendKeys(Keys.ARROW_UP);
            getDriver().findElement(filtradoEstado).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            if (estado.equals("Activas")){
                getDriver().findElement(filtradoEstado).sendKeys(Keys.ENTER);
                getDriver().findElement(filtradoEstado).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(filtradoEstado).sendKeys(Keys.ENTER);
            }
            if (estado.equals("Finalizadas")){
                getDriver().findElement(filtradoEstado).sendKeys(Keys.ENTER);
                getDriver().findElement(filtradoEstado).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(filtradoEstado).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(filtradoEstado).sendKeys(Keys.ENTER);
            }
            interactorTime.esperaMilis(1000);
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No se encuentra la opcion de filtrar por estado","");
            throw new RuntimeException("No se encuentra la opcion de filtrar por estado");
        }
    }

    public void filtrarestadoexitoso(String estado){
        if (estado.equals("Activas")){
            if (getDriver().findElement(listarecogida).getText().equals("Activa")){
                System.out.println("El sistema filtro corectamente");
            }else{
                try{
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","El sistema no filtro correctamente","");
                    fail("El sistema no filtro correctamente");
                }catch (final RuntimeException e){
                    assertTrue(true);
                }
            }
        }
        if (estado.equals("Finalizadas")){
            if (getDriver().findElement(listarecogida).getText().equals("Finalizada")){
                System.out.println("El sistema filtro corectamente");
            }else{
                try{
                    generarReporte.TomarPantallazo();
                    generarReporte.CasoFallido("","El sistema no filtro correctamente","");
                    fail("El sistema no filtro correctamente");
                }catch (final RuntimeException e){
                    assertTrue(true);
                }
            }
        }
    }

}
