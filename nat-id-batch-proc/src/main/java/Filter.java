import Validation.Person;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Filter {
    public static ArrayList<Person> filter(ArrayList<Person> people, String gender)
    {
        ArrayList<Person> filtered = people.stream().filter(d -> Objects.equals(d.getGender(), gender))
                .collect(Collectors.toCollection(ArrayList::new));
        return filtered;
    }
    public static ArrayList<Person> filter(ArrayList<Person> people, String gender, String gender2)
    {
        ArrayList<Person> filtered = people.stream().filter(d -> Objects.equals(d.getGender(), gender) || Objects.equals(d.getGender(), gender2))
                .collect(Collectors.toCollection(ArrayList::new));
        return filtered;
    }
}
