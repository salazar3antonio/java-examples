package json_io;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: Main [file path]");
            return;
        }

        Client client =
                new Client(
                        "CatFacts LLC",
                        17,
                        8000,
                        5,
                        true
                );

        Path outputPath = Path.of(args[0]);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(Files.newBufferedWriter(outputPath), client);

        System.out.println("Wrote to " + outputPath.toAbsolutePath());

        Client deserialized = objectMapper.readValue(Files.newBufferedReader(outputPath), Client.class);
        System.out.println("Deserialized " + deserialized);
    }
}
