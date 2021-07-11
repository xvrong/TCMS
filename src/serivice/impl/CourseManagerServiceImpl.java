/*
 * @Author: xv_rong
 * @Date: 2021-07-10 21:36:02
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 19:49:56
 * @Description: 
 * @FilePath: \TCMS\src\serivice\impl\CourseManagerServiceImpl.java
 */
package serivice.impl;

import java.util.ArrayList;

import SQL.Query;
import SQL.Impl.QueryImpl;
import entity.Course.Course;
import serivice.CourseManager;
import windows.Print;
import windows.impl.PrintImpl;

public class CourseManagerServiceImpl implements CourseManager {

    @Override
    public void showAllTCourse() {
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        ArrayList<Course> courseList = qy.queryCourse(true);
        pt.printCourseBasicInfomation(courseList);
    }

    @Override
    public void showAllTClassCertainCourse() {

    }

    @Override
    public void addCourse() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCoursePrice() {
        // TODO Auto-generated method stub

    }

}
