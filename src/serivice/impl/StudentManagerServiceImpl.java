/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 21:44:53
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 12:25:21
 * @Description: 
 * @FilePath: \TCMS\src\serivice\impl\StudentManagerServiceImpl.java
 */

package serivice.impl;

import java.util.ArrayList;

import SQL.Query;
import SQL.Update;
import SQL.Impl.QueryImpl;
import SQL.Impl.UpdateImpl;
import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
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
        ArrayList<Student> studentList = qy.queryStudent(true);
        pt.printStudentBasicInfomation(studentList);
    }

    @Override
    public void showCertainTeacherStudent() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        int teacherId = get.getInputId();
        ArrayList<Student> studentList = qy.queryStudentByTeacher(teacherId, true);
        pt.printStudentBasicInfomation(studentList);
    }

    @Override
    public void showCertainStudent() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        int studentId = get.getInputId();
        Student student = qy.queryStudentByStudentID(studentId, true);
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        pt.printStudentAllInformation(studentList);
    }

    @Override
    public void addStudent() {
        Student student = new Student();
        GetInput get = new GetInputImpl();
        Update up = new UpdateImpl();
        Print pt = new PrintImpl();
        String name = get.getInputName();
        student.setName(name);
        Education edu = get.getInputEducation();
        student.setEdu(edu);
        String birthday = get.getInputBirthday();
        student.setBirthday(birthday);
        String sex = get.getInputSex();
        student.setSex(sex);
        String passWord = get.getInputPassword();
        up.addStudent(student, passWord);

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
