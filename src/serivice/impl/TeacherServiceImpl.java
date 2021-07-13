/*
 * @Author: LinXuan
 * @Date: 2021-07-12 16:58:57
 * @Description: 
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-13 12:16:24
 * @FilePath: \TCMS\src\serivice\impl\TeacherServiceImpl.java
 */
package serivice.impl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import SQL.Impl.QueryImpl;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;
import serivice.TeacherService;
import windows.impl.GetInputImpl;
import windows.impl.PrintImpl;

public class TeacherServiceImpl implements TeacherService {
    final static PrintStream jout = System.out;
    Teacher teacher = null;
    QueryImpl qy = new QueryImpl(); // 数据库查新方法
    PrintImpl pt = new PrintImpl(); // 打印方法
    GetInputImpl gt = new GetInputImpl(); //获取输入方法
    @Override
    public void showPersonalInfo() {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        
        pt.printTeacherAllInformation(teacherList);
    }

    @Override
    public void showTeachingClass() {
        ArrayList<TClass> courseList = qy.queryTClassByTeacherId(teacher.getTeacherID(), true);
        pt.printTClassBasicInfomation(courseList);
    }

    @Override
    public void searchTeachingStudent() {
        ArrayList<Student> studentList = qy.queryStudentByTeacher(teacher.getTeacherID(), true);
        pt.printStudentBasicInfomation(studentList);
    }

    @Override
    public void showHistoryTeachingClass() {
        ArrayList<TClass> courseList = qy.queryTClassByTeacherId(teacher.getTeacherID(), false);
        pt.printTClassBasicInfomation(courseList);
    }

    @Override
    public void searchTeachingStudentInfo() {
        ArrayList<Student> studentList = qy.queryStudentByTeacher(teacher.getTeacherID(), true);
        int studentID = gt.getInputStudent(studentList);
        ArrayList<Student> searchStudent = new ArrayList<Student>();
        for(Student stu : studentList) {
            if(stu.getStudentID() == studentID) {
                searchStudent.add((stu));
                break;
            }
        }
        pt.printStudentAllInformation(searchStudent);
    }

    @Override
    public void run(int teacherID) {
        QueryImpl qy = new QueryImpl();
        teacher = qy.queryTeacherByTeacherId(teacherID, true);

        // 界面部分
        jout.println("-----------------学生界面----------------");
        jout.println("1.查看个人信息");
        jout.println("2.查询自己所教的班级");
        jout.println("3.查询历史所教班级");
        jout.println("4.查询自己所教的所有学生");
        jout.println("5.查询自己所教某位学生的详细信息");
        jout.println("0.退出登录");
        
        int func = -1;
        Scanner input = new Scanner(System.in);
        while (func != 0) {
            do {
                jout.print("请输入选择: ");
                func = input.nextInt();
                if (func < 0 || func > 5) {
                    System.out.print("输入错误!");
                }
            } while (func < 0 || func > 5);
            switch (func) {
            case 1:
                showPersonalInfo();
                break;
            case 2:
                showTeachingClass();
                break;
            case 3:
                showHistoryTeachingClass();
                break;
            case 4:
                searchTeachingStudent();;
                break;
            case 5:
                searchTeachingStudentInfo();
                break;
            case 0:
                return;
            default:
                break;
            }
        }
        
    }

}
