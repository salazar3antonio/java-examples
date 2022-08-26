package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample {

    public static void main(String[] args) {

        String myEmail = "johndoe@email.com";
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(myEmail);

        System.out.println(emailMatcher.matches());

        System.out.println(isEmailValidRegEx(myEmail, emailPattern));

    }

    public static boolean isEmailValidRegEx(String email, Pattern emailPattern) {
        return emailPattern.matcher(email).matches();
    }


}
