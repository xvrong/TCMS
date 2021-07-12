/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 21:44:53
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-12 20:11:29
 * @Description: 
 * @FilePath: \TCMS\src\serivice\impl\StudentManagerServiceImpl.java
 */

package serivice.impl;

import java.util.ArrayList;
import java.util.Scanner;

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

    @Override
    public void run() {
        System.out.println("-----------------学生管理----------------");
        System.out.println("1.显示当前存在的所有学生");
        System.out.println("2.显示某门班级的所有学生");
        System.out.println("3.显示一个老师的所有学生");
        System.out.println("4.显示一个学生的详细信息");
        System.out.println("5.显示一个学生的当前班级");
        System.out.println("6.显示一个学生的历史班级");
        System.out.println("7.添加一个学生");
        System.out.println("8.删除一个学生");
        System.out.println("9.更改学生班级");
        System.out.println("0.退出");
        int func = -1;
        Scanner input = new Scanner(System.in);
        while (func != 0) {
            do {
                func = input.nextInt();
                if (func < 0 || func > 9) {
                    System.out.print("输入错误，请重新输入:");
                }
            } while (func < 0 || func > 9);
            switch (func) {
                case 1:
                    showAllStudent();
                    break;
                case 2:
                    showCertainClassStudent();
                    break;
                case 3:
                    showCertainTeacherStudent();
                    break;
                case 4:
                    showCertainStudent();
                    break;
                case 5:
                    showCertainStudentNowClass();
                    break;
                case 6:
                    showCertainStudentHistoryClass();
                    break;
                case 7:
                    addStudent();
                    break;
                case 8:
                    deleteStudent();
                    break;
                case 9:
                    changeStudentClass();
                    break;
                default:
                    break;
            }
        }
    }
}
