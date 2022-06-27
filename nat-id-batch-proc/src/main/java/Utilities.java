import Validation.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Utilities {
    public static ArrayList<Person> filter(ArrayList<Person> people, String gender) {
        ArrayList<Person> filtered = people.stream().filter(d -> Objects.equals(d.getGender(), gender))
                .collect(Collectors.toCollection(ArrayList::new));
        return filtered;
    }

    public static ArrayList<Person> filter(ArrayList<Person> people, String gender, String gender2) {
        ArrayList<Person> filtered = people.stream().filter(d -> Objects.equals(d.getGender(), gender) || Objects.equals(d.getGender(), gender2))
                .collect(Collectors.toCollection(ArrayList::new));
        return filtered;
    }

    public static ArrayList<Person> sorting(ArrayList<Person> people)
    {
        ArrayList<Person> sortedList = people.stream().sorted(Comparator.comparing(d -> d.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
        return sortedList;
    }
    public static ArrayList<Person> sortingByDate(ArrayList<Person> people)
    {
        ArrayList<Person> sortedList = people.stream().sorted(Comparator.comparing(d -> d.getDate()))
                .collect(Collectors.toCollection(ArrayList::new));
        return sortedList;
    }
}
