package shell;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class ReportCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: report <directory>");
            return;
        }

        String directoryPath = args[0];
        Path path = Paths.get(directoryPath);
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.out.println("Invalid directory path.");
            return;
        }

        generateHtmlReport(path);
    }

    private void generateHtmlReport(Path directoryPath) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
        velocityEngine.setProperty("file.resource.loader.path", Paths.get("").toAbsolutePath().toString() + "/resources");

        Template template = velocityEngine.getTemplate("exampleTemplate.vm");

        VelocityContext context = new VelocityContext();
        List<String> files = null;
        try {
            files = Files.list(directoryPath)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Failed to list files in directory.");
            e.printStackTrace();
        }
        context.put("files", files);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        String reportFilePath = "resources/report.html";
        try (FileWriter fileWriter = new FileWriter(reportFilePath)) {
            fileWriter.write(writer.toString());
            System.out.println("Report generated successfully: " + reportFilePath);
        } catch (IOException e) {
            System.out.println("Failed to write report to file.");
            e.printStackTrace();
        }

        openInBrowser(reportFilePath);
    }

    private void openInBrowser(String filePath) {
        try {
            Desktop.getDesktop().browse(new File(filePath).toURI());
        } catch (IOException e) {
            System.out.println("Failed to open report in browser.");
            e.printStackTrace();
        }
    }
}
