import Validation.Person;
import Validation.ValidateID;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                Person person = validateID.FindingGender(data);
                person.setValid(validateID.IDValidation(data));
                people.add(person);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading the file " + e.getMessage());
        }
        return people;
    }

    public static void printToTxt(String fileName, ArrayList<Person> people,  String header)
    {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(header + "\n");
            for (Person person : people) {
                myWriter.write(person.toString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
    }
}
