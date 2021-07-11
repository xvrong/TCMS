/*
 * @Author: xv_rong
 * @Date: 2021-07-06 20:46:51
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 12:12:43
 * @Description: 
 * @FilePath: \TCMS\src\entity\Course\Course.java
 */
package entity.Course;

import Tool.Education;

public class Course {
    private String name; // 课程名
    private double price; // 价格
    private int CourseId; // 课程Id
    private Education edu; // 学历 （小学 初中 高中）
    private boolean state; // 状态

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public Education getEdu() {
        return edu;
    }

    public void setEdu(Education edu) {
        this.edu = edu;
    }

}
