package Validation;

public class Person {
    private String id;
    private int date;
    private String gender;
    private boolean isValid;


    public Person(String id, int date, String gender) {
        this.id = id;
        this.date = date;
        this.gender = gender;
    }

    public Person() {
        this.id = "Unknown id";
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
