package file_io;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIOExample {

    public static void main(String[] args) throws IOException {

        // creates a simple text file inside the file_io package
        Path path = Path.of("src/main/java/file_io/simpleFile.txt");
        File textFile = new File(path.toUri());

        textFile.createNewFile();

        // if the file exists, write a string to the file
        if (textFile.exists()) {
            // write to the file
            try (Writer buffWriter = Files.newBufferedWriter(path)) {
                System.out.println("Writing: " + path.toAbsolutePath());
                String textToWrite = "Hey there!";
                buffWriter.write(textToWrite);
            }
        }

        // if file exists, read from the file and print out the result
        if (textFile.exists()) {
            try (Reader buffReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                char[] data = new char[10];
                System.out.println("Reading: ");
                while (buffReader.read(data) != -1) {
                    System.out.println(data);
                }
            }
        }
    }
}
