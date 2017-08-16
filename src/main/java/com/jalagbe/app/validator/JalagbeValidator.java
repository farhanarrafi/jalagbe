package com.jalagbe.app.validator;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by WhiteConsole on 8/15/2017.
 */

@Component
public class JalagbeValidator {

    private boolean isCheckAble(Integer min, Integer max){
        if(min != null && max != null) {
            return true;
        }
        return false;
    }

    public boolean isValidString(String value, Integer minSize, Integer maxSize){

        if(value != null && !value.isEmpty()){
            if(isCheckAble(minSize, maxSize)) {
                if(value.length() < minSize || value.length() > maxSize) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isValidString(String value){
        return isValidString(value, null, null);
    }

    public boolean isValidInteger(Integer value, Integer minValue, Integer maxValue) {
        if(value != null && value != 0) {
            if(isCheckAble(minValue, maxValue)) {
                if(value < minValue || value > maxValue) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean isValidInteger(Integer value) {
        return isValidInteger(value, null, null);
    }

    public boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public boolean isValidEmail(String emailStr){
        Pattern validEmailRegex =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = validEmailRegex .matcher(emailStr);
        return matcher.find();
    }

    public boolean isValidPassword(String password, Integer minLength, Integer maxLength) {
        return isValidString(password, minLength, maxLength);
    }

    public boolean isValidAdminPassword(String password, Integer minLength, Integer maxLength) {
        String regex = "([\\.\\-\\s+\\/()]*[a-zA-Z0-9][\\.\\-\\s+\\/()]*){8,15}";
        if (isValidString(password, minLength, maxLength)) {
            return password.matches(regex);
        }
        return false;
    }

}
