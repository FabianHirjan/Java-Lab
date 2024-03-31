package shell;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.example.Operations;

public class Shell {
    private Map<String, Command> commands;
    private Operations operations;
    private Map<String, List<String>> repository;

    public Shell(Operations operations) {
        this.operations = operations;
        commands = new HashMap<>();
        DocumentManager DocumentManager = new DocumentManager();
        commands.put("add-document", new AddDocumentCommand(DocumentManager));
        commands.put("open-file", new OpenDocumentCommand(DocumentManager));
        commands.put("report", new ReportCommand());
        commands.put("export-json", new ExportJSONCommand(operations, repository)); // Adaugă comanda export-json
    }

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split("\\s+");
            String commandName = parts[0];
            Command command = commands.get(commandName);
            if (command != null) {
                String[] args = new String[parts.length - 1];
                System.arraycopy(parts, 1, args, 0, args.length);
                command.execute(args);
            } else {
                System.out.println("Command not found: " + commandName);
            }
        }
    }
}
