package com.Inter.AdminRecogidas.Runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty" }
        ,features="src/test/resources/features"
        ,glue="com.Inter.AdminRecogidas"
        ,tags = "@PruebasAfectacion"
)
public class RunnerAdmin {

}
