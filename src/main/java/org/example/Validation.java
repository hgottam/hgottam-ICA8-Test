package org.example;

public class Validation {
    public boolean validateString(String str){
        if(str.charAt(0)!='1' ||str.charAt(0)!='0')
            return false;
        return true;
    }
}
