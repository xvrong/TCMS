package entity.Person;

public class Teacher extends Person {
    private String teacherID; // 老师ID号
    private boolean isTakingCourse;
    private String takingCourse;
    private double salary;

    public Teacher(String name, String sex, int age, String teacherID, boolean isClassHeader, boolean isTakingCourse,
            String takingCourse, double salary) {
        super(name, sex, age);
        this.teacherID = teacherID;

        this.isTakingCourse = isTakingCourse;
        this.takingCourse = takingCourse;
        this.salary = salary;
    }

    public Teacher() {
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public boolean isTakingCourse() {
        return isTakingCourse;
    }

    public void setTakingCourse(boolean isTakingCourse) {
        this.isTakingCourse = isTakingCourse;
    }

    public String getTakingCourse() {
        return takingCourse;
    }

    public void setTakingCourse(String takingCourse) {
        this.takingCourse = takingCourse;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
