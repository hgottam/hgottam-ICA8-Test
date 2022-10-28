import jdk.jfr.Description;
import org.example.Inputs;
import org.example.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

public class UrinalsTest {
    public static Validation validate;
    public static Inputs inputs;
    @BeforeAll
    public static void setup() {
         validate = new Validation();
         inputs = new Inputs();
    }
    @Test
    @Description("This method tests if the current string is valid or not")
    public void testValidateString(){
        System.out.println("=====HARI PRIYA==== TEST ONE EXECUTED======");
        String str="1001";
        Assertions.assertTrue(validate.validateString(str), "Invalid string");
    }

    @Test
    @Description("Tests if the input file has content or not")
    public void testHasFileContent() throws Exception
    {
        System.out.println("=====HARI PRIYA==== TEST TWO EXECUTED======");
        File f=new File("./src/main/resources/urinals.txt");
        Assertions.assertTrue(inputs.hasFileContent(f), "File content doesnt exits");
    }

    @Test
    @Description("Tests the count of urinals at one instance")
    public void testUrinalCount(){
        System.out.println("=====HARI PRIYA==== TEST THREE EXECUTED======");
        String str="100101";
        Assertions.assertEquals(validate.urinalCount(str),6,"Incorrect count");

    }

    @Test
    @Description("tests if the file exists")
    public void testIsFileExist(){
        System.out.println("=====HARI PRIYA==== TEST FOUR EXECUTED======");
        File f=new File("./src/main/resources/urinals.txt");
        Assertions.assertTrue(inputs.isFileExist(f),"File doesnt exist");
    }

    @Test
    @Description("Tests if string length lies between 1 and 20")
    public void testValidateLength(){
        System.out.println("=====HARI PRIYA==== TEST FIVE EXECUTED======");
        Assertions.assertTrue(validate.validateLength("100100"), "Invalid length");
    }

    @Test
    @Description("Tests the maximum persons that can be accomodated for given urinal string")
    public void testMaxUrinalAccomodation(){
        System.out.println("=====HARI PRIYA==== TEST SIX EXECUTED======");
        String str="10001100";
        int answer= validate.maxAUrinalAccomodation(str);
        Assertions.assertEquals(2, answer,"Incorrect answer");
    }
    @Test()
    @Description("Tests if data to file if written properly")
    public void testBadFileName(){
        System.out.println("=====HARI PRIYA==== TEST SEVEN EXECUTED======");
        Assertions.assertFalse(inputs.badFileName(),"Bad File name ");
    }
}
