/*
 * @Author: xv_rong
 * @Date: 2021-07-10 21:36:02
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:45:58
 * @Description: 
 * @FilePath: \TCMS\src\serivice\impl\CourseManagerServiceImpl.java
 */
package serivice.impl;

import java.util.ArrayList;
import Tool.Education;
import entity.Course.Course;
import entity.TClass.TClass;
import serivice.CourseManagerService;

public class CourseManagerServiceImpl implements CourseManagerService {

    @Override
    public void showAllTCourse() {
        ArrayList<Course> courseList = qy.queryCourse(true);
        pt.printCourseBasicInfomation(courseList);
    }

    @Override
    public void showAllTClassCertainCourse() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        pt.printTClassBasicInfomation(tClassList);
    }

    @Override
    public void addCourse() {
        Course course = new Course();
        String courseName = get.getInputName();
        course.setName(courseName);
        Education edu = get.getInputEducation();
        course.setEdu(edu);
        qy.IsExistCourse(edu, courseName, true);
        double price = get.getInputSalary();
        course.setPrice(price);
        ArrayList<Course> courseList = new ArrayList<Course>();
        pt.printCourseBasicInfomation(courseList);
        if (get.getInputYN())
            up.addCourse(course);
    }

    @Override
    public void setCoursePrice() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        if (qy.IsExistCourse(courseId, true)) {
            double price = get.getInputSalary();
            up.setCoursePrice(courseId, price);
            System.out.println("修改成功");
        } else {
            System.out.println("此课程不存在");
        }

    }

    @Override
    public void deleteCourse() {
        int courseId = get.getInputId();
        if (qy.IsExistCourse(courseId, true)) {
            ArrayList<TClass> tClssList = qy.queryTClass(courseId, true);
            if (tClssList.size() == 0) {
                boolean flag = up.deleteCourse(courseId);
                if (flag) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            } else {
                System.out.println("此课程有正在进行的班级，无法删除");
            }
        } else {
            System.out.println("此课程不存在");
        }

    }

    @Override
    public void run() {
        int func = -1;
        while (func != 0) {
            System.out.println("-----------------课程管理----------------");
            System.out.println("1.显示当前存在的所有课程");
            System.out.println("2.显示某一课程的所有班级");
            System.out.println("3.增加一门课程");
            System.out.println("4.删除一门课程");
            System.out.println("5.设置一门课程的价格");
            System.out.println("0.退出");
            func = get.getInputFunction(5);
            switch (func) {
                case 1:
                    showAllTCourse();
                    get.getInputEnter();
                    break;
                case 2:
                    showAllTClassCertainCourse();
                    get.getInputEnter();
                    break;
                case 3:
                    addCourse();
                    get.getInputEnter();
                    break;
                case 4:
                    deleteCourse();
                    get.getInputEnter();
                    break;
                case 5:
                    setCoursePrice();
                    get.getInputEnter();
                    break;
                default:
                    break;
            }
        }
    }
}
