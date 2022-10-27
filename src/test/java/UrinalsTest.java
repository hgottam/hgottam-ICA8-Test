import org.example.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UrinalsTest {
    Validation validate=new Validation();

    @Test
    public void testValidateString(){
        String str="10010";
        Assertions.assertEquals(validate.validateString(str), true, "Invalid string");
    }
}
