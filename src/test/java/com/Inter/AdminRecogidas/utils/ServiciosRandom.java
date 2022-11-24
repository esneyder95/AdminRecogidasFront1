package com.Inter.AdminRecogidas.utils;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ServiciosRandom extends PageObject {

    public By serivicio1 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[1]/li[1]");
    public By serivicio2 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[2]/li[1]");
    public By serivicio3 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[3]/li[1]");
    public By serivicio4 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[4]/li[1]");
    public By serivicio5 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[5]/li[1]");
    public By serivicio6 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[6]/li[1]");
    public By serivicio7 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[7]/li[1]");
    public By serivicio8 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[8]/li[1]");
    public By serivicio9 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[9]/li[1]");
    public By serivicio10 = By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[10]/li[1]");

    static String tiposervicio = "";


     public void contarservicios(){
         int i=0;
         try{
             getDriver().findElement(serivicio1).getText();
             i++;
             getDriver().findElement(serivicio2).getText();
             i++;
             getDriver().findElement(serivicio3).getText();
             i++;
             getDriver().findElement(serivicio4).getText();
             i++;
             getDriver().findElement(serivicio5).getText();
             i++;
             getDriver().findElement(serivicio6).getText();
             i++;
             getDriver().findElement(serivicio7).getText();
             i++;
             getDriver().findElement(serivicio8).getText();
             i++;
             getDriver().findElement(serivicio9).getText();
             i++;
             getDriver().findElement(serivicio10).getText();
             i++;
         }catch (NoSuchElementException exception){
             System.out.println("Se encontraron " + i + " Servicios");
         }
         int longitud = (int) (Math.random() * (i - 1) + 1);
         switch (longitud){
             case 1: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[1]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio1).click();
                 break;
             }
             case 2: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[2]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio2).click();
                 break;
             }
             case 3: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[3]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio3).click();
                 break;
             }
             case 4: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[4]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio4).click();
                 break;
             }
             case 5: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[5]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio5).click();
                 break;
             }
             case 6: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[6]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio6).click();
                 break;
             }
             case 7: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[7]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio7).click();
                 break;
             }
             case 8: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[8]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio8).click();
                 break;
             }
             case 9: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[9]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio9).click();
                 break;
             }
             case 10: {
                 WebElement textoservicio = getDriver().findElement(By.xpath("//div[@class='service-selection modal-container container']/div[1]/div[1]/ul[10]/li[1]/span"));
                 tiposervicio = textoservicio.getText();
                 getDriver().findElement(serivicio10).click();
                 break;
             }
         }
     }

     public static String servicio(){
         return tiposervicio;
     }
}
