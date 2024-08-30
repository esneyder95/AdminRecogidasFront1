package com.Inter.AdminRecogidas.definitions;

import com.Inter.AdminRecogidas.pageObjects.PantallaconfirmacionPage;
import com.Inter.AdminRecogidas.pageObjects.PreenvioExitoso;
import com.Inter.AdminRecogidas.steps.AdminformularioSteps;
import com.Inter.AdminRecogidas.steps.EditarRecogidasSteps;
import com.Inter.AdminRecogidas.steps.PreenviosSteps;
import com.Inter.AdminRecogidas.steps.CvsSteps;
import com.Inter.AdminRecogidas.utils.DataCvs;
import com.Inter.AdminRecogidas.utils.GenerarReporte;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.gherkin.Gherkin;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import io.cucumber.plugin.event.Node;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Feature;
import org.openqa.selenium.By;

import javax.annotation.Resource;
import java.io.IOException;

public class AdminformularioDefinitions extends PageObject {
    public By recogida1 = By.xpath("//div[@name='registros']/ul[1]/li[4]");
    AdminformularioSteps adminformularioSteps = new AdminformularioSteps();
    PreenviosSteps preenviosSteps = new PreenviosSteps();
    CvsSteps cvsSteps = new CvsSteps();
    DataCvs dataCvs = new DataCvs();
    EditarRecogidasSteps editarRecogidasSteps = new EditarRecogidasSteps();
    GenerarReporte generarReporte = new GenerarReporte();

    @Given("Ingresa la pagina de recogidas")
    public void ingresa_la_pagina_de_recogidas() {
        adminformularioSteps.ingresalapaginaderecogidas();
    }

    @When("Ingresa los datos de Personales")
    public void ingresa_los_datos_de_Personales() throws CsvValidationException, IOException {
        adminformularioSteps.ingresalosdatosdePersonales();
        adminformularioSteps.secargalapaginarecogidas();
    }

    @And("Ingresa los datos de Recogidas")
    public void ingresa_los_datos_de_Recogida() {
        adminformularioSteps.ingresalosdatosdeRecogida();

    }

    @Then("la solicitud de la recogida es creada exitosamente")
    public void la_solicitud_de_la_recogida_es_creada_exitosamente() {
        adminformularioSteps.solicituddelarecogida();
    }

    //////////////////////-------------------------- Agregar Preenvio ------------------------///////////////////////////
    @Given("Ingreso a la opcion de Agregar Preenvios")
    public void ingresoALaOpcionDeAgregarEnvios() throws CsvValidationException, IOException {
        adminformularioSteps.ingresalapaginaderecogidas();
        adminformularioSteps.ingresalosdatosdePersonales();
        adminformularioSteps.secargalapaginarecogidas();
        adminformularioSteps.ingresalosdatosdeRecogida();
        adminformularioSteps.solicituddelarecogidanuevopreenvio();
    }

    @When("Ingreso la informacion solicitada")
    public void ingresoLaInformacionDeCotizacion() {
        preenviosSteps.informaciondecotizacion("otrodato");
        preenviosSteps.informaciondedestinatario();
    }

    @When("Ingreso la informacion solicitada.")
    public void IngresoLaInformacionDeCotizacioncongeo() {
        editarRecogidasSteps.agregarpreenvio("listado");
        preenviosSteps.informaciondecotizacion("carguedatos");
        preenviosSteps.informaciondedestinatariocongeo();
    }

    @When("Solicito la informacion solicitada.")
    public void IngresoLaInformacionDeCotizacionsingeo() {
        editarRecogidasSteps.agregarpreenvio("listado");
        preenviosSteps.informaciondecotizacion("carguedatos");
        preenviosSteps.informaciondedestinatariosingeo();
    }

    @When("Regreso de cotiza tu envio")
    public void Regresocotizatuenvio() {
        editarRecogidasSteps.agregarpreenvio("listado");
        preenviosSteps.regresopreenvio();
    }

    @When("Regreso de datos destinatario")
    public void regresodestinatario(){
        editarRecogidasSteps.agregarpreenvio("listado");
        preenviosSteps.informaciondecotizacion("");
        preenviosSteps.regresopreenviodestinatario();
        preenviosSteps.regresopreenvio();
    }

    @When("Regreso de nueva recogida")
    public void regresonuevarecogida(){
        editarRecogidasSteps.nuevarecogida();
        editarRecogidasSteps.regresarrecogida();
    }

    @Then("El regreso es exitoso")
    public void regresoexitoso(){
        preenviosSteps.regresoexitoso();
    }

    @Given("Usuario nuevo ingresa a tus recogidas")
    public void ingresorecogidas() throws CsvValidationException, IOException {
        adminformularioSteps.ingresalapaginaderecogidas();
        adminformularioSteps.ingresalosdatosdePersonales();
    }

    @When("Regreso a home")
    public void regresohome(){
        editarRecogidasSteps.regresarrecogida();
    }

    @When("Usuario frecuente regresa a home")
    public void regresohomefrec(){
        editarRecogidasSteps.regresarrecogidahome();
    }

    @Then("El regreso a home es exitoso")
    public void regresoexitosohome(){
        adminformularioSteps.regresohomeexitoso();
    }

    @Then("la solicitud del preenvio es creada exitosamente {} {}")
    public void SolicitudPreenvioExitosa(String Cedula,String Scenario) {
        preenviosSteps.SolicitudPrenvioExitosa();
        if (Cedula.equals("ClienteNue")){
            System.out.println("Cliente Nuevo creo un preenvio exitosamente");
        }else {
            System.out.println("Cliente con Numero de Cedula: " + Cedula + " creo un preenvio exitosamente");
        }
        generarReporte.CasoExitoso(Cedula,Scenario);
    }

    @Given("Documento de todos los clientes")
    public void DocumentoUsuarios() throws CsvValidationException, IOException {
        cvsSteps.determinodata("Recogida");
    }

    @When("Ingreso la informacion requerida")
    public void InformacionRequerida() throws CsvValidationException, IOException {
        cvsSteps.ncantidaddata("Recogida");
    }

    @Then("Se crea un documento con los datos del cliente y solicitud de recogida")
    public void CreacionDocumento() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        cvsSteps.CrearCvs("Recogida");
    }

    @Given("Documento de clientes")
    public void DocumentoUsuariosPreenvio() throws CsvValidationException, IOException {
        cvsSteps.determinodata("Preenvio");
    }

    @When("Ingreso informacion requerida")
    public void InformacionRequeridaPreenvio() throws CsvValidationException, IOException {
        cvsSteps.ncantidaddata("Preenvio");
    }

    @Then("Se crea un documento con los datos del cliente y solicitud de recogida + preenvio")
    public void CreacionDocumentoPreenvio() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        cvsSteps.CrearCvs("Preenvio");
    }

    //////////////////////-------------------------- Usuario Frecuente ------------------------///////////////////////////

    @Given("Ingreso a la pagina de recogidas. {} {} {}")
    public void PaginaRecogida(String Cedula, String Celular,String Scenario) throws CsvValidationException, IOException {
        generarReporte.CasoFallido(Cedula,"",Scenario);
        if (Cedula.equals("ClienteNue")){
            adminformularioSteps.ingresalapaginaderecogidas();
            adminformularioSteps.ingresalosdatosdePersonales();
            adminformularioSteps.secargalapaginarecogidas();
            adminformularioSteps.ingresalosdatosdeRecogida();
            adminformularioSteps.solicituddelarecogida();
        }else {
            adminformularioSteps.ingresalapaginaderecogidas();
            adminformularioSteps.ingresalosdatosdePersonalesF(Cedula, Celular);
            adminformularioSteps.IngresoTusRecogidas();
        }
    }

    @When("Usuario crea una Nueva recogida.")
    public void DatosPersonales() {
        adminformularioSteps.ingresalosdatosdeRecogidaF();
    }

    @Then("La recogida se crea exitosa con su numero de solicitud. {}")
    public void NumerodeRadicado(String Cedula) {
        adminformularioSteps.solicituddelarecogida();
        if (Cedula.equals("ClienteNue")){
            System.out.println("Cliente Nuevo diligencia una nueva recogida");
        }else {
            System.out.println("Cliente con Numero de Cedula: " + Cedula + " diligencia una nueva recogida");
        }
        generarReporte.CasoExitoso(Cedula,"Usuario diligencia formulario de recogida.");
    }

    @Given("Ingreso a la opcion de Agregar Preenvios de una nueva recogida. {} {} {}")
    public void PaginaRecogidaPre(String Cedula, String Celular, String Scenario) throws CsvValidationException, IOException {
        generarReporte.CasoFallido(Cedula,"",Scenario);
        if (Cedula.equals("ClienteNue")){
            adminformularioSteps.ingresalapaginaderecogidas();
            adminformularioSteps.ingresalosdatosdePersonales();
            adminformularioSteps.secargalapaginarecogidas();
            adminformularioSteps.ingresalosdatosdeRecogida();
            adminformularioSteps.solicituddelarecogidanuevopreenvio();
        }else {
            adminformularioSteps.ingresalapaginaderecogidas();
            adminformularioSteps.ingresalosdatosdePersonalesF(Cedula, Celular);
            adminformularioSteps.IngresoTusRecogidas();
            adminformularioSteps.ingresalosdatosdeRecogidaF();
            adminformularioSteps.solicituddelarecogidanuevopreenvio();
        }
    }

    @Given("Ingreso a la opcion de Agregar otro preenvio de una nueva recogida. {} {}")
    public void PaginaRecogidaPreN(String Cedula, String Celular) throws CsvValidationException, IOException {
        if (Cedula.equals("ClienteNue")){
            adminformularioSteps.ingresalapaginaderecogidas();
            adminformularioSteps.ingresalosdatosdePersonales();
            adminformularioSteps.secargalapaginarecogidas();
            adminformularioSteps.ingresalosdatosdeRecogida();
            adminformularioSteps.solicituddelarecogidanuevopreenvio();
            preenviosSteps.informaciondecotizacion("");
            preenviosSteps.informaciondedestinatario();
            preenviosSteps.SolicitudPrenvioExitoso();
        }else {
            adminformularioSteps.ingresalapaginaderecogidas();
            adminformularioSteps.ingresalosdatosdePersonalesF(Cedula, Celular);
            adminformularioSteps.IngresoTusRecogidas();
            adminformularioSteps.ingresalosdatosdeRecogidaF();
            adminformularioSteps.solicituddelarecogidanuevopreenvio();
            preenviosSteps.informaciondecotizacion("");
            preenviosSteps.informaciondedestinatario();
            preenviosSteps.SolicitudPrenvioExitoso();
        }
    }

    ////////////////////////////////////////////////////////Editar Recogidas/////////////////////////////////////////////////////////////////////////////
    @Given("Dado un listado de recogidas {} {}")
    public void ListaRecogidas(String Cedula, String Celular) throws CsvValidationException, IOException {
        adminformularioSteps.ingresalapaginaderecogidas();
        if (Cedula.equals("NuevoAgreg") || Cedula.equals("NuevoBorra") || Cedula.equals("NuevoDesas") || Cedula.equals("NuevoCance")){
            adminformularioSteps.ingresalosdatosdePersonales();
            adminformularioSteps.ingresalosdatosdeRecogida();
            adminformularioSteps.solicituddelarecogidanuevopreenvio();
            preenviosSteps.informaciondecotizacion("otrodato");
            preenviosSteps.informaciondedestinatario();
            preenviosSteps.SolicitudPrenvioExitosa();
            adminformularioSteps.TusRecogidas();
            editarRecogidasSteps.editarrecogida();
        }else{
            switch (Cedula){
                case "NuevoEdita": {
                    adminformularioSteps.ingresalosdatosdePersonales();
                    adminformularioSteps.ingresalosdatosdeRecogida();
                    adminformularioSteps.solicituddelarecogidanuevopreenvio();
                    preenviosSteps.informaciondecotizacion("otrodato");
                    preenviosSteps.informaciondedestinatario();
                    preenviosSteps.SolicitudPrenvioExitosa();
                    adminformularioSteps.TusRecogidas();
                    editarRecogidasSteps.editarrecogida();
                    break;
                }
                case "NuevoAsoci": {
                    adminformularioSteps.ingresalosdatosdePersonales();
                    adminformularioSteps.ingresalosdatosdeRecogida();
                    adminformularioSteps.solicituddelarecogidanuevopreenvio();
                    preenviosSteps.informaciondecotizacion("otrodato");
                    preenviosSteps.informaciondedestinatario();
                    preenviosSteps.SolicitudPrenvioExitosa();
                    adminformularioSteps.TusRecogidas();
                    editarRecogidasSteps.editarrecogida();
                    editarRecogidasSteps.desasociarpreenvio();
                    break;
                }
                default: {
                    adminformularioSteps.ingresalosdatosdePersonalesF(Cedula, Celular);
                    adminformularioSteps.IngresoTusRecogidas();
                    if (getDriver().findElement(recogida1).getText().equals("0")) {
                        editarRecogidasSteps.agregarpreenvio("listado");
                        preenviosSteps.informaciondecotizacion("");
                        preenviosSteps.informaciondedestinatario();
                        preenviosSteps.SolicitudPrenvioExitosa();
                        adminformularioSteps.TusRecogidas();
                        editarRecogidasSteps.editarrecogida();
                    } else {
                        editarRecogidasSteps.editarrecogida();
                    }
                }
            }
        }
    }

    @Given("Dado un listado de recogidas. {} {}")
    public void asociarpreenvio(String Cedula, String Celular) throws CsvValidationException, IOException {
        adminformularioSteps.ingresalapaginaderecogidas();
        switch (Cedula){
            case "NuevoAsoci": {
                adminformularioSteps.ingresalosdatosdePersonales();
                adminformularioSteps.ingresalosdatosdeRecogida();
                adminformularioSteps.solicituddelarecogidanuevopreenvio();
                preenviosSteps.informaciondecotizacion("otrodato");
                preenviosSteps.informaciondedestinatario();
                preenviosSteps.SolicitudPrenvioExitosa();
                adminformularioSteps.TusRecogidas();
                editarRecogidasSteps.editarrecogida();
                editarRecogidasSteps.desasociarpreenvio();
                break;
            }
            default: {
                adminformularioSteps.ingresalosdatosdePersonalesF(Cedula, Celular);
                adminformularioSteps.IngresoTusRecogidas();
            }
        }
    }

    @When("Cancelo una recogida")
    public void CanceloRecogida(){
        editarRecogidasSteps.cancelarrecogida();
    }

    @Then("Se cancela la recogida exitosamente {}")
    public void SeCancelaRecogida(String Cedula){
        editarRecogidasSteps.notificacion();
        if (Cedula.equals("NuevoCance")){
            System.out.println("Cliente Nuevo Cancela una recogida");
        }else {
            System.out.println("Cliente con Numero de Cedula: " + Cedula + " Cancela una recogida");
        }
    }

    @When("Edito una recogida")
    public void EditoRecogida(){
        editarRecogidasSteps.editardatosrecogida();
    }

    @Then("La recogida se edita exitosamente {}")
    public void SeEditaRecogida(String Cedula){
        editarRecogidasSteps.notificacion();
        if (Cedula.equals("NuevoEdita")){
            System.out.println("Cliente Nuevo edita una recogida");
        }else {
            System.out.println("Cliente con Numero de Cedula: " + Cedula + " edita una recogida");
        }
    }

    @When("Agrego un preenvio")
    public void AgregarPreenvio(){
        editarRecogidasSteps.agregarpreenvio("recogida");
        preenviosSteps.informaciondecotizacion("");
        preenviosSteps.informaciondedestinatario();
    }

    @When("Borro un preenvio")
    public void BorrarPreenvio(){
        editarRecogidasSteps.borrarpreenvio();
    }

    @Then("El preenvio se borra exitosamente {}")
    public void preenvioborrado(String Cedula){
        if (Cedula.equals("NuevoBorra")){
            System.out.println("Cliente Nuevo borra un preenvio");
        }else {
            System.out.println("Cliente con Numero de Cedula: " + Cedula + " borra un preenvio");
        }
    }

    @When("Desasocio un preenvio")
    public void DesasociarPreenvio(){
        editarRecogidasSteps.desasociarpreenvio();
    }

    @Then("El preenvio se desasocia exitosamente {}")
    public void preenviodesaciado(String Cedula){
        if (Cedula.equals("NuevoDesas")){
            System.out.println("Cliente Nuevo desasocia un preenvio");
        }else {
            System.out.println("Cliente con Numero de Cedula: " + Cedula + " desasocia un preenvio");
        }
    }

    @When("asocio un preenvio")
    public void AsocioPreenvio(){
        editarRecogidasSteps.agregarpreenvio("listado");
        editarRecogidasSteps.asociarpreenvio();
    }

    @Then("El preenvio se asocia exitosamente {}")
    public void preenvioasociado(String Cedula){
        if (Cedula.equals("NuevoAsoci")){
            System.out.println("Cliente Nuevo agrego por accion, asocio un preenvio");
        }else {
            System.out.println("Cliente con Numero de Cedula: " + Cedula + " agrego por accion, asocio un preenvio");
        }
    }

    ////////////////////////////////////////////////////////Pruebas de afectacion/////////////////////////////////////////////////////////////////////////////

    @Given("Usuario frecuente ingresa a tus recogidas {} {}")
    public void IngresoRecogidas(String Cedula, String Celular){
        adminformularioSteps.ingresalapaginaderecogidas();
        adminformularioSteps.ingresalosdatosdePersonalesFR(Cedula,Celular);
        adminformularioSteps.IngresoTusRecogidas();
    }

    @When("Ingreso datos de preenvio de contado")
    public void PreenvioContado(){
        cvsSteps.diferentespreenvios();
        adminformularioSteps.solicituddelarecogida();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnviocontado();
    }

    @When("Ingreso datos de preenvio pago en casa")
    public void PreenvioPagoCasaSinVerificacion(){
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioPagoEnCasa();
    }

    @When("Ingreso datos de preenvio al cobro")
    public void PreenvioCobro(){
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioAlCrobro();
    }

    @When("Ingreso datos de preenvio con convenio")
    public void PreenvioConvenio(){
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioConvenio();
    }
    @Then("El preenvio se crea exitosamente")
    public void FormularioPreenvio() throws IOException {
        preenviosSteps.SolicitudNuevoPrenvioExitoso();
    }

    //////////////////////////////////////////////// FUNCIONALIDADES BASICAS ///////////////////////////////////////////////////////////////////////////////////////

    @Given("Un preenvio cotizado {} {}")
    public void cotizopreenvio(String Cedula, String Celular){
        adminformularioSteps.ingresalapaginaderecogidas();
        adminformularioSteps.ingresalosdatosdePersonalesFR(Cedula,Celular);
        adminformularioSteps.IngresoTusRecogidas();
        editarRecogidasSteps.agregarpreenvio("listado");
        preenviosSteps.informaciondecotizacion("carguedatos");
    }

    @When("Ingreso nombre destinatario")
    public void ingresodestinatario(){
        preenviosSteps.carguedatadestinatario();
    }

    @Then("Se carga informacion del destinatario")
    public void carguedestinatario(){
        preenviosSteps.cargueexitosodestinatario();
    }

    @Given("Preenvio cotizado pago en casa {} {}")
    public void cotizopagoencasa(String Cedula, String Celular){
        adminformularioSteps.ingresalapaginaderecogidas();
        adminformularioSteps.ingresalosdatosdePersonalesFR(Cedula,Celular);
        adminformularioSteps.IngresoTusRecogidas();
        editarRecogidasSteps.agregarpreenvio("listado");
        preenviosSteps.cotizaPagoEnCasa();
    }

    @When("Ingeso link actualizar cuenta")
    public void linkactualizocuenta(){
        preenviosSteps.actualizarCuenta();
    }

    @Then("El link responde exitosamente")
    public void linkresponde(){
        preenviosSteps.actualizacuentaexitoso();
    }

    @Given("Pagina principal de recogidas")
    public void abrirpagina(){
        adminformularioSteps.ingresalapaginaderecogidas();
    }

    @When("Selecciono logo de interrapidisimo")
    public void seleccionarlogo(){
        adminformularioSteps.seleccionologo();
    }

    @Then("Direccionamineto pagina oficial interrapidismo exitosa")
    public void linkinterexitoso(){
        adminformularioSteps.linkinterexitoso();
    }
    @When("Selecciono link tratamiento de politica datos")
    public void seleccionarpolitcadatos(){
        adminformularioSteps.seleccionopoliticadatos();
    }

    @Then("Direccionamineto politica datos exitosa")
    public void linkpoliticadatosexitoso(){
        adminformularioSteps.linkpoliticadatosexitoso();
    }

    @When("Selecciono link terminos y condiciones")
    public void seleccionarterminos(){
        adminformularioSteps.seleccionterminos();
    }

    @Then("Direccionamineto terminos y condiciones exitosa")
    public void linkterminosexitoso(){
        adminformularioSteps.linkterminosexitoso();
    }
    ///////////////////////////////////////////////////////////// CONTROLLER APP ////////////////////////////////////////////////////////////////////////////////////////////////
    @When("Ingreso diferentes preenvios {} {}")
    public void diferentespreenvios(String cedula, String celular) throws IOException {
        adminformularioSteps.ingresalosdatosdeAPP();
        adminformularioSteps.solicituddelarecogidaAPP();
        adminformularioSteps.IngresoTusRecogidas();
        Integer i = 0;
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizapreenvioAPP(i,cedula);
        preenviosSteps.informaciondedestinatario();
        preenviosSteps.envioexitosoAPP(cedula,celular,"no","N/A");
        adminformularioSteps.IngresoTusRecogidas();
        i++;
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizapreenvioAPP(i,cedula);
        preenviosSteps.informaciondedestinatario();
        preenviosSteps.envioexitosoAPP(cedula,celular,"no","N/A");
        adminformularioSteps.IngresoTusRecogidas();
        i++;
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizapreenvioAPP(i,cedula);
        preenviosSteps.informaciondedestinatario();
        preenviosSteps.envioexitosoAPP(cedula,celular,"no","N/A");
        adminformularioSteps.IngresoTusRecogidas();
        i++;
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizapreenvioAPP(i,cedula);
        preenviosSteps.destinatarioAPP();
        preenviosSteps.envioexitosoAPP(cedula,celular,"yes","no");
        adminformularioSteps.IngresoTusRecogidas();
        adminformularioSteps.ingresalosdatosdeAPP();
        adminformularioSteps.solicituddelarecogidaAPP();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizapreenvioAPP(3,cedula);
        preenviosSteps.destinatarioAPP();
        preenviosSteps.envioexitosoAPP(cedula,celular,"no","N/A");
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizapreenvioAPP(3,cedula);
        preenviosSteps.destinatarioAPP();
        preenviosSteps.envioexitosoAPP(cedula,celular,"yes","si");
        adminformularioSteps.IngresoTusRecogidas();
    }

    @Then("Creo data de formularios exitosos")
    public void crearData() throws IOException {
        dataCvs.CrearCsv("APP");
    }
////////////////////////////////////////////////////////////////////////PRUEBAS POS//////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("Usuario ingresa a tus recogidas {} {}")
    public void IngresoRecogidasPOS(String Cedula, String Celular){
        adminformularioSteps.ingresalapaginaderecogidas();
        adminformularioSteps.ingresalosdatosdePersonalesPOS(Cedula,Celular);
        adminformularioSteps.IngresoTusRecogidas();
    }

    @When("Ingreso los diferentes preenvios")
    public void diferentespreenvios() throws IOException {
        cvsSteps.diferentespreenvios();
        adminformularioSteps.solicituddelarecogida();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnviocontado();
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioPagoEnCasa();
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioAlCrobro();
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioConvenio();
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnviocontado();
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioPagoEnCasa();
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioAlCrobro();
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
        preenviosSteps.opciondeAgregarenvios();
        preenviosSteps.cotizaEnvioConvenio();
    }

    @Then("Creo data pruebas POS")
    public void crearDataPOS() throws IOException {
        preenviosSteps.envioexitosoafectacionPOS();
        adminformularioSteps.IngresoTusRecogidas();
    }
}
