package BatchProc;

import Validation.Person;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Command(
    name="helloName",
    description = "It prints hello [name]"
)
public class Controller implements Runnable{


    public static void main(String[] args){
      new CommandLine(new Controller()).execute(args);
    }
    @Option(names = {"-i", "--input"}, description = "Input txt file for ids", required = true)
    private String fileName = "file_Name.txt";
    @Option(names = {"-f", "--filter"}, description = "Filtering males, females or both", required = false)
    private String gender;
    @Option(names = {"-sbd", "--sort-by-birth-date"}, description = "Sorting ids by date", required = false)
    private String sortingType;
    @Override
    public void run() {
        //Path path = Paths.get("Documents/GitHub/TelesoftasJava/nat-id-batch-proc/src/main/resources/"); for jar
        Path path = Paths.get("src/main/resources/"); // for consoleapp
            ArrayList<Person> people = InOutUtils.readFromTxt(path.toAbsolutePath() + "\\" + fileName);

            ArrayList<Person> modified = people;
            if (gender != null) {
                modified = Utilities.filter(people, gender);
                gender = gender.toLowerCase();
            }

            modified = Utilities.sorting(modified);
            if (sortingType != null)
                modified = Utilities.sortingByDate(modified, sortingType);

            ArrayList<Person> valid = Utilities.filter(modified, true);
            ArrayList<Person> unValid = Utilities.filter(modified, false);
            InOutUtils.printToTxt("Valid.txt", valid, "Validated IDs " +
                    (gender != null ? "filtered by gender:" + gender : "") +
                    (sortingType != null ? " sorted by date " + sortingType : " sorted by IDs ascending"));
            InOutUtils.printToTxt("UnValid.txt", unValid, "Unvalidated IDs " +
                    (gender != null ? "filtered by gender:" + gender : "") +
                    (sortingType != null ? " sorted by date " + sortingType : " sorted by IDs ascending"));
            System.out.println("Valid ids: " + Utilities.filter(people, true).size() + " out of " + people.size());
    }
}
