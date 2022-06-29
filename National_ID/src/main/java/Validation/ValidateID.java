package Validation;

public class ValidateID {
        public static void main(String[] args)
        {

        }

        public boolean idValidation(String id)
        {
            Person person = constructingPerson(id);
            if (person.getId().length() != 11)
                person.setValid(false);
            else {
                int remainder = remainderCalculation(person.getId());
                person.setValid(remainder == Character.getNumericValue(person.getId().charAt(10)));

            }
            return person.isValid();
        }

        public int remainderCalculation(String id)
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

        public Person constructingPerson(String id)
        {
            Person person = new Person();
            int date;
            if (id.length() != 11)
            {
                person.setId(id);
                person.setValid(false);
            }
                else
            {
                if (Integer.parseInt(id.substring(1,7)) > 220600)
                    date = Integer.parseInt(id.substring(1,7)) + 19000000;
                else
                    date = Integer.parseInt(id.substring(1,7)) + 20000000;
                switch (id.charAt(0)) {
                    case '3', '5' -> person = new Person(id, date, "male");
                    case '4', '6' -> person = new Person(id, date, "female");
                }
            }
            return person;
        }
}
