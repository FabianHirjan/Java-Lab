package shell;

import org.example.Document;
import org.example.Person;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

class OpenDocumentCommand implements Command {
    private DocumentManager documentManager;

    public OpenDocumentCommand(DocumentManager documentManager) {
        this.documentManager = documentManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: open-file <path>");
            return;
        }
        String filePath = args[0];
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                throw new IOException("The specified document does not exist.");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

            if (!Desktop.isDesktopSupported()) {
                throw new UnsupportedOperationException("Desktop is not supported on this platform.");
            }

            Desktop desktop = Desktop.getDesktop();
            if (!desktop.isSupported(Desktop.Action.OPEN)) {
                throw new UnsupportedOperationException("Open action is not supported on this platform.");
            }

        try {
            try {
                desktop.browse(new URI(filePath));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}