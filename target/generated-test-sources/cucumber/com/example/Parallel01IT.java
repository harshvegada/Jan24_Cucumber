package com.example;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
        features = {"C:/Users/harsh/OneDrive/Desktop/Jan24/cucumber-jan24/src/test/resources/featurefiles/login.feature:5"},
        plugin = {"json:C:/Users/harsh/OneDrive/Desktop/Jan24/cucumber-jan24/target/cucumber-parallel/1.json"},
        monochrome = true,
        glue = {"steps"})
public class Parallel01IT {
}