package Validation;

public class Person {
    private String id;
    private String date;
    private String gender;
    private boolean isValid;


    public Person(String id, String date, String gender) {
        this.id = id;
        this.date = date;
        this.gender = gender;
    }

    public Person() {
        this.id = "Unknown id";
        this.date = "Unknown date";
        this.gender = "Unknown gender";
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", isValid=" + isValid +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getGender() {
        return gender;
    }
}
