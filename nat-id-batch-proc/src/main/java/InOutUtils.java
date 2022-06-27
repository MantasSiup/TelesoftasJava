import Validation.Person;
import Validation.ValidateID;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InOutUtils {
    public static ArrayList<Person> readFromTxt(String fileName) {
        ValidateID validateID = new ValidateID();
        ArrayList<Person> people = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Person person = validateID.constructingPerson(data);
                person.setValid(validateID.idValidation(data));
                people.add(person);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return people;
    }
}
