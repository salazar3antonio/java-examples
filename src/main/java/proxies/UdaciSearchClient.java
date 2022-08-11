package proxies;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public interface UdaciSearchClient {
    @Tracker
    int getNumEmployees();

    String getName();
    long getId();
    int getQuarterlyBudget();
    Instant getContractStart();
    Duration getContractLength();
    ZoneId getTimeZone();

    @Tracker
    String getBillingAddress();
}
