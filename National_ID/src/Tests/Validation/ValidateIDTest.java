package Validation;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ValidateIDTest {


    @Test
    public void testRemainderCalculation() {
        ValidateID tester = new ValidateID();
        assertEquals("44104154428 calculated remainder must be 3 ", 3, tester.RemainderCalculation("44104154428"));
        assertEquals("34409157850 calculated remainder must be 0 ", 0, tester.RemainderCalculation("34409157850"));
        assertEquals("55602038344 calculated remainder must be 5 ", 5, tester.RemainderCalculation("55602038344"));
    }

    @Test
    public void testFindingGender() {
        ValidateID tester = new ValidateID();

        for (String s1 : Arrays.asList("34409157850", "54409157850, 38601138179", "36007148458","52101021310"))
            assertEquals("3 and 5 must be a male", "male", tester.FindingGender(s1).getGender());


        for (String s : Arrays.asList("44104154428", "64104154428", "40412136548", "42405048129", "66805096280", "68701253995", "48502033998"))
            assertEquals("4 and 6 must be a female", "female", tester.FindingGender(s).getGender());

    }

    @Test
    public void testIDValidation() {
        ValidateID tester = new ValidateID();

        assertTrue("The same control digit means id is valid", tester.IDValidation("34409157850"));
        assertTrue("The same control digit means id is valid", tester.IDValidation("56701126655"));
        assertTrue("The same control digit means id is valid", tester.IDValidation("45611139673"));
        assertTrue("The same control digit means id is valid", tester.IDValidation("63601079885"));
        assertTrue("The same control digit means id is valid", tester.IDValidation("35112013388"));
        assertTrue("The same control digit means id is valid", tester.IDValidation("54607281217"));
    }
}