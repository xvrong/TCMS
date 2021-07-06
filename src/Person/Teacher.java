package Person;

public class Teacher extends Person {
    String ID;

    public Teacher(String name, String sex, int age, String ID) {
        super(name, sex, age);
        this.ID = ID;
    }

    public Teacher() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
