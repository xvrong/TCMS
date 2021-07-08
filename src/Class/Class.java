package Class;

import Tool.ShowInfoInterface;

public abstract class Class implements ShowInfoInterface {
    private ClassAttribute attribute; // 学历、年级、课程基本属性
    private String classHeader; // 任课老师
    private int year;
    private int maxStudent = 30; // 学生最大人数

    public Class() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public Class(String education, int grade, String courseName, String classHeader, int year, int maxStudent) {
        this.attribute = new ClassAttribute(education, grade, courseName);
        this.classHeader = classHeader;
        this.maxStudent = maxStudent;
        this.year = year;
    }

    public String getClassHeader() {
        return classHeader;
    }

    public void setClassHeader(String classHeader) {
        this.classHeader = classHeader;
    }

    public String getEducation() {
        return attribute.getEducation();
    }

    public void setEducation(String education) {
        attribute.setEducation(education);
    }

    public int getGrade() {
        return attribute.getGrade();
    }

    public void setGrade(int grade) {
        attribute.setGrade(grade);
    }

    public String getCourseName() {
        return attribute.getCourseName();
    }

    public void setCourseName(String courseName) {
        attribute.setCourseName(courseName);
    }
}
