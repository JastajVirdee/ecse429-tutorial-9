package ca.mcgill.ecse321.eventregistration.test;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "features",
        glue = {"ca.mcgill.ecse321.eventregistration.test"},
        monochrome = true,
        plugin = { "pretty"}
)
public class CucumberRunner {
}