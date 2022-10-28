package org.example;

import java.io.*;
import java.util.*;

public class Inputs {
    /**
     * This class takes input from user whether to scan the string from file or the user wants to enter it.
     */
    public File outputFile;
    public static int increment=1;
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
        ArrayList<String> answer =new ArrayList<>();
        while((line)!=null){
            if(!validate.validateLength(line))
                answer.add(String.valueOf(-1));
            else {
                if (validate.validateString(line)) {
                    answer.add(String.valueOf(validate.maxAUrinalAccomodation(line)));
                }
                else{
                    answer.add("-1");
                }
                line = in.readLine();
            }
            writeToFile(answer);
        }
    }
    public boolean isFileExist(File f){
       return f.exists();
    }
    public void writeToFile(ArrayList<String> answer){
        BufferedWriter output = null;
        try {
            if(outputFile==null)
                outputFile = new File("./src/main/resources/output/rule.txt");

            if(isFileExist(outputFile)) {
                createNewFile();
            }

            output = new BufferedWriter(new FileWriter(outputFile));
            for (String s : answer) output.write(s + "\n");
        } catch ( IOException e ) {
           System.out.println("Couldn't write to the file");
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                }catch (IOException e){
                    System.out.println("Couldn't close the file");
                }
            }
        }
    }
    public void createNewFile(){
        String path="./src/main/resources/output/rule"+(increment++)+".txt";
        this.outputFile = new File(path);
    }

    public boolean badFileName(){
        File[] files = new File("./src/main/resources/output").listFiles();
        assert files != null;
        for (File file : files) {
            if(!file.getName().contains("rule")){
            System.out.println("Bad file name: "+file.getName());
            return true;
            }
        }
        return false;
    }
}
