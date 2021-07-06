package Person;

import Class.ClassAttribute;

public class Student extends Person {
    private String studentID; // 学生ID
    private ClassAttribute classAttribute; // 班级基本信息 学历，年级，班级

    @Override
    public void showInfo() {
        // TODO Auto-generated method stub

    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(final String studentID) {
        this.studentID = studentID;
    }

    public ClassAttribute getClassAttribute() {
        return classAttribute;
    }

    public void setClassAttribute(final ClassAttribute classAttribute) {
        this.classAttribute = classAttribute;
    }

    public Student(final String name, final String sex, final int age, final String studentID) {
        super(name, sex, age);
        this.studentID = studentID;
    }

    public Student() {
    }

    // 套娃属性
    public String getEducation() {
        return classAttribute.getEducation();
    }

    public void setEducation(final String education) {
        classAttribute.setEducation(education);
    }

    public int getGrade() {
        return classAttribute.getGrade();
    }

    public void setGrade(final int grade) {
        classAttribute.setGrade(grade);
    }

    public int getClassNumber() {
        return classAttribute.getClassNumber();
    }

    public void setClassNumber(final int classNumber) {
        classAttribute.setClassNumber(classNumber);
    }

}

// class OldClass {
// private String name;
// private int point;

// public OldClass(String name, int point) {
// this.name = name;
// this.point = point;
// }

// public OldClass() {

// }

// public String getName() {
// return name;
// }

// public void setName(String name) {
// this.name = name;
// }

// public int getPoint() {
// return point;
// }

// public void setPoint(int point) {
// this.point = point;
// }

// }