package big4exercise;

public class BlueJay extends Bird implements IZoo {

    private final String shadeOfBlue;

    public BlueJay(String commonName, int weight, int wingSpan, String shadeOfBlue) {
        super(commonName, weight, wingSpan);
        this.shadeOfBlue = shadeOfBlue;
    }

    @Override
    public String onParkOpen() {
        return "Play with bird friends!";
    }

    @Override
    public String onParkClose() {
        return "Go to the nest and sleep.";
    }

    @Override
    public String toString() {
        return "BlueJay{" +
                "shadeOfBlue='" + shadeOfBlue + '\'' +
                ", commonName='" + commonName + '\'' +
                ", weight=" + weight +
                ", wingSpan=" + wingSpan +
                '}';
    }


}
