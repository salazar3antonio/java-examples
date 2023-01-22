package file_io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class FileIOExample {

    public static void main(String[] args) throws IOException {

        // creates a simple text file inside the file_io package
        Path path = Path.of("src/main/java/file_io/simpleFile.txt");
        File textFile = new File(path.toUri());

        textFile.createNewFile();

        // if the file exists, write a string to the file
        if (textFile.exists()) {
            // write to the file
            try (Writer writer = Files.newBufferedWriter(path)) {
                System.out.println("Writing: " + path.toAbsolutePath());
                String textToWrite = "Hey there!";
                writer.write(textToWrite);
            }
        }

        // if file exists, read from the file and print out the result
        if (textFile.exists()) {
            try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                char[] data = new char[10];
                System.out.println("Reading with Reader: ");
                while (reader.read(data) != -1) {
                    System.out.println(data);
                }
            }
        }

        Path pathToSampleText = Path.of("src/main/java/file_io/sampleText.txt");
        try (BufferedReader buffReader = Files.newBufferedReader(pathToSampleText, StandardCharsets.UTF_8)) {
            System.out.println("Reading with BufferedReader: ");
            String singleLine = buffReader.readLine();
            // TODO: How can we read all of the lines in the file?
            System.out.println(singleLine);
        }
    }
}
