package controller;

import java.util.regex.Pattern;

/**
 *
 * @author dom_h
 */
public class Validator {
    private Pattern emailPattern = Pattern.compile("([a-zA-Z0-9._-]+)(@)([a-zA-Z0-9]+)(.)([a-zA-Z0-9._-]+)"); // Emails only
    private Pattern passwordPattern = Pattern.compile("([a-zA-Z0-9#&*<>/,.%()^?@_!$]{6,32}+)");//6-32 reg characters with at least 1 special char
    private Pattern namePattern = Pattern.compile("([a-zA-Z\\s]{1,50})");          // Letters only  1 to 50 characters
    private Pattern descPattern = Pattern.compile("([a-zA-Z0-9\\s]{1,1000})");  // Letters number and whitespaces - 1 to 1000 characters
    private Pattern lonLatPattern = Pattern.compile("([0-9]+)(.)([0-9]+)");     // Numbers with a decimal point in between 

    
    public boolean validate(Pattern pattern, String in){                        // Matches predefined pattern to string, returns boolean match
    return pattern.matcher(in).matches();
    }
    public boolean validateEmail(String email) {                                // Takes string and uses email pattern to match
        return validate(emailPattern, email);
    }

    public boolean validatePassword(String password) {                          // Takes string and uses password pattern to match
        return validate(passwordPattern, password);
    }
    
    public boolean validateName(String name) {                                  // Takes string and uses Name pattern to match
        return validate(namePattern, name);
    }
    
    public boolean validateDesc(String desc) {                                  // // Takes string and uses desc pattern to match
        return validate(descPattern, desc);
    }
    
    public boolean validateLonLat(String lonLat){
        return validate(lonLatPattern, lonLat);
    }
}
