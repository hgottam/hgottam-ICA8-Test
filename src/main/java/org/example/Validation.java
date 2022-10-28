package org.example;

public class Validation {
    public boolean validateString(String str){
        boolean valid=true;
        int n=urinalCount(str);
        for(int i=0;i<n-1;i++){
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

    public int urinalCount(String str){
        return str.length();
    }
}
