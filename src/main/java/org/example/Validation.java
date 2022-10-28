package org.example;

public class Validation {
    public boolean validateString(String str){
            boolean valid = true;
            int n = urinalCount(str);
            for (int i = 0; i < n - 1; i++) {
                if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                    invalidString(str);
                    valid = false;
                    break;
                } else if (str.charAt(i) == '1') {
                    if (str.charAt(i + 1) == '1') {
                        valid = false;
                        break;
                    }
                }
            }
            if (str.charAt(str.length() - 1) != '0' && str.charAt(str.length() - 1) != '1')
                valid = false;
            return valid;
        }

    public int urinalCount(String str){
        return str.length();
    }
    public void invalidString(String str){
        System.out.println(str+" is an Invalid String");
    }
    public int maxAUrinalAccomodation(String str){
        int count=0;
        char[] position =str.toCharArray();
        if(position.length>1) {
            if (position[0] == '0' && position[1] == '0') {
                position[0] = '1';
                count++;
            }
            for (int i = 1; i < urinalCount(str) - 1; i++) {
                if (position[i] == '0') {
                    if (position[i - 1] == '0' && position[i + 1] == '0') {
                        position[i] = '1';
                        count++;
                    }
                }
            }
            if (position[position.length - 1] == '0' && position[position.length - 2] == '0') {
                count++;
            }
        }
        else{
            if(position[0]=='1')
                count=0;
            else
                count=1;
        }
        return count;
    }
    public boolean validateLength(String str) {
        return urinalCount(str) >= 1 && urinalCount(str) <= 20;
    }
}
