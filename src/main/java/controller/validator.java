package controller;

import java.util.regex.Pattern;

/**
 *
 * @author dom_h
 */
public class validator {
    private Pattern emailPattern = Pattern.compile("([a-zA-Z0-9._-]+)(@)([a-zA-Z0-9]+)(.)([a-zA-Z0-9._-]+)");
    private Pattern passwordPattern = Pattern.compile("([a-zA-Z0-9#&*<>/,.%()^?@_!$]{6,32}+)");//6-32 reg characters with at least 1 special char
    private Pattern namePattern = Pattern.compile("([a-zA-Z]+)");
    
    public boolean validate(Pattern pattern, String in){
    return pattern.matcher(in).matches();
    }
    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validateName(String name) {
        return validate(namePattern, name);
    }
}
