package Class;

public class ClassAttribute {
    private String education;
    private int grade;
    private int classNumber;

    public ClassAttribute(String education, int grade, int classNumber) {
        this.education = education;
        this.grade = grade;
        this.classNumber = classNumber;
    }

    public ClassAttribute() {
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
