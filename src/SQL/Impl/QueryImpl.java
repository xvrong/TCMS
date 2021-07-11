/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 23:45:56
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 12:05:20
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
    public ArrayList<TClass> queryStudentTClass(int studentId, boolean state) {
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
    public ArrayList<Student> queryStudentByTeacher(int teacherId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Student queryStudentByStudentID(int studentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<TClass> queryTClass(boolean state) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean IsExistCourse(Education education, String CourseName) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Course> queryCourse(boolean state) {
        // TODO Auto-generated method stub
        return null;
    }

}