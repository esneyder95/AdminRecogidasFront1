package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
//import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import org.openqa.selenium.Keys;


public class DatosDestinatario extends PageObject{

    InteractorTime interactorTime = new InteractorTime();

    public By CotizarPreenvio = By.id("CotizarPreenvio");
    public By destinatarionombreCompleto = By.id("txtDestinatarioNombreCompleto");
    public By destinatarioNumeroIdentificacion = By.id("txtDestinatarioNumeroIdentificacion");
    public By destinatarioTelefono = By.id("txtDestinatarioTelefono");
    public By destinatarioDireccion = By.id("txtDestinatarioDireccion");
    public By destinatarioCorreo = By.xpath("//input[@type='email']");
    public By destinatarioGuardar = By.id("GuardarPreenvio");

    public By regresar = By.xpath("//div[@class='col-xs-12 form-container']/form/div[7]/a");

    static String cedulaDes = "";

    static String celularDes = "";

    static String direcccionDes = "";

    static String tipoenvio = "";

    public void datoaDestinatario(){
        System.out.println("Ingresando datos Destinatario");
        interactorTime.esperaMilis(8000);
        getDriver().findElement(destinatarionombreCompleto).sendKeys("CARLOS GUTIERREZ");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarionombreCompleto).sendKeys(Keys.TAB);
        String comprobacion = new String();
        comprobacion = getDriver().findElement(destinatarioNumeroIdentificacion).getAttribute("value");
        interactorTime.esperaMilis(1000);
        if (comprobacion.equals("")){
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys("41778012");
            getDriver().findElement(destinatarioTelefono).sendKeys("3133160278");
            getDriver().findElement(destinatarioTelefono).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarioDireccion).sendKeys("calle");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(destinatarioDireccion).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarioCorreo).sendKeys("Correo@gmail.com");
        }
        getDriver().findElement(destinatarioGuardar).click();
        interactorTime.esperaMilis(20000);
    }

    public void cargueDataDestinatario(){
        System.out.println("Ingresando datos Destinatario");
        interactorTime.esperaMilis(5000);
        getDriver().findElement(destinatarionombreCompleto).sendKeys("LUZ ROMERO");
        interactorTime.esperaMilis(5000);
        getDriver().findElement(destinatarionombreCompleto).sendKeys(Keys.ARROW_DOWN);
        getDriver().findElement(destinatarionombreCompleto).sendKeys(Keys.ENTER);
        getDriver().findElement(destinatarionombreCompleto).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(5000);
        cedulaDes = getDriver().findElement(destinatarioNumeroIdentificacion).getAttribute("value");
        celularDes = getDriver().findElement(destinatarioTelefono).getAttribute("value");
        direcccionDes = getDriver().findElement(destinatarioDireccion).getAttribute("value");
        interactorTime.esperaMilis(5000);
    }

    public void cargueexitosodestinatario(){
        if ((cedulaDes.equals("41779013")) & (celularDes.equals("3133160298")) & (direcccionDes.equals("Calle falsa 49n 23"))){
            System.out.println("El cargue de los datos son correctos");
        }else{
            try {
                getDriver().findElement(CotizarPreenvio).click();
            }catch (Exception e){
                throw new RuntimeException("Los datos no son correctos");
            }
        }
    }

    public void regresodestinatario(){
        interactorTime.esperaMilis(2000);
        try {
            getDriver().findElement(regresar).click();
            interactorTime.esperaMilis(2000);
        }catch (Exception e){
            throw new RuntimeException("No funciona boton regresar");
        }
    }

    public void datoaDestinatarioCsv(){
        interactorTime.esperaMilis(10000);
        getDriver().findElement(destinatarionombreCompleto).sendKeys(DataCvs.nombredes2());
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(DataCvs.cedulades2());
        getDriver().findElement(destinatarioTelefono).sendKeys(DataCvs.celulardes2());
        getDriver().findElement(destinatarioDireccion).sendKeys(DataCvs.direcciondes2());
        getDriver().findElement(destinatarioCorreo).sendKeys(DataCvs.correodes2());
        getDriver().findElement(destinatarioGuardar).click();
        interactorTime.esperaMilis(10000);
    }

    public void datosDestinatarioafectacion(String Envio) {
        if (Envio.equals("Contado")){
            cedulaDes = "41778013";
            celularDes = "3003160298";
            interactorTime.esperaMilis(10000);
            getDriver().findElement(destinatarionombreCompleto).sendKeys("Luz Garcia");
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(cedulaDes);
            getDriver().findElement(destinatarioTelefono).sendKeys(celularDes);
            getDriver().findElement(destinatarioDireccion).sendKeys("Calle falsa N 123");
            getDriver().findElement(destinatarioCorreo).sendKeys("luz.romero@gmail.com");
            getDriver().findElement(destinatarioGuardar).click();
            interactorTime.esperaMilis(10000);
            tipoenvio = "Contado";
        }
        if (Envio.equals("AlCrobro")){
            cedulaDes = "218217";
            celularDes = "3004710585";
            interactorTime.esperaMilis(10000);
            getDriver().findElement(destinatarionombreCompleto).sendKeys("Victor Gutierrez");
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(cedulaDes);
            getDriver().findElement(destinatarioTelefono).sendKeys(celularDes);
            getDriver().findElement(destinatarioDireccion).sendKeys("Calle falsa N 123");
            getDriver().findElement(destinatarioCorreo).sendKeys("victor.gutierrez@gmail.com");
            getDriver().findElement(destinatarioGuardar).click();
            interactorTime.esperaMilis(10000);
            tipoenvio = "Al Cobro";
        }
        if (Envio.equals("PagoEnCasa")){
            cedulaDes = "1023017050";
            celularDes = "3004195427";
            interactorTime.esperaMilis(10000);
            getDriver().findElement(destinatarionombreCompleto).sendKeys("Duvan Rodriguez");
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(cedulaDes);
            getDriver().findElement(destinatarioTelefono).sendKeys(celularDes);
            getDriver().findElement(destinatarioDireccion).sendKeys("Calle falsa N 123");
            getDriver().findElement(destinatarioCorreo).sendKeys("duvan.rodriguez@gmail.com");
            getDriver().findElement(destinatarioGuardar).click();
            interactorTime.esperaMilis(10000);
            tipoenvio = "PagoEnCasa";
        }
        if (Envio.equals("Convenio")){
            interactorTime.esperaMilis(10000);
            cedulaDes = getDriver().findElement(destinatarioNumeroIdentificacion).getAttribute("value");
            celularDes = getDriver().findElement(destinatarioTelefono).getAttribute("value");
            getDriver().findElement(destinatarioGuardar).click();
            interactorTime.esperaMilis(10000);
            tipoenvio = "Crédito";
        }
    }

    public static String CedulaDes(){
        String cedula = cedulaDes;
        return cedula;
    }

    public static String CelularDes(){
        String celular = celularDes;
        return celular;
    }

    public static String tipoenvio(){
        String envio = tipoenvio;
        return envio;
    }
}
