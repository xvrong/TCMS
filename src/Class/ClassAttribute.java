package Class;

public class ClassAttribute {
    private String education;
    private int grade;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ClassAttribute(String education, int grade, String courseName) {
        this.education = education;
        this.grade = grade;
        this.courseName = courseName;
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

}
