package Validation;
import java.util.ArrayList;

public class ValidateID {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        int j = 0;
            for (String data : args) {
                int remainder = -1;
                if (data.charAt(0) == '3' || data.charAt(0) == '5') {
                    Person person = new Person(data, data.substring(1, 7), "male");
                    remainder = RemainderCalculation(person.getId());
                    people.add(person);

                } else if (data.charAt(0) == '4' || data.charAt(0) == '6') {
                    Person person = new Person(data, data.substring(1, 7), "female");
                    remainder = RemainderCalculation(person.getId());
                    people.add(person);
                }


                if (remainder == Character.getNumericValue(people.get(j).getId().charAt(10)))
                    people.get(j).setValid(true);
                else
                    people.get(j).setValid(false);
                System.out.println(people.get(j));
                System.out.println(remainder);
                j++;

            }

        }

        public static int RemainderCalculation(String id) {

            int sum = 0;
            for (int i = 1; i <= 9; i++) {
                sum += Character.getNumericValue(id.charAt(i - 1)) * i;
            }
            sum += Character.getNumericValue(id.charAt(9));
            int remainder = sum % 11;
            if (remainder == 10) {
                for (int i = 3; i <= 9; i++) {
                    sum += Character.getNumericValue(id.charAt(i - 3)) * i;
                }
                for (int i = 1; i <= 3; i++) {
                    sum += Character.getNumericValue(id.charAt(i + 6)) * i;
                }
                remainder = sum % 11;
            }
            if (remainder == 10)
                remainder = 0;

            return remainder;
        }
}
