package org.example;

public class Validation {
    public boolean validateString(String str){
        boolean valid=true;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)!='0'&& str.charAt(i)!='1' ){
                valid=false;
                break;
            }
            else if(str.charAt(i)=='1') {
                if (str.charAt(i + 1) == '1') {
                    valid = false;
                    break;
                }
            }
        }
        if(str.charAt(str.length()-1)!='0' && str.charAt(str.length()-1)!='1')
            valid=false;
        return valid;
    }
}
