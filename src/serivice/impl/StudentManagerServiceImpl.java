/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 21:44:53
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 11:50:14
 * @Description: 
 * @FilePath: \TCMS\src\serivice\impl\StudentManagerServiceImpl.java
 */

package serivice.impl;

import java.util.ArrayList;

import SQL.Query;
import SQL.Impl.QueryImpl;
import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.TClass.TClass;
import serivice.StudentManagerService;
import windows.GetInput;
import windows.Print;
import windows.impl.GetInputImpl;
import windows.impl.PrintImpl;

public class StudentManagerServiceImpl implements StudentManagerService {

    @Override
    public void showCertainClassStudent() {

        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> classList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(classList);
        ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
        pt.printStudentBasicInfomation(studentList);
    }

    @Override
    public void showAllStudent() {
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        ArrayList<Student> studentList = qy.query

    }

    @Override
    public void showCertainTeacherStudent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showCertainStudent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addStudent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteStudent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void changeStudentClass() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showCertainStudentNowClass() {
        // TODO Auto-generated method stub

    }

    @Override
    public void showCertainStudentHistoryClass() {
        // TODO Auto-generated method stub

    }
}
