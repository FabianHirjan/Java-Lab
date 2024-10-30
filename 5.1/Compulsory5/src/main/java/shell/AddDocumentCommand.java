package shell;

import org.example.Document;
import org.example.Person;

class AddDocumentCommand implements Command {
    private DocumentManager documentManager;

    public AddDocumentCommand(DocumentManager documentManager) {
        this.documentManager = documentManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: add-document <username> <docname>");
            return;
        }
        String username = args[0];
        String docname = args[1];
        Document d = new Document(docname);
        Person person = Person.createPerson(username);
        try {
            documentManager.addDocumentToUser(person, d);
            System.out.println("Document added to user '" + username + "'.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}