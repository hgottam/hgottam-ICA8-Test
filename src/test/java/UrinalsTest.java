import org.example.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UrinalsTest {
    Validation validate=new Validation();

    @Test
    public void validateString(){
        String str="abc";
        Assertions.assertTrue(validate.validateString(str), "Failed");
    }
}
