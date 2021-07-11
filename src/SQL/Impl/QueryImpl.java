/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 23:45:56
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 12:14:09
 * @Description: 
 * @FilePath: \TCMS\src\SQL\Impl\QueryImpl.java
 */
package SQL.Impl;

import java.util.ArrayList;

import SQL.Query;
import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;

public class QueryImpl implements Query {

    @Override
    public ArrayList<Course> queryCourse(Education edu, boolean courseState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<TClass> queryTClass(int courseId, boolean tClassState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<TClass> queryTClassByStudent(int studentId, boolean tClassstate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Student> queryStudent(int tClassId, boolean studentState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Teacher queryTeacher(int tClassId, boolean teacherState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Student> queryStudentByTeacher(int teacherId, boolean studentState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Student queryStudentByStudentID(int studentId, boolean studentState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<TClass> queryTClass(boolean tClassState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean IsExistCourse(Education education, String vourseName, boolean courseState) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Course> queryCourse(boolean CourseState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Student> queryStudent(boolean StudentState) {
        // TODO Auto-generated method stub
        return null;
    }

}