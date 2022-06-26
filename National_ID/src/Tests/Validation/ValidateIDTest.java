package Validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateIDTest {

    @Test
    public void testMain() {
        ValidateID tester = new ValidateID();

        assertEquals("The same control digit means id is valid", true, tester.main("34409157850"));
        assertEquals("The same control digit means id is valid", true, tester.main("56701126655"));
        assertEquals("The same control digit means id is valid", true, tester.main("45611139673"));
        assertEquals("The same control digit means id is valid", true, tester.main("63601079885"));
        assertEquals("The same control digit means id is valid", true, tester.main("35112013388"));
        assertEquals("The same control digit means id is valid", true, tester.main("54607281217"));
    }

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
        Person male = new Person("", ",", "male");
        assertEquals("3 and 5 must be a male", male.getGender(), tester.FindingGender("34409157850").getGender());
        assertEquals("3 and 5 must be a male", male.getGender(), tester.FindingGender("54409157850").getGender());

        Person female = new Person("", ",", "female");
        assertEquals("4 and 6 must be a female", female.getGender(), tester.FindingGender("44104154428").getGender());
        assertEquals("4 and 6 must be a female", female.getGender(), tester.FindingGender("64104154428").getGender());

    }
}