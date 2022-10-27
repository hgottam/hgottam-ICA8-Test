package org.example;

import java.io.*;
import java.util.*;

public class Inputs {
    /**
     * This class takes input from user whether to scan the strgin from file or the user wants to enter it.
     */
    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to enter the input or read from file?");
        System.out.println("Select an option:");
        System.out.println("0-Enter input \n1- Read from file");
        System.out.println();
        while(true) {
            int option = sc.nextInt();
            if (option == 0) {
                keyboardInput();
                break;
            } else if (option == 1) {
                try {
                    fileInput();
                } catch (Exception e) {
                    System.out.println("Cannot open file!");
                }
                break;
            } else {
                System.out.println("Please enter valid option:");
                option = sc.nextInt();
            }
        }
    }
    public void keyboardInput(){
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
        File f=new File("./src/main/resources/urinals.txt");
        if(hasFileContent(f))
            System.out.println("File has content");
        else
            System.out.println("File doesnt have content");
        bw.flush();
    }

    public boolean hasFileContent(File f) throws IOException{
        //File f=new File("./src/main/resources/urinals.txt");
        BufferedReader in = new BufferedReader(new FileReader(f));
        String line = "";
        int c=-1;
        while((line=in.readLine())!=null)
            c++;
        return c>=0;
    }



}
