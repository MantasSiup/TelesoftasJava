import Validation.Person;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.ArrayList;

@Command(
    name="helloName",
    description = "It prints hello [name]"
)
public class Controller implements Runnable{


    public static void main(String[] args){
      new CommandLine(new Controller()).execute(args);



    }
    @Parameters(index = "0", description = "the name to print")
    private String name;
    @Option(names = {"-f", "--firstName"}, description = "testing")
    private boolean allCaps = false;
    @Override
    public void run() {
        ArrayList<Person> people = InOutUtils.readFromTxt("src/main/resources/in.txt");
<<<<<<< Updated upstream

=======
        ArrayList<Person> filtered = Utilities.filter(people, "male", "female");
        ArrayList<Person> Sorted = Utilities.sorting(people);
>>>>>>> Stashed changes
        System.out.println("Hello " + (allCaps ? name.toUpperCase() : name));
    }
}
