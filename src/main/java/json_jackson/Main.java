package json_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Main {
    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.out.println("Usage: Main [file path]");
//            return;
//        }

        Client client =
                new Client(
                        "CatFacts LLC",
                        17,
                        8000,
                        5,
                        true
                );
        Path outputPath = Path.of("src/main/java/json_jackson/newResults.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath)) {
            objectMapper.writeValue(bufferedWriter, client);
            System.out.println("Wrote to " + outputPath.toAbsolutePath());
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(outputPath)) {
            Client deserialized = objectMapper.readValue(bufferedReader, Client.class);
            System.out.println("Deserialized Java Client Object data read " + deserialized);
        }
    }
}
