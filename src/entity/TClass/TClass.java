/*
 * @Author: xv_rong
 * @Date: 2021-07-06 20:35:40
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-14 09:41:34
 * @Description:  class
 * @FilePath: \TCMS\src\entity\TClass\TClass.java
 */
package entity.TClass;

import Tool.Education;

public class TClass {
    private int classID; // 班级ID
    private int courseID; // 课程ID
    private String CourseName; // 课程名称
    private int teacherID; // 老师ID
    private String teacherName; // 老师说姓名
    private int studentNum; // 学生数
    private Education education; // 学历 （小学 初中 高中）
    private int grade; // 年级
    private int startYear; // 开班年份
    private int orderNumber; // 班序号
    private int maxStudentNum; // 最大学生数
    private boolean state; // 状态

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getMaxStudentNum() {
        return maxStudentNum;
    }

    public void setMaxStudentNum(int maxStudentNum) {
        this.maxStudentNum = maxStudentNum;
    }

    public TClass() {
    }

}
