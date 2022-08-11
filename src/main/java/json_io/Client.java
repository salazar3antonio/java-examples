package json_io;

import java.time.ZoneId;

public final class Client {
    private String name = "";
    private long id = 0;
    private int quarterlyBudget = 0;
    private int numEmployees = 0;
    private boolean isPrimary = false;

    public Client() {
        // Default values.
    }

    public Client(
            String name,
            long id,
            int quarterlyBudget,
            int numEmployees,
            boolean isPrimary) {
        this.name = name;
        this.id = id;
        this.quarterlyBudget = quarterlyBudget;
        this.numEmployees = numEmployees;
        this.isPrimary = isPrimary;
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

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", quarterlyBudget=" + quarterlyBudget +
                ", numEmployees=" + numEmployees +
                ", isPrimary=" + isPrimary +
                '}';
    }
}

