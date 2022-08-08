package exceptions;

import java.util.regex.Pattern;

public class Phone {
    private final String carrier;
    private final String number;
    private final String numberRegEx = "^(?:\\d{1}\\s)?\\(?(\\d{3})\\)?-?\\s?(\\d{3})-?\\s?(\\d{4})$";
    private final Pattern numberPattern = Pattern.compile(numberRegEx);

    public Phone(String carrier, String number) {

        this.carrier = carrier;
        if (isNumberValid(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Phone number is not valid");
        }
    }

    public String getCarrier() {
        return carrier;
    }

    public String getNumber() {
        return number;
    }

    private boolean isNumberValid(String number) {
        if (numberPattern.matcher(number).matches()) {
            // phone number is valid
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneType='" + carrier + '\'' +
                ", phoneNumber='" + number + '\'' +
                '}';
    }
}
