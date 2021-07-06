package Person;

import java.util.ArrayList;

import Class.ClassAttribute;

public class Student extends Person {
    private String studentID;
    ClassAttribute classAttribute;

    ArrayList<OldClass> oldCourse = new ArrayList<OldClass>();

    public Student(final String name, final String sex, final int age, final String studentID) {
        super(name, sex, age);
        this.studentID = studentID;
    }

    public Student() {
    }

    public String getId() {
        return studentID;
    }

    public void setId(final String studentID) {
        this.studentID = studentID;
    }

    // 套娃属性
    public String getEducation() {
        return classAttribute.getEducation();
    }

    public void setEducation(String education) {
        classAttribute.setEducation(education);
    }

    public int getGrade() {
        return classAttribute.getGrade();
    }

    public void setGrade(int grade) {
        classAttribute.setGrade(grade);
    }

    public int getClassNumber() {
        return classAttribute.getClassNumber();
    }

    public void setClassNumber(int classNumber) {
        classAttribute.setClassNumber(classNumber);
    }
}

class OldClass {
    private String name;
    private int point;

    public OldClass(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public OldClass() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}