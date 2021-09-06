package core.cucumberHelper;

import core.Config;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportHelper {
    public static void generateCucumberReport(String propPath) {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        String path = "target" + File.separator + "cucumber-reports" + File.separator;
        jsonFiles.add(path + "cucumber.json");

        String projectName = "amazonShopping";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addClassifications("environment", Config.globalEnvironment);

        // optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<String>();
        classificationFiles.add(propPath);
        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
