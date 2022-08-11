package forkjoinpools;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ClientStore {
    private ClientStore() {
        // No instantiation
    }

    private static List<UdacisearchClient> CLIENTS =
            generateClients(10_000).collect(Collectors.toUnmodifiableList());

    public static List<UdacisearchClient> getClients() {
        return CLIENTS;
    }

    private static Stream<UdacisearchClient> generateClients(int n) {
        return Stream.generate(new ClientSupplier()).limit(n);
    }

    private static final class ClientSupplier implements Supplier<UdacisearchClient> {
        private final List<String> zoneIds = new ArrayList<>(ZoneId.getAvailableZoneIds());
        private final Random random = new Random();
        private int id = 0;

        @Override
        public UdacisearchClient get() {
            int thisId = id++;
            List<ZoneId> zones = pickZoneIds(random.nextInt(2) + 1);
            return new UdacisearchClient(
                    "Witty Company Name " + thisId,
                    thisId,
                    random.nextInt(10_000),
                    random.nextInt(5_000),
                    ZonedDateTime.of(2015 + random.nextInt(6), 1, 1, 0, 0, 0, 0, zones.get(0)).toInstant(),
                    Duration.ofDays(30 * (1 + random.nextInt(99))),
                    zones,
                    "Address of Witty Company Name " + thisId);
        }

        private List<ZoneId> pickZoneIds(int n) {
            if (n > zoneIds.size()) {
                throw new IllegalArgumentException();
            }
            Set<String> result = new HashSet<>(n);
            for (int i = 0; i < n; i++) {
                String choice;
                do {
                    choice = zoneIds.get(random.nextInt(zoneIds.size()));
                } while (!result.add(choice));
            }
            return result.stream().map(ZoneId::of).collect(Collectors.toList());
        }
    }
}

