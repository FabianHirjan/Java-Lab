package shell;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(getClass(), "/");

        try {
            Template template = cfg.getTemplate("exampleTemplate.ftl");

            Map<String, Object> input = new HashMap<>();
            List<String> files = listFiles(directoryPath);
            input.put("files", files);

            File reportFile = new File("/Users/fabian-andreihirjan/Desktop/Path/resources/report.html");
            FileWriter fileWriter = new FileWriter(reportFile);
            template.process(input, fileWriter);

            System.out.println("Report generated successfully: " + reportFile.getAbsolutePath());

            openInBrowser(reportFile.getAbsolutePath());
        } catch (IOException | TemplateException e) {
            System.out.println("Failed to generate report.");
            e.printStackTrace();
        }
    }

    private List<String> listFiles(Path directoryPath) {
        try {
            return Files.list(directoryPath)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Failed to list files in directory.");
            e.printStackTrace();
            return null;
        }
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
