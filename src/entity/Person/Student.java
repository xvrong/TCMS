/*
 * @Author: xv_rong
 * @Date: 2021-07-06 20:35:40
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 12:12:53
 * @Description: Student
 * @FilePath: \TCMS\src\entity\Person\Student.java
 */
package entity.Person;

import Tool.Education;

public class Student extends Person {
    private String studentID; // 学生ID
    private Education edu; // 学历
    private boolean state; // 状态

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Education getEdu() {
        return edu;
    }

    public void setEdu(Education edu) {
        this.edu = edu;
    }

    public Student() {
    }

}
