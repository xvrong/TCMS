package Person;

public abstract class Person {
    private String name;
    private String sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Person(final String name, final String sex, final int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Person() {
    }
}
