package com.Inter.AdminRecogidas.utils;

import com.Inter.AdminRecogidas.Runner.RunnerAdmin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.plugin.event.Node;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.jupiter.api.Tags;
import org.junit.runner.Runner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class GenerarReporte extends PageObject {
    static String NombrePrueba = "";
    static String CedulaPrueba = "";
    static String imagen = "";
    static int contadorImagenes;
    private static ExtentReports extent = new ExtentReports();
    private static ExtentSparkReporter reporter = new ExtentSparkReporter("Reporte.html");

    public void CasoExitoso(String cedula, String scenario){

        String tagprueba = CucumberWithSerenity.currentRuntimeOptions().getTagExpressions().toString();
        tagprueba = tagprueba.replace("[","").replace("]","").replace("@","");
        scenario = scenario.replaceAll("_"," ");
        reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD,ViewName.TEST}).apply();
        extent.attachReporter(reporter);
        if (cedula.equals("ClienteNue")){
            int imagenWhen=contadorImagenes-1;
            int imagenGiven=contadorImagenes-2;
            extent.createTest(scenario)
                    .log(Status.PASS,"Caso exitoso con cliente nuevo",
                            MediaEntityBuilder.createScreenCaptureFromPath("src/screenshot/" + imagenGiven +".png").build())
                    .info(MediaEntityBuilder.createScreenCaptureFromPath("src/screenshot/" + imagenWhen + ".png").build())
                    .info(MediaEntityBuilder.createScreenCaptureFromPath("src/screenshot/" + imagen + ".png").build())
                    .addScreenCaptureFromPath("src/screenshot/" + imagen + ".png")
                    .assignCategory(tagprueba);
        }else{
            int imagenWhen=contadorImagenes-1;
            int imagenGiven=contadorImagenes-2;
            extent.createTest(scenario)
                    .log(Status.PASS,"Caso exitoso con cliente frecuente, cedula: " + cedula,
                            MediaEntityBuilder.createScreenCaptureFromPath("src/screenshot/" + imagenGiven +".png").build())
                    .info(MediaEntityBuilder.createScreenCaptureFromPath("src/screenshot/" + imagenWhen + ".png").build())
                    .info(MediaEntityBuilder.createScreenCaptureFromPath("src/screenshot/" + imagen + ".png").build())
                    .addScreenCaptureFromPath("src/screenshot/" + imagen + ".png")
                    .assignCategory(tagprueba);
        }
        extent.flush();

    }

    public void CasoFallido(String cedula, String errordetalle, String scenario){
        if (errordetalle.equals("")){
            scenario = scenario.replaceAll("_"," ");
            NombrePrueba = scenario;
            CedulaPrueba = cedula;
        }else{
            String tagprueba = CucumberWithSerenity.currentRuntimeOptions().getTagExpressions().toString();
            tagprueba = tagprueba.replace("[","").replace("]","").replace("@","");
            reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD,ViewName.TEST}).apply();
            extent.attachReporter(reporter);
            if (CedulaPrueba.equals("ClienteNue")){
                extent.createTest(NombrePrueba)
                        .log(Status.FAIL,"Caso fallido con cliente nuevo")
                        .log(Status.INFO,errordetalle)
                        .addScreenCaptureFromPath("src/screenshot/" + imagen + ".png")
                        .assignCategory(tagprueba);
            }else{
                extent.createTest(NombrePrueba)
                        .log(Status.FAIL,"Caso fallido con cliente frecuente, cedula: " + CedulaPrueba)
                        .log(Status.INFO,errordetalle)
                        .addScreenCaptureFromPath("src/screenshot/" + imagen + ".png")
                        .assignCategory(tagprueba);
            }
            extent.flush();
        }
    }

    public void TomarPantallazo(){
        contadorImagenes++;
        imagen = String.valueOf(contadorImagenes);
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/screenshot/" + imagen + ".png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
