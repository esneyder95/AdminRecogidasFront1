package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class PantallaEditarRecogidasPage extends PageObject {

    InteractorTime interactorTime = new InteractorTime();

    public By cancelarrecogida = By.id("btnCancelarRecogida");

    public By cancelarconfirmacion = By.id("GuardarCancelacionRecogida");

    public By editarecogida = By.id("btnEditarRecogida");

    public By agregarpreenvio = By.id("btnAsociarPreenvios");

    public By seleccionarpreenvio = By.xpath("//div[@id='PreenviosAsociados']/div[1]/ul[1]/li[1]/div[1]");

    public By borrarpreenvio = By.xpath("//div[@id='PreenviosAsociados']/div[1]/ul[1]/li[6]/a[2]");

    public By confirmarborradoPRE = By.id("AnularPreenvio");

    public By desasociarpre = By.id("LiberarPreenvio");

    public void CancelarRecogida() {
        interactorTime.esperaMilis(5000);
        getDriver().findElement(cancelarrecogida).click();
        interactorTime.esperaMilis(5000);
        getDriver().findElement(cancelarconfirmacion).click();
    }

    public void EditarRecogida(){
        try{
            interactorTime.esperaMilis(5000);
            getDriver().findElement(editarecogida).click();
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }

    public void AgregarPreenvio(){
        try {
            getDriver().findElement(agregarpreenvio).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }

    public void BorrarPreenvio(){
        try {
            interactorTime.esperaMilis(5000);
            getDriver().findElement(seleccionarpreenvio).click();
            interactorTime.esperaMilis(1000);
            getDriver().findElement(borrarpreenvio).click();
            interactorTime.esperaMilis(3000);
            getDriver().findElement(confirmarborradoPRE).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }

    public void DesasociarPreenvio(){
        try {
            interactorTime.esperaMilis(5000);
            getDriver().findElement(seleccionarpreenvio).click();
            interactorTime.esperaMilis(1000);
            getDriver().findElement(borrarpreenvio).click();
            interactorTime.esperaMilis(3000);
            getDriver().findElement(desasociarpre).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No se cargo popup opciones Editar Recogidas");
        }
    }
}
