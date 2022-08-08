package classes;

public class Dog {

    private String dogType;
    private String dogName;
    private String dogColor;
    private int dogAge;
    private boolean isFixed;

    public Dog(String dogType, String dogName, String dogColor, int dogAge, boolean isFixed) {
        this.dogType = dogType;
        this.dogName = dogName;
        this.dogColor = dogColor;
        this.dogAge = dogAge;
        this.isFixed = isFixed;
    }


    public String getDogType() {
        return dogType;
    }

    public void setDogType(String dogType) {
        this.dogType = dogType;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }



    @Override
    public String toString() {
        return "Dog{" +
                "dogType='" + dogType + '\'' +
                ", dogName='" + dogName + '\'' +
                ", dogColor='" + dogColor + '\'' +
                ", dogAge=" + dogAge +
                ", isFixed=" + isFixed +
                '}';
    }
}
