/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 21:44:53
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-11 20:55:32
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
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
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
        if (qy.IsExistTeacher(teacherId, true)) {
            ArrayList<Student> studentList = qy.queryStudentByTeacher(teacherId, true);
            pt.printStudentBasicInfomation(studentList);
        } else {
            System.out.println("无此老师");
        }
    }

    @Override
    public void showCertainStudent() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        int studentId = get.getInputId();
        if (qy.IsExistStudent(studentId, true)) {
            Student student = qy.queryStudentByStudentID(studentId, true);
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList.add(student);
            pt.printStudentAllInformation(studentList);
        } else {
            System.out.println("无此学生");
        }
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
        String password = get.getInputPassword();
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        pt.printStudentAllInformation(studentList);
        if (get.getInputYN()) {
            if (up.addStudent(student, password))
                System.out.println("添加成功");
            else
                System.out.println("添加失败");
        }
    }

    @Override
    public void deleteStudent() {
        GetInput get = new GetInputImpl();
        Update up = new UpdateImpl();
        Print pt = new PrintImpl();
        Query qy = new QueryImpl();
        int studentId = get.getInputId();
        if (qy.IsExistStudent(studentId, true)) {
            Student student = qy.queryStudentByStudentID(studentId, true);
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList.add(student);
            pt.printStudentAllInformation(studentList);
            if (get.getInputYN()) {
                if (up.deleteStudent(studentId))
                    System.out.println("删除成功");
                else
                    System.out.println("删除失败");
            }
        } else {
            System.out.println("无此学生");
        }
    }

    @Override
    public void changeStudentClass() {
        GetInput get = new GetInputImpl();
        Update up = new UpdateImpl();
        Query qy = new QueryImpl();
        System.out.println("学生");
        int studentId = get.getInputId();
        if (qy.IsExistStudent(studentId, true)) {
            System.out.println("要调换的班级");
            int tClassId = get.getInputId();
            if (qy.IsExistTClass(tClassId, true)) {
                TClass newTClass = qy.queryTClassByTClassId(tClassId, true);
                TClass oldTClass = qy.queryTClass(newTClass.getCourseID(), studentId, true);
                if (up.deleteTaking(studentId, oldTClass.getClassID())) {
                    if (up.addTaking(studentId, tClassId)) {
                        System.out.println("调整成功");
                    } else {
                        System.out.println("调整失败");
                    }
                } else {
                    System.out.println("调整失败");
                }
            } else {
                System.out.println("无此班级");
            }
        } else {
            System.out.println("无此学生");
        }

    }

    @Override
    public void showCertainStudentNowClass() {
        GetInput get = new GetInputImpl();
        Print pt = new PrintImpl();
        Query qy = new QueryImpl();
        int studentId = get.getInputId();
        ArrayList<TClass> tClassList = qy.queryTClassByStudent(studentId, true);
        pt.printTClassBasicInfomation(tClassList);
    }

    @Override
    public void showCertainStudentHistoryClass() {
        GetInput get = new GetInputImpl();
        Print pt = new PrintImpl();
        Query qy = new QueryImpl();
        int studentId = get.getInputId();
        ArrayList<TClass> tClassList = qy.queryTClassByStudent(studentId, false);
        pt.printTClassBasicInfomation(tClassList);
    }
}
