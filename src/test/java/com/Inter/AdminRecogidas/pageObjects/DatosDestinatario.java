package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.DataCvs;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class DatosDestinatario extends PageObject{

    InteractorTime interactorTime = new InteractorTime();
    public By CotizarPreenvio = By.id("CotizarPreenvio");
    public By destinatarionombreCompleto = By.id("txtDestinatarioNombres");
    public By destinatarioapellidoCompleto = By.id("txtDestinatarioApellidos");
    public By destinatarioNumeroIdentificacion = By.id("txtDestinatarioNumeroIdentificacion");
    public By destinatarioTelefono = By.id("txtDestinatarioTelefono");
    public By destinatarioDireccion = By.id("txtDestinatarioDireccion");
    public By destinatarioCorreo = By.xpath("//input[@type='email']");
    public By destinatarioGuardar = By.id("GuardarPreenvio");
    public By regresar = By.xpath("//div[@class='col-xs-12 form-container']/form/div[11]/a");
    public By msggeoref = By.xpath("//div[@id='idMsgGeo']");
    static String cedulaDes = "";
    static String celularDes = "";
    static String direcccionDes = "";
    static String tipoenvio = "";
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);

    public void datoaDestinatario(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
            interactorTime.esperaMilis(500);
        }catch (Exception e){
            throw new RuntimeException("No cargo formulario de destinatario");
        }
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys("41778012");
        interactorTime.esperaMilis(500);
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(500);
        String comprobacion = getDriver().findElement(destinatarioTelefono).getAttribute("value");
        interactorTime.esperaMilis(1000);
        if (comprobacion.equals("")) {
            getDriver().findElement(destinatarioTelefono).sendKeys("3133160278");
            getDriver().findElement(destinatarioTelefono).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarionombreCompleto).sendKeys("CARLOS");
            getDriver().findElement(destinatarionombreCompleto).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarioapellidoCompleto).sendKeys("GUTIERREZ");
            getDriver().findElement(destinatarioapellidoCompleto).sendKeys(Keys.TAB);
        }else{
            getDriver().findElement(destinatarioCorreo).clear();
            getDriver().findElement(destinatarioDireccion).clear();
            interactorTime.esperaMilis(1000);
        }
        getDriver().findElement(destinatarioDireccion).sendKeys("calle");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioDireccion).sendKeys(Keys.ARROW_DOWN);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioCorreo).sendKeys("Correo@gmail.com");
        getDriver().findElement(destinatarioGuardar).click();
    }
    public void datoaDestinatariocongeo(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
            interactorTime.esperaMilis(500);
        }catch (Exception e){
            throw new RuntimeException("No cargo formulario de destinatario");
        }
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys("41778012");
        interactorTime.esperaMilis(500);
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(500);
        String comprobacion = getDriver().findElement(destinatarioTelefono).getAttribute("value");
        interactorTime.esperaMilis(1000);
        if (comprobacion.equals("")) {
            getDriver().findElement(destinatarioTelefono).sendKeys("3133160278");
            getDriver().findElement(destinatarioTelefono).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarionombreCompleto).sendKeys("CARLOS");
            getDriver().findElement(destinatarionombreCompleto).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarioapellidoCompleto).sendKeys("GUTIERREZ");
            getDriver().findElement(destinatarioapellidoCompleto).sendKeys(Keys.TAB);
        }else{
            getDriver().findElement(destinatarioCorreo).clear();
            getDriver().findElement(destinatarioDireccion).clear();
            interactorTime.esperaMilis(1000);
        }
        getDriver().findElement(destinatarioDireccion).sendKeys("calle");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioDireccion).sendKeys(Keys.ARROW_DOWN);
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(1000);
        String variable = null;
        JtwigTemplate template = JtwigTemplate.classpathTemplate("APIS/ObtenerGeoMultiZona.json");
        JtwigModel model = JtwigModel.newModel()
                .with("direccion", getDriver().findElement(destinatarioDireccion).getAttribute("value"))
                .with("ciudad", "BOGOTA");
        try {
            JsonNode body = Unirest.post("https://zde7atgwt9.execute-api.us-east-1.amazonaws.com/RecogidasQA/api/Integraciones/ObtenerGeoMultiZona")
                    .header("Content-Type", "application/json; charset=utf-8")
                    .body(template.render(model))
                    .asJson()
                    .getBody();
            JSONArray body_array = body.getArray();
            for (int i = 0; i < body_array.length(); i++){
                variable = body_array.getJSONObject(i).getString("mensaje");
            }
        } catch (UnirestException e) {
            throw new RuntimeException("No carga la georreferenciación");
        }
        if ((variable.equals("Geocodificacion Exitosa.")) && (getDriver().findElement(msggeoref).getAttribute("class").equals("alert-message with-close-button hide"))){
            getDriver().findElement(destinatarioCorreo).sendKeys("Correo@gmail.com");
            getDriver().findElement(destinatarioGuardar).click();
        } else{
            try{
                fail("El sistema esta cargando el mensaje de advertencia");
            }catch (final RuntimeException e){
                assertTrue(true);
            }
        }
    }
    public void datoDestinatariosingeo(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
            interactorTime.esperaMilis(500);
        }catch (Exception e){
            throw new RuntimeException("No cargo formulario de destinatario");
        }
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys("218217");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.TAB);
        String comprobacion = getDriver().findElement(destinatarioTelefono).getAttribute("value");
        interactorTime.esperaMilis(1000);
        if (comprobacion.equals("")) {
            getDriver().findElement(destinatarioTelefono).sendKeys("3133160278");
            getDriver().findElement(destinatarioTelefono).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarionombreCompleto).sendKeys("CARLOS");
            getDriver().findElement(destinatarionombreCompleto).sendKeys(Keys.TAB);
            getDriver().findElement(destinatarioapellidoCompleto).sendKeys("GUTIERREZ");
            getDriver().findElement(destinatarioapellidoCompleto).sendKeys(Keys.TAB);
        }else{
            getDriver().findElement(destinatarioCorreo).clear();
            getDriver().findElement(destinatarioDireccion).clear();
            interactorTime.esperaMilis(1000);
        }
        getDriver().findElement(destinatarioDireccion).sendKeys("calle");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
        try {
            tiempo.until(ExpectedConditions.attributeToBe(msggeoref,"class","alert-message with-close-button"));
            getDriver().findElement(destinatarioCorreo).sendKeys("Correo@gmail.com");
            getDriver().findElement(destinatarioGuardar).click();
        }catch (Exception e){
            throw new RuntimeException("El sistema no carga la advertencia de georeferenciacion");
        }
    }

    public void cargueDataDestinatario(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
            interactorTime.esperaMilis(500);
        }catch (Exception e){
            throw new RuntimeException("No cargo formulario de destinatario");
        }
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys("41778013");
        interactorTime.esperaMilis(1000);
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.ARROW_DOWN);
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.TAB);
        interactorTime.esperaMilis(1000);
        cedulaDes = getDriver().findElement(destinatarioNumeroIdentificacion).getAttribute("value");
        celularDes = getDriver().findElement(destinatarioTelefono).getAttribute("value");
        direcccionDes = getDriver().findElement(destinatarioDireccion).getAttribute("value");
    }

    public void cargueexitosodestinatario(){
        if ((cedulaDes.equals("41778013")) & (celularDes.equals("3133160298")) & (direcccionDes.equals("Calle falsa 49n 23"))){
        }else{
            try {
                getDriver().findElement(CotizarPreenvio).click();
            }catch (Exception e){
                throw new RuntimeException("Los datos no son correctos");
            }
        }
    }

    public void regresodestinatario(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
            interactorTime.esperaMilis(500);
        }catch (Exception e){
            throw new RuntimeException("No cargo formulario de destinatario");
        }
        try {
            getDriver().findElement(regresar).click();
            interactorTime.esperaMilis(2000);
        }catch (Exception e){
            throw new RuntimeException("No funciona boton regresar");
        }
    }

    public void datoaDestinatarioCsv(){
        try {
            tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
            interactorTime.esperaMilis(500);
        }catch (Exception e){
            throw new RuntimeException("No cargo formulario de destinatario");
        }
        getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(DataCvs.cedulades2());
        getDriver().findElement(destinatarioTelefono).sendKeys(DataCvs.celulardes2());
        getDriver().findElement(destinatarionombreCompleto).sendKeys(DataCvs.nombredes2());
        getDriver().findElement(destinatarioapellidoCompleto).sendKeys("GUTIERREZ");
        getDriver().findElement(destinatarioDireccion).sendKeys(DataCvs.direcciondes2());
        getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
        tiempo.until(ExpectedConditions.attributeToBe(msggeoref,"class","alert-message with-close-button"));
        getDriver().findElement(destinatarioCorreo).sendKeys(DataCvs.correodes2());
        getDriver().findElement(destinatarioGuardar).click();
    }

    public void datosDestinatarioafectacion(String Envio) {
        if (Envio.equals("Contado")){
            cedulaDes = "41778013";
            celularDes = "3003160298";
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
                interactorTime.esperaMilis(500);
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de destinatario");
            }
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(cedulaDes);
            interactorTime.esperaMilis(500);
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(500);
            String comprobacion = getDriver().findElement(destinatarioTelefono).getAttribute("value");
            interactorTime.esperaMilis(1000);
            if (comprobacion.equals("")) {
                getDriver().findElement(destinatarioTelefono).sendKeys(celularDes);
                getDriver().findElement(destinatarionombreCompleto).sendKeys("LUZ");
                getDriver().findElement(destinatarioapellidoCompleto).sendKeys("GARCIA");
                getDriver().findElement(destinatarioDireccion).sendKeys("calle");
                getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(destinatarioCorreo).sendKeys("luz.romero@gmail.com");
                getDriver().findElement(destinatarioGuardar).click();
            }else{
                getDriver().findElement(destinatarioGuardar).click();
            }
            tipoenvio = "Contado";
        }
        if (Envio.equals("AlCrobro")){
            cedulaDes = "218217";
            celularDes = "3004710585";
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
                interactorTime.esperaMilis(500);
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de destinatario");
            }
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(cedulaDes);
            interactorTime.esperaMilis(500);
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(500);
            String comprobacion = getDriver().findElement(destinatarioTelefono).getAttribute("value");
            interactorTime.esperaMilis(1000);
            if (comprobacion.equals("")) {
                getDriver().findElement(destinatarioTelefono).sendKeys(celularDes);
                getDriver().findElement(destinatarionombreCompleto).sendKeys("VICTOR");
                getDriver().findElement(destinatarioapellidoCompleto).sendKeys("GUTIERREZ");
                getDriver().findElement(destinatarioDireccion).sendKeys("calle");
                getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(destinatarioCorreo).sendKeys("victor.gutierrez@gmail.com");
                getDriver().findElement(destinatarioGuardar).click();
            }else{
                getDriver().findElement(destinatarioGuardar).click();
            }
            tipoenvio = "Al Cobro";
        }
        if (Envio.equals("PagoEnCasa")){
            cedulaDes = "1023017050";
            celularDes = "3004195427";
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
                interactorTime.esperaMilis(500);
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de destinatario");
            }
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(cedulaDes);
            interactorTime.esperaMilis(500);
            getDriver().findElement(destinatarioNumeroIdentificacion).sendKeys(Keys.TAB);
            interactorTime.esperaMilis(500);
            String comprobacion = getDriver().findElement(destinatarioTelefono).getAttribute("value");
            interactorTime.esperaMilis(1000);
            if (comprobacion.equals("")) {
                getDriver().findElement(destinatarioTelefono).sendKeys(celularDes);
                getDriver().findElement(destinatarionombreCompleto).sendKeys("DUVAN");
                getDriver().findElement(destinatarioapellidoCompleto).sendKeys("RODRIGUEZ");
                getDriver().findElement(destinatarioDireccion).sendKeys("calle");
                getDriver().findElement(destinatarioDireccion).sendKeys(Keys.TAB);
                interactorTime.esperaMilis(1000);
                getDriver().findElement(destinatarioCorreo).sendKeys("duvan.rodriguez@gmail.com");
                getDriver().findElement(destinatarioGuardar).click();
            }else{
                getDriver().findElement(destinatarioGuardar).click();
            }
            tipoenvio = "PagoEnCasa";
        }
        if (Envio.equals("Convenio")){
            try {
                tiempo.until(ExpectedConditions.elementToBeClickable(destinatarioNumeroIdentificacion));
                interactorTime.esperaMilis(500);
            }catch (Exception e){
                throw new RuntimeException("No cargo formulario de destinatario");
            }
            cedulaDes = getDriver().findElement(destinatarioNumeroIdentificacion).getAttribute("value");
            celularDes = getDriver().findElement(destinatarioTelefono).getAttribute("value");
            getDriver().findElement(destinatarioGuardar).click();
            tipoenvio = "Crédito";
        }
    }
}
