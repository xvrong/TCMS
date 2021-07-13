/*
 * @Author: xv_rong
 * @Date: 2021-07-09 21:48:17
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-13 12:16:47
 * @Description: TClassManagerServiceImpl
 * @FilePath: \TCMS\src\serivice\impl\TClassManagerServiceImpl.java
 */
package serivice.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import SQL.Query;
import SQL.Update;
import SQL.Impl.QueryImpl;
import SQL.Impl.UpdateImpl;
import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;
import serivice.TClassManagerService;
import windows.GetInput;
import windows.Print;
import windows.impl.GetInputImpl;
import windows.impl.PrintImpl;

public class TClassManagerServiceImpl implements TClassManagerService {

    @Override
    public void showAllTClass() {
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        ArrayList<TClass> tClassList = qy.queryTClass(true);
        pt.printTClassBasicInfomation(tClassList);
    }

    @Override
    public void showCertainTClassStudent() {
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
    public void showCertainTClassTeacher() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> classList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(classList);
        Teacher teacher = qy.queryTeacher(tClassId, true);
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        pt.printTeacherBasicInfomation(teacherList);

    }

    @Override
    public void addTClass() {
        TClass tClass = new TClass();
        Calendar cal = Calendar.getInstance();
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Update up = new UpdateImpl();

        Education edu = get.getInputEducation();
        tClass.setEducation(edu);
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        tClass.setCourseID(courseId);
        tClass.setGrade(1);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int num = tClassList.size() + 1;
        tClass.setOrderNumber(num);
        System.out.println("选择对应老师");
        int teacherId = get.getInputId();
        get.getInputClassMaxNum();
        tClass.setTeacherID(teacherId);
        int year = cal.get(Calendar.YEAR);
        tClass.setStartYear(year);
        tClass.setState(true);
        boolean flag = up.addTClass(tClass);
        if (flag) {
            System.out.println("增加班级成功");
        } else {
            System.out.println("增加班级失败");
        }
    }

    @Override
    public void ChangeTeacher() {
        Print pt = new PrintImpl();
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Update up = new UpdateImpl();
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
        qy.queryTClassByTClassId(tClassId, true);
        pt.printTClassBasicInfomation(tClassList);
        System.out.println("选择老师");
        int teacherId = get.getInputId();
        if (qy.IsExistTeacher(teacherId, true)) {
            boolean flag = up.setTeahcer(tClassId, teacherId);
            if (flag) {
                System.out.println("修改老师成功");
            } else {
                System.out.println("修改老师失败");
            }
        } else {
            System.err.println("此老师不存在");
        }
    }

    @Override
    public void deleteStudent() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Update up = new UpdateImpl();
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
        ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
        int studentId = get.getInputStudent(studentList);
        boolean flag = up.deleteTaking(studentId, tClassId);
        if (flag) {
            System.out.println("在班级里删除成功");
        } else {
            System.out.println("在班级里删除失败");
        }
    }

    @Override
    public void addStudent() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Update up = new UpdateImpl();
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
        int studentId = get.getInputId();
        if (qy.IsExistStudent(studentId, true)) {
            boolean flag = up.addTaking(studentId, tClassId);
            if (flag) {
                System.out.println("增加学生成功");
            } else {
                System.out.println("增加学生失败");
            }
        } else {
            System.out.println("此学生不存在");
        }
    }

    @Override
    public void deleteTClass() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Update up = new UpdateImpl();
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> classList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(classList);
        boolean flag = false;
        for (TClass tClass : classList) {
            if (tClassId == tClass.getClassID()) {
                if (tClass.getStudentNum() == 0)
                    flag = true;
            }
        }
        if (flag) {
            flag = up.deleteTClass(tClassId);
            if (flag) {
                System.out.println("删除课程成功");
            } else {
                System.out.println("删除课程失败");
            }
        } else {
            System.out.println("此班级中有学生存在，不能删除");
        }
    }

    public void run() {
        System.out.println("-----------------班级管理----------------");
        System.out.println("1.查询当前存在的所有班级");
        System.out.println("2.查询某个班级的所有学生");
        System.out.println("3.查询一个班级的老师");
        System.out.println("4.增加一个班级");
        System.out.println("5.删除一个班级");
        System.out.println("6.更改一个班级的老师");
        System.out.println("7.在一个班级里删除一个学生");
        System.out.println("8.在一个班级里增加一个学生");
        System.out.println("0.退出");
        int func = -1;
        Scanner input = new Scanner(System.in);
        while (func != 0) {
            do {
                System.out.print("请输入选择: ");
                func = input.nextInt();
                if (func < 0 || func > 9) {
                    System.out.print("输入错误!");
                }
            } while (func < 0 || func > 9);
            switch (func) {
                case 1:
                    showAllTClass();
                    break;
                case 2:
                    showCertainTClassStudent();
                    break;
                case 3:
                    showCertainTClassTeacher();
                    break;
                case 4:
                    addTClass();
                    break;
                case 5:
                    deleteTClass();
                    break;
                case 6:
                    ChangeTeacher();
                    break;
                case 7:
                    addStudent();
                    break;
                case 8:
                    deleteStudent();
                    break;
                default:
                    break;
            }
        }
    }

}
