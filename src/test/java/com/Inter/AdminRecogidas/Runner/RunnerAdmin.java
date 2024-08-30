package com.Inter.AdminRecogidas.Runner;

import io.cucumber.junit.CucumberOptions;
import net.bytebuddy.build.Plugin;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.openqa.selenium.grid.config.ConfigValue;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"}
        ,features="src/test/resources/features"
        ,glue="com.Inter.AdminRecogidas"
        ,tags = "@PruebasRegresion1"
)
public class RunnerAdmin {

}