package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
import com.Inter.AdminRecogidas.utils.DataRandom;
import org.openqa.selenium.*;
import net.serenitybdd.core.pages.PageObject;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CotizaciondeenviosPage extends PageObject{

    InteractorTime interactorTime = new InteractorTime();
    ListadoTusRecogidas listadoTusRecogidas = new ListadoTusRecogidas();
    DataRandom dataRandom = new DataRandom();
    int respuesta = 0;
    public By cotizacionCiudad = By.id("CiudadDestino");
    public By cotizaciondonde = By.xpath("//div[@id='DatosCotizacion']/div[1]/div[1]/form/div[6]/select");
    public By cotizacionTpaquete = By.xpath("//div[@id='DatosCotizacion']/div[1]/div[1]/form/div[7]/select");
    public By cotizacionContiene = By.xpath("//input[@placeholder='Ej: Reproductor de música']");
    public By pagoencasa = By.xpath("//div[@class='card col-xs-12 col-md-6 ']/div/span[2]/div/label/span");
    public By nopagoencasa = By.xpath("//div[@id='DatosCotizacion']/div/div/form/div[13]/div/div[2]/div/span[2]/div/label/span");
    public By pagoencasadeshabilitado = By.xpath("//div[@id='DatosCotizacion']/div/div/form/div[13]");
    public By alcontado = By.xpath("//div[@class='card col-xs-12 col-md-6  ']/div/span[2]/div/label/span");
    public By CotizarPreenvio = By.id("CotizarPreenvio");
    public By clientecorporativo = By.xpath("//div[@class='form-group col-md-3 col-xs-12 customer-agreement no-padding-right']/div[1]/label");
    public By confirmarCuenta = By.xpath("//div[@class='col-xs-12']/form/div[3]/button");
    public By convenio = By.xpath("//input[@placeholder='Código del convenio']");
    public By errorconvenio = By.xpath("//div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/form/div[3]");
    public By agregarpreenvio = By.xpath("//div[@id='AsociarPreenvios']/div/form/div[3]/a");
    public By listapreenviosnoasociados = By.xpath("//div[@id='AsociarPreenvios']");
    public By regresar = By.xpath("//div[@id='DatosCotizacion']/div/div/form/div[15]/a");
    public By regresarConfi = By.id("ConfirmaAceptada");
    public By actualizarcuenta = By.xpath("//a[@class='btn btn-link AbrirPortalAutogestion']");
    public By peso = By.xpath("//div[@class='form-group col-md-2 col-xs-12 weight-input no-padding-left']/input");
    public By pesoerrortxt = By.xpath("//div[@class='form-group col-md-2 col-xs-12 weight-input no-padding-left error-input']/input");
    public By btnjudiciales = By.xpath("//div[@class='judicial-notifications modal-container container']/div[1]/div[1]/div[1]/form/div[4]/button");
    public By codigoradicado = By.xpath("//input[@placeholder='Ej: 1234']");
    public By btnradicado = By.xpath("//div[@class='rapi-radicado modal-container container']/div[1]/div[1]/div[1]/form/div[6]/button");
    public By cargando = By.id("cargando");
    public By errorpeso = By.xpath("//div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/form/div[5]");
    public By errorvalor = By.xpath("//div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/form/div[10]");
    public By errorpaquete = By.xpath("//div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/form/div[7]");
    static String tiposervicio = "";
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);

    public void Cotizatuenvio(String dato){
        try{
            tiempo.until(
                    ExpectedConditions.or(
                            ExpectedConditions.attributeToBe(listapreenviosnoasociados,"class","disassociated-preshippings-container"),
                            ExpectedConditions.and(
                                    ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                    ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                            )
                    )
            );
        }catch (Exception e){
            throw new RuntimeException("No cargo pagina de cotizar preenvio");
        }
        if (getDriver().findElement(listapreenviosnoasociados).getAttribute("class").equals("disassociated-preshippings-container")){
            getDriver().findElement(agregarpreenvio).click();
            try{
                tiempo.until(
                        ExpectedConditions.and(
                                ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                        )
                );
            }catch (Exception e){
                throw new RuntimeException("No cargo pagina de cotizar preenvio");
            }
        }
        if (dato.equals("carguedatos")){
            getDriver().findElement(cotizacionCiudad).sendKeys("BOGOTA\\CUND\\COL");
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
        }else{
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
        }
        Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
        drpcotizaciondonde.selectByVisibleText(DataRandom.Donde());
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
        interactorTime.esperaMilis(1000);
        dataRandom.paquete();
        getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cotizacionContiene).sendKeys("Automatización");
        interactorTime.esperaMilis(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(CotizarPreenvio).click();
        interactorTime.esperaMilis(1000);
        while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
            || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
            getDriver().findElement(pesoerrortxt).clear();
            interactorTime.esperaMilis(1000);
            getDriver().findElement(pesoerrortxt).sendKeys("1");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
        }
        while (getDriver().findElement(errorpaquete).getAttribute("class").equals("form-group col-md-3 col-xs-12 no-padding-right error-input")){
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            dataRandom.paquete();
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
        }
        try {
            tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
        }catch (Exception e){
            throw new RuntimeException("No cargo lista de servicios");
        }
        try {
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
            opcionesServicios.click();
        }catch (Exception e){
            throw new RuntimeException("No cargo el servicio de Mensajeria Expresa");
        }
    }

    public void RegresoCotizaEnvio(){
        try{
            tiempo.until(
                    ExpectedConditions.or(
                            ExpectedConditions.attributeToBe(listapreenviosnoasociados,"class","disassociated-preshippings-container"),
                            ExpectedConditions.and(
                                    ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                    ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                            )
                    )
            );
        }catch (Exception e){
            throw new RuntimeException("No cargo pagina de cotizar preenvio");
        }
        if (getDriver().findElement(listapreenviosnoasociados).getAttribute("class").equals("disassociated-preshippings-container")){
            getDriver().findElement(agregarpreenvio).click();
            try{
                tiempo.until(
                        ExpectedConditions.and(
                                ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                        )
                );
            }catch (Exception e){
                throw new RuntimeException("No cargo pagina de cotizar preenvio");
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        getDriver().findElement(regresar).click();
        interactorTime.esperaMilis(2000);
        getDriver().findElement(regresarConfi).click();
        interactorTime.esperaMilis(2000);
    }

    public void actualizarCuenta(){
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
            tiempo.until(
                    ExpectedConditions.or(
                            ExpectedConditions.attributeToBe(listapreenviosnoasociados,"class","disassociated-preshippings-container"),
                            ExpectedConditions.and(
                                    ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                    ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                            )
                    )
            );
        }catch (Exception e){
            throw new RuntimeException("No cargo pagina de cotizar preenvio");
        }
        if (getDriver().findElement(listapreenviosnoasociados).getAttribute("class").equals("disassociated-preshippings-container")){
            getDriver().findElement(agregarpreenvio).click();
            try{
                tiempo.until(
                        ExpectedConditions.and(
                                ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                        )
                );
            }catch (Exception e){
                throw new RuntimeException("No cargo pagina de cotizar preenvio");
            }
        }
        getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(1000);
        if (getDriver().findElement(nopagoencasa).getAttribute("class").equals("selected")){
            RegresoCotizaEnvio();
            listadoTusRecogidas.AgregarPreenvio();
            pagoencasaactulizocuenta();
        }else{
            Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
            drpcotizaciondonde.selectByVisibleText(DataRandom.Donde());
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            dataRandom.paquete();
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
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
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            while (getDriver().findElement(errorpaquete).getAttribute("class").equals("form-group col-md-3 col-xs-12 no-padding-right error-input")){
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                dataRandom.paquete();
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ConfirmarValorComercialPagoEnCasa"),"class","confirm-commercial-value-container"));
                interactorTime.esperaMilis(1000);
            }catch (Exception e){
                throw new RuntimeException("No cargo pop up informacion de cuenta bancaria");
            }
        }
    }

    public void CotizatuenvioCsv(){
        try{
            tiempo.until(
                    ExpectedConditions.or(
                            ExpectedConditions.attributeToBe(listapreenviosnoasociados,"class","disassociated-preshippings-container"),
                            ExpectedConditions.and(
                                    ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                    ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                            )
                    )
            );
        }catch (Exception e){
            throw new RuntimeException("No cargo pagina de cotizar preenvio");
        }
        if (getDriver().findElement(listapreenviosnoasociados).getAttribute("class").equals("disassociated-preshippings-container")){
            getDriver().findElement(agregarpreenvio).click();
            try{
                tiempo.until(
                        ExpectedConditions.and(
                                ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                        )
                );
            }catch (Exception e){
                throw new RuntimeException("No cargo pagina de cotizar preenvio");
            }
        }
        getDriver().findElement(cotizacionCiudad).sendKeys(DataCvs.ciudaddes2());
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(1000);
        Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
        drpcotizaciondonde.selectByVisibleText(DataCvs.destino2());
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
        interactorTime.esperaMilis(1000);
        switch (DataCvs.tipopq2()){
            case "PAQUETE PEQUEÑO":{
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
            case "SOBRE CARTA":{
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
            case "SOBRE MANILA":{
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
            case "TULA":{
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                break;
            }
        }
        getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(cotizacionContiene).sendKeys(DataCvs.contenido2());
        interactorTime.esperaMilis(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(CotizarPreenvio).click();
        interactorTime.esperaMilis(1000);
        while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
            getDriver().findElement(pesoerrortxt).clear();
            interactorTime.esperaMilis(1000);
            getDriver().findElement(pesoerrortxt).sendKeys("1");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
        }
        try {
            tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
        }catch (Exception e){
            throw new RuntimeException("No cargo lista de servicios");
        }
        try {
            WebElement opcionesServicios = getDriver().findElement(By.
                    xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
            opcionesServicios.click();
        }catch (Exception e){
            throw new RuntimeException("No cargo el servicio de Mensajeria Expresa");
        }
    }

    public void CotizatuenvioAfectacion(String Envio){
        try{
            tiempo.until(
                    ExpectedConditions.or(
                            ExpectedConditions.attributeToBe(listapreenviosnoasociados,"class","disassociated-preshippings-container"),
                            ExpectedConditions.and(
                                    ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                    ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                            )
                    )
            );
        }catch (Exception e){
            throw new RuntimeException("No cargo pagina de cotizar preenvio");
        }
        if (getDriver().findElement(listapreenviosnoasociados).getAttribute("class").equals("disassociated-preshippings-container")){
            getDriver().findElement(agregarpreenvio).click();
            try{
                tiempo.until(
                        ExpectedConditions.and(
                                ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                        )
                );
            }catch (Exception e){
                throw new RuntimeException("No cargo pagina de cotizar preenvio");
            }
        }
        if (Envio.equals("Contado")){
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
            drpcotizaciondonde.selectByVisibleText(DataRandom.Donde());
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            dataRandom.paquete();
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioDeContado");
            interactorTime.esperaMilis(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            while (getDriver().findElement(errorpaquete).getAttribute("class").equals("form-group col-md-3 col-xs-12 no-padding-right error-input")){
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                dataRandom.paquete();
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
            }catch (Exception e){
                throw new RuntimeException("No cargo lista de servicios");
            }
            try {
                WebElement opcionesServicios = getDriver().findElement(By.
                        xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Notificaciones Judiciales']"));
                opcionesServicios.click();
                tiposervicio = "Notificaciones";
                interactorTime.esperaMilis(1000);
                getDriver().findElement(btnjudiciales).click();
            }catch (Exception e){
                throw new RuntimeException("No cargo el servicio de Notificaciones Jusiciales");
            }
        }
        if (Envio.equals("PagoEnCasa")){
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            if (getDriver().findElement(pagoencasadeshabilitado).getAttribute("class").equals("form-group col-xs-12 col-md-8 no-padding-left hide")){
                RegresoCotizaEnvio();
                listadoTusRecogidas.AgregarPreenvio();
                CotizatuenvioAfectacion("PagoEnCasa");
            }else{
                Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
                drpcotizaciondonde.selectByVisibleText(DataRandom.Donde());
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                dataRandom.paquete();
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionContiene).sendKeys("EnvioPagoEnCasa");
                interactorTime.esperaMilis(1000);
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pagoencasa).click();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
                while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                        || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                    getDriver().findElement(pesoerrortxt).clear();
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(pesoerrortxt).sendKeys("1");
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                    interactorTime.esperaMilis(1000);
                    js.executeScript("window.scrollBy(0,1000)");
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(CotizarPreenvio).click();
                    interactorTime.esperaMilis(1000);
                }
                while (getDriver().findElement(errorpaquete).getAttribute("class").equals("form-group col-md-3 col-xs-12 no-padding-right error-input")){
                    getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                    interactorTime.esperaMilis(1000);
                    dataRandom.paquete();
                    getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                    interactorTime.esperaMilis(1000);
                    js.executeScript("window.scrollBy(0,1000)");
                    interactorTime.esperaMilis(1000);
                    getDriver().findElement(CotizarPreenvio).click();
                    interactorTime.esperaMilis(1000);
                }
                try {
                    tiempo.until(ExpectedConditions.attributeToBe(By.id("ConfirmarValorComercialPagoEnCasa"),"class","confirm-commercial-value-container"));
                }catch (Exception e){
                    throw new RuntimeException("No cargo pop up informacion de cuenta bancaria");
                }
                getDriver().findElement(confirmarCuenta).click();
                try {
                    tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
                }catch (Exception e){
                    throw new RuntimeException("No cargo lista de servicios");
                }
                try {
                    WebElement opcionesServicios = getDriver().findElement(By.
                            xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería']"));
                    opcionesServicios.click();
                    tiposervicio = "Mensajería";
                }catch (Exception e){
                    throw new RuntimeException("No cargo el servicio de Mensajeria");
                }
            }
        }
        if (Envio.equals("AlCobro")){
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.Ciudad());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            Select drpcotizaciondonde = new Select (getDriver().findElement(cotizaciondonde));
            drpcotizaciondonde.selectByVisibleText(DataRandom.Donde());
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            dataRandom.paquete();
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioAlCobro");
            interactorTime.esperaMilis(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            try {
                getDriver().findElement(alcontado).click();
            }catch (NoSuchElementException exception){
                RegresoCotizaEnvio();
                listadoTusRecogidas.AgregarPreenvio();
                CotizatuenvioAfectacion("AlCobro");
            }
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            while (getDriver().findElement(errorpaquete).getAttribute("class").equals("form-group col-md-3 col-xs-12 no-padding-right error-input")){
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                dataRandom.paquete();
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
            }catch (Exception e){
                throw new RuntimeException("No cargo lista de servicios");
            }
            try {
                WebElement opcionesServicios = getDriver().findElement(By.
                        xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
                opcionesServicios.click();
                tiposervicio = "Mensajería";
            }catch (Exception e){
                throw new RuntimeException("No cargo el servicio de Mensajeria Expresa");
            }
        }
        if (Envio.equals("Convenio")){
            getDriver().findElement(cotizacionCiudad).sendKeys("BOGOTA\\CUND\\COL");
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(clientecorporativo).click();
            tiempo.until(ExpectedConditions.elementToBeClickable(convenio));
            if (DatosPersonalesPage.ambiente().equals("QA")){
                getDriver().findElement(convenio).sendKeys("2681");
                tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
            }else if (DatosPersonalesPage.ambiente().equals("Apitesting")){
                getDriver().findElement(convenio).sendKeys("10553");
                tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
            }
            getDriver().findElement(peso).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            dataRandom.paquete();
            getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(cotizacionContiene).sendKeys("EnvioConvenio");
            interactorTime.esperaMilis(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            while (getDriver().findElement(errorpaquete).getAttribute("class").equals("form-group col-md-3 col-xs-12 no-padding-right error-input")){
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                dataRandom.paquete();
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            if (getDriver().findElement(errorconvenio).getAttribute("class").equals("form-group col-md-3 col-xs-12 customer-agreement no-padding-right error-input")){
                try{
                    fail("El codigo de convenio esta errado");
                }catch (final RuntimeException e){
                    assertTrue(true);
                }
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
            }catch (Exception e){
                throw new RuntimeException("No cargo lista de servicios");
            }
            try {
                WebElement opcionesServicios = getDriver().findElement(By.
                        xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
                opcionesServicios.click();
                tiposervicio = "Mensajería";
            }catch (Exception e){
                throw new RuntimeException("No cargo el servicio de Mensajeria Expresa");
            }
        }
    }
    public void CotizatuenvioAPP(String Envio,String Cedula){
        try{
            tiempo.until(
                    ExpectedConditions.or(
                            ExpectedConditions.attributeToBe(listapreenviosnoasociados,"class","disassociated-preshippings-container"),
                            ExpectedConditions.and(
                                    ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                    ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                            )
                    )
            );
        }catch (Exception e){
            throw new RuntimeException("No cargo pagina de cotizar preenvio");
        }
        if (getDriver().findElement(listapreenviosnoasociados).getAttribute("class").equals("disassociated-preshippings-container")){
            getDriver().findElement(agregarpreenvio).click();
            try{
                tiempo.until(
                        ExpectedConditions.and(
                                ExpectedConditions.attributeToBe(cargando,"hidden","true"),
                                ExpectedConditions.elementToBeClickable(cotizacionCiudad)
                        )
                );
            }catch (Exception e){
                throw new RuntimeException("No cargo pagina de cotizar preenvio");
            }
        }
        if (Envio.equals("Contado")){
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.CiudadAPP());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
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
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
            }catch (Exception e){
                throw new RuntimeException("No cargo lista de servicios");
            }
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
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.CiudadAPP());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
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
            interactorTime.esperaMilis(1000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ConfirmarValorComercialPagoEnCasa"),"class","confirm-commercial-value-container"));
                getDriver().findElement(confirmarCuenta).click();
            }catch (Exception e){
                throw new RuntimeException("No cargo pop up informacion de cuenta bancaria");
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
            }catch (Exception e){
                throw new RuntimeException("No cargo lista de servicios");
            }
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
            getDriver().findElement(cotizacionCiudad).sendKeys(DataRandom.CiudadAPP());
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
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
            }catch (NoSuchElementException exception){
                RegresoCotizaEnvio();
                listadoTusRecogidas.AgregarPreenvio();
                CotizatuenvioAfectacion("AlCobro");
            }
            interactorTime.esperaMilis(2000);
            getDriver().findElement(CotizarPreenvio).click();
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizaciondonde).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
            }catch (Exception e){
                throw new RuntimeException("No cargo lista de servicios");
            }
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
            getDriver().findElement(cotizacionCiudad).sendKeys("BOGOTA\\CUND\\COL");
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            getDriver().findElement(cotizacionCiudad).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(1000);
            getDriver().findElement(clientecorporativo).click();
            tiempo.until(ExpectedConditions.elementToBeClickable(convenio));
            if (DatosPersonalesPage.ambiente().equals("QA")){
                getDriver().findElement(convenio).sendKeys("2681");
                tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
            }else if (DatosPersonalesPage.ambiente().equals("Apitesting")){
                getDriver().findElement(convenio).sendKeys("10553");
                tiempo.until(ExpectedConditions.attributeToBe(cargando,"hidden","true"));
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
            interactorTime.esperaMilis(1000);
            while ((getDriver().findElement(errorpeso).getAttribute("class").equals("form-group col-md-2 col-xs-12 weight-input no-padding-left error-input"))
                    || (getDriver().findElement(errorvalor).getAttribute("class").equals("form-group col-md-3 col-xs-12 value-input no-padding-right error-input"))){
                getDriver().findElement(pesoerrortxt).clear();
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys("1");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(pesoerrortxt).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ARROW_DOWN);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(cotizacionTpaquete).sendKeys(Keys.ENTER);
                interactorTime.esperaMilis(1000);
                js.executeScript("window.scrollBy(0,1000)");
                interactorTime.esperaMilis(1000);
                getDriver().findElement(CotizarPreenvio).click();
                interactorTime.esperaMilis(1000);
            }
            if (getDriver().findElement(errorconvenio).getAttribute("class").equals("form-group col-md-3 col-xs-12 customer-agreement no-padding-right error-input")){
                try{
                    fail("El codigo de convenio esta errado");
                }catch (final RuntimeException e){
                    assertTrue(true);
                }
            }
            try {
                tiempo.until(ExpectedConditions.attributeToBe(By.id("ListaServicios"),"class","service-selection-container"));
            }catch (Exception e){
                throw new RuntimeException("No cargo lista de servicios");
            }
            try {
                WebElement opcionesServicios = getDriver().findElement(By.
                        xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul/li[@class='name']/span[text()='Mensajería Expresa']"));
                opcionesServicios.click();
            }catch (Exception e){
                throw new RuntimeException("No se cargó servicio Mensajeria Expresa");
            }
        }
    }
}
