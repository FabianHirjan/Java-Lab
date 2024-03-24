package shell;

import org.example.Document;
import org.example.Operations;
import org.example.Person;

import java.awt.*;
import java.io.File;
import java.io.IOException;

class DocumentManager {
    private Operations operations;

    public DocumentManager() {
        operations = new Operations();
    }

    public void addDocumentToUser(Person person, Document document) throws IOException {
        try {
            operations.addDocumentToPerson(person, document);
        } catch (IOException e) {
            throw new IOException("Failed to add document to user.", e);
        }
    }

}
