package shell;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shell {
    private Map<String, Command> commands;
    private DocumentManager documentManager;

    public Shell() {
        commands = new HashMap<>();
        documentManager = new DocumentManager();
        commands.put("add-document", new AddDocumentCommand(documentManager));
        commands.put("open-file", new OpenDocumentCommand(documentManager));
        commands.put("report", new ReportCommand());
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