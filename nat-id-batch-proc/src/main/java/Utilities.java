import Validation.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class Utilities {
    public static ArrayList<Person> filter(ArrayList<Person> people, String gender) {
        try {
            ArrayList<Person> filtered;
            if (gender.equals("both")) {
                filtered = people.stream().filter(d -> Objects.equals(d.getGender(), "male") || Objects.equals(d.getGender(), "female"))
                        .collect(Collectors.toCollection(ArrayList::new));
            } else if (gender.equals("male") | gender.equals("female"))
                filtered = people.stream().filter(d -> Objects.equals(d.getGender(), gender))
                        .collect(Collectors.toCollection(ArrayList::new));
            else
                throw new RuntimeException("provided gender:" + gender + " does not exist in this context.");
            return filtered;
        }
        catch (Exception e)
        {
            System.out.println("An error occurred filtering by gender, " + e.getMessage());
            ArrayList<Person> empty = new ArrayList<>();
            return empty;
        }

    }
    public static ArrayList<Person> filter(ArrayList<Person> people, boolean validation)
    {
        ArrayList<Person> filtered = people.stream().filter(d -> d.isValid() == validation)
                .collect(Collectors.toCollection(ArrayList::new));
        return filtered;
    }

    public static ArrayList<Person> sorting(ArrayList<Person> people)
    {
        ArrayList<Person> sortedList = people.stream().sorted(Comparator.comparing(d -> d.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
        return sortedList;
    }
    public static ArrayList<Person> sortingByDate(ArrayList<Person> people, String sortingType)
    {

        try {
            ArrayList<Person> sortedList = new ArrayList<>();
            if (sortingType.equals("asc")) {
                sortedList = people.stream().sorted(Comparator.comparing(d -> d.getDate()))
                        .collect(Collectors.toCollection(ArrayList::new));
            } else if (sortingType.equals("desc")) {
                sortedList = people.stream().sorted(Comparator.comparing(d -> d.getDate(), Comparator.reverseOrder()))
                        .collect(Collectors.toCollection(ArrayList::new));
            }
            else
                throw new RuntimeException("could not sort the list, wrong sorting type inserted.");
            return sortedList;
        }
        catch (Exception e) {
            System.out.println("An error occurred sorting by date: " + e.getMessage());
            ArrayList<Person> empty = new ArrayList<>();
            return empty;
        }

    }
}
