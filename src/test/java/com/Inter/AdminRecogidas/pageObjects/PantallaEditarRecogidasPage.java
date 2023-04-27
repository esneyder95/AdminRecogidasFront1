package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PantallaEditarRecogidasPage extends PageObject {

    public By cancelarrecogida = By.id("btnCancelarRecogida");
    public By cancelarconfirmacion = By.id("GuardarCancelacionRecogida");
    public By editarecogida = By.id("btnEditarRecogida");
    public By agregarpreenvio = By.id("btnAsociarPreenvios");
    public By seleccionarpreenvio = By.xpath("//div[@id='PreenviosAsociados']/div[1]/ul[1]/li[1]/div[1]");
    public By borrarpreenvio = By.xpath("//div[@id='PreenviosAsociados']/div[1]/ul[1]/li[6]/a[2]");
    public By confirmarborradoPRE = By.id("AnularPreenvio");
    public By desasociarpre = By.id("LiberarPreenvio");
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);

    public void CancelarRecogida() {
        tiempo.until(ExpectedConditions.elementToBeClickable(cancelarrecogida));
        getDriver().findElement(cancelarrecogida).click();
        tiempo.until(ExpectedConditions.elementToBeClickable(cancelarrecogida));
        getDriver().findElement(cancelarconfirmacion).click();
    }

    public void EditarRecogida(){
        try{
            tiempo.until(ExpectedConditions.elementToBeClickable(editarecogida));
            getDriver().findElement(editarecogida).click();
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }

    public void AgregarPreenvio(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(agregarpreenvio));
            getDriver().findElement(agregarpreenvio).click();
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }

    public void BorrarPreenvio(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(seleccionarpreenvio));
            getDriver().findElement(seleccionarpreenvio).click();
            tiempo.until(ExpectedConditions.elementToBeClickable(borrarpreenvio));
            getDriver().findElement(borrarpreenvio).click();
            tiempo.until(ExpectedConditions.elementToBeClickable(confirmarborradoPRE));
            getDriver().findElement(confirmarborradoPRE).click();
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }

    public void DesasociarPreenvio(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(seleccionarpreenvio));
            getDriver().findElement(seleccionarpreenvio).click();
            tiempo.until(ExpectedConditions.elementToBeClickable(borrarpreenvio));
            getDriver().findElement(borrarpreenvio).click();
            tiempo.until(ExpectedConditions.elementToBeClickable(desasociarpre));
            getDriver().findElement(desasociarpre).click();
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }
}
