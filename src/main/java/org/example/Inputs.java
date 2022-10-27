package org.example;

import java.io.*;
import java.util.*;

public class Inputs {
    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to enter the input or read from file?");
        System.out.println("Select an option:");
        System.out.println("0-Enter input \n1- Read from file");
        System.out.println();
        int option = sc.nextInt();
        if (option == 0) {
           keyboardInput();
        }
        else {
            try {
                fileInput();
            } catch (Exception e) {
            }
        }
    }
    public void keyboardInput(){
        Scanner sc=new Scanner(System.in);
        String str="testString";
        Validation validate=new Validation();
        validate.validateString(str);
//        while(Integer.parseInt(str)!=-1){
//            Validation validate=new Validation();
//            validate.validateString(str);
//            str="-1";
//        }
    }
    public void fileInput() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
    }



}
