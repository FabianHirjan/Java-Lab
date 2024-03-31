package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Operations {

    private String masterPath = "/Users/fabian-andreihirjan/Desktop/Path";

    public void make(Person[] persons) throws IOException {
        List<Path> paths = Arrays.stream(persons)
                .map(person -> Paths.get(masterPath, person.name()))
                .collect(Collectors.toList());

        for (Path path : paths) {
            if (Files.notExists(path)) {
                Files.createDirectory(path);
            } else {
                throw new IOException("The directory already exists: " + path);
            }
        }
    }

    public void makeDir() throws IOException {
        Path path = Paths.get(masterPath);
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        } else {
            throw new IOException("The directory already exists: " + path);
        }
    }

    public void displayDirectoryContent(String directoryPath) throws IOException {
        Path path = Paths.get(directoryPath);
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            throw new IOException("The directory does not exist: " + directoryPath);
        }

        System.out.println("Content of directory " + path + ":");
        Files.list(path)
                .forEach(p -> System.out.println(p.getFileName()));
    }

    public void setMasterPath(String masterPath) {
        this.masterPath = masterPath;
    }

    public String getMasterPath() {
        return masterPath;
    }

    public void addDocumentToPerson(Person person, Document document) throws IOException {
        Path personDirectory = Paths.get(masterPath, person.name());
        if (Files.exists(personDirectory) && Files.isDirectory(personDirectory)) {
            Path documentPath = personDirectory.resolve(document.name());
            if (Files.notExists(documentPath)) {
                Files.createFile(documentPath);
                System.out.println("Document '" + document.name() + "' added to " + person.name() + "'s folder.");
            } else {
                throw new IOException("The document already exists for this person.");
            }
        } else {
            throw new IOException("Person's directory does not exist.");
        }
    }

    public void exportRepositoryToJSON(String outputPath, Map<String, List<String>> repository) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File outputFile = new File(outputPath);
        objectMapper.writeValue(outputFile, repository);

        System.out.println("Repository exported to JSON successfully: " + outputPath);
    }
}
