package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.InteractorTime;
import net.serenitybdd.core.pages.PageObject;
//import org.jruby.RubyProcess;
import org.openqa.selenium.By;


public class ListadoTusRecogidas extends PageObject {

    InteractorTime interactorTime = new InteractorTime();

    public By EditaRecogida = By.xpath("//div[@name='registros']/ul[1]/li[7]/a[2]");

    public By AgregarPreenvio = By.xpath("//div[@name='registros']/ul[1]/li[7]/a[1]");

    public By notificacioncancelaR = By.id("Notificacion");

    public void EditarRecogida(){
        try {
            interactorTime.esperaMilis(5000);
            getDriver().findElement(EditaRecogida).click();
        }catch (Exception e){
            throw new RuntimeException("No se encontró funcionalidad Editar Recogida");
        }
    }

    public void regrezoExitoso(){
        try {
            getDriver().findElement(EditaRecogida).isDisplayed();
        }catch (Exception e){
            throw new RuntimeException("El regreso no fue exitoso");
        }
    }

    public void MensajeNotificacion(){
        try {
            String confirmacion = getDriver().findElement(notificacioncancelaR).getText();
            System.out.println(confirmacion);
        }catch (Exception e){
            throw new RuntimeException("No se ve las modificaciones");
        }
    }

    public void AgregarPreenvio(){
        try {
            getDriver().findElement(AgregarPreenvio).click();
            interactorTime.esperaMilis(5000);
        }catch (Exception e){
            throw new RuntimeException("No se encontró funcionalidad Agregar Prrenvio");
        }
    }
}
