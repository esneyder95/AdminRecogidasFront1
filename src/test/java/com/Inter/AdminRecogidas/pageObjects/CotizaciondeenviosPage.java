package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
import com.Inter.AdminRecogidas.utils.DataRandom;
import com.Inter.AdminRecogidas.utils.ServiciosRandom;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;

import net.serenitybdd.core.pages.PageObject;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import org.openqa.selenium.support.ui.Select;

import java.net.HttpURLConnection;
import java.net.URL;

public class CotizaciondeenviosPage extends PageObject{

    InteractorTime interactorTime = new InteractorTime();
    ServiciosRandom serviciosRandom = new ServiciosRandom();
    int respuesta = 0;

    public By cotizacionCiudad = By.id("CiudadDestino");
    public By cotizaciondonde = By.xpath("//div[@id='DatosCotizacion']/div[1]/div[1]/form/div[6]/select");
    public By cotizacionTpaquete = By.xpath("//div[@id='DatosCotizacion']/div[1]/div[1]/form/div[7]/select");
    public By cotizacionContiene = By.xpath("//input[@placeholder='Ej: Reproductor de música']");
    public By pagoencasa = By.id("SelectedIncluirPagoEnCasa");

    public By nopagoencasa = By.id("SelectedNoIncluirPagoEnCasa");
    public By alcontado = By.xpath("//div[@class='form-group col-xs-12 payment-way no-padding-left ']/div[1]");
    public By CotizarPreenvio = By.id("CotizarPreenvio");

    public By clientecorporativo = By.xpath("//div[@class='form-group col-md-3 col-xs-12 customer-agreement no-padding-right']/div[1]/label");

    public By confirmarCuenta = By.xpath("//div[@class='col-xs-12']/form/div[3]/button");

    public By convenio = By.xpath("//input[@placeholder='Código del convenio']");

    public By agregarpreenvio = By.xpath("//div[@class='disassociated-preshippings-container']/div[1]/form/div[3]/a");

    public By regresar = By.xpath("//div[@class='col-xs-12 form-container']/form/div[16]/a");

    public By regresarConfi = By.id("ConfirmaAceptada");

    public By actualizarcuenta = By.xpath("//a[@class='btn btn-link AbrirPortalAutogestion']");

    public By peso = By.xpath("//div[@class='form-group col-md-2 col-xs-12 weight-input no-padding-left']/input");

    public By btnjudiciales = By.xpath("//div[@class='judicial-notifications modal-container container']/div[1]/div[1]/div[1]/form/div[4]/button");

    public By codigoradicado = By.xpath("//input[@placeholder='Ej: 1234']");
    public By btnradicado = By.xpath("//div[@class='rapi-radicado modal-container container']/div[1]/div[1]/div[1]/form/div[6]/button");

    static String tiposervicio = "";

    public void Cotizatuenvio(String dato){
        try{
            getDriver().findElement(agregarpreenvio).isDisplayed();
            System.out.println("Se encontraron preenvios para asociar");
            getDriver().findElement(agregarpreenvio).click();
            interactorTime.esperaMilis(5000);
        }catch (NoSuchElementException exception){
        }
        interactorTime.esperaMilis(10000);
        System.out.println("Ingresando datos de Cotización");
        if (dato.equals("carguedatos")){
            getDriver().findElement(cotizacionCiudad).sendKeys("BOGOTA\\CUND\\COL");
        }else{
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
        }
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(10000);
        Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
        drpcotizaciondonde.selectByVisibleText(DataRandom.Donde());
        interactorTime.esperaMilis(5000);
        Select drpcotizacionTpaquete = new Select (getDriver().findElement(cotizacionTpaquete));
        drpcotizacionTpaquete.selectByVisibleText(DataRandom.paquete());
        interactorTime.esperaMilis(5000);
        getDriver().findElement(cotizacionContiene).sendKeys("Automatización");
        interactorTime.esperaMilis(5000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();  
        js.executeScript("window.scrollBy(0,1000)");
        interactorTime.esperaMilis(10000);
        getDriver().findElement(nopagoencasa).click();
        interactorTime.esperaMilis(1000);
        getDriver().findElement(CotizarPreenvio).click();
        interactorTime.esperaMilis(5000);
        try {
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
            opcionesServicios.click();
        }catch (Exception e){
            throw new RuntimeException("No se cargó ningún servicio");
        }
    }

    public void RegresoCotizaEnvio(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        interactorTime.esperaMilis(5000);
        getDriver().findElement(regresar).click();
        interactorTime.esperaMilis(2000);
        getDriver().findElement(regresarConfi).click();
        interactorTime.esperaMilis(2000);
    }

    public void actualizarCuenta(){
        interactorTime.esperaMilis(10000);
        HttpURLConnection http = null;
        String src = "";
        src = getDriver().findElement(actualizarcuenta).getAttribute("href");
        try{
            http = (HttpURLConnection) (new URL(src).openConnection());
            http.setRequestMethod("HEAD");
            http.connect();
            respuesta = http.getResponseCode();
        }catch (Exception e){
            throw new RuntimeException("No se encuentra link para actualizar la cuenta");
        }
    }

    public void cargueexitosoactulizarcuenta(){
        if (respuesta < 400){
            System.out.println("El link esta en buenas condiciones" + respuesta);
        }else{
            try {
                getDriver().findElement(regresar).click();
            }catch (Exception e){
                throw new RuntimeException("El link se encuentra roto");
            }
        }
    }

    public void pagoencasaactulizocuenta(){
        try{
            getDriver().findElement(agregarpreenvio).isDisplayed();
            System.out.println("Se encontraron preenvios para asociar");
            getDriver().findElement(agregarpreenvio).click();
            interactorTime.esperaMilis(5000);
        }catch (NoSuchElementException exception){
        }
        interactorTime.esperaMilis(10000);
        getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(10000);
        Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
        drpcotizaciondonde.selectByVisibleText(DataRandom.Donde());
        interactorTime.esperaMilis(5000);
        Select drpcotizacionTpaquete = new Select (getDriver().findElement(cotizacionTpaquete));
        drpcotizacionTpaquete.selectByVisibleText(DataRandom.paquete());
        interactorTime.esperaMilis(5000);
        getDriver().findElement(cotizacionContiene).sendKeys("EnvioPagoEnCasa");
        interactorTime.esperaMilis(5000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        interactorTime.esperaMilis(10000);
        try {
            getDriver().findElement(pagoencasa).click();
        }catch (Exception e){
            throw new RuntimeException("Opcion pago en casa no esta habilitada");
        }
        interactorTime.esperaMilis(2000);
        getDriver().findElement(CotizarPreenvio).click();
        interactorTime.esperaMilis(10000);
    }

    public void CotizatuenvioCsv(){
        interactorTime.esperaMilis(5000);
        try{
            getDriver().findElement(agregarpreenvio).isDisplayed();
            System.out.println("Se encontraron preenvios para asociar");
            getDriver().findElement(agregarpreenvio).click();
            interactorTime.esperaMilis(5000);
        }catch (NoSuchElementException exception){
        }
        interactorTime.esperaMilis(10000);
        getDriver().findElement(cotizacionCiudad).sendKeys(DataCvs.ciudaddes2());
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(10000);
        Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
        drpcotizaciondonde.selectByVisibleText(DataCvs.destino2());
        interactorTime.esperaMilis(5000);
        Select drpcotizacionTpaquete = new Select (getDriver().findElement(cotizacionTpaquete));
        drpcotizacionTpaquete.selectByVisibleText(DataCvs.tipopq2());
        interactorTime.esperaMilis(5000);
        getDriver().findElement(cotizacionContiene).sendKeys(DataCvs.contenido2());
        interactorTime.esperaMilis(5000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        interactorTime.esperaMilis(10000);
        getDriver().findElement(nopagoencasa).click();
        interactorTime.esperaMilis(1000);
        getDriver().findElement(CotizarPreenvio).click();
        interactorTime.esperaMilis(5000);
        try {
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
            opcionesServicios.click();
        }catch (Exception e){
            throw new RuntimeException("No se cargó ningún servicio");
        }
    }

    public void CotizatuenvioAfectacion(String Envio){
        if (Envio.equals("Contado")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(5000);
            Select drpcotizacionTpaquete = new Select (getDriver().findElement(cotizacionTpaquete));
            drpcotizacionTpaquete.selectByVisibleText(DataRandom.paquete());
            interactorTime.esperaMilis(5000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioDeContado");
            interactorTime.esperaMilis(5000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(10000);
            getDriver().findElement(nopagoencasa).click();
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(5000);
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Notificaciones Judiciales']"));
            opcionesServicios.click();
            tiposervicio = "Notificaciones";
            interactorTime.esperaMilis(1000);
            getDriver().findElement(btnjudiciales).click();
            /*serviciosRandom.contarservicios();
            if(ServiciosRandom.servicio().equals("Notificaciones Judiciales")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(btnjudiciales).click();
            }
            if(ServiciosRandom.servicio().equals("Radicado")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(codigoradicado).sendKeys("123");
                getDriver().findElement(btnradicado).click();
            }*/
        }
        if (Envio.equals("PagoEnCasa")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(5000);
            Select drpcotizacionTpaquete = new Select (getDriver().findElement(cotizacionTpaquete));
            drpcotizacionTpaquete.selectByVisibleText(DataRandom.paquete());
            interactorTime.esperaMilis(5000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioPagoEnCasa");
            interactorTime.esperaMilis(5000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(10000);
            try {
                getDriver().findElement(pagoencasa).click();
            }catch (Exception e){
                throw new RuntimeException("Opcion pago en casa no esta habilitada");
            }
            interactorTime.esperaMilis(2000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(20000);
            try {
                getDriver().findElement(confirmarCuenta).click();
            }catch (Exception e){
                throw new RuntimeException("No se ha cargado la cuenta");
            }
            interactorTime.esperaMilis(5000);
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería']"));
            opcionesServicios.click();
            tiposervicio = "Mensajería";
            /*serviciosRandom.contarservicios();
            if(ServiciosRandom.servicio().equals("Notificaciones")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(btnjudiciales).click();
            }
            if(ServiciosRandom.servicio().equals("Rapi Radicado")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(codigoradicado).sendKeys("123");
                getDriver().findElement(btnradicado).click();
            }*/
        }
        if (Envio.equals("AlCobro")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(5000);
            Select drpcotizacionTpaquete = new Select (getDriver().findElement(cotizacionTpaquete));
            drpcotizacionTpaquete.selectByVisibleText(DataRandom.paquete());
            interactorTime.esperaMilis(5000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioAlCobro");
            interactorTime.esperaMilis(5000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(10000);
            try {
                getDriver().findElement(alcontado).click();
            }catch (Exception e){
                throw new RuntimeException("Opcion  al cobro no esta habilitada");
            }
            interactorTime.esperaMilis(2000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(20000);
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
            opcionesServicios.click();
            tiposervicio = "Mensajería";
            /*serviciosRandom.contarservicios();
            if(ServiciosRandom.servicio().equals("Notificaciones Judiciales")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(btnjudiciales).click();
            }
            if(ServiciosRandom.servicio().equals("Radicado")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(codigoradicado).sendKeys("123");
                getDriver().findElement(btnradicado).click();
            }*/
        }
        if (Envio.equals("Convenio")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys("BOGOTA\\CUND\\COL");
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(20000);
            getDriver().findElement(clientecorporativo).click();
            interactorTime.esperaMilis(5000);
            if (DatosPersonalesPage.ambiente().equals("QA")){
                getDriver().findElement(convenio).sendKeys("2681");
                interactorTime.esperaMilis(5000);
            }else {
                getDriver().findElement(convenio).sendKeys("2678");
                interactorTime.esperaMilis(5000);
            }
            Select drpcotizacionTpaquete = new Select (getDriver().findElement(cotizacionTpaquete));
            drpcotizacionTpaquete.selectByVisibleText(DataRandom.paquete());
            interactorTime.esperaMilis(5000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioConvenio");
            interactorTime.esperaMilis(5000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(10000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(10000);
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
            opcionesServicios.click();
            tiposervicio = "Mensajería";
            /*serviciosRandom.contarservicios();
            if(ServiciosRandom.servicio().equals("Notificaciones Judiciales")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(btnjudiciales).click();
            }
            if(ServiciosRandom.servicio().equals("Radicado")){
                interactorTime.esperaMilis(1000);
                getDriver().findElement(codigoradicado).sendKeys("123");
                getDriver().findElement(btnradicado).click();
            }*/
        }
    }
    public void CotizatuenvioAPP(String Envio,String Cedula){
        if (Envio.equals("Contado")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.CiudadAPP());
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(4000);
            if (Cedula.equals("1024567308")){
                getDriver().findElement(peso).sendKeys("15");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(peso).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }else{
                getDriver().findElement(peso).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            if (Cedula.equals("1024567308")){
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }else{
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioDeContado");
            interactorTime.esperaMilis(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(nopagoencasa).click();
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(5000);
            try {
                if (Cedula.equals("1024567308")){
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Carga Terrestre']"));
                    opcionesServicios.click();
                }else if (Cedula.equals("900456789")){
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Rapidísimo AM']"));
                    opcionesServicios.click();
                }else{
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
                    opcionesServicios.click();
                }
            }catch (Exception e){
                throw new RuntimeException("No se cargó ningún servicio");
            }
        }
        if (Envio.equals("PagoEnCasa")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.CiudadAPP());
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(4000);
            if (Cedula.equals("1024567208")){
                getDriver().findElement(peso).sendKeys("15");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(peso).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }else{
                getDriver().findElement(peso).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            if (Cedula.equals("1024567208")){
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }else{
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioPagoEnCasa");
            interactorTime.esperaMilis(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            try {
                getDriver().findElement(pagoencasa).click();
            }catch (Exception e){
                throw new RuntimeException("Opcion pago en casa no esta habilitada");
            }
            interactorTime.esperaMilis(2000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(20000);
            try {
                getDriver().findElement(confirmarCuenta).click();
            }catch (Exception e){
                throw new RuntimeException("No se ha cargado la cuenta");
            }
            interactorTime.esperaMilis(7000);
            try {
                if (Cedula.equals("1024567208")){
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Rapi Carga']"));
                    opcionesServicios.click();
                } else if (Cedula.equals("1024567308")) {
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Rapidísimo AM']"));
                    opcionesServicios.click();
                }else {
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería']"));
                    opcionesServicios.click();
                }
            }catch (Exception e){
                throw new RuntimeException("No se cargó ningún servicio");
            }
        }
        if (Envio.equals("AlCobro")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.CiudadAPP());
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(4000);
            if (Cedula.equals("900456789")){
                getDriver().findElement(peso).sendKeys("15");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(peso).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }else{
                getDriver().findElement(peso).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            if (Cedula.equals("900456789")){
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }else{
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
            }
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioAlCobro");
            interactorTime.esperaMilis(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            try {
                getDriver().findElement(alcontado).click();
            }catch (Exception e){
                throw new RuntimeException("Opcion  al cobro no esta habilitada");
            }
            interactorTime.esperaMilis(2000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(20000);
            try {
                if (Cedula.equals("900456789")){
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Carga Terrestre']"));
                    opcionesServicios.click();
                } else {
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Radicado']"));
                    opcionesServicios.click();
                    interactorTime.esperaMilis(2000);
                    getDriver().findElement(codigoradicado).sendKeys("123");
                    getDriver().findElement(btnradicado).click();
                }
            }catch (Exception e){
                throw new RuntimeException("No se cargó ningún servicio");
            }
        }
        if (Envio.equals("Convenio")){
            try{
                getDriver().findElement(agregarpreenvio).isDisplayed();
                System.out.println("Se encontraron preenvios para asociar");
                getDriver().findElement(agregarpreenvio).click();
                interactorTime.esperaMilis(5000);
            }catch (NoSuchElementException exception){
            }
            interactorTime.esperaMilis(10000);
            getDriver().findElement(cotizacionCiudad).sendKeys("BOGOTA\\CUND\\COL");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(4000);
            getDriver().findElement(clientecorporativo).click();
            interactorTime.esperaMilis(5000);
            if (DatosPersonalesPage.ambiente().equals("QA")){
                getDriver().findElement(convenio).sendKeys("2681");
                interactorTime.esperaMilis(5000);
            }else {
                getDriver().findElement(convenio).sendKeys("2678");
                interactorTime.esperaMilis(5000);
            }
            getDriver().findElement(peso).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioConvenio");
            interactorTime.esperaMilis(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(10000);
            try{
                WebElement opcionesServicios = getDriver().findElement(By.
                        xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
                opcionesServicios.click();
            }catch (Exception e){
                throw new RuntimeException("Código de convenio no existe o está errado");
            }
        }
    }

    public static String servicio(){
        return tiposervicio;
    }

}
