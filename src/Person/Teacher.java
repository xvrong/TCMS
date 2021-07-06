package Person;

import Class.ClassAttribute;

public class Teacher extends Person {
    private String teacherID;
    private boolean isClassHeader;
    private ClassAttribute classAttribute;
    private boolean isTakingCourse;
    private String takingCourse;
    private double salary;

    public Teacher(final String name, final String sex, final int age, final String teacherID,
            final boolean isClassHeader, final ClassAttribute classAttribute, final boolean isTakingCourse,
            final String takingCourse, final double salary) {
        super(name, sex, age);
        this.teacherID = teacherID;
        this.isClassHeader = isClassHeader;
        this.classAttribute = classAttribute;
        this.isTakingCourse = isTakingCourse;
        this.takingCourse = takingCourse;
        this.salary = salary;
    }

    public Teacher() {
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(final String teacherID) {
        this.teacherID = teacherID;
    }

    public boolean isClassHeader() {
        return isClassHeader;
    }

    public void setClassHeader(final boolean isClassHeader) {
        this.isClassHeader = isClassHeader;
    }

    public ClassAttribute getClassAttribute() {
        return classAttribute;
    }

    public void setClassAttribute(final ClassAttribute classAttribute) {
        this.classAttribute = classAttribute;
    }

    public boolean isTakingCourse() {
        return isTakingCourse;
    }

    public void setTakingCourse(final boolean isTakingCourse) {
        this.isTakingCourse = isTakingCourse;
    }

    public String getTakingCourse() {
        return takingCourse;
    }

    public void setTakingCourse(final String takingCourse) {
        this.takingCourse = takingCourse;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    @Override
    public void showInfo() {
        // TODO Auto-generated method stub

    }

}
