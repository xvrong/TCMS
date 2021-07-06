package Person;

import Tool.ShowInfoInterface;

public abstract class Person implements ShowInfoInterface {
    private String name; // 名字
    private String sex; // 性别
    private int age; // 年龄

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
