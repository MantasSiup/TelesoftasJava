package Validation;

public class ValidateID {
        public static void main(String[] args)
        {

        }

        public static boolean IDValidation(String id)
        {
            Person person = FindingGender(id);
            int remainder = RemainderCalculation(person.getId());
            person.setValid(remainder == Character.getNumericValue(person.getId().charAt(10)));
            return person.isValid();
        }

        public static int RemainderCalculation(String id)
        {
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

        public static Person FindingGender(String id)
        {
            Person person = new Person();
            if (id.charAt(0) == '3' || id.charAt(0) == '5') {
                person = new Person(id, id.substring(1, 7), "male");

            } else if (id.charAt(0) == '4' || id.charAt(0) == '6') {
                person = new Person(id, id.substring(1, 7), "female");
            }
            return person;
        }
}
