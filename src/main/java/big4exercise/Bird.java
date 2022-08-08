package big4exercise;

abstract class Bird {

    String commonName;
    int weight;
    int wingSpan;

    public Bird(String commonName, int weight, int wingSpan) {
        this.commonName = commonName;
        this.weight = weight;
        this.wingSpan = wingSpan;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(int wingSpan) {
        this.wingSpan = wingSpan;
    }
}
