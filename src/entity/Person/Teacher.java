/*
 * @Author: xv_rong
 * @Date: 2021-07-06 20:35:40
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 16:56:27
 * @Description: Teacher
 * @FilePath: \TCMS\src\entity\Person\Teacher.java
 */
package entity.Person;

public class Teacher extends Person {
    private int teacherID; // 老师ID号
    private double salary; // 工资
    private boolean state; // 状态

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Teacher() {
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
