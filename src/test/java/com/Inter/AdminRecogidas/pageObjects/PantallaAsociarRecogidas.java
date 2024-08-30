package com.Inter.AdminRecogidas.pageObjects;

import com.Inter.AdminRecogidas.utils.GenerarReporte;
import net.serenitybdd.core.pages.PageObject;
import com.Inter.AdminRecogidas.utils.InteractorTime;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PantallaAsociarRecogidas extends PageObject {
    InteractorTime interactorTime = new InteractorTime();
    GenerarReporte generarReporte = new GenerarReporte();
    public By asociarpreenvioli = By.xpath("//ul[@class='preshipping-container disassociated-preshipping-one']/li[1]/div[1]");
    public By asociarpreenvio = By.id("AsociarPrenvios");
    public By listapreenviosnoasociados = By.xpath("//div[@id='AsociarPreenvios']");
    WebDriverWait tiempo = new WebDriverWait(getDriver(),30);

    public void AsociarPreenvio(){
        try {
            tiempo.until(ExpectedConditions.attributeToBe(listapreenviosnoasociados,"class","disassociated-preshippings-container"));
        }catch (Exception e){
            generarReporte.TomarPantallazo();
            generarReporte.CasoFallido("","No cargo popup opciones de Asociar Preenvios","");
            throw new RuntimeException("No se cargo popup opciones Asociar Preenvio");
        }
        getDriver().findElement(asociarpreenvioli).click();
        interactorTime.esperaMilis(1000);
        getDriver().findElement(asociarpreenvio).click();
        interactorTime.esperaMilis(3000);
    }
}
