package shell;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.example.Operations;

public class ExportJSONCommand implements Command {
    private Operations operations;
    private Map<String, List<String>> repository;

    public ExportJSONCommand(Operations operations, Map<String, List<String>> repository) {
        this.operations = operations;
        this.repository = repository;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: export-json <outputPath>");
            return;
        }

        String outputPath = args[0];
        try {
            operations.exportRepositoryToJSON(outputPath, repository);
            System.out.println("Repository exported to JSON successfully.");
        } catch (IOException e) {
            System.out.println("Failed to export repository to JSON: " + e.getMessage());
        }
    }
}
