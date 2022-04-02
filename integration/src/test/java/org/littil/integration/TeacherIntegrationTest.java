package org.littil.integration;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/littil/integration")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org/littil/integration")
public class TeacherIntegrationTest {
}
