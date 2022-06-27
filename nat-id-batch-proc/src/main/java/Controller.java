import Validation.Person;
import Validation.ValidateID;
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
        ArrayList<Person> filtered = Filter.filter(people, "male", "female");
        System.out.println("Hello " + (allCaps ? name.toUpperCase() : name));
    }
}
