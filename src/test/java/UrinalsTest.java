import jdk.jfr.Description;
import org.example.Inputs;
import org.example.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;


public class UrinalsTest {
    Validation validate=new Validation();
    @Test
    @Description("This method tests if the current string is valid or not")
    public void testValidateString(){
        String str="10010";
        Assertions.assertTrue(validate.validateString(str), "Invalid string");
    }


    @Test
    @Description("Tests if the input file has content or not")
    public void testHasFileContent() throws Exception
    {
        Inputs inputs=new Inputs();
        File f=new File("./src/main/resources/urinals.txt");
        Assertions.assertTrue(inputs.hasFileContent(f), "File content doesnt exits");
    }
}
