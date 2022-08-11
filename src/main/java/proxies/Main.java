package proxies;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public final class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Object> propertiesFromDatabase = new HashMap<>();
        propertiesFromDatabase.put("name", "CatFacts LLC");
        propertiesFromDatabase.put("id", 17L);
        propertiesFromDatabase.put("quarterlyBudget", 8000);
        propertiesFromDatabase.put("numEmployees", 5);
        propertiesFromDatabase.put("contractStart", Instant.now());
        propertiesFromDatabase.put("contractLength", Duration.ofDays(180));
        propertiesFromDatabase.put("timeZone", ZoneId.of("America/Los_Angeles"));
        propertiesFromDatabase.put("billingAddress", "555 Meowmers Ln, Riverside, CA 92501");

        UdaciSearchClient client = UdaciSearchClientFactory.fromPropertyMap(propertiesFromDatabase);

        System.out.println(client);
        System.out.println(clientToString(client));
    }

    private static String clientToString(UdaciSearchClient client) {
        return "UdacisearchClient{" +
                "name='" + client.getName() + '\'' +
                ", id=" + client.getId() +
                ", quarterlyBudget=" + client.getQuarterlyBudget() +
                ", numEmployees=" + client.getNumEmployees() +
                ", contractStart=" + client.getContractStart() +
                ", contractLength=" + client.getContractLength() +
                ", timeZone=" + client.getTimeZone() +
                ", billingAddress='" + client.getBillingAddress() + '\'' +
                '}';
    }

}
