package org.example;

import java.io.*;
import java.util.*;

public class Inputs {
    /**
     * This class takes input from user whether to scan the string from file or the user wants to enter it.
     */
    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to enter the input or read from file?");
        System.out.println("Select an option:");
        System.out.println("0-Enter input \n1- Read from file");
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
            }
        }
    }
    public void keyboardInput(){
        Scanner sc=new Scanner(System.in);
        Validation validate=new Validation();
        System.out.println("Enter String:");
        String str=sc.nextLine();
        while(!str.equals("-1")){
            if(!validate.validateLength(str))
                System.out.println("-1");
            else {
                if (!validate.validateString(str))
                    System.out.println("-1");
                else {
                    System.out.println(validate.maxAUrinalAccomodation(str));
                }
                System.out.println("enter again");
                str = sc.nextLine();
            }
        }
    }
    public void fileInput() throws IOException {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        File f=new File("./src/main/resources/urinals.txt");
        boolean isFileExist= isFileExist(f);
        if(isFileExist) {
            if (!hasFileContent(f)) {
                System.out.println("File doesnt have content");
                return;
            }
            validateFileInputString(f);
        }

        bw.flush();
    }

    public boolean hasFileContent(File f) throws IOException{
        //File f=new File("./src/main/resources/urinals.txt");
        BufferedReader in = new BufferedReader(new FileReader(f));
        int c=-1;
        while((in.readLine())!=null)
            c++;
        return c>=0;
    }

    public void validateFileInputString(File f) throws  IOException{
        BufferedReader in = new BufferedReader(new FileReader(f));
        String line=in.readLine();
        Validation validate=new Validation();
        while((line)!=null){
            if(!validate.validateLength(line))
                System.out.println("-1");
            else {
                if (validate.validateString(line))
                    validate.maxAUrinalAccomodation(line);
                line = in.readLine();
            }
        }
    }
    public boolean isFileExist(File f){
       return f.exists();
    }



}
