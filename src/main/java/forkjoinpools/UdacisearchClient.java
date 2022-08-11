package forkjoinpools;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public final class UdacisearchClient {
    private String name = "";
    private long id = 0;
    private int quarterlyBudget = 0;
    private int numEmployees = 0;
    private Instant contractStart = Instant.EPOCH;
    private Duration contractLength = Duration.ZERO;
    private List<ZoneId> timeZones = new ArrayList<>();
    private String billingAddress = "";

    public UdacisearchClient(
            String name,
            long id,
            int quarterlyBudget,
            int numEmployees,
            Instant contractStart,
            Duration contractLength,
            List<ZoneId> timeZones,
            String billingAddress) {
        this.name = name;
        this.id = id;
        this.quarterlyBudget = quarterlyBudget;
        this.numEmployees = numEmployees;
        this.contractStart = contractStart;
        this.contractLength = contractLength;
        this.timeZones = timeZones;
        this.billingAddress = billingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuarterlyBudget() {
        return quarterlyBudget;
    }

    public void setQuarterlyBudget(int quarterlyBudget) {
        this.quarterlyBudget = quarterlyBudget;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public Instant getContractStart() {
        return contractStart;
    }

    public void setContractStart(Instant contractStart) {
        this.contractStart = contractStart;
    }

    public Duration getContractLength() {
        return contractLength;
    }

    public void setContractLength(Duration contractLength) {
        this.contractLength = contractLength;
    }

    public Instant getContractEnd() {
        return getContractStart().plus(getContractLength());
    }

    public List<ZoneId> getTimeZones() {
        return timeZones;
    }

    public void setTimeZone(List<ZoneId> timeZones) {
        this.timeZones = timeZones;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "UdacisearchClient{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", quarterlyBudget=" + getQuarterlyBudget() +
                ", numEmployees=" + getNumEmployees() +
                ", contractStart=" + getContractStart() +
                ", contractLength=" + getContractLength() +
                ", timeZones=" + getTimeZones() +
                ", billingAddress='" + getBillingAddress() + '\'' +
                '}';
    }
}

