package big4exercise;

public class Penguin extends Bird implements IZoo {

    private int coldestTemperature;

    public Penguin(String commonName, int weight, int wingSpan, int coldestTemperature) {
        super(commonName, weight, wingSpan);
        this.coldestTemperature = coldestTemperature;
    }

    @Override
    public String onParkOpen() {
        return "Start swimming!";
    }

    @Override
    public String onParkClose() {
        return "Huddle up and sleep.";
    }
}
