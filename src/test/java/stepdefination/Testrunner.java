package stepdefination;


import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")//default
@SelectClasspathResource("login.feature")//feature file name
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,value="stepdefination")//package nmame
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report.html")//report plugin
public class Testrunner {

}