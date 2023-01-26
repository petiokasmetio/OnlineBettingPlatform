package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features",
        //features = ".//Features/Login.feature",
        //features = ".//Features/Sport.feature",
        glue = {"StepDefinitions"},
        dryRun = false,
        monochrome = true,
        //plugin = {"pretty", "html:src/test/java/Reports/HtmlReport.html"},
        //plugin = {"pretty", "json:src/test/java/Reports/JsonReport.json"},
        plugin = {"pretty"
//                ,"json:src/test/java/Reports/DiagramReport.json"
//                ,"net.masterthought.cucumber.ReportBuilder:src/test/java/Reports/DiagramReport.html"
                , "junit:src/test/java/Reports/JUnitReport.xml"
                ,"json:src/test/java/Reports/JsonReport.json"
                ,"html:src/test/java/Reports/HtmlReport.html"},
        //tags = "SmokeTest",
        //tags = "@SmokeTest and not @RegressionTest",
        tags = "@RegressionTest or @SmokeTest"

)

public class TestRunner{
}
