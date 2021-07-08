package Person;

public class Student extends Person {
    private String studentID; // 学生ID

    @Override
    public void showInfo() {
        // TODO 打印学生的ID和姓名

    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Student(String name, String sex, int age, String studentID) {
        super(name, sex, age);
        this.studentID = studentID;
    }

    public Student() {
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