package memp.common;

import io.cucumber.spring.CucumberContextConfiguration;
import memp.EmpApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { EmpApplication.class })
public class CucumberSpingConfiguration {}
