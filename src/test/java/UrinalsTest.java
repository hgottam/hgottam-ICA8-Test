import jdk.jfr.Description;
import org.example.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class UrinalsTest {
    Validation validate=new Validation();
    @Test
    public void testValidateString(){
        String str="10010";
        Assertions.assertTrue(validate.validateString(str), "Invalid string");
    }


    @Test
    @Description("Tests if the input file has content or not")
    public void testFileInput() throws Exception
    {

        File f=new File("./src/main/resources/urinals.txt");
        BufferedReader in = new BufferedReader(new FileReader(f));
        String line = "";
        int c=-1;
        while((line=in.readLine())!=null)
            c++;
        Assertions.assertTrue(c>=0, "File content doesnt exits");
    }
}
