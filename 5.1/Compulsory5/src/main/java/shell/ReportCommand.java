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
        // 1. Inițializați motorul Velocity
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        // 2. Încărcați template-ul
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
        velocityEngine.setProperty("file.resource.loader.path", Paths.get("").toAbsolutePath().toString() + "/resources");

        Template template = velocityEngine.getTemplate("exampleTemplate.html");

        // 3. Creați contextul și adăugați datele (lista de fișiere)
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

        // 4. Procesați template-ul
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        // 5. Scrieți rezultatul într-un fișier HTML
        String reportFilePath = "report.html"; // Specificați calea și numele fișierului raportului HTML
        try (FileWriter fileWriter = new FileWriter(reportFilePath)) {
            fileWriter.write(writer.toString());
            System.out.println("Report generated successfully: " + reportFilePath);
        } catch (IOException e) {
            System.out.println("Failed to write report to file.");
            e.printStackTrace();
        }

        // 6. Deschideți raportul HTML într-un browser web (opțional)
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
