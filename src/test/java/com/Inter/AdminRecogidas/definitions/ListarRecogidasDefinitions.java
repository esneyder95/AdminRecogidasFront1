package com.Inter.AdminRecogidas.definitions;

import com.Inter.AdminRecogidas.steps.AdminformularioSteps;
import com.Inter.AdminRecogidas.steps.EditarRecogidasSteps;
import com.Inter.AdminRecogidas.steps.ListarRecogidasSteps;
import com.Inter.AdminRecogidas.steps.PreenviosSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;

public class ListarRecogidasDefinitions extends PageObject {

    AdminformularioSteps adminformularioSteps = new AdminformularioSteps();
    ListarRecogidasSteps listarRecogidasSteps = new ListarRecogidasSteps();
    EditarRecogidasSteps editarRecogidasSteps = new EditarRecogidasSteps();

    @Given("Un listado de recogidas {} {}")
    public void Ingresolistadorecogidas(String cedula, String celular){
        adminformularioSteps.ingresalapaginaderecogidas();
        if (cedula.equals("NuevoCance") && celular.equals("NuevoCance")){
            adminformularioSteps.ingresalosdatosdePersonales();
            adminformularioSteps.ingresalosdatosdeRecogida();
            adminformularioSteps.solicituddelarecogida();
        }else{
            adminformularioSteps.ingresalosdatosdePersonalesF(cedula,celular);
            adminformularioSteps.IngresoTusRecogidas();
        }
    }

    @When("Filtro por ID de recogida")
    public void FiltroIdRecogida(){
        listarRecogidasSteps.BuscarIDrecogida();
    }

    @Then("La tabla filtra la recogida escogida")
    public void FiltroExitosoporId(){
        listarRecogidasSteps.filtradoIdexitoso();
    }

    @When("Filtro por recogidas activas")
    public void filtrarporactivas(){
        listarRecogidasSteps.filtrarEstado("Activas");
    }

    @Then("La tabla filtra por recogidas activas")
    public void filtroexitosactivas(){
        listarRecogidasSteps.filtrarEstadoexitoso("Activas");
    }

    @When("Filtro por recogidas finalizadas")
    public void filtrarporfinalizadas(){
        listarRecogidasSteps.filtrarEstado("Finalizadas");
    }

    @Then("La tabla filtra por recogidas finalizadas")
    public void filtroexitosfinalizadas(){
        listarRecogidasSteps.filtrarEstadoexitoso("Finalizadas");
    }

    @When("Cancelo la recogida")
    public void cancelarrecogidalistado(){
        listarRecogidasSteps.cancelarrecogidalistado();
    }

    @Then("Se cancela la recogida exitosamente")
    public void SeCancelaRecogida(){
        editarRecogidasSteps.notificacion();
    }
}
