/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 23:45:56
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 08:34:18
 * @Description: 
 * @FilePath: \TCMS\src\SQL\Impl\QueryImpl.java
 */
package SQL.Impl;

import java.util.ArrayList;

import SQL.Query;
import Tool.Education;
import dao.impl.CourseDaoImpl;
import dao.impl.ManagerDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.TClassDaoImpl;
import dao.impl.TeacherDaoImpl;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;

public class QueryImpl implements Query {

    @Override
    public ArrayList<Course> queryCourse(Education edu, boolean courseState) {
        String sql = "select * from course where education=? and state=?";
        CourseDaoImpl tmp = new CourseDaoImpl();
        Object arr[] = new Object[2];
        arr[0] = edu;
        arr[1] = courseState;
        return tmp.selectCourse(sql, arr);
    }

    @Override
    public ArrayList<TClass> queryTClass(int courseId, boolean tClassState) {
        String sql = "select * from class where courseID=? and state=?";
        TClassDaoImpl tmp = new TClassDaoImpl();
        Object arr[] = new Object[2];
        arr[0] = courseId;
        arr[1] = tClassState;
        return tmp.selectTClass(sql, arr);
    }

    @Override
    public ArrayList<TClass> queryTClassByStudent(int studentId, boolean tClassState) {
        String sql = "select * from class where courseID in (select distinct classID from taking nature join student as t where t.studentID=?) and class.state=?";
        TClassDaoImpl tmp = new TClassDaoImpl();
        Object arr[] = new Object[2];
        arr[0] = studentId;
        arr[1] = tClassState;
        return tmp.selectTClass(sql, arr);
    }

    @Override
    public ArrayList<Student> queryStudent(int tClassId, boolean studentState) {
        String sql = "select * from student where student.studentID in (select distinct t.studentID from student nature join taking as t where classID=?) and student.state=?";
        Object arr[] = new Object[2];
        arr[0] = tClassId;
        arr[1] = studentState;
        StudentDaoImpl tmp = new StudentDaoImpl();
        return tmp.selectStudent(sql, arr);
    }

    @Override
    public Teacher queryTeacher(int tClassId, boolean teacherState) {
        String sql = "select * from teacher where state=? and teacherID=(select teacherID from class where classID=?)";
        TeacherDaoImpl tmp = new TeacherDaoImpl();
        Object arr[] = new Object[2];
        arr[0] = tClassId;
        arr[1] = teacherState;
        return tmp.selectTeacher(sql, arr).get(0);
    }

    @Override
    public ArrayList<Teacher> queryTeacher(boolean teacherState) {
        String sql = "select * from teacher where state=?";
        TeacherDaoImpl tmp = new TeacherDaoImpl();
        Object arr[] = new Object[2];
        arr[0] = teacherState;
        return tmp.selectTeacher(sql, arr);
    }

    @Override
    public ArrayList<Student> queryStudentByTeacher(int teacherId, boolean studentState) {
        String sql = "select * from student where studentID in (select studentID from taking where classID in (select classID from class where teacherID=?)) and state=?";
        Object arr[] = new Object[2];
        arr[0] = teacherId;
        arr[1] = studentState;
        StudentDaoImpl tmp = new StudentDaoImpl();
        return tmp.selectStudent(sql, arr);
    }

    @Override
    public Student queryStudentByStudentID(int studentId, boolean studentState) {
        String sql = "select * from student where studentID=? and state=?";
        Object arr[] = new Object[2];
        arr[0] = studentId;
        arr[1] = studentState;
        StudentDaoImpl tmp = new StudentDaoImpl();
        return tmp.selectStudent(sql, arr).get(0);

    }

    @Override
    public ArrayList<TClass> queryTClass(boolean tClassState) {
        String sql = "select * from class where state=?";
        TClassDaoImpl tmp = new TClassDaoImpl();
        Object arr[] = new Object[1];
        arr[0] = tClassState;
        return tmp.selectTClass(sql, arr);

    }

    @Override
    public boolean IsExistCourse(Education education, String courseName, boolean courseState) {
        String sql = "select * from course where education=? and coursename=? and state=?";
        Object arr[] = new Object[3];
        arr[0] = education;
        arr[1] = courseName;
        arr[2] = courseState;
        CourseDaoImpl tmp = new CourseDaoImpl();
        if (tmp.selectCourse(sql, arr).isEmpty())
            return false;
        else
            return true;
    }

    @Override
    public ArrayList<Course> queryCourse(boolean CourseState) {
        String sql = "select * from course where state=?";
        Object arr[] = new Object[1];
        arr[0] = CourseState;
        CourseDaoImpl tmp = new CourseDaoImpl();
        return tmp.selectCourse(sql, arr);
    }

    @Override
    public ArrayList<Student> queryStudent(boolean StudentState) {
        String sql = "select * from student where state=?";
        Object arr[] = new Object[1];
        arr[0] = StudentState;
        StudentDaoImpl tmp = new StudentDaoImpl();
        return tmp.selectStudent(sql, arr);
    }

    @Override
    public boolean IsExistStudent(int studentId, boolean state) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean IsExistCourse(int courseId, boolean state) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean IsExistTClass(int tClassId, boolean state) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean IsExistTeacher(int teacherId, boolean state) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public TClass queryTClassByTClassId(int tClassId, boolean state) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TClass queryTClass(int courseId, int StudentId, boolean state) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Teacher queryTeacherByTeacherId(int TeacherId, boolean state) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<TClass> queryTClassByTeacherId(int TeacherId, boolean state) {
        // TODO Auto-generated method stub
        return null;
    }

}